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

INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('1', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('2', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('3', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('4', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('5', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('6', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('7', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('8', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('9', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('10', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('11', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('12', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('13', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('14', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('15', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('16', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('17', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('18', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('19', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '1');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('20', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('21', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('22', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('23', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('24', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('25', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('26', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('27', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('28', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('29', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('30', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('31', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('32', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
INSERT INTO `crblog`.`book` (`id`, `cover`, `title`, `author`, `date`, `press`, `abs`, `cid`) VALUES ('33', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '方多睡放是', '大萨达', '2019-05-05', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '2');
