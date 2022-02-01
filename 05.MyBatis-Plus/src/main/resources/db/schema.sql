
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