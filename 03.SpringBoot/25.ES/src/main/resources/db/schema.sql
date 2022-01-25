drop table if exists tb_book;

create table tb_book(
    id bigint auto_increment primary key comment 'ID',
    name varchar(100) not null default '' comment '书名',
    author varchar(100) not null default '' comment '作者',
    publish_time date not null comment '出版日期',
    price double not null default 0.00 comment '价格',
    remarks varchar(256) not null default '' comment '备注'
);
