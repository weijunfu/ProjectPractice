insert into TB_RESOURCE values(1, null, '系统管理', 0, '', '', 1);
insert into TB_RESOURCE values(11, 1, '角色管理', 1, 'role/toList', '', 1);
insert into TB_RESOURCE values(12, 1, '账号管理', 1, 'account/toList', '', 2);
insert into TB_RESOURCE values(2, null, '客户管理', 0, '', '', 2);
insert into TB_RESOURCE values(21, 2, '客户管理', 1, 'customer/toList', '', 1);

insert into TB_ROLE(role_id, role_name, created_by, last_updated_by) values (1, '程序开发', 1, 1);

insert into TB_ROLE_RESOURCE values (1, 1, 1);
insert into TB_ROLE_RESOURCE values (2, 1, 2);
insert into TB_ROLE_RESOURCE values (3, 1, 11);
insert into TB_ROLE_RESOURCE values (4, 1, 12);
insert into TB_ROLE_RESOURCE values (5, 1, 21);

insert into TB_ACCOUNT values (1, 1, 'root', 'ce080973368b7094e3f64601da430fde', 'Axxop6OBcHdZvZi6zQ8g4rh69DGVkF9v', '超级管理员', '男', 'ijunfu@qq.com', current_timestamp(), 1, current_timestamp(), 1, 0);

insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (1, '马仁毅', '男', 'fengrenyi@ijunfu.org', '131xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (2, '郭山彤', '女', 'guoshantong@ijunfu.org', '132xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (3, '查良镛', '男', 'chaliangyong@ijunfu.org', '133xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (4, '饶敏莉', '女', 'raominli@ijunfu.org', '151xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (5, '欧子欣', '女', 'ouzixin@ijunfu.org', '152xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (6, '刘绰琪', '女', 'liuzhuoqi@ijunfu.org', '153xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (7, '徐岑子', '男', 'xuqinzi@ijunfu.org', '171xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (8, '邵小珊', '女', 'shaoxiaoshan@ijunfu.org', '173xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (9, '魏佳庆', '男', 'weijiaqing@ijunfu.org', '166xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (10, '陈娟红', '女', 'chenjuanhong@ijunfu.org', '183xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (11, '赵一涵', '男', 'zhaoyihan@ijunfu.org', '188xxxxxxxx', '', 1, 1);
insert into TB_CUSTOMER(customer_id, real_name, sex, email, phone, address, created_by, last_updated_by) values (12, '周娇', '女', 'zhoujiao@ijunfu.org', '192xxxxxxxx', '', 1, 1);
