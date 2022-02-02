
drop table if exists tb_user;

create table tb_user(
  id bigint(20) not null primary key comment '主键',
  name varchar(30) not null default '' comment '姓名',
  age int(11) default 0 comment '年龄',
  email varchar(50) default '' comment '邮箱',
  manager_id bigint(20) default 0 comment '直属上级ID',
  create_time datetime default current_time comment '创建时间',
  constraint manager_fk foreign key (manager_id) references tb_user(id)
);

drop table if exists tb_teacher;
create table tb_teacher(
    id varchar(32) not null primary key comment '主键',
    name varchar(30) not null default '' comment '姓名',
    age int(11) default 0 comment '年龄',
    email varchar(50) default '' comment '邮箱',
    manager_id bigint(20) default 0 comment '直属上级ID',
    version int(11) default 1 comment '版本',
    deleted tinyint default 0 comment '是否被删除：0 未删除，1 已删除',
    create_time datetime default current_time comment '创建时间',
    last_update_time datetime default current_time comment '最后更新时间',
    constraint teacher_fk foreign key (manager_id) references tb_teacher(id)
);