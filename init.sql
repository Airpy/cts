CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) PRIMARY KEY NOT NULL auto_increment COMMENT '用户ID',
  `username` varchar(45)  NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `nick_name` varchar(45)  DEFAULT NULL COMMENT '昵称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表'