-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pistol
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `authorization`
--

DROP TABLE IF EXISTS `authorization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorization` (
  `id_authorization` int NOT NULL AUTO_INCREMENT,
  `login` text,
  `password` text,
  `id_passport` bigint DEFAULT NULL,
  PRIMARY KEY (`id_authorization`),
  UNIQUE KEY `id_authorization_UNIQUE` (`id_authorization`),
  KEY `fa_id_passport_idx` (`id_passport`),
  CONSTRAINT `fa_id_passport` FOREIGN KEY (`id_passport`) REFERENCES `person` (`id_passport`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorization`
--

LOCK TABLES `authorization` WRITE;
/*!40000 ALTER TABLE `authorization` DISABLE KEYS */;
INSERT INTO `authorization` VALUES (9,'admin','admin',717300000),(12,'katy','12345',1234567890),(14,'breg','al',2211334455),(32,'111','111',2233111111);
/*!40000 ALTER TABLE `authorization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case`
--

DROP TABLE IF EXISTS `case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case` (
  `number_of_case` int NOT NULL AUTO_INCREMENT,
  `service_number_of_employee` int DEFAULT NULL,
  `number_of_gangster` int DEFAULT NULL,
  `status_of_case` varchar(45) DEFAULT NULL,
  `name_of_case` varchar(45) DEFAULT NULL,
  `date_of_crime` date DEFAULT NULL,
  PRIMARY KEY (`number_of_case`),
  UNIQUE KEY `number_of_case_UNIQUE` (`number_of_case`),
  KEY `fc_service_number_of_employee_idx` (`service_number_of_employee`),
  KEY `fc_number_of_gangster_idx` (`number_of_gangster`),
  CONSTRAINT `fc_number_of_gangster` FOREIGN KEY (`number_of_gangster`) REFERENCES `gangster` (`number_of_gangster`),
  CONSTRAINT `fc_service_number_of_employee` FOREIGN KEY (`service_number_of_employee`) REFERENCES `employee` (`service_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case`
--

LOCK TABLES `case` WRITE;
/*!40000 ALTER TABLE `case` DISABLE KEYS */;
INSERT INTO `case` VALUES (1,220002,23456,'закрыто','разбой','2004-08-05');
/*!40000 ALTER TABLE `case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id_contact` int NOT NULL AUTO_INCREMENT,
  `mail` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_contact`),
  UNIQUE KEY `id_contact_UNIQUE` (`id_contact`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (5,'r.zamuruev@vk.com','89197408462'),(8,'dayekaterina@gmail.com','89997650233'),(10,'alena@mail.ru','8998876655'),(25,'a','a'),(28,'ii@mail.ru','89996675643');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `number_of_department` int NOT NULL AUTO_INCREMENT,
  `phone_of_department` varchar(45) DEFAULT NULL,
  `name_of_department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`number_of_department`),
  UNIQUE KEY `number_of_department_UNIQUE` (`number_of_department`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (112,'89679065478','IT-отдел');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `service_number` int NOT NULL AUTO_INCREMENT,
  `serial_number_of_weapon` int DEFAULT NULL,
  `id_passport` bigint DEFAULT NULL,
  `number_of_department` int DEFAULT NULL,
  `ranks` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `id_contact` int DEFAULT NULL,
  PRIMARY KEY (`service_number`),
  UNIQUE KEY `service_number_UNIQUE` (`service_number`),
  KEY `fe_id_passport_idx` (`id_passport`),
  KEY `fe_id_contact_idx` (`id_contact`),
  KEY `fe_serial_number_of_weapon_idx` (`serial_number_of_weapon`),
  KEY `fe_number_of_department_idx` (`number_of_department`),
  CONSTRAINT `fe_id_contact` FOREIGN KEY (`id_contact`) REFERENCES `contact` (`id_contact`),
  CONSTRAINT `fe_id_passport` FOREIGN KEY (`id_passport`) REFERENCES `person` (`id_passport`),
  CONSTRAINT `fe_number_of_department` FOREIGN KEY (`number_of_department`) REFERENCES `department` (`number_of_department`),
  CONSTRAINT `fe_serial_number_of_weapon` FOREIGN KEY (`serial_number_of_weapon`) REFERENCES `weapon` (`serial_number`)
) ENGINE=InnoDB AUTO_INCREMENT=220064 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (220040,NULL,717300000,NULL,'генерал','1.000.000',5),(220043,NULL,1234567890,NULL,'ТикТокер','5.000.000',8),(220045,NULL,2211334455,NULL,'лейтенант','100.000',10),(220063,NULL,2233111111,NULL,'лейтенант','100.000',28);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factory`
--

DROP TABLE IF EXISTS `factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factory` (
  `id_factory` int NOT NULL AUTO_INCREMENT,
  `date_of_creation` date DEFAULT NULL,
  `name_of_factory` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_factory`),
  UNIQUE KEY `id_factory_UNIQUE` (`id_factory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factory`
--

LOCK TABLES `factory` WRITE;
/*!40000 ALTER TABLE `factory` DISABLE KEYS */;
INSERT INTO `factory` VALUES (10002,'1999-04-04','А-завод');
/*!40000 ALTER TABLE `factory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gangster`
--

DROP TABLE IF EXISTS `gangster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gangster` (
  `number_of_gangster` int NOT NULL AUTO_INCREMENT,
  `id_passport` bigint DEFAULT NULL,
  PRIMARY KEY (`number_of_gangster`),
  UNIQUE KEY `number_of_gangster_UNIQUE` (`number_of_gangster`),
  KEY `fg_id_passport_idx` (`id_passport`),
  CONSTRAINT `fg_id_passport` FOREIGN KEY (`id_passport`) REFERENCES `person` (`id_passport`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gangster`
--

LOCK TABLES `gangster` WRITE;
/*!40000 ALTER TABLE `gangster` DISABLE KEYS */;
INSERT INTO `gangster` VALUES (23456,908123098),(5,1111111111),(2,2233112209),(1,2233112233),(6,3333333333),(3,3344558899),(4,4455990088);
/*!40000 ALTER TABLE `gangster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imageprofile`
--

DROP TABLE IF EXISTS `imageprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imageprofile` (
  `id_imageProfile` int NOT NULL AUTO_INCREMENT,
  `id_passport` bigint DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_imageProfile`),
  UNIQUE KEY `idimageProfile_UNIQUE` (`id_imageProfile`),
  KEY `fip_id_passport_idx` (`id_passport`),
  CONSTRAINT `fip_id_passport` FOREIGN KEY (`id_passport`) REFERENCES `person` (`id_passport`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imageprofile`
--

LOCK TABLES `imageprofile` WRITE;
/*!40000 ALTER TABLE `imageprofile` DISABLE KEYS */;
INSERT INTO `imageprofile` VALUES (17,717300000,'file:/C:/Users/zamur/Downloads/IMG_2960.jpg'),(19,1234567890,'file:/C:/Users/zamur/Downloads/e1188130.jpg'),(20,2211334455,'file:/C:/Users/zamur/Downloads/e4oxQdnB-50.jpg');
/*!40000 ALTER TABLE `imageprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_passport` bigint NOT NULL DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_passport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (12,NULL,'a','a'),(717300000,NULL,'Замуруев','Роман'),(908123098,'2000-04-16','Захаров','Андрей'),(1111111111,'2001-01-01','Коваленко','Денис'),(1234567890,NULL,'Деенкова','Екатерина'),(2211334455,NULL,'Брежнева','Алена'),(2233111111,NULL,'Иванов','Иван'),(2233112209,'2001-01-01','Андреев','Кирилл'),(2233112233,'2001-01-01','Гундина','Ольга'),(3333333333,'2001-01-01','Кирилов','Генадий'),(3344558899,'2001-01-01','Голдовский','Иван'),(4455990088,'2001-01-01','Захаров','Дмитрий');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon`
--

DROP TABLE IF EXISTS `weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapon` (
  `serial_number` int NOT NULL AUTO_INCREMENT,
  `id_factory` int DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `date_of_prodaction` date DEFAULT NULL,
  PRIMARY KEY (`serial_number`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`),
  KEY `fw_id_factory_idx` (`id_factory`),
  CONSTRAINT `fw_id_factory` FOREIGN KEY (`id_factory`) REFERENCES `factory` (`id_factory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon`
--

LOCK TABLES `weapon` WRITE;
/*!40000 ALTER TABLE `weapon` DISABLE KEYS */;
INSERT INTO `weapon` VALUES (100986,10002,'K2','new','20000','2001-12-12');
/*!40000 ALTER TABLE `weapon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 20:57:33
