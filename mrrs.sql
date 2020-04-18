/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.17 : Database - mrrs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mrrs` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mrrs`;

/*Table structure for table `accesslog` */

DROP TABLE IF EXISTS `accesslog`;

CREATE TABLE `accesslog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `method` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `accesslog` */

/*Table structure for table `apprecord` */

DROP TABLE IF EXISTS `apprecord`;

CREATE TABLE `apprecord` (
  `apprecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `attend_status` varchar(10) DEFAULT NULL,
  `cost_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`apprecord_id`),
  KEY `FK_医护人员预约记录表` (`emp_id`),
  KEY `FK_病人和预约记录表` (`patient_id`),
  KEY `FK_预约记录与医技项目` (`project_id`),
  KEY `schedule_id` (`schedule_id`),
  CONSTRAINT `FK_医护人员预约记录表` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`),
  CONSTRAINT `FK_病人和预约记录表` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `FK_预约记录与医技项目` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `apprecord_ibfk_1` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `apprecord` */

insert  into `apprecord`(`apprecord_id`,`emp_id`,`project_id`,`patient_id`,`schedule_id`,`attend_status`,`cost_status`) values (2,3,2,12,2,'否','否'),(3,3,2,12,18,'否','否'),(4,1,1,12,4,'否','否'),(5,3,2,12,4,'否','否'),(6,3,2,2,17,'否','否'),(7,3,2,13,17,'否','否');

/*Table structure for table `aroom` */

DROP TABLE IF EXISTS `aroom`;

