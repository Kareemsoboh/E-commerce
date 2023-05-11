-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address` (
  `Aid` int NOT NULL AUTO_INCREMENT,
  `city` varchar(32) DEFAULT NULL,
  `village` varchar(32) DEFAULT NULL,
  `street` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'ramallah','birzeit','birzeit','0568200503'),(2,'ramallah','birzeit','birzeit','0568200503'),(3,'ramallah','birzeit','birzjgdsh','i546934'),(4,'ramallah','birzeit','birzjgdsh','5857'),(5,'tfdgd','bfddf','bbdf','54353'),(6,'uudfu','gu','ufd','554'),(7,'gfdgdf','gfdgfd','gfdg','432'),(8,'dsadsa','dsadsa','dsadsa','1234'),(9,'vzvds','vxcvcx','vcxv','1234'),(10,'fdsfdsf','fdsfds','fdsfd','1234'),(11,'ramallah','tereh','zvi','123456789'),(12,'ramallah','tereh','ere','12345'),(13,'ramallah','tereh','cock','0458200503'),(14,'dsad','dsadas','dssad','321321'),(15,'dsa','dsad','dasd','2'),(16,'fas','sfafas','fas','2'),(17,'fsaf','fsafsa','fsaf','1'),(18,'SDA','DSA','DSA','2'),(19,'dsadas','dsad','dsad','123'),(20,'ramallah','alrehan','lacasamall','012612521'),(21,'ewae','ewqeqw','ewqew','33'),(22,'ramallah','ramallah','ramallah','12345'),(23,'Rammallah','birzait','ain','0595683952'),(24,'ramallah','street','street','12345'),(25,'gsdg','gdsgd','gdsg','21'),(26,'fsa','fasf','fddsafd','12'),(27,'adsa','dsadsa','das','123'),(28,'dsfaf','fsafda','sadas','1234'),(29,'fdz','fds','fdsf','123'),(30,'ramallah','birzeit','ameer hassan','0568828290'),(31,'ramallah','birzeit','birzeit','0568560230'),(32,'fds','fds','fds','33'),(33,'dsad','dsad','dasdas','124241'),(34,'dsadsa','dsasd','dsaas','12345'),(35,'lo','hh','uuu','056'),(36,'fds','fdsfdsfsfds','fdsd','123'),(37,'dsfdsfdsfsd','fds','fdsf','123'),(38,'dsad','dsadsfsdfsd','fds','123'),(39,'','','',''),(40,'','','',''),(41,'ramallah','birzeit','birzeit','0568200503'),(42,'Ramallah','birait','ainhammam','05956756'),(43,'','','',''),(44,'Ramallah','yabroud','ghj','12345'),(45,'Ramallah','yabroud','dfgh','123456');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 22:01:54
