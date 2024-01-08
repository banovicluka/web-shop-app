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
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(1000) NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_product_idx` (`product_id`),
  CONSTRAINT `fk_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'assets/images/iphone.jpg',1),(2,'assets/images/iphone2.jpg',1),(6,'assets/images/c86a7e71-846f-4341-92a2-248bb5365d4d_A_black_image.jpeg',19),(7,'assets/images/725342ca-88d4-4cab-80e9-bcf3b1e4e070_addButton.png',19),(8,'assets/images/c86a7e71-846f-4341-92a2-248bb5365d4d_A_black_image.jpeg',20),(9,'assets/images/725342ca-88d4-4cab-80e9-bcf3b1e4e070_addButton.png',20),(10,'assets/images/7e11d8ab-70e4-48ca-ad47-c6ff403a8016_addButton.png',20),(11,'assets/images/188c1853-cd0d-438a-b67c-8c831bef21c8_A_black_image.jpeg',20),(12,'assets/images/d8ea1a35-4c30-4ef7-8e23-8b75b56e1290_A_black_image.jpeg',23),(13,'assets/images/02fc42cd-a978-4070-ab68-ad14b42111ec_A_black_image.jpeg',27),(14,'assets/images/067877ad-38b4-4628-8e3b-218e979ac764_thumb_1657190602_dnevni-boravak-i-kuhinja.jpg',35),(15,'assets/images/067877ad-38b4-4628-8e3b-218e979ac764_thumb_1657190602_dnevni-boravak-i-kuhinja.jpg',35),(16,'assets/images/8df1a761-2ddd-41e0-ac52-174aaa078f79_IMG_3573-1200x1600.jpg',35),(17,'assets/images/f7b3d09f-615f-4088-99eb-32a5003909a3_A_black_image.jpeg',36),(18,'assets/images/no-pic.png',41),(19,'assets/images/no-pic.png',42),(20,'assets/images/no-pic.png',43),(21,'assets/images/no-pic.png',44),(22,'assets/images/no-pic.png',45),(23,'assets/images/no-pic.png',46),(24,'assets/images/ba18712c-2f4a-4716-aee0-35460afe63e8_A_black_image.jpeg',47),(25,'assets/images/0c2cf10e-ed14-48f2-96be-bb2b6f91cdb3_img-1692284386-6403b9e3271e.jpg',48),(26,'assets/images/05273ca4-e381-4c2c-865e-f2a9f55c6244_img-1692284551-560409a32ba2.jpg',48),(27,'assets/images/0c2cf10e-ed14-48f2-96be-bb2b6f91cdb3_img-1692284386-6403b9e3271e.jpg',48),(28,'assets/images/c09aa584-f371-4673-8807-54f4a4a24111_img-1692611455-178382c5664b.jpg',49),(29,'assets/images/c09aa584-f371-4673-8807-54f4a4a24111_img-1692611455-178382c5664b.jpg',49),(30,'assets/images/c53a96d1-1dc8-4482-8096-dc705b71d1c4_img-1692612438-29213864b1c6.jpg',49),(31,'assets/images/b1d46681-b811-4e9f-a994-96a1e50d6bbc_img-1688653552-481321202264.jpg',50),(32,'assets/images/0f4da111-aa38-48e6-ad3e-800b453137bc_img-1688653553-db80e5969cdc.jpg',50),(33,'assets/images/b1d46681-b811-4e9f-a994-96a1e50d6bbc_img-1688653552-481321202264.jpg',50),(34,'assets/images/5414b421-f092-42af-b542-cac59a2558e7_bcdrKdeZekrYW7Q0PsVA.jpg',51),(35,'assets/images/no-pic.png',52),(36,'assets/images/161fb70b-b49c-4cbb-82ff-b5a9f678fd96_slika-49509-63ab6c761145a-velika.jpg',53),(37,'assets/images/cccf80f5-3b89-4f65-addb-eacb4c2d973f_slika-2373486-63c018236556f-velika-2.jpg',54),(38,'assets/images/8b8aa2d2-070d-49e1-8e61-2bb35f59a3a2_slika-2373486-63c018236556f-velika.jpg',54),(39,'assets/images/cccf80f5-3b89-4f65-addb-eacb4c2d973f_slika-2373486-63c018236556f-velika-2.jpg',54),(40,'assets/images/61519a83-ecda-4f8f-80e0-08ea652e94a1_img-1677766967-5ced697d261d.jpg',55),(41,'assets/images/0dd612c4-bec5-4355-93d9-dee06db308fd_6ynf91h3trxbutbrdp3c.jpg',56),(42,'assets/images/578f497f-3b27-4800-a57f-0fb2ddab5336_ba-galaxy-a23-5g-sm-a236-sm-a236blbueuc-thumb-533703729.webp',57),(43,'assets/images/578f497f-3b27-4800-a57f-0fb2ddab5336_ba-galaxy-a23-5g-sm-a236-sm-a236blbueuc-thumb-533703729.webp',57),(44,'assets/images/613a4f5f-a440-45cb-8f33-6a5502fc6157_ba-galaxy-a53-5g-a536-sm-a536bzkleuc-thumb-531389127.webp',57),(45,'assets/images/5fe7fece-b0f7-41e8-9d0b-130e7da7c55f_OfDoAEkWa8f1HMPfz3Zk.jpg',58),(46,'assets/images/001118f0-b239-44b6-9d46-8abef3dcde22_bcdrKdeZekrYW7Q0PsVA.jpg',58),(47,'assets/images/5fe7fece-b0f7-41e8-9d0b-130e7da7c55f_OfDoAEkWa8f1HMPfz3Zk.jpg',58),(48,'assets/images/6475bee6-adb1-4321-8fa4-99f6026bdc5c_2RogXLqfqyea9b6Z7n8N.jpg',59),(49,'assets/images/6475bee6-adb1-4321-8fa4-99f6026bdc5c_2RogXLqfqyea9b6Z7n8N.jpg',59),(50,'assets/images/98762392-f460-402e-9cfd-ebfd95c5fba4_b8gyROtLCn5I8rZ2aAac.jpg',59),(51,'assets/images/6bf21ea5-9cce-4f98-bf0d-8c65cf14d40b_img-1692611455-178382c5664b.jpg',60);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
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
