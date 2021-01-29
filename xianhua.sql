/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.36 : Database - sushe
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xianhua` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Admin_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_Username` varchar(20) DEFAULT NULL,
  `Admin_Password` varchar(20) DEFAULT NULL,
  `Admin_Name` varchar(20) DEFAULT NULL,
  `Admin_State` varchar(10) DEFAULT NULL,
  `Admin_err` int(20) DEFAULT '0',
  PRIMARY KEY (`Admin_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`Admin_ID`,`Admin_Username`,`Admin_Password`,`Admin_Name`,`Admin_State`,`Admin_err`) values (1,'admin','123456','admin','',0),(2,'ttt','ttt','ttt','0',0),(3,'ttt','ttt','ttt','0',0),(4,'rr','tt','','0',0);

/*Table structure for table `classification` */

DROP TABLE IF EXISTS `classification`;

CREATE TABLE `classification` (
  `Clazz_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Clazz_Name` varchar(50) DEFAULT NULL,
  `Clazz_Introduction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Clazz_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `classification` */

insert  into `classification`(`Clazz_ID`,`Clazz_Name`,`Clazz_Introduction`) values (1,'名花1','这个111'),(2,'香花2','这个2222');

/*Table structure for table `flower` */

DROP TABLE IF EXISTS `flower`;

CREATE TABLE `flower` (
  `Flower_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Flower_ClazzID` int(11) DEFAULT NULL,
  `Flower_Name` varchar(20) DEFAULT NULL,
  `Flower_Type` varchar(20) DEFAULT NULL,
  `Flower_Number` varchar(20) DEFAULT NULL,
  `Flower_Money` varchar(20) DEFAULT NULL,
  `Flower_Sell_Money` varchar(20) DEFAULT NULL,
  `Flower_Pic1` varchar(100) DEFAULT NULL,
  `Flower_Pic2` varchar(100) DEFAULT NULL,
  `Flower_Pic3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Flower_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `flower` */

insert  into `flower`(`Flower_ID`,`Flower_ClazzID`,`Flower_Name`,`Flower_Type`,`Flower_Number`,`Flower_Money`,`Flower_Sell_Money`,`Flower_Pic1`,`Flower_Pic2`,`Flower_Pic3`) values (1,1,'11','11','11','11','1','1.jpg','',''),(2,2,'002','111','12','312','1','1.png','',''),(3,1,'1','2','3','5','6',NULL,NULL,NULL),(5,1,'4','5','7','8','9','IT (1).png','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
