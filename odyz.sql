DROP DATABASE IF EXISTS `OldDeal`;
CREATE DATABASE OldDeal;
use OldDeal;
DROP TABLE IF EXISTS `OldDeal_user`;
CREATE TABLE `OldDeal_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) DEFAULT NULL,
  `upwd` varchar(32) DEFAULT NULL,
  `corfirmupwd` varchar(64) DEFAULT NULL,
  `QQ` varchar(32) DEFAULT NULL,
  `safe` varchar(200) DEFAULT NULL,
  `answer` varchar(200) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `memberLevel` int(11) DEFAULT NULL,
  `headImg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


LOCK TABLES `OldDeal_user` WRITE;
INSERT INTO `OldDeal_user` VALUES (1,'flower','123456','123456','15815815888','你知不知道我知道你是谁','知道',99,0,'img/person.jpg'),(2,'snow','123456','123456','2364220583','你知不知道我知道你是谁','知道',98,0,'img/person.jpg'),(3,'wangjf','123456','123456','2942014019','你知不知道我知道你是谁','知道',100,2,'img/person.jpg');
UNLOCK TABLES;


DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(12) DEFAULT NULL,
  `pwd` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (1,'wjf','123456');
UNLOCK TABLES;


DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `tipid` int(11) DEFAULT NULL,
  `tipmessage` varchar(200) DEFAULT NULL,
  `tipstatus` int(11) DEFAULT NULL,
  `tiptime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


LOCK TABLES `report` WRITE;
INSERT INTO `report` VALUES (1,1,2,'看起来很好玩的样子',1,'2017-04-14 17:15:11'),(2,1,2,'看起来很好玩的样子',0,'2017-04-14 17:15:50'),(3,1,2,'看起来好好玩',0,'2017-04-15 09:20:10'),(4,1,2,'看起来好好玩1',0,'2017-04-15 09:21:46'),(5,1,2,'看起来好好玩2',0,'2017-04-15 09:21:46'),(6,1,2,'看起来好好玩3',0,'2017-04-15 09:21:46'),(7,1,2,'看起来好好玩4',0,'2017-04-15 09:21:46'),(8,1,2,'看起来好好玩5',0,'2017-04-15 09:21:46'),(9,1,2,'看起来好好玩6',0,'2017-04-15 09:21:46'),(10,1,2,'看起来好好玩7',0,'2017-04-15 09:21:46'),(11,1,2,'看起来好好玩8',0,'2017-04-15 09:21:46'),(12,1,2,'看起来好好玩9',0,'2017-04-15 09:21:46'),(13,1,2,'看起来好好玩0',0,'2017-04-15 09:21:46'),(14,1,2,'看起来好好玩q',0,'2017-04-15 09:21:46'),(15,1,2,'看起来好好玩w',0,'2017-04-15 09:21:46'),(16,1,2,'看起来好好玩e',0,'2017-04-15 09:21:46'),(17,1,2,'看起来好好玩r',0,'2017-04-15 09:21:46'),(18,1,2,'看起来好好玩t',0,'2017-04-15 09:21:46'),(19,1,2,'看起来好好玩y',0,'2017-04-15 09:21:46'),(20,1,2,'看起来好好玩u',0,'2017-04-15 09:21:46'),(21,1,2,'看起来好好玩i',0,'2017-04-15 09:21:46'),(22,1,2,'看起来好好玩o',0,'2017-04-15 09:21:46'),(23,1,2,'看起来好好玩p',0,'2017-04-15 09:21:46'),(24,1,2,'看起来好好玩a',0,'2017-04-15 09:21:46'),(25,1,2,'看起来好好玩s',0,'2017-04-15 09:21:46'),(26,1,2,'看起来好好玩d',0,'2017-04-15 09:21:46'),(27,1,2,'看起来好好玩f',0,'2017-04-15 09:21:49');
UNLOCK TABLES;


DROP TABLE IF EXISTS `stuValidate`;
CREATE TABLE `stuValidate` (
  `stuNumber` int(11) NOT NULL AUTO_INCREMENT,
  `stuSchool` varchar(64) DEFAULT NULL,
  `stuName` varchar(64) DEFAULT NULL,
  `stuCollege` int(11) DEFAULT NULL,
  `stuId` int(12) DEFAULT NULL,
  `stuPic` varchar(200) DEFAULT NULL,
  `stuStat` int(1) DEFAULT NULL,
  PRIMARY KEY (`stuNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


LOCK TABLES `stuValidate` WRITE;
INSERT INTO `stuValidate` VALUES (1,'中原工学院','flower',10465,1,'/abc/abc',1);
UNLOCK TABLES;


