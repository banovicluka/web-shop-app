CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pin` int NOT NULL,
  `active` tinyint NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Luka','Banovic','BL','/','banovic456@gmail.com',3232,1,'luka123','$2a$10$kB11Y6tjIgWtOi1eJBFtJOam4GwXxoGJmfrcMuAJsSG9hzV/o5Fyq'),(2,'Marko','Vranjes','Prijedor','/','dsdfs@gmail.com',3231,1,'marko','$2a$10$kB11Y6tjIgWtOi1eJBFtJOam4GwXxoGJmfrcMuAJsSG9hzV/o5Fyq'),(4,'Bredli','Kuper','Prijedor','/','banovic456@gmail.com',1029,0,'bridle','$2a$10$4Bcdf2zuDM4iJQfxekyMEud5VqrDeB88oinw6E9rUq8/2MM8lejAy'),(17,'Banana','Banana','Banja Luka','/','banovic456@gmail.com',1745,1,'banana','$2a$10$r5yCNMw.qmBF386FoQ56WO4jo.ctDkPTu/B0iHDJyiR5Jjsa6D3CW'),(18,'Luka','Banovic','Prijedor','/','banovic456@gmail.com',7176,1,'banabre','$2a$10$oZAg9i8GguXFebRJk7sJrO0EXWZN6IL5d1dgifjvD06FgKeWL5Jr6'),(19,'xgdfgdf','dfgdfg','dfgdfg','/','banovic456@gmail.com',6675,0,'brebre','$2a$10$jdRQ9aVnDROu4e7jSLKIWO3bYJSjXyJJNQL4ZdVJ8SrVANKmzCX5e'),(20,'dfgdfg','dfgdfg','dfgdfg','/','banovic456@gmail.com',6947,1,'brabra','$2a$10$706nrYzARSKgXnbyZ5GXIuF.fDH4LA7TVrGqI8rUGUpSf0XmjDyCG'),(23,'Bozo','Bozovic','Prijedor','/','mojmejl@gmail.com',4352,0,'bozobozo','$2a$10$TZItoOwgw0nHI/yS3tjL1uFD.1TV2i2BldMQKFW7rnnIq/JYT77FW'),(24,'dasd','asdasd','asdasdasd','/','banovic456@gmail.com',6245,1,'banucci','$2a$10$ymgYnsSE7r4IhJhWXjsERe/riBqrnYX19o8niQoadZObPFryWT6i2'),(25,'Marko','Mirkovic','Prijedor','/','banovic456@gmail.com',1277,1,'markic','$2a$10$td5SnF4a7yeo299x8wj3feARsUngfL/I4q0kHUOXbmIIvu6uzABH2'),(30,'lana','lana','Prijedor','/','banovic.lana.lb@gmail.com',5093,0,'lana','$2a$10$EqQ2W/1X.pUEiW1e7LIt2e0IDBGIasmMdxc8UcMrxnDAA61jzvmQC'),(31,'luka','luka','Banja Luka','/','banacar333@gmail.com',8847,1,'lukas','$2a$10$68plBqVJ.G4n5v7lGg1kSuvdPIuJG35g9hGWAPmkOg4fW1EBk5y3.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-29  0:35:47
