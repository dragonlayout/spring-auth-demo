INSERT INTO `user` VALUES (1, 'admin', 'admin');
INSERT INTO `user` VALUES (2, 'root', 'root');

INSERT INTO `resource` VALUES (1, '/user/account', '账户管理');
INSERT INTO `resource` VALUES (2, '/user/role', '角色管理');
INSERT INTO `resource` VALUES (3, '/data', '数据管理');

insert into `user_resource` values (1, 1, 1);
insert into `user_resource` values (2, 1, 2);
insert into `user_resource` values (3, 1, 3);
insert into `user_resource` values (4, 2, 3);