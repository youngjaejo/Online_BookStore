-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: book
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auth_user`
--

DROP TABLE IF EXISTS `auth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_user` (
  `auth_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user`
--

LOCK TABLES `auth_user` WRITE;
/*!40000 ALTER TABLE `auth_user` DISABLE KEYS */;
INSERT INTO `auth_user` VALUES (1,'Youngjae','Jo','admin@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED'),(22,'Angelica','Turingan','gellopoink@gmail.com','$2a$10$.CcaxyLfBDJF3ZF6P8c9tOaLjfR0l7viQgnELRgHEJy3LSwJQKwyu','VERIFIED'),(23,'Youngjea','Jo','goodstanjo@gmail.com','$2a$10$qxseOW0qC8YDzYNZuAm4rel7Tp/RWXVa.23eB5TtkrPDTcyFfrWPG','VERIFIED'),(24,'haha','jo','haha@gmail.com','$2a$10$RVQnbbP/yKePwV5/VrvjSuhygHSs54K39.FiEieahd4JW2QOM7qhy','VERIFIED'),(25,'jajja','Jo','123@gmail.com','$2a$10$86eXAk9LNPJ2M1myrQnfO.g5Zbuqpm.mJYuWNg.yzyWfrXG4jWja2','VERIFIED'),(26,'juju','Jo','gg@gmail.com','$2a$10$swoceoHxW1EIFOebKsN8ROpMkzo1Ra0HC5P7vLoPZRoR4/HsYXH.y','VERIFIED'),(27,'aaaa','a','2@gmail.com','$2a$10$CMYePu64023Jy/fSTLAv0u.hkcP0YzBq7DUHUIGvgJD62RULfWdP6','VERIFIED'),(28,'aa','b','3@gmail.com','$2a$10$STxQauENeHfVr83vQWp8Oe91Fo5Y1BRK5BbHcFzFUkHc7JhaULQOO','VERIFIED'),(29,'z','zz','5@gmail.com','$2a$10$m0t9TO5gwVRdr5yxYzp.SeyEaUsMIrd9P1Y9ftkeCZAgZPapgrLq2','VERIFIED'),(30,'tt','Jo','tttt@gmail.com','$2a$10$naCgjVvuY3gNjTEP9KGXKe.Oh4xM7HUu9eCEql/50owha7C3I7eCC','VERIFIED'),(31,'asdf','adf','2424@gmail.com','$2a$10$U82c7QlKtO0j/uctujC2Setb0tHk/9KPJRU7awvDYbKWBftv0J1ZK','VERIFIED'),(32,'hhhh','hh','hhh@gmail.com','$2a$10$tqmt5AmklG6mUThydsIL7uhz/yldxrtu54VqNFm1/4g1UeDuFuSNK','VERIFIED'),(35,'Angelica','Turingan','gellopoink1@gmail.com','$2a$10$T5Pm6SxGeJiVONSpz2qYve4B0JO8i7Ia8zuPuV0E9ijgbT1YG9h7e','VERIFIED'),(36,'123123','123','hhh1@gmail.com','$2a$10$qj1K1SKqWkuEDDp0mNiit.aElmq/Od0U3vLPbZTVC3G0e19YBqbQ2','VERIFIED'),(37,'Youngjea','Jo','hhh2@gmail.com','$2a$10$VxQm0kyjVpLg5kqpqooVP.kYlQT80ecmeEIWf2IgzCmBONhSGNF7O','VERIFIED'),(38,'asdf','asdf','hhh4@gmail.com','$2a$10$Lpu2iat3xf44syMBiEU7Sumj86JqzyFgOGu5WP9tpccVQYryxPLvS','VERIFIED'),(39,'asdfasdf','asdfasdf','hhh5@gmail.com','$2a$10$V04DXNP5xiL8.hiEHcK8ouXQmj0zwDtMHrJkDd4kB9Bjo4hlSjPCq','VERIFIED'),(40,'Youngjea','Jo','hhh8@gmail.com','$2a$10$xQ90pp.nfeaBi1McsVnV/ewnAwrhB8vrzN65gaa2zy7FNQuCEynve','VERIFIED'),(41,'afef','wer','hhh7@gmail.com','$2a$10$jIEurt6J6Bry6Xg41eoCwO42AJGbWK2skeK/YWt5SirInQ/NTiRlm','VERIFIED'),(42,'adfwer','Jo4','hhh9@gmail.com','$2a$10$j9nb8HyiKpxH9F/kCzrFv.i5aH0BCCqPWzSC/.qPRdajD07iuhFPq','VERIFIED');
/*!40000 ALTER TABLE `auth_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-09  0:54:29
