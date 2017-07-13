create table account (
    user_id int not null auto_increment comment '账号id',
    username varchar(20) not null comment '用户名',
    password varchar(128) not null comment '密码',
    last_login_date timestamp not null default current_timestamp comment '最近登录日期',
    primary key (user_id),
    key idx_account (username)
) comment '用户账号';


create table user (
    user_id int not null comment '用户id',
    name varchar(20) not null comment '姓名',
    email varchar(50) not null comment 'Email',
    employee_no varchar(10) not null comment '工号',
    birthday datetime not null comment '出生日期',
    primary key (user_id)
) comment '用户';

create table `group` (
    group_id int not null auto_increment comment '分组id',
    group_name int not null comment '组名',
    primary key (group_id)
) comment '分组';

create table user_group (
    user_group_id int not null auto_increment comment '用户分组id',
    user_id int not null comment '用户id',
    group_id int not null comment '分组id',
    primary key (user_group_id),
    key (user_id, group_id)
) comment '用户分组';

create table permission (
    permission_id int not null auto_increment comment '权限id',
    permission_code bigint not null comment '权限码',
    group_id int not null comment '组id',
    user_id int not null comment '用户id',
    primary key (permission_id),
    key idx_permission_group (group_id),
    key idx_permission_user (user_id)
) comment '权限';

create table log (
    log_id int not null auto_increment comment '日志id',
    log_type int not null comment '日志类型',
    user_id int not null comment '操作用户id',
    log_message varchar(200) not null comment '日志信息',
    log_date timestamp not null default current_timestamp comment '日志日期',
    primary key (log_id),
    key idx_log_type (log_type),
    key idx_log_user (user_id, log_type)
) comment '日志';

insert account(username, password, last_login_date) values ('admin', '7fcf4ba391c48784edde599889d6e3f1e47a27db36ecc050cc92f259bfac38afad2c68a1ae804d77075e8fb722503f3eca2b2c1006ee6f6c7b7628cb45fffd1d', current_timestamp);
insert user (user_id, name, email, employee_no, birthday) values (last_insert_id(), '管理员', 'admin@admin.com', '0', current_timestamp);
insert permission (permission_code, group_id, user_id) values (9223372036854775807, 0, last_insert_id());