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

/*Table structure for table `apprecord` */

DROP TABLE IF EXISTS `apprecord`;

CREATE TABLE `apprecord` (
  `apprecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `attend_status` varchar(10) DEFAULT NULL,
  `cost_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`apprecord_id`),
  KEY `FK_医护人员预约记录表` (`emp_id`),
  KEY `FK_病人和预约记录表` (`patient_id`),
  KEY `FK_预约记录与医技项目` (`project_id`),
  CONSTRAINT `FK_医护人员预约记录表` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`),
  CONSTRAINT `FK_病人和预约记录表` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `FK_预约记录与医技项目` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `apprecord` */

/*Table structure for table `aroom` */

DROP TABLE IF EXISTS `aroom`;

CREATE TABLE `aroom` (
  `aroom_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroom_name` varchar(20) DEFAULT NULL,
  `aroom_code` varchar(20) DEFAULT NULL,
  `aroom_addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `aroom` */

insert  into `aroom`(`aroom_id`,`aroom_name`,`aroom_code`,`aroom_addr`) values (1,'急诊室','101','门诊部一楼'),(2,'内科','105','门诊大楼二楼'),(3,'妇产科','203','门诊大楼二楼'),(4,'麻醉科','104','麻醉室');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `croom` */

insert  into `croom`(`croom_id`,`aroom_id`,`croom_code`,`croom_addr`) values (1,1,'100','急诊室一楼'),(2,4,'115','麻醉室'),(3,3,'204','妇产组二楼'),(4,2,'305','内科组三楼');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`emp_id`,`aroom_id`,`user_id`,`emp_name`,`emp_birthday`,`emp_grade`) values (1,2,2,'张飞','2009-05-11','内科医师'),(2,3,3,'貂蝉','2020-03-09','妇产科主任'),(3,1,4,'李小龙','2020-03-10','副院长'),(20,1,7,'完','2020-03-14','专家');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `equipment` */

insert  into `equipment`(`equipment_id`,`aroom_id`,`equipment_name`,`equipment_status`) values (1,2,'呼吸机','正常'),(2,1,'心电监护仪','正常'),(3,1,'心电图机','正常'),(4,3,'B超设备','正常'),(5,4,'多功能麻醉机','正常');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`role_id`,`user_id`,`patient_name`,`patient_age`,`patient_sex`,`patient_count`,`patient_status`) values (1,4,5,'张三',25,'男',0,'否'),(2,4,6,'柳柳',18,'女',0,'否'),(3,4,13,'w\'w\'w',20,'男',0,'否');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`name`,`parent_id`,`url`) values (1,'操作',NULL,NULL),(2,'系统管理',1,NULL),(3,'基础管理',1,NULL),(4,'医护人员管理',1,NULL),(5,'病人管理',1,NULL),(6,'权限管理',2,'/permission/index'),(7,'角色管理',2,'/role/index'),(8,'设备管理',3,NULL),(9,'科室管理',3,NULL),(10,'诊室管理',3,NULL),(11,'号源类型',3,'/sourceType/index'),(12,'员工管理',3,'/emp/index'),(13,'班次管理',3,NULL),(14,'医技组管',3,NULL),(15,'医技项目',3,NULL),(16,'队列管理',3,'/queue/queueList'),(17,'号源池',4,'/source/sourceList'),(18,'叫号',4,NULL),(19,'预约管理',5,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`project_id`,`skillgroup_id`,`equipment_id`,`project_name`,`project_cost`,`project_comment`) values (1,1,2,'心脏检查','500.00','。。。。。'),(2,2,1,'心脏复苏','3000.00','。。。。。'),(3,3,5,'手术治疗','1000.00','。。。。。');

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `rolepermission` */

insert  into `rolepermission`(`rp_id`,`role_id`,`permission_id`) values (4,3,1),(5,3,4),(6,3,17),(7,3,18),(13,1,1),(14,1,2),(15,1,6),(16,1,7),(17,1,3),(18,1,8),(19,1,9),(20,1,10),(21,1,11),(22,1,12),(23,1,13),(24,1,14),(25,1,15),(26,1,16),(27,1,4),(28,1,17),(29,1,18),(30,1,5),(31,1,19),(32,2,1),(33,2,3),(34,2,8),(35,2,9),(36,2,10),(37,2,11),(38,2,12),(39,2,13),(40,2,14),(41,2,15),(42,2,16),(43,4,1),(44,4,5),(45,4,19);

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `datestart` time DEFAULT NULL,
  `datelast` time DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_号源池与排班计划` (`source_id`),
  CONSTRAINT `FK_号源池与排班计划` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `schedule` */

insert  into `schedule`(`schedule_id`,`source_id`,`date`,`datestart`,`datelast`) values (1,1,'2020-03-10','08:30:00','17:30:00'),(2,2,'2020-03-11','08:30:00','17:30:00'),(3,2,'2020-03-13','08:30:00','12:00:00'),(4,3,'2020-03-15','13:50:00','17:30:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `skillgroup` */

insert  into `skillgroup`(`skillgroup_id`,`aroom_id`,`source_id`,`skillgroup_name`) values (1,2,1,'内科组'),(2,1,2,'急诊科'),(3,4,3,'麻醉科');

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `queue_id` int(11) DEFAULT NULL,
  `skillgroup_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `source_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`source_id`),
  KEY `FK_医技组与号源池2` (`skillgroup_id`),
  KEY `FK_号源池与号源类型` (`type_id`),
  KEY `FK_队列与号源池` (`queue_id`),
  CONSTRAINT `FK_医技组与号源池2` FOREIGN KEY (`skillgroup_id`) REFERENCES `skillgroup` (`skillgroup_id`),
  CONSTRAINT `FK_号源池与号源类型` FOREIGN KEY (`type_id`) REFERENCES `sourcetype` (`type_id`),
  CONSTRAINT `FK_队列与号源池` FOREIGN KEY (`queue_id`) REFERENCES `queue` (`queue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `source` */

insert  into `source`(`source_id`,`queue_id`,`skillgroup_id`,`type_id`,`source_num`) values (1,1,1,2,300),(2,2,2,3,300),(3,3,3,4,200);

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
  `upwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`uname`,`upwd`) values (1,'tom','123'),(2,'andy','123'),(3,'jack','123'),(4,'jeery','123'),(5,'smms','123'),(6,'ideai','123'),(7,'twk','123'),(13,'123','123'),(14,'dxj','123');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert  into `userrole`(`ur_id`,`user_id`,`role_id`) values (1,1,1),(4,2,1),(5,3,3),(6,7,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
