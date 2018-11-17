
-- 基础信息库


所有功能点定义表
字典表
日志记录表

图片上传接口
短信接口


CREATE TABLE `p_operation_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `execute_user` bigint(20) DEFAULT NULL COMMENT '操作用户ID',
  `syscode` varchar(20) DEFAULT NULL COMMENT '系统编码',
  `service_code` varchar(20) DEFAULT NULL COMMENT '服务编码',
  `execute_ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `execute_time` int(11) DEFAULT NULL COMMENT '执行时间',
  `inputparam` longtext COMMENT '请求参数',
  `outputparam` longtext COMMENT '返回参数',
  `execute_starttime` datetime DEFAULT NULL COMMENT '执行开始时间',
  `execute_endtime` datetime DEFAULT NULL COMMENT '执行结束时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018100000 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志轨迹表';


CREATE TABLE `p_service_info` (
  `service_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `service_name` varchar(20) DEFAULT NULL COMMENT '服务名',
  `service_code` varchar(20) NOT NULL DEFAULT '' COMMENT '服务编码',
  `sysname` varchar(30) NOT NULL DEFAULT '' COMMENT '系统名称',
  `syscode` varchar(20) NOT NULL DEFAULT '' COMMENT '系统编码',
  `status` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效状态 N 无效 ；Y 有效；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`service_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018100003 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='基础服务定义表';