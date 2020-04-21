DROP DATABASE if exists  `crblog`;
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

/*创建图书表（book）*/
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `author` varchar(255) DEFAULT '',
  `date` varchar(20) DEFAULT '',
  `press` varchar(255) DEFAULT '',
  `abs` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_category_on_cid` (`cid`),
  CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

NSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('1', '封面1', '标题1', '张三', '20202222', '220', 'ss', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('2', '封面2', '标题2', '李四', '20202222', '220', 'ss', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('3', '封面3', '标题3', '王五', '20202222', '220', '啥', '3');

/*创建分类表（category）*/
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `crblog`.`category` (`id`, `name`) VALUES ('1', '校园');
INSERT INTO `crblog`.`category` (`id`, `name`) VALUES ('2', '都市');
INSERT INTO `crblog`.`category` (`id`, `name`) VALUES ('3', '玄幻');
INSERT INTO `crblog`.`category` (`id`, `name`) VALUES ('4', '修真');

