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
-- Table structure for table `eorder`
--

DROP TABLE IF EXISTS `eorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `eorder` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `odate` varchar(50) DEFAULT NULL,
  `Aid` int DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `Aid` (`Aid`),
  KEY `cid` (`cid`),
  KEY `payment_id` (`payment_id`),
  CONSTRAINT `eorder_ibfk_1` FOREIGN KEY (`Aid`) REFERENCES `address` (`Aid`),
  CONSTRAINT `eorder_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`),
  CONSTRAINT `eorder_ibfk_3` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eorder`
--

LOCK TABLES `eorder` WRITE;
/*!40000 ALTER TABLE `eorder` DISABLE KEYS */;
INSERT INTO `eorder` VALUES (8,'10/6/2022',10,125,10,50),(10,'10/6/2022',13,125,13,50),(11,'10/6/2022',14,125,14,30),(12,'10/6/2022',15,125,15,30),(13,'10/6/2022',16,125,16,30),(14,'10/6/2022',17,125,17,30),(15,'10/6/2022',18,125,18,30),(16,'10/6/2022',19,125,19,30),(17,'10/6/2022',20,125,20,120),(18,'10/6/2022',21,125,21,120),(19,'10/6/2022',22,125,22,80),(20,'10/6/2022',23,125,23,100),(21,'10/6/2022',24,125,24,60),(22,'10/6/2022',25,125,25,30),(23,'10/6/2022',26,125,26,30),(24,'10/6/2022',27,125,27,30),(25,'10/6/2022',28,125,28,30),(26,'10/6/2022',29,125,29,30),(27,'12/6/2022',31,125,30,160),(28,'12/6/2022',32,130,31,80),(29,'12/6/2022',33,130,32,30),(30,'12/6/2022',34,130,33,140),(31,'13/6/2022',35,132,34,60),(32,'13/6/2022',36,132,35,30),(33,'13/6/2022',37,132,36,80),(34,'13/6/2022',38,132,37,90),(35,'13/6/2022',39,125,38,100),(36,'13/6/2022',41,134,39,100),(37,'13/6/2022',42,125,40,200),(38,'13/6/2022',43,125,41,140),(39,'13/6/2022',44,133,42,200),(40,'13/6/2022',45,133,43,100);
/*!40000 ALTER TABLE `eorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 22:01:53
