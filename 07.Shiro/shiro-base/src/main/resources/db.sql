drop table if exists users;
create table users(
    username varchar(30) comment '用户名',
    password varchar(64) comment '密码',
    password_salt varchar(64) comment '盐值'
);
insert into users(username,password) values('ijunfu', '123456');

drop table if exists user_roles;
create table user_roles(
    username varchar(30) comment '用户名',
    role_name varchar(30) comment '角色名'
);
insert into user_roles values('ijunfu', 'root');

drop table if exists roles_permissions;
create table roles_permissions(
    role_name varchar(30) comment '角色名',
    permission varchar(30) comment '权限'
);
insert into roles_permissions values('root', 'usr:del');