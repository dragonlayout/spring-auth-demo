INSERT INTO `user` VALUES (1, 'admin', 'admin');
INSERT INTO `user` VALUES (2, 'root', 'root');

INSERT INTO `resource` VALUES (1, '/user/account', '账户管理');
INSERT INTO `resource` VALUES (2, '/user/role', '角色管理');
INSERT INTO `resource` VALUES (3, '/data', '数据管理');

INSERT INTO `role` VALUES (1, '超级管理员');
INSERT INTO `role` VALUES (2, '数据管理员');

INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);

INSERT INTO `role_resource` VALUES (1, 1, 1);
INSERT INTO `role_resource` VALUES (2, 1, 2);
INSERT INTO `role_resource` VALUES (3, 1, 3);
INSERT INTO `role_resource` VALUES (4, 2, 3);