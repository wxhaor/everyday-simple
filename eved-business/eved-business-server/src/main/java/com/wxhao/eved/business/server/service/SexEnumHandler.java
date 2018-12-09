package com.wxhao.eved.business.server.service;

import com.wxhao.boot.api.enums.SexEnum;
import com.wxhao.boot.base.utils.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wxhao
 * @date 2018/12/9
 */
//声明jdbctype为 整型
@MappedJdbcTypes(JdbcType.INTEGER)
//声明JavaType 为SexEnum
@MappedTypes(value = SexEnum.class)
public class SexEnumHandler extends BaseTypeHandler<SexEnum> {

    //设置非空参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getCode());
    }

    //通过列名读取
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return EnumUtils.getEunmByCode(code, SexEnum.class);
    }

    //通过下标读取
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return EnumUtils.getEunmByCode(code, SexEnum.class);
    }

    //通过存储过程读取
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return EnumUtils.getEunmByCode(code, SexEnum.class);
    }
}
