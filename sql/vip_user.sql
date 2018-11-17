-- 用户权限库


用户基础信息表
-- 用户绑定账号信息表

用户银行卡账号表（持卡人姓名、卡号、卡类型、银行、手机号、安全码/卡面背后三位数、有效日期/示例：01/20，输入0120）
用户收货地址信息表
用户登录记录表
用户V值记录表
用户操作轨迹记录表（登录、注册、修改表）




CREATE TABLE `u_base_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名/身份证实名',
  `login_passwd` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录密码',
  `mobile_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '绑定邮箱',
  `user_img_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `sex` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `user_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'U01' COMMENT '用户状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户基础信息表';


CREATE TABLE `u_auth_object` (
  `object_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `type_name` varchar(20) DEFAULT NULL COMMENT '对象组类型名称',
  `type_code` varchar(20) NOT NULL DEFAULT '' COMMENT '对象组类型编码',
  `object_name` varchar(30) NOT NULL COMMENT '对象名称',
  `object_code` varchar(20) NOT NULL DEFAULT '' COMMENT '对象编码',
  `status` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效状态 N 无效 ；Y 有效；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`object_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018100018 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='基础定义表';


CREATE TABLE `u_auth_role_user` (
  `auth_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(20) NOT NULL DEFAULT '' COMMENT '角色编码',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `status` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效状态 N 无效 ；Y 有效；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';


CREATE TABLE `u_bank_card` (
  `card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `card_type` varchar(10) NOT NULL COMMENT '银行卡类型',
  `card_num` bigint(20) NOT NULL COMMENT '银行卡卡号',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '持卡人姓名',
  `mobile_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '银行预留手机号',
  `card_sericuty_num` varchar(10) DEFAULT NULL COMMENT '安全码/卡面背后三位数',
  `card_effective_date` varchar(10) DEFAULT NULL COMMENT '有效日期/示例：01/20，输入0120',
  `status` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效状态 N 无效 ；Y 有效；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`card_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018100001 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户银行卡信息表';



CREATE TABLE `u_receive_address` (
  `addres_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `address_type` varchar(10) NOT NULL COMMENT '地址类型',
  `user_name` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '收货人手机号',
  `phone_bak` varchar(20) DEFAULT NULL COMMENT '备用电话 手机号/区号-固定电话',
  `address_province` varchar(20) DEFAULT NULL COMMENT '收货地址-省',
  `address_city` varchar(20) DEFAULT NULL COMMENT '收货地址-市',
  `address_county` varchar(20) DEFAULT NULL COMMENT '收货地址-区',
  `address_street` varchar(20) DEFAULT NULL COMMENT '收货地址-街道',
  `address_detail` varchar(20) DEFAULT NULL COMMENT '详细地址',
  `status` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效状态 N 无效 ；Y 有效；',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `default_flag` varchar(1) NOT NULL DEFAULT 'N' COMMENT '是否是默认地址，Y 是 N 否',
  PRIMARY KEY (`addres_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018100000 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户收货地址信息表';