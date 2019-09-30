/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.5-10.1.10-MariaDB : Database - bank_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bank_db`;

/*Table structure for table `tabungan_tbl` */

DROP TABLE IF EXISTS `tabungan_tbl`;

CREATE TABLE `tabungan_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `kredit` int(11) DEFAULT NULL,
  `debet` int(11) DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tabungan_tbl` */

insert  into `tabungan_tbl`(`id`,`nik`,`nama`,`kredit`,`debet`,`saldo`,`createTime`) values (1,'02041701','Amelia',500000,0,500000,'2019-09-30 10:16:00'),(3,'02041705','Sidik',8600000,0,8600000,'2019-09-30 10:47:02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
