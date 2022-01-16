drop table if exists tb_book;
create table tb_book (
  id int auto_increment primary key comment '编号',
  name varchar(64) not null default '' comment '书名',
  author varchar(128) not null default '' comment '作者',
  publisher varchar(128) not null default '' comment '出版社',
  remarks varchar(512) not null default '' comment '备注'
);