CREATE TABLE `aroom` (
  `aroom_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_name` varchar(20) DEFAULT NULL,
  `aroom_code` varchar(20) DEFAULT NULL,
  `aroom_addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `aroom` */

insert  into `aroom`(`aroom_id`,`aroom_name`,`aroom_code`,`aroom_addr`) values (1,'急诊室','101','门诊大楼一楼'),(2,'内科','105','门诊大楼二楼'),(3,'妇产科','203','门诊大楼二楼'),(4,'麻醉科','104','门诊大楼一楼'),(5,'眼科','304','门诊大楼三楼'),(6,'放射科','404','门诊大楼四楼');

/*Table structure for table `croom` */

DROP TABLE IF EXISTS `croom`;

CREATE TABLE `croom` (
  `croom_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_id` int(11) DEFAULT NULL,
  `croom_code` varchar(20) DEFAULT NULL,
  `croom_addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`croom_id`),
  KEY `FK_科室与诊室` (`aroom_id`),
  CONSTRAINT `FK_科室与诊室` FOREIGN KEY (`aroom_id`) REFERENCES `aroom` (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `croom` */

insert  into `croom`(`croom_id`,`aroom_id`,`croom_code`,`croom_addr`) values (1,1,'100','急诊室一楼'),(2,4,'115','麻醉室'),(3,3,'204','妇产组二楼'),(4,2,'305','内科组三楼'),(5,5,'306','门诊大楼三楼'),(6,6,'406','门诊大楼四楼');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `emp_name` varchar(20) DEFAULT NULL,
  `emp_birthday` date DEFAULT NULL,
  `emp_grade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_医护人员与科室` (`aroom_id`),
  KEY `FK_医护人员和用户` (`user_id`),
  CONSTRAINT `FK_医护人员与科室` FOREIGN KEY (`aroom_id`) REFERENCES `aroom` (`aroom_id`),
  CONSTRAINT `FK_医护人员和用户` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`emp_id`,`aroom_id`,`user_id`,`emp_name`,`emp_birthday`,`emp_grade`) values (1,2,2,'张飞','2009-05-11','内科医师'),(2,3,3,'貂蝉','2020-03-09','妇产科主任'),(3,1,4,'李小龙','2020-03-10','副院长'),(20,1,7,'田文凯','2020-03-14','医生'),(29,2,26,'王大锤','2020-04-11','医生'),(30,3,27,'王五','2020-04-01','医生'),(31,5,28,'李四','2020-04-16','医生'),(32,4,33,'李二狗','2020-03-31','医生'),(33,6,34,'张大炮','2020-04-03','医生'),(34,5,35,'张志宏','2020-04-09','专家');

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_id` int(11) DEFAULT NULL,
  `equipment_name` varchar(50) DEFAULT NULL,
  `equipment_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  KEY `FK_设备与科室` (`aroom_id`),
  CONSTRAINT `FK_设备与科室` FOREIGN KEY (`aroom_id`) REFERENCES `aroom` (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `equipment` */

insert  into `equipment`(`equipment_id`,`aroom_id`,`equipment_name`,`equipment_status`) values (1,2,'呼吸机','正常'),(2,1,'心电监护仪','正常'),(3,1,'心电图机','正常'),(4,3,'B超设备','正常'),(5,4,'多功能麻醉机','正常'),(6,5,'验光机','正常');

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `patient_name` varchar(20) DEFAULT NULL,
  `patient_age` int(11) DEFAULT NULL,
  `patient_sex` varchar(10) DEFAULT NULL,
  `patient_count` int(11) DEFAULT NULL,
  `patient_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `FK_患者和用户` (`user_id`),
  KEY `FK_患者和角色` (`role_id`),
  CONSTRAINT `FK_患者和用户` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_患者和角色` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`role_id`,`user_id`,`patient_name`,`patient_age`,`patient_sex`,`patient_count`,`patient_status`) values (1,4,5,'张三',25,'男',0,'否'),(2,4,6,'柳柳',18,'女',0,'否'),(12,4,29,'刘备',25,'男',0,'否'),(13,4,30,'吕布',24,'男',0,'否'),(14,4,31,'小乔',18,'女',0,'否'),(15,4,32,'大桥',19,'女',0,'否');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  KEY `FK_自关联` (`parent_id`),
  CONSTRAINT `FK_自关联` FOREIGN KEY (`parent_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`name`,`parent_id`,`url`) values (1,'操作',NULL,NULL),(2,'系统管理',1,NULL),(3,'基础管理',1,NULL),(4,'医护人员管理',1,NULL),(5,'病人管理',3,'/patient/index'),(6,'权限管理',2,'/permission/index'),(7,'角色管理',2,'/role/index'),(8,'设备管理',3,'/Equipment/index'),(9,'科室管理',3,'/aroom/aroomListByPage'),(10,'诊室管理',3,'/croom/croomListByPage'),(11,'号源类型',3,'/sourceType/index'),(12,'员工管理',3,'/emp/index'),(13,'班次管理',3,'/schedule/index'),(14,'医技组管',3,'/Skillgroup/index'),(15,'医技项目',3,'/Project/index'),(16,'队列管理',3,'/queue/queueList'),(17,'号源池',4,'/source/sourceList'),(18,'叫号',4,'/queue/queueList'),(19,'预约管理',1,NULL),(20,'日志管理',2,'/accesslog/index'),(21,'个人信息',1,NULL),(28,'预约清单',19,'/apprecord/index'),(29,'预约',21,'/apprecord/goBook'),(32,'展示个人信息',21,'/Info/PersonInfo');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `skillgroup_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `project_name` varchar(50) DEFAULT NULL,
  `project_cost` decimal(10,2) DEFAULT NULL,
  `project_comment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK_医技组与医技项目` (`skillgroup_id`),
  KEY `FK_设备与医技项目` (`equipment_id`),
  CONSTRAINT `FK_医技组与医技项目` FOREIGN KEY (`skillgroup_id`) REFERENCES `skillgroup` (`skillgroup_id`),
  CONSTRAINT `FK_设备与医技项目` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`project_id`,`skillgroup_id`,`equipment_id`,`project_name`,`project_cost`,`project_comment`) values (1,1,2,'心脏检查','500.00','。。。。。'),(2,2,1,'心脏复苏','3000.00','。。。。。'),(3,3,5,'手术治疗','1000.00','。。。。。'),(4,1,4,'B超检查','130.00','。。。。。'),(5,1,2,'心电图','150.00','。。。。。'),(6,2,3,'心电图','150.00','。。。。。'),(7,7,NULL,'全身CT','600.00','。。。。。'),(8,6,6,'视力验光','50.00','。。。。。'),(9,3,5,'紧急镇定','150.00','。。。。。');

/*Table structure for table `queue` */

DROP TABLE IF EXISTS `queue`;

