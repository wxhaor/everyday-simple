CREATE TABLE `mg_manager` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` varchar(256) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员'


CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `mobile` varchar(128) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
