CREATE TABLE `ms-hao`.`mg_manager`(
  `id` BIGINT(20) NOT NULL COMMENT '主键',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL COMMENT '更新时间',
  `username` VARCHAR(256) NOT NULL COMMENT '用户名',
  `password` VARCHAR(256) NOT NULL COMMENT '密码',
  `state` INT COMMENT '状态',
  PRIMARY KEY (`id`)
);
