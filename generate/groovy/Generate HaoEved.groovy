import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil
import groovy.json.JsonSlurper
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants

typeMapping = [
        (~/(?i)bigint/)                   : "Long",
        (~/(?i)tinyint/)                  : "Byte",
        (~/(?i)int/)                      : "Integer",
        (~/(?i)float|double|decimal|real/): "BigDecimal",
        (~/(?i)datetime|timestamp/)       : "Date",
        (~/(?i)date/)                     : "Date",
        (~/(?i)time/)                     : "Time",
        (~/(?i)/)                         : "String"
]

dbTypeMapping = [
        (~/(?i)bigint/)   : "BIGINT",
        (~/(?i)tinyint/)  : "TINYINT",
        (~/(?i)int/)      : "INTEGER",
        (~/(?i)float/)    : "FLOAT",
        (~/(?i)double/)   : "DOUBLE",
        (~/(?i)decimal/)  : "DECIMAL",
        (~/(?i)timestamp/): "TIMESTAMP",
        (~/(?i)datetime/) : "TIMESTAMP",
        (~/(?i)date/)     : "Date",
        (~/(?i)time/)     : "Time",
        (~/(?i)/)         : "VARCHAR"
]

importMapping = [
        BigDecimal: 'java.math.BigDecimal',
        Date      : 'java.util.Date',
        Time      : 'java.sql.Time'

]

// 指定配置文件基本路径
basePath = PROJECT.getBaseDir().path + "/generate"

// 读取配置
config = readConfig()


// 初始化模版引擎
VelocityEngine ve = new VelocityEngine()
ve.setProperty(RuntimeConstants.RUNTIME_LOG, config.runtimeLog)
ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, basePath)
ve.init()

config.modules.each { module ->
    module.templates.each { template ->
        // 获取Velocity模版文件
        Template templateVM = ve.getTemplate(template.templateFilePath)

        // 设置变量
        VelocityContext ctx = new VelocityContext()

        ctx.put("module", module)
        def classPackage = module.projectBasePackage + "." + template.package
        ctx.put("classPackage", classPackage)

        SELECTION.filter { it instanceof DasTable && it.getKind() == ObjectKind.TABLE }.each {
            def table = it
            //待转换类名称 , 去掉表前缀
            def todoTranClassName = table.getName()
            //判断是否配置表前缀
            if (module.missTablePrefix.size() > 0) {
                todoTranClassName = table.getName().substring(table.getName().indexOf(module.missTablePrefix, 1) + module.missTablePrefix.size() + 1)
            }

            def className = convertJavaName(todoTranClassName, true)
            def classFileName = template.classPrefix + className + template.classSuffix
            // 将类信息放入模板变量
            ctx.put("className", className) //类名称
            ctx.put("classFileName", classFileName) //文件名称
            ctx.put("tableComment", table.comment) // 表注释

            // 将字段信息放入模板变量
            def imports = new HashSet()
            ctx.put("fields", calcFields(imports, table))
            ctx.put("imports", imports)

            // 输出
            StringWriter sw = new StringWriter()
            templateVM.merge(ctx, sw)

            //先判文件夹是否存在
            def folderPath = PROJECT.getBaseDir().path + "/generate/gen/" + template.package
            def folder = new File(folderPath)
            if (!folder.exists()) {
                folder.mkdirs()
            }
            //创建文件
            def fileName = classFileName + "." + (template.fileExt != null ? template.fileExt : "java")
            def file = new File(folderPath, fileName)
            file.withPrintWriter("UTF-8") { out -> out.print sw }

        }
    }
}


/**
 * 读取配置config.json
 * @return 解析后的config
 */
def readConfig() {
    def configText = new File(basePath + "/config.json").text
    new JsonSlurper().parseText(configText)
}

/**
 * 处理表字段信息
 * @param table 表信息
 * @return
 */
def calcFields(imports, table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def specification = col.getDataType().getSpecification()
        def spec = Case.LOWER.apply(specification)
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
        def importPackage = importMapping.find { p, t -> p == typeStr }
        def dbType = dbTypeMapping.find { p, t -> p.matcher(spec).find() }.value
        if (importPackage) {
            imports.add("import " + importPackage.value + ";")
        }
        fields += [[
                           name   : convertJavaName(col.getName(), false),
                           type   : typeStr,
                           dbType : dbType,
                           dbName : col.getName(),
                           comment: col.comment,
                           annos  : ""]]
    }
}

/**
 * 转驼峰 (待转换,首字母是否大写)
 */
def convertJavaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}
