DROP DATABASE if exists  test;
CREATE DATABASE `crblog`;
USE `crblog`;

/*创建用户表（user）*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*插入数据*/
INSERT INTO `user` VALUES ('1', 'admin', '123');