CREATE TABLE `queue` (
  `queue_id` int(11) NOT NULL AUTO_INCREMENT,
  `queue_num` int(11) DEFAULT NULL,
  `aroom_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`queue_id`),
  KEY `FK_科室与队列` (`aroom_id`),
  CONSTRAINT `FK_科室与队列` FOREIGN KEY (`aroom_id`) REFERENCES `aroom` (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `queue` */

insert  into `queue`(`queue_id`,`queue_num`,`aroom_id`) values (1,100,2),(2,101,2),(3,112,1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`) values (1,'系统管理员'),(2,'医护管理员'),(3,'医护人员'),(4,'患者');

/*Table structure for table `rolepermission` */

DROP TABLE IF EXISTS `rolepermission`;

CREATE TABLE `rolepermission` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rp_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `rolepermission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `rolepermission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8;

/*Data for the table `rolepermission` */

insert  into `rolepermission`(`rp_id`,`role_id`,`permission_id`) values (182,2,1),(183,2,3),(184,2,5),(185,2,8),(186,2,9),(187,2,10),(188,2,11),(189,2,12),(190,2,13),(191,2,14),(192,2,15),(193,2,16),(194,2,4),(195,2,17),(196,2,18),(197,2,19),(198,2,28),(199,2,21),(200,2,29),(201,2,32),(202,3,1),(203,3,4),(204,3,17),(205,3,18),(206,3,19),(207,3,28),(208,3,21),(209,3,29),(210,3,32),(211,4,1),(212,4,19),(213,4,28),(214,4,21),(215,4,29),(216,4,32),(217,1,1),(218,1,2),(219,1,6),(220,1,7),(221,1,20),(222,1,3),(223,1,5),(224,1,8),(225,1,9),(226,1,10),(227,1,11),(228,1,12),(229,1,13),(230,1,14),(231,1,15),(232,1,16),(233,1,4),(234,1,17),(235,1,18),(236,1,19),(237,1,28),(238,1,21),(239,1,29),(240,1,32);

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `skillgroup_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `datestart` time DEFAULT NULL,
  `datelast` time DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_号源池与排班计划` (`skillgroup_id`),
  KEY `source_id` (`source_id`),
  CONSTRAINT `FK_号源池与排班计划` FOREIGN KEY (`skillgroup_id`) REFERENCES `skillgroup` (`skillgroup_id`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `schedule` */

insert  into `schedule`(`schedule_id`,`skillgroup_id`,`date`,`datestart`,`datelast`,`source_id`) values (1,1,'2020-03-10','08:30:00','17:30:00',3),(2,2,'2020-03-11','08:30:00','17:30:00',3),(3,2,'2020-03-13','08:30:00','12:00:00',2),(4,3,'2020-03-15','13:50:00','17:30:00',4),(16,2,'2020-04-16','08:20:00','16:20:00',31),(17,3,'2020-04-16','12:20:00','18:20:00',32),(18,2,'2020-04-17','06:20:00','16:20:00',33),(19,1,'2020-04-17','09:20:00','11:20:00',34),(20,1,'2020-04-18','16:20:00','18:00:00',35),(21,2,'2020-04-17','17:20:00','18:00:00',33),(23,1,'2020-04-18','08:00:00','16:00:00',39),(24,3,'2020-04-19','08:00:00','16:00:00',40),(27,6,'2020-04-25','08:00:00','16:00:00',44),(28,2,'2020-04-21','08:00:00','16:00:00',45),(29,1,'2020-04-22','08:00:00','16:00:00',46),(30,1,'2020-04-23','08:00:00','16:00:00',47),(31,3,'2020-04-22','08:00:00','16:00:00',48),(32,7,'2020-04-22','08:00:00','16:00:00',49),(33,2,'2020-04-20','08:00:00','16:00:00',50),(34,3,'2020-04-20','08:00:00','12:00:00',51),(35,6,'2020-04-21','08:00:00','12:00:00',52);

/*Table structure for table `shift` */

DROP TABLE IF EXISTS `shift`;

CREATE TABLE `shift` (
  `Shift_id` int(11) NOT NULL AUTO_INCREMENT,
  `Source_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Shift_id`),
  KEY `fk_1` (`Source_id`),
  CONSTRAINT `fk_1` FOREIGN KEY (`Source_id`) REFERENCES `source` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `shift` */

insert  into `shift`(`Shift_id`,`Source_id`) values (1,1),(2,2);

/*Table structure for table `skillgroup` */

DROP TABLE IF EXISTS `skillgroup`;

CREATE TABLE `skillgroup` (
  `skillgroup_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `skillgroup_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`skillgroup_id`),
  KEY `FK_医技组与号源池` (`source_id`),
  KEY `FK_科室与医技组` (`aroom_id`),
  CONSTRAINT `FK_医技组与号源池` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`),
  CONSTRAINT `FK_科室与医技组` FOREIGN KEY (`aroom_id`) REFERENCES `aroom` (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `skillgroup` */

insert  into `skillgroup`(`skillgroup_id`,`aroom_id`,`source_id`,`skillgroup_name`) values (1,2,1,'内科组'),(2,1,2,'急诊科'),(3,4,3,'麻醉科'),(6,5,31,'眼科组'),(7,6,4,'放射科组');

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `skillgroup_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `source_num` int(11) DEFAULT NULL,
  `queue_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`source_id`),
  KEY `FK_医技组与号源池2` (`skillgroup_id`),
  KEY `FK_号源池与号源类型` (`type_id`),
  CONSTRAINT `FK_医技组与号源池2` FOREIGN KEY (`skillgroup_id`) REFERENCES `skillgroup` (`skillgroup_id`),
  CONSTRAINT `FK_号源池与号源类型` FOREIGN KEY (`type_id`) REFERENCES `sourcetype` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `source` */

insert  into `source`(`source_id`,`skillgroup_id`,`type_id`,`source_num`,`queue_id`) values (1,1,2,200,NULL),(2,2,3,298,NULL),(3,3,4,200,NULL),(4,1,1,20,NULL),(31,2,1,200,NULL),(32,3,1,200,NULL),(33,2,1,300,NULL),(34,1,1,300,NULL),(35,1,1,300,NULL),(36,6,4,200,NULL),(37,7,4,50,NULL),(39,6,1,300,NULL),(40,7,1,200,NULL),(44,6,1,300,NULL),(45,2,1,300,NULL),(46,1,1,300,NULL),(47,1,1,300,NULL),(48,3,1,300,NULL),(49,7,1,300,NULL),(50,2,1,300,NULL),(51,3,1,300,NULL),(52,6,1,300,NULL);

/*Table structure for table `sourcetype` */

DROP TABLE IF EXISTS `sourcetype`;

CREATE TABLE `sourcetype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `sourcetype` */

insert  into `sourcetype`(`type_id`,`type_name`) values (1,'挂号'),(2,'手术'),(3,'治疗'),(4,'检查');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `upwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`uname`,`upwd`) values (2,'andy','202cb962ac59075b964b07152d234b70'),(3,'jack','202cb962ac59075b964b07152d234b70'),(4,'jeery','202cb962ac59075b964b07152d234b70'),(5,'smms','202cb962ac59075b964b07152d234b70'),(6,'ideai','202cb962ac59075b964b07152d234b70'),(7,'twk','202cb962ac59075b964b07152d234b70'),(26,'wangdachui','202cb962ac59075b964b07152d234b70'),(27,'wangwu','202cb962ac59075b964b07152d234b70'),(28,'lisi','202cb962ac59075b964b07152d234b70'),(29,'liubei','202cb962ac59075b964b07152d234b70'),(30,'lvbu','202cb962ac59075b964b07152d234b70'),(31,'xiaoqiao','202cb962ac59075b964b07152d234b70'),(32,'daqiao','202cb962ac59075b964b07152d234b70'),(33,'liergou','202cb962ac59075b964b07152d234b70'),(34,'zhangdapao','202cb962ac59075b964b07152d234b70'),(35,'zhangzhihong','202cb962ac59075b964b07152d234b70');

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert  into `userrole`(`ur_id`,`user_id`,`role_id`) values (5,3,3),(6,7,1),(8,5,4),(9,26,3),(10,27,3),(11,28,2),(12,29,4),(13,30,4),(14,31,4),(15,32,4),(16,4,3),(17,2,2),(18,33,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
