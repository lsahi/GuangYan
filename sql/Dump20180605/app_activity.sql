-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: app
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `idactivity` varchar(45) NOT NULL,
  `activityhost` varchar(45) DEFAULT NULL,
  `activityname` varchar(80) NOT NULL DEFAULT '我发起的校园召集活动',
  `activityinfo` longtext,
  `type1` tinyint(4) DEFAULT '0',
  `type2` tinyint(4) DEFAULT '0',
  `type3` tinyint(4) DEFAULT '0',
  `type4` tinyint(4) DEFAULT '0',
  `activityenabled` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`idactivity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES ('1','lsa','我发起的校园召集活动','大创 缺一名同学 程序',1,0,0,0,1),('2','hostname','大创召集','大创 缺一名策划',1,0,0,0,1),('20180531133311','hostname','1111','0.00',0,0,0,0,1),('20180531133814','hostname','1111','0.00',0,0,0,0,1),('20180531135011','Roll','020','时间\r\n地点\r\n活动',0,0,0,0,1),('20180531135943','Tom','1111newTest','try',0,0,0,0,1),('20180531140718','Jack','d','sss',0,0,0,0,1),('20180531140957','000','1231','sfsfs',0,0,0,0,1),('20180531141141','Test','1111','\r\n22',0,0,0,0,1),('20180531141611','2','自习','ssss',0,1,0,1,1),('20180531211827','3','新活动','没有描述',0,1,1,0,1),('20180601150612','lsahi','lsahi的第一个测试','时间 暂无\r\n地点 暂无',1,1,0,0,1),('20180601151451','lsahi','新建测试','我的测试',0,1,0,0,1),('3','111','约自习','周日全天 约自习',0,0,0,1,1),('4','0000','test','mytest',0,0,0,1,1);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-05 10:17:51
