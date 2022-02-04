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