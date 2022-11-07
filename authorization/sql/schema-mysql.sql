drop table if exists `user`;
create table `user`
(
    `id`       bigint unsigned auto_increment comment '用户 id',
    `username` varchar(64) not null comment '用户名',
    `password` varchar(32) not null comment '密码',
    primary key `pk_user` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '用户表';

drop table if exists `role`;
create table `role`
(
   `id` bigint unsigned auto_increment comment '角色 id',
   `name` varchar(50) not null comment '角色名',
   primary key `pk_role` (`id`)
) ENGINE = InnoDB
   default charset = utf8mb4
   collate = utf8mb4_general_ci comment '角色表';


drop table if exists `resource`;
create table `resource`
(
    `id`   bigint unsigned auto_increment comment '资源 id',
    `path` varchar(255) not null comment 'URI 路径',
    `name` varchar(255) not null comment '名称',
    `type` tinyint unsigned not null comment '类型(0页面权限 1操作权限)',
    primary key `pk_resource` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '资源表';

drop table if exists `user_resource`;
create table `user_resource`
(
    `id`          bigint unsigned auto_increment comment '主键 id',
    `user_id`     bigint unsigned not null comment '',
    `resource_id` bigint unsigned not null comment '',
    primary key `pk_user_resource` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '用户资源对应表';

drop table if exists `user_role`;
create table `user_role`
(
    `id`          bigint unsigned auto_increment comment '主键 id',
    `user_id`     bigint unsigned not null comment '用户 id',
    `role_id` bigint unsigned not null comment '角色 id',
    primary key `pk_user_role` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '用户角色对应表';

drop table if exists `role_resource`;
create table `role_resource`
(
    `id`          bigint unsigned auto_increment comment '主键 id',
    `role_id`     bigint unsigned not null comment '用户 id',
    `resource_id` bigint unsigned not null comment '角色 id',
    primary key `pk_role_resource` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '角色资源对应表';