DROP TABLE IF EXISTS TB_RESOURCE;
CREATE TABLE TB_RESOURCE(
    resource_id bigint(0) primary key comment '主键',
    parent_id bigint(0) default null comment '父级ID',
    resource_name varchar(50) default '' comment '资源名称',
    resource_type tinyint(0) default 0 comment '资源类型：0 目录，1 菜单，2 按钮',
    url varchar(200) default '' comment '访问路径',
    code varchar(100) comment '代码',
    sort int(0) unsigned default 1 comment '排序编号'
);

DROP TABLE IF EXISTS TB_ROLE;
CREATE TABLE TB_ROLE(
    role_id bigint(0) primary key comment '主键',
    role_name varchar(50) not null default '' comment '角色名称',
    remarks varchar(200) default '' comment '备注',
    create_time datetime default current_timestamp() comment '创建时间',
    created_by bigint(0) not null comment '创建人',
    last_update_time datetime default current_timestamp() comment '最后更新时间',
    last_updated_by bigint(0) not null comment '最后修改人',
    deleted tinyint(0) default 0 comment '逻辑删除标识：0 未删除 1 已删除'
);

DROP TABLE IF EXISTS TB_ROLE_RESOURCE;
CREATE TABLE TB_ROLE_RESOURCE(
    role_resource_id bigint(0) primary key comment '主键',
    role_id bigint(0) comment '角色ID',
    resource_id bigint(0) comment '资源ID'
);

ALTER TABLE TB_ROLE_RESOURCE ADD CONSTRAINT fk_rr_role FOREIGN KEY (role_id) REFERENCES TB_ROLE(role_id);
ALTER TABLE TB_ROLE_RESOURCE ADD CONSTRAINT fk_rr_resource FOREIGN KEY (resource_id) REFERENCES TB_RESOURCE(resource_id);

DROP TABLE IF EXISTS TB_ACCOUNT;
CREATE TABLE TB_ACCOUNT(
    account_id bigint(0) primary key comment '主键',
    role_id bigint(0) comment '角色',
    username varchar(20) comment '用户名',
    password varchar(32) comment '密码',
    salt varchar(32) comment '盐值',
    real_name varchar(50) comment '真实姓名',
    sex char(1) comment '性别',
    email varchar(100) comment '邮箱',
    create_time datetime default current_timestamp() comment '创建时间',
    created_by bigint(0) not null comment '创建人',
    last_update_time datetime default current_timestamp() comment '最后更新时间',
    last_updated_by bigint(0) not null comment '最后修改人',
    deleted tinyint(0) default 0 comment '逻辑删除标识：0 未删除 1 已删除'
);

ALTER TABLE TB_ACCOUNT ADD CONSTRAINT fk_acc_role FOREIGN KEY (role_id) references TB_ROLE(role_id);

DROP TABLE IF EXISTS TB_CUSTOMER;
CREATE TABLE TB_CUSTOMER(
  customer_id bigint(0) primary key comment '主键',
  real_name varchar(50) comment '真实姓名',
  sex char(1) comment '性别',
  email varchar(100) comment '邮箱',
  phone varchar(11) comment '手机号码',
  address varchar(200) comment '地址',
  create_time datetime default current_timestamp() comment '创建时间',
  created_by bigint(0) not null comment '创建人',
  last_update_time datetime default current_timestamp() comment '最后更新时间',
  last_updated_by bigint(0) not null comment '最后修改人',
  deleted tinyint(0) default 0 comment '逻辑删除标识：0 未删除 1 已删除'
);
