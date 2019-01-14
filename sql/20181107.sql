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

-- 20190114

CREATE TABLE `simple_event` (
  `id` BIGINT(20) NOT NULL COMMENT '主键',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
  `content` VARCHAR(1024) DEFAULT NULL COMMENT '内容',
  `event_date` DATE DEFAULT NULL COMMENT '事件时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='简单的事件记录'


CREATE TABLE `simple_event_record` (
  `id` BIGINT(20) NOT NULL COMMENT '主键',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `simple_event_id` BIGINT(20) DEFAULT NULL COMMENT 'simple_event_id',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
  `content` VARCHAR(1024) DEFAULT NULL COMMENT '内容',
  `event_date` DATE DEFAULT NULL COMMENT '事件时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='简单的事件记录更新历史'
