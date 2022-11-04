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

drop table if exists `resource`;
create table `resource`
(
    `id` bigint unsigned auto_increment comment '资源 id',
    `user_id` bigint unsigned not null comment '用户 id',
    `path` varchar(64) not null comment 'URI 路径',
    primary key `pk_resource` (`id`)
) ENGINE = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_general_ci comment '资源对应表';