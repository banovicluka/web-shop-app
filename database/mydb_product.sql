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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `new` tinyint NOT NULL,
  `location` varchar(45) NOT NULL,
  `category_id` int NOT NULL,
  `purchased` tinyint NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category1_idx` (`category_id`),
  KEY `fk_product_user1_idx` (`user_id`),
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Iphone 11','Potpuno ocuvan buraz',1000.00,1,'Banja Luka',1,1,1),(19,'sdasd','asdasd',234.00,1,'sdfsdf',1,0,2),(20,'sdasd','asdasd',234.00,1,'sdfsdf',1,0,2),(23,'Sto','asdasdasdasd',1000.00,0,'Prijedor',5,0,1),(27,'asdasd','asdasd',222.00,1,'asad',2,0,1),(35,'Stan u Banjoj Luci','Opremljen stan 46m kvadratnih',90000.00,0,'Banja Luka',2,0,1),(36,'asdasd','asdas',222.00,1,'Asda',5,0,1),(41,'ddd','dd',55.00,0,'vvv',5,0,1),(42,'were','wrwerwr',22.00,0,'33',5,0,1),(43,'dosa','asd',22.00,1,'sd',5,0,1),(44,'dasda','asdasd',22.00,1,'sdfasd',5,0,1),(45,'ffff','ffff',333.00,1,'vv',5,0,1),(46,'as','as',2.00,1,'as',5,0,1),(47,'asdfaf','asdasd',100.00,0,'BL',1,0,1),(48,'Automobil crveni','Automobil u ekstra stanju, godiste 2000, prvi vlasnik.',19900.00,0,'Prijedor',6,0,31),(49,'Automobil zuti','Automobil uvezen prije 5 godinja iz Njemacke, trenutno bez papira,',3000.00,0,'Banja Luka',6,0,31),(50,'Frizider','Frizider nov, pod garancijom',3000.00,1,'Trebinje',8,0,31),(51,'Putovanje na planinu','Jeftino putovanje za dvoje.',399.00,1,'Bijeljina',9,0,31),(52,'Saptac pima','Jeftina usluga dresiranja psa',10.00,1,'Banja Luka',9,0,2),(53,'Hrana za kibice','Najbolja u gradu',2.00,1,'Trebinje',7,0,2),(54,'Pringls cips','Limited edition najboljeg cipsa na svijetu.',5.00,1,'Prijedor',7,0,2),(55,'Hauba od auta','Dio auta',100.00,0,'Bijeljina',8,0,2),(56,'Iphone 11','Polovan Iphone, jos pod garancijom',1000.00,0,'Banja Luka',1,0,2),(57,'Samsung Galaxy','Nov telefon, dostupan u raznim bojama',700.00,1,'Zenica',1,0,2),(58,'TV','LG TV, uzeo sam ga prije 3 mjeseca, nekoristen',500.00,1,'Sarajevo',8,0,2),(59,'Trapezarijski sto','Pravljen od punog drveta',100.00,1,'Sarajevo',5,0,24),(60,'Automobil','Automobil',10000.00,1,'Zenica',6,0,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-29  0:35:46
