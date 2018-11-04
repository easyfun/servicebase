create database code;
use code;

create table t_code_apply (
	`apply_id` varchar(80) not null comment '申请id',
	`apply_type` varchar(32) not null comment '申请类型: APPLY-申请, VERIFY-验证',
	`business_id` varchar(100) not null comment '业务id: 手机号; 邮箱;',
	`code_mode` varchar(32) not null comment '验证码类型:注册; 重置登录密码; 重置支付密码',
	`code` varchar(16) default null comment '验证码',
	`ip` varchar(48) not null null comment 'ip',
	`user_agent` varchar(32) not null comment '客户端代理: BROWSER, IOS, ANDROID',
	`device_id` varchar(100) default null comment '设备id',
	`result` varchar(32) not null comment '结果: ACCEPT-处理中(未知); SUCCESS-成功; FAIL-失败',
   	`fail_code` varchar(32) default null comment '失败码',
   	`fail_reason` varchar(256) default null comment '失败原因',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	primary key (`apply_id`),
	key k_create_time (`create_time`)
) engine=innodb default charset=utf8 comment='验证码申请表';