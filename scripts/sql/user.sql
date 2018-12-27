create database user;

#用户注册申请表
create table t_user_sign_up_apply
(
    apply_id varchar(80) not null comment 'apply id',
    uid bigint default null comment 'uid',
    mobile varchar(20) default null comment '手机号',
    email varchar(200) default null comment '邮箱',
    code varchar(16) not null comment '注册验证码',
    password varchar(80) not null comment '登陆密码',
    confirm_password varchar(80) not null comment '确认登陆密码',
    city_code varchar(30) default null comment '城市code',
    province_code varchar(30) default null comment '省份code',
    ip varchar(64) not null comment '注册ip',
    user_agent varchar(40) not null comment '注册app类型: browser; ios; andriod',
    result varchar(32) not null comment '结果: accepted-处理中(未知); success-成功; fail-失败',
    fail_code varchar(32) default null comment '失败码',
    fail_reason varchar(256) default null comment '失败原因',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间',
    primary key (apply_id),
    key k_uid(uid),
    key k_mobile (mobile),
    key k_email (email)
) engine=InnoDB default charset=utf8 comment '用户注册申请表';


#用户信息表
create table t_user
(
    uid bigint not null comment 'uid',
    mobile varchar(20) default null comment '手机号',
    mobile_status varchar(40) not null comment '手机号状态: disable-未启用; enable-已启用',
    email varchar(200) default null comment '邮箱',
    email_status varchar(40) not null comment '邮箱状态:  disable-未启用; enable-已启用',
    card_no varchar(100) default null comment '证件号码',
    card_mode varchar(40) default null comment '证件类型: 1-中国大陆居民身份证; 2-台湾居民来往大陆通行证; 3-港澳居民来往内地通行证',
    real_name_status varchar(40) default null comment '实名状态: unRealName-未实名; realName-已实名',
    password varchar(80) not null comment '登陆密码',
    user_status varchar(40) not null comment '状态: normal-正常; lock-锁定; deleted-删除; black-黑名单',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间',
    primary key (uid),
    unique key uk_mobile (mobile),
    unique key uk_email (email),
    unique key uk_card_no (card_no)
) engine=InnoDB default charset=utf8 comment '用户表';

#用户详细信息表
create table t_user_detail
(
    uid bigint not null comment 'uid',
    nick_name varchar(64) default null comment '昵称',
    head_picture_url varchar(256) default null comment '头像地址',
    gender varchar(40) not null comment '性别: unknown-未知; woman-女; man-男',
    real_name varchar(100) default null comment '真实姓名',
    birthday datetime default null comment '生日',
    age int not null default '-1' comment '年龄: -1未知',
    marriage_status varchar(40) not null comment '婚姻状态: married-未婚; unmarried-已婚; secret-保密',
    education varchar(40) default null comment '学历: ',
    security_level varchar(40) not null comment '账户安全等级: normal-一般',
    city_code varchar(30) default null comment '城市code',
    province_code varchar(30) default null comment '省份code',
    ip varchar(64) not null comment '注册ip',
    user_agent varchar(40) not null comment '注册app类型: browser; ios; andriod',
    sign_up_date datetime not null comment '注册时间',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间',
    PRIMARY KEY (uid)
) engine=InnoDB default charset=utf8 comment '用户详细信息';

#用户登录历史
create table t_user_sign_in_log
(
    id bigint not null comment '主键',
    uid bigint not null comment 'uid',
    account_mode varchar(40) not null comment '登陆账号类型:mobile,email',
    ip varchar(64) not null comment '登录ip',
    user_agent varchar(40) default '0' comment 'app类型: browser; ios; andriod',
    result varchar(40) not null comment '登录状态: fail-失败; successful-成功',
    fail_code varchar(32) default null comment '登录失败错误码',
    fail_reason varchar(128) default null comment '登录失败原因',
    sign_in_time  datetime default null comment '登录时间',
    create_time datetime default null comment '创建时间',
    update_time datetime default null comment '更新时间',
    primary key(id),
    index i_uid (uid)
)engine=InnoDB default charset=utf8 comment '用户登录日志';