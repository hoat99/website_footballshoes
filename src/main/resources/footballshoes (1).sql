CREATE DATABASE  IF NOT EXISTS `abc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `abc`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: abc
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `article_product`
--

DROP TABLE IF EXISTS `article_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_product` (
  `id_article_product` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name_product` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id_article_product`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_product`
--

LOCK TABLES `article_product` WRITE;
/*!40000 ALTER TABLE `article_product` DISABLE KEYS */;
INSERT INTO `article_product` VALUES (12,'<p><strong>ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK</strong>&nbsp;l&agrave; mẫu gi&agrave;y chuy&ecirc;n cho s&acirc;n cỏ nh&acirc;n tạo . Nhẹ , &ocirc;m ch&acirc;n , b&aacute;m s&acirc;n tốt l&agrave; cảm gi&aacute;c đầu ti&ecirc;n khi bạn xỏ tr&ecirc;n ch&acirc;n&nbsp;ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK .&nbsp;</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/229251c7-90ac-45aa-aa26-380e1285d154.png\" style=\"width:100%\" /></p>\n\n<p><strong>Asics c&oacute; thể coi l&agrave; nguồn cảm hứng , l&agrave; khu&ocirc;n mẫu tạo ra bước đi đầu ti&ecirc;n của đế chế Nike thương hiệu nổi tiếng đến từ Mỹ . Phil Knight l&agrave; người đồng s&aacute;ng lập , chủ tịch danh dự của đế chế NIKE . &Ocirc;ng muốn t&igrave;m hiểu xem c&oacute; d&ograve;ng gi&agrave;y n&agrave;o c&oacute; thể so s&aacute;nh được với c&aacute;c đ&ocirc;i gi&agrave;y đến từ Đức đang rất được y&ecirc;u th&iacute;ch tr&ecirc;n thế giới thời điểm hiện tại . Trong một lần đi khảo s&aacute;t v&agrave; học hỏi đ&atilde; bị bất ngờ trước chất lượng c&aacute;c đ&ocirc;i gi&agrave;y Asics đem lại . &Ocirc;ng xin được ph&acirc;n phối v&agrave; sau đ&oacute; l&agrave; săn đ&oacute;n c&aacute;c kỹ sư thiết kế để tạo ta thương hiệu Nike của ri&ecirc;ng m&igrave;nh .&nbsp;</strong></p>\n\n<p>Si&ecirc;u sao Iniesta hiện đang l&agrave; gương mặt đại diện nổi tiếng của thương hiệu đan ch&eacute;o huyền thoại đến từ Nhật Bản .</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/0e366a2a-4175-45af-b48a-0fe42550ddab.jpg\" style=\"width:100%\" /></p>\n\n<p>&nbsp;</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/2c053c21-2711-4e75-beef-2221812897c8.jpg\" style=\"width:100%\" /></p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/b99119ec-e67d-4d44-bfe8-6d1e862e4474.jpg\" style=\"width:100%\" /></p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/972d4b29-4769-4ede-9136-46507ef474c6.jpg\" style=\"width:100%\" /></p>\n\n<p>&nbsp;</p>\n\n<p><img alt=\"\" src=\"http://localhost:8080/img/aebd1ecd-0e67-46b2-9352-d03c631b98a6.jpg\" style=\"width:100%\" /></p>\n\n<p>&nbsp;</p>\n','ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK');
/*!40000 ALTER TABLE `article_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id_banner` int NOT NULL AUTO_INCREMENT,
  `img` varchar(500) COLLATE utf8mb4_bin NOT NULL,
  `content` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `short_description` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id_banner`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (16,'https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/Professional-Men-Superfly-Original-Soccer-Shoes-High-Ankle-Football-Boots-Shoes.jpg?alt=media&token=15a70159-85f9-476c-b28f-9e2cd3799d34','Football Shoes','Best shoes in the world','Selected'),(19,'http://localhost:8080/img/ddfc4ec9-f73b-4261-84ec-cdc735fb915c.png','Summer','Hot summer','Not selected'),(31,'https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1643380255869-Screenshot%20(2).png?alt=media&token=26a0d8a2-d3a7-49f3-a53f-f5df6e6db59a','Football Shoes','aloalo','Not selected'),(32,'https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1643380255869-Screenshot%20(2).png?alt=media&token=26a0d8a2-d3a7-49f3-a53f-f5df6e6db59a','Football Shoes','aloalo','Not selected');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id_cart` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `id_product` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cost` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id_cart`),
  KEY `FK_cart_product_idx` (`id_product`),
  CONSTRAINT `FK_cart_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (79,'hoat',23,1,1990000.00);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id_comment` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `id_product` bigint DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `FK13khro47l5ga9h5995u85l5di` (`id_product`),
  KEY `FKarq5xh8jp9xtdg8npd1ql6xfh` (`username`),
  CONSTRAINT `FK13khro47l5ga9h5995u85l5di` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`),
  CONSTRAINT `FKarq5xh8jp9xtdg8npd1ql6xfh` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courtyard`
--

DROP TABLE IF EXISTS `courtyard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courtyard` (
  `id_courtyard` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_courtyard`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courtyard`
--

LOCK TABLES `courtyard` WRITE;
/*!40000 ALTER TABLE `courtyard` DISABLE KEYS */;
INSERT INTO `courtyard` VALUES (1,'Sân cỏ nhân tạo'),(2,'Sân cỏ tự nhiên'),(3,'Futsal');
/*!40000 ALTER TABLE `courtyard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cthdn`
--

DROP TABLE IF EXISTS `cthdn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cthdn` (
  `hoa_don_nhap_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`hoa_don_nhap_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cthdn`
--

LOCK TABLES `cthdn` WRITE;
/*!40000 ALTER TABLE `cthdn` DISABLE KEYS */;
INSERT INTO `cthdn` VALUES (7,19,'2022-03-24 16:52:05','2022-03-24 16:52:05',2),(7,20,'2022-03-24 16:52:05','2022-03-24 16:52:05',1);
/*!40000 ALTER TABLE `cthdn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_campaign`
--

DROP TABLE IF EXISTS `discount_campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount_campaign` (
  `id_discount_campaign` bigint NOT NULL AUTO_INCREMENT,
  `start_at` datetime DEFAULT NULL,
  `end_at` datetime DEFAULT NULL,
  `discount` decimal(18,2) DEFAULT NULL,
  `name_product` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `original_cost` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id_discount_campaign`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_campaign`
--

LOCK TABLES `discount_campaign` WRITE;
/*!40000 ALTER TABLE `discount_campaign` DISABLE KEYS */;
INSERT INTO `discount_campaign` VALUES (1,'2022-01-15 14:56:00','2022-01-16 14:56:00',1.00,'abc','haloween',2.00),(3,'2022-01-15 15:03:00','2022-01-20 15:03:00',1550000.00,'ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK','Thang',1990000.00),(4,'2022-01-15 20:36:00','2022-01-19 20:36:00',1200000.00,'ASICS DS LIGHT WD FG - WHITE/BLACK','Thang',1800000.00);
/*!40000 ALTER TABLE `discount_campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firebase_token`
--

DROP TABLE IF EXISTS `firebase_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firebase_token` (
  `token` varchar(500) NOT NULL,
  `device_info` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firebase_token`
--

LOCK TABLES `firebase_token` WRITE;
/*!40000 ALTER TABLE `firebase_token` DISABLE KEYS */;
INSERT INTO `firebase_token` VALUES ('c06zPwKJNQDdPps6kS-feG:APA91bE4SV0xy__8VWS1terk3bjSXNaTiqmYMtDsZCnf33cnlYvvwWcWSvx-RaHXtGOk7CyWrYAjBJjjbQ9dWaVbLadBhIqtEKcHhTwM0-EG1LrsjPYIY7nxHxrriHtyyICXAXaDTvf5','\"fl=23f284\\nh=www.cloudflare.com\\nip=117.5.156.180\\nts=1640447702.756\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Linux; Android 10; Joy 3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Mobile Safari/537.36\\ncolo=HKG\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"'),('cfg_EBpcee6eh709ZjcOHd:APA91bHCO2H8aHAhpP3W4PzA_5rbNureXx6dZCqhR6JT3Zc2vFljDhaXzp4AiYe5ZZ5WPeMkhZwsZQhXY9iitt2Bpxd3aj3trS5qb5IGYlLpr5KcVuZHtC0c1r5djPJ3U7Fhc3vO9opx','\"fl=23f379\\nh=www.cloudflare.com\\nip=2402:800:613c:a0ea:ac81:37eb:5b7d:a333\\nts=1640674706.398\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62\\ncolo=HKG\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"'),('cmQYTY_5eYeVRquXetezmX:APA91bGqbJ-HAgUePNmZhp7OKqeJiu3mfCy9A5dbVz9enAFdGbAqDzFvNmhQ9ZCZv7t_b1deFiWfwL1KyuqwWblYysHN2snGzj5T1wsR941HAYePBJMy_31sR-qJwGCxlAMfnjbpddgd','\"fl=23f557\\nh=www.cloudflare.com\\nip=2402:800:613c:a0ea:1c25:3224:d4f9:95ca\\nts=1640590062.566\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36\\ncolo=HKG\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"'),('d3wmCHcjq9pRFPecCjY9Ib:APA91bHmSIERpmd_6QWIoeFydukoTSSB_xwEc9SV2jSP_26BFHaxtskI9z-na0l9yCnBuwWv1QxPXE5SpQzKclNkG47hZKDD9vNMLfbnTer0U187ex-Hb_jtvCMg499f1cgILSl4x1H6','\"fl=23f475\\nh=www.cloudflare.com\\nip=2402:800:613c:a0ea:ac81:37eb:5b7d:a333\\nts=1640675405.139\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36\\ncolo=HKG\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"'),('ds4qt3n-pbgR52_axofx8U:APA91bFiWdpmsvAHvUl5ahY21_5WFq58Gnbo2KVfNcQdd5wzxhQ_k4Q32GOEIv90Hv00xqpksN1BcbKVmxKE3UKfEaaDRqRdL7vW6dubpJiPJ5nFOfe077v4gRh8MUPMUIiqAyjaPynN','\"fl=177f8\\nh=www.cloudflare.com\\nip=1.55.171.119\\nts=1645588684.917\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36\\ncolo=HAN\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"'),('exPSFIdc7ZHvhxILd28YrN:APA91bFRHxYws9K3b5VLoYnxk-3YicR_anXWHeOVZn5WjCOH-5rVMT-IMEdF5Fk2ZU1orWLgDFnOu8VHSy2Q22ByaiTvhbv9NwxR9WJ6fXk8sW44nLyoh_RhT8lr_Upyc45n6wvkLPML','\"fl=23f422\\nh=www.cloudflare.com\\nip=117.5.156.89\\nts=1640677971.436\\nvisit_scheme=https\\nuag=Mozilla/5.0 (Linux; Android 10; Joy 3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Mobile Safari/537.36\\ncolo=HKG\\nhttp=http/2\\nloc=VN\\ntls=TLSv1.3\\nsni=plaintext\\nwarp=off\\ngateway=off\\n\"');
/*!40000 ALTER TABLE `firebase_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don_nhap`
--

DROP TABLE IF EXISTS `hoa_don_nhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don_nhap` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `supplier_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hoadonnhap_suppiler_idx` (`supplier_id`),
  CONSTRAINT `fk_hoadonnhap_suppiler` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don_nhap`
--

LOCK TABLES `hoa_don_nhap` WRITE;
/*!40000 ALTER TABLE `hoa_don_nhap` DISABLE KEYS */;
INSERT INTO `hoa_don_nhap` VALUES (7,'2022-03-24 16:52:05','2022-03-24 16:52:05',2);
/*!40000 ALTER TABLE `hoa_don_nhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id_image` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `image1` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `image3` varchar(255) DEFAULT NULL,
  `image4` varchar(255) DEFAULT NULL,
  `name_product` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_image`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (3,'http://localhost:8080/img/b3473913-a60c-42d5-91cf-35929682f064.jpeg','http://localhost:8080/img/3703f76d-491a-479c-95d0-3dee4056a5cc.jpeg','http://localhost:8080/img/2ca0b6bb-0fe1-43d7-bc51-b4702ea7bf6c.jpg','http://localhost:8080/img/682a248b-b4ad-431f-9ba2-358d48dd0d06.jpg','http://localhost:8080/img/ce6e8d70-9e2d-4c06-a7a7-f4cb535c33fe.jpg','Thang'),(4,'http://localhost:8080/img/92674f49-22b5-447c-bca6-107bec1d755c.jpeg','http://localhost:8080/img/b3ba4a19-25a9-4ffa-b090-95b987c8034f.jpeg','http://localhost:8080/img/53e0940b-15ea-4785-a86a-6d9272ba3c29.jpeg','http://localhost:8080/img/418cac39-464c-4e07-963a-9879f8991f7a.jpeg','http://localhost:8080/img/5d4ef140-df5b-4af1-8646-c5f2de3164fd.jpeg',NULL),(5,'http://localhost:8080/img/f4000cab-087c-4aa9-a654-877f5e2b0332.jpg','http://localhost:8080/img/f6487e7f-5d8d-4d34-bd5e-9dd87cc367fe.jpg','http://localhost:8080/img/fb290f2b-bb5b-4ccc-b521-82296a2e1d8d.jpg','http://localhost:8080/img/69b4631f-fc27-4036-8296-031a755e8ed5.jpg','http://localhost:8080/img/e0238575-a7b0-464c-be50-c3be8f3b8a44.jpg',NULL),(6,'http://localhost:8080/img/3dc28835-c164-49dd-8606-7fd07374ebaa.jpg','http://localhost:8080/img/b67805a1-8daf-4151-ac60-1e2f2f71b5c9.jpg','http://localhost:8080/img/42740731-c3e2-4ada-a41b-9273faafa922.jpg','http://localhost:8080/img/dcf746d5-c675-4c9a-959e-9f8e22aa20e4.jpg','http://localhost:8080/img/e8ff133d-23a3-4bb9-a32d-af917f14bb4c.jpg',NULL),(7,'http://localhost:8080/img/92414668-b2ca-480c-975b-3bd07d6308fe.jpg','http://localhost:8080/img/2595d31e-adef-4df8-bf73-7a0996c4ec79.jpg','http://localhost:8080/img/ab71915d-6028-40c8-bbfd-40bb5dcf4cc3.jpg','http://localhost:8080/img/9a90518e-4b16-430b-ae05-fe93041abca6.jpg','http://localhost:8080/img/da95b42b-971c-4937-8e66-37ea7db2d8d1.jpeg',NULL),(8,'http://localhost:8080/img/79664d51-4625-42c7-8375-8a933ee280c9.jpeg','http://localhost:8080/img/d8557d69-7273-4340-820e-08d64b555f6f.jpeg','http://localhost:8080/img/5dd2be21-f715-43bb-9ace-c1429f385a5f.jpeg','http://localhost:8080/img/cf582a62-cec0-4cfa-9c60-843f47cd554f.jpg','http://localhost:8080/img/5bfe90d7-e233-44ab-aa45-55a0a6b90c18.jpeg',NULL),(9,'http://localhost:8080/img/b1c75863-1707-4d3a-9036-431965cea624.jpeg','http://localhost:8080/img/25bb020f-a270-41ce-a352-8d2881bb41ac.jpeg','http://localhost:8080/img/43e1b2a2-f165-4ab3-a808-8f5aef3a17bc.jpeg','http://localhost:8080/img/2573609a-df87-485b-82c9-36646e78dc16.jpeg','http://localhost:8080/img/6e8f0ec7-c61f-4f8b-b6ec-13178d695488.jpeg',NULL),(10,'http://localhost:8080/img/cb4d1e28-d05c-4a3b-a2a9-004746711dd8.jpeg','http://localhost:8080/img/e7d4e77e-89d5-4182-8f25-cbb5993875ad.jpg','http://localhost:8080/img/dac76c95-6502-4f08-b0f1-09bab5f4721e.jpg','http://localhost:8080/img/60b9de64-95af-414b-806f-c4157e23dc92.jpg','http://localhost:8080/img/35749dce-8c09-45f7-a429-742f509defa8.jpg',NULL),(11,'http://localhost:8080/img/c14a9ed1-764d-4938-af85-461592b6ce06.jpg','http://localhost:8080/img/16decc3e-3f4b-48c4-86e6-4742c8149700.jpg','http://localhost:8080/img/f08e8ca3-ae17-4393-b812-00ddc0b9c5f1.jpg','http://localhost:8080/img/3e5b4a74-d515-4a3c-934c-e0ea07413193.jpg','http://localhost:8080/img/804f11dc-255b-45aa-8767-eed472946763.jpg','NIKE MERCURIAL SUPERFLY 8 ACADEMY MG CR7 SPARK POSITIVITY - CHILE REDBLACKWHITETOTAL ORANGE'),(12,'http://localhost:8080/img/0bdc6dbd-8542-4412-9fc1-79642b6c2c83.jpg','http://localhost:8080/img/a23825d3-d220-4ac8-a5e9-a720c42c451a.jpg','http://localhost:8080/img/165cf3d8-2fd3-4ee6-9c18-aab46f9ca7ef.jpeg','http://localhost:8080/img/333caf35-97bc-4ae8-bc21-89406bde5055.png','http://localhost:8080/img/6a737277-dbb3-45a8-9be8-893dcbd0b70d.jpg','ASICS ULTREZZA CLUB 2 AI SAFETY YELLOW/MAKO BLUE'),(13,'http://localhost:8080/img/d9e70314-c130-4bb5-98f1-f6a91083e29c.jpg','http://localhost:8080/img/23b76ef7-5ca7-4df8-811b-5fe6dcbf998d.jpg','http://localhost:8080/img/b9fffeed-4242-4ad2-b7e4-b20f142424ab.jpg','http://localhost:8080/img/d6636ef5-e609-46d2-963d-8e3a27b05df5.jpg','http://localhost:8080/img/d24817ec-18a3-4871-91e1-abb9db4b95ca.jpg','ASICS DS LIGHT WD FG - WHITE/BLACK'),(15,'http://localhost:8080/img/51175bfb-94d4-447a-ae87-28af51f9a71b.jpg','http://localhost:8080/img/5dc51d7b-6887-40c3-a1a4-b29c833c4178.jpg','http://localhost:8080/img/bc28b54b-db98-47eb-bfc3-5ebdceacbdaf.jpg','http://localhost:8080/img/c4e73a58-ad07-4c27-aa19-89ac7719f9ee.jpg','http://localhost:8080/img/72fab637-9ca7-4653-b781-9f2a6a6b2842.','ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_article`
--

DROP TABLE IF EXISTS `image_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_article` (
  `id_image_article` bigint NOT NULL AUTO_INCREMENT,
  `name_product` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `img1` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `img2` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `img3` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `img4` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `img5` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `img6` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id_image_article`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_article`
--

LOCK TABLES `image_article` WRITE;
/*!40000 ALTER TABLE `image_article` DISABLE KEYS */;
INSERT INTO `image_article` VALUES (1,'ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK','http://localhost:8080/img/229251c7-90ac-45aa-aa26-380e1285d154.png','http://localhost:8080/img/0e366a2a-4175-45af-b48a-0fe42550ddab.jpg','http://localhost:8080/img/2c053c21-2711-4e75-beef-2221812897c8.jpg','http://localhost:8080/img/b99119ec-e67d-4d44-bfe8-6d1e862e4474.jpg','http://localhost:8080/img/972d4b29-4769-4ede-9136-46507ef474c6.jpg','http://localhost:8080/img/aebd1ecd-0e67-46b2-9352-d03c631b98a6.jpg'),(2,'Thang','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1641041393855-_mg_9107_b48ad20bebc3438bb59b2d3f2ef00ade_1024x1024.jpg?alt=media&token=70280bb7-727a-4020-82e2-73513dec69e9','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product'),(3,'Adidas1','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1641041502038-_mg_9117_2c7f933551e34dcfa80562a43066a8b5_1024x1024.jpg?alt=media&token=fe0aea62-3ad1-44dd-adab-79159c180022','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1641041502677-anh_sp_add_web_2ascis-01-01_54038fe2e6614baba8b8fac11909362c_1024x1024.jpg?alt=media&token=3b60e822-97a6-4f3e-b81e-4ed86fdb7f49','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product'),(4,'Hoạt Nông','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/1641041550037-_mg_9128_44829e74d62f42d78c7f3872c4f7bf79_1024x1024.jpg?alt=media&token=4bb88b7d-4faa-49fc-bfa4-019c29ed02a5','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product','http://localhost:8080/admin/create-article-product');
/*!40000 ALTER TABLE `image_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order1`
--

DROP TABLE IF EXISTS `order1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order1` (
  `id_order1` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `received_at` datetime DEFAULT NULL,
  `price` decimal(18,2) DEFAULT NULL,
  `id_status` bigint DEFAULT NULL,
  `payment_method` varchar(45) DEFAULT NULL,
  `id_payment_info` bigint DEFAULT NULL,
  `check_rate` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `full_name` varchar(250) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_order1`),
  KEY `fk_order1_status_idx` (`id_status`),
  KEY `fk_order1_payment_info_idx` (`id_payment_info`),
  CONSTRAINT `fk_order1_payment_info` FOREIGN KEY (`id_payment_info`) REFERENCES `payment_info` (`id_payment_info`),
  CONSTRAINT `fk_order1_status` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1`
--

LOCK TABLES `order1` WRITE;
/*!40000 ALTER TABLE `order1` DISABLE KEYS */;
INSERT INTO `order1` VALUES (3,'abc','2022-02-11 20:29:37',NULL,3790000.00,1,NULL,NULL,_binary '',NULL,NULL,NULL,NULL,NULL),(4,'abc','2022-02-14 14:25:14',NULL,3790000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(6,'abc','2022-02-14 19:48:35',NULL,3980000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(7,'abc','2022-02-14 19:48:37',NULL,3980000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(8,'abc','2022-02-14 19:51:08',NULL,3980000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(9,'abc','2022-02-14 19:52:53',NULL,3980000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(10,'abc','2022-02-14 20:01:33',NULL,3980000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(11,'abc','2022-02-14 20:07:51',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(12,'abc','2022-02-14 20:09:45',NULL,199000000.00,1,'ONLINE',12,_binary '\0',NULL,NULL,NULL,NULL,NULL),(14,'abc','2022-02-17 14:26:40',NULL,199000000.00,1,'ONLINE',14,_binary '\0',NULL,NULL,NULL,NULL,NULL),(15,'abc','2022-02-17 14:38:41',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(16,'abc','2022-02-17 14:38:41',NULL,1990000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(17,'abc','2022-02-17 14:39:04',NULL,1990000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(18,'abc','2022-02-17 14:39:04',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(19,'abc','2022-02-17 14:45:55',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(20,'abc','2022-02-17 14:48:11',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(21,'abc','2022-02-17 14:48:28',NULL,1990000.00,1,'ONLINE',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(22,'abc','2022-02-17 14:50:00',NULL,1990000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(23,'abc','2022-02-17 14:52:45',NULL,3980000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(24,'abc','2022-02-17 14:53:31',NULL,3980000.00,1,'ONLINE',24,_binary '\0',NULL,NULL,NULL,NULL,NULL),(25,'abc','2022-02-17 23:08:43',NULL,1990000.00,1,'COD',NULL,_binary '',NULL,NULL,NULL,NULL,NULL),(26,'hoat','2022-02-22 19:57:46',NULL,3980000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(27,'abc','2022-02-22 20:43:23',NULL,3980000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(28,'hoat','2022-03-12 20:51:03',NULL,3980000.00,1,'COD',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL),(29,'hoat','2022-03-12 20:51:29',NULL,1990000.00,1,'ONLINE',29,_binary '',NULL,NULL,NULL,NULL,NULL),(30,'abc','2022-03-12 20:54:01',NULL,1990000.00,1,'ONLINE',30,_binary '\0',NULL,NULL,NULL,NULL,NULL),(31,'abc','2022-04-03 20:05:15',NULL,1990000.00,1,'ONLINE',31,_binary '\0',NULL,NULL,NULL,NULL,NULL),(32,'abc','2022-04-03 20:11:31',NULL,3980000.00,1,'ONLINE',32,_binary '\0',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `order1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id_order_detail` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(200) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `cost` decimal(18,2) DEFAULT NULL,
  `id_product` bigint DEFAULT NULL,
  `id_status` bigint DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `check_rate` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_order_detail`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (17,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,23,4,'a',1,NULL,_binary ''),(19,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',7960000.00,25,4,'',4,NULL,_binary ''),(20,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,39,4,'aaa',1,NULL,_binary ''),(21,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',2490000.00,40,4,'aaa',1,NULL,_binary ''),(22,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',3600000.00,20,4,'aa',2,NULL,_binary ''),(23,'',NULL,'hoat','','','',1800000.00,20,4,'',1,NULL,_binary ''),(24,NULL,NULL,NULL,NULL,NULL,NULL,1800000.00,20,1,NULL,1,NULL,NULL),(25,NULL,NULL,NULL,NULL,NULL,NULL,1990000.00,39,1,NULL,1,NULL,NULL),(26,NULL,NULL,NULL,NULL,NULL,NULL,1990000.00,39,1,NULL,1,NULL,NULL),(27,'Lạng Sơn',NULL,'hoat','0377254742','','Hoạt Nông',1990000.00,39,1,'',1,NULL,NULL),(28,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,39,1,'llllll',1,NULL,NULL),(29,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,39,1,'',1,NULL,NULL),(30,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',5970000.00,39,1,'',3,NULL,NULL),(31,'Lạng Sơn',NULL,'hoat','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,35,1,'',1,NULL,NULL),(32,'Lạng Sơn',NULL,'hoat','0377254742','nonghoat113@gmail.com','Hoạt Nông99',2490000.00,19,1,'oke',1,NULL,NULL),(34,'Lạng Sơn',NULL,'hoat99','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,23,1,'q',1,'2022-01-10 20:46:45',NULL),(35,'Lạng Sơn',NULL,'hoat99','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1990000.00,24,1,'',1,'2022-01-10 20:47:24',NULL),(36,'Lạng Sơn',NULL,'hoat99','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1800000.00,20,4,'',1,'2022-01-11 20:16:26',_binary ''),(37,'Lạng Sơn',NULL,'hoat99','0377254742','nongvanhoat1999@gmail.com','Hoạt Nông',1800000.00,20,4,'',1,'2022-01-11 20:38:18',_binary ''),(38,'Lạng Sơn',NULL,'hoat','0377254742','nonghoat113@gmail.com','Hoạt Nông99',3600000.00,20,1,'',2,'2022-01-18 20:23:40',_binary '\0'),(39,'Lạng Sơn',NULL,'hoat','0377254742','nonghoat113@gmail.com','Hoạt Nông99',1990000.00,23,1,'',1,'2022-01-18 20:23:40',_binary '\0'),(40,'Lạng Sơn',NULL,'hoat','0377254742','nonghoat113@gmail.com','Hoạt Nông99',1550000.00,35,1,'',1,'2022-01-18 20:25:06',_binary '\0'),(41,'Lạng Sơn',NULL,'hoat','0377254742','nonghoat113@gmail.com','Hoạt Nông99',2400000.00,20,1,'',2,'2022-01-18 20:26:34',_binary '\0');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `id_order` bigint NOT NULL,
  `id_product` bigint NOT NULL,
  `quantity` bigint DEFAULT NULL,
  `price` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_product`),
  KEY `fk_order-info_order_idx` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` VALUES (3,20,1,1200000.00),(3,23,1,1990000.00),(4,20,1,1200000.00),(4,23,1,1990000.00),(6,23,2,1990000.00),(6,24,1,1990000.00),(7,23,2,1990000.00),(7,24,1,1990000.00),(8,23,2,1990000.00),(8,24,1,1990000.00),(9,23,2,1990000.00),(9,24,1,1990000.00),(10,23,2,1990000.00),(10,24,1,1990000.00),(11,23,1,1990000.00),(12,23,1,1990000.00),(14,23,1,1990000.00),(15,23,1,1990000.00),(16,23,1,1990000.00),(17,23,1,1990000.00),(18,23,1,1990000.00),(19,24,1,1990000.00),(20,24,2,1990000.00),(21,24,2,1990000.00),(22,24,2,1990000.00),(23,24,2,1990000.00),(24,25,2,1990000.00),(25,23,1,1990000.00),(26,23,2,1990000.00),(27,23,2,1990000.00),(28,23,2,1990000.00),(29,23,1,1990000.00),(30,23,1,1990000.00),(31,23,1,1990000.00),(32,23,2,1990000.00);
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_info`
--

DROP TABLE IF EXISTS `payment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_info` (
  `id_payment_info` bigint NOT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `bank_code` varchar(45) DEFAULT NULL,
  `card_type` varchar(45) DEFAULT NULL,
  `order_info` varchar(255) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id_payment_info`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_info`
--

LOCK TABLES `payment_info` WRITE;
/*!40000 ALTER TABLE `payment_info` DISABLE KEYS */;
INSERT INTO `payment_info` VALUES (5,398000000.00,'NCB','ATM','thanh toan don hang','2022-02-14 14:53:08'),(12,1990000.00,'NCB','ATM','thanh toan don hang','2022-02-14 20:10:19'),(14,1990000.00,'NCB','ATM','thanh toan don hang','2022-02-17 14:26:58'),(24,3980000.00,'NCB','ATM','thanh toan don hang','2022-02-17 14:53:47'),(29,1990000.00,'NCB','ATM','thanh toan don hang','2022-03-12 20:51:52'),(30,1990000.00,'NCB','ATM','thanh toan don hang','2022-03-12 20:54:14'),(31,1990000.00,'NCB','ATM','thanh toan don hang','2022-04-03 20:07:03'),(32,3980000.00,'NCB','ATM','thanh toan don hang','2022-04-03 20:11:46');
/*!40000 ALTER TABLE `payment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` bigint NOT NULL AUTO_INCREMENT,
  `album` varchar(255) DEFAULT NULL,
  `cost` decimal(18,2) NOT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` bigint NOT NULL,
  `representative_player` varchar(255) DEFAULT NULL,
  `technology` varchar(255) DEFAULT NULL,
  `year_of_production` bigint DEFAULT NULL,
  `id_courtyard` bigint DEFAULT NULL,
  `id_image` bigint DEFAULT NULL,
  `id_strademark` bigint DEFAULT NULL,
  `size` int NOT NULL,
  `color` varchar(45) NOT NULL,
  `id_cart` int DEFAULT NULL,
  `name_removed_accent` varchar(255) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `id_article_product` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `number_of_rating` bigint DEFAULT NULL,
  `is_discount` bit(1) DEFAULT NULL,
  `cost_discount` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `FKrdih0wp2upu5ndj48jllb4v8y` (`id_courtyard`),
  KEY `FKb7kqfghf630cin68beuo2ras9` (`id_image`),
  KEY `FK7qu6todsqr5sakkmieu6xwwkf` (`id_strademark`),
  CONSTRAINT `FK7qu6todsqr5sakkmieu6xwwkf` FOREIGN KEY (`id_strademark`) REFERENCES `strademark` (`id_strademark`),
  CONSTRAINT `FKb7kqfghf630cin68beuo2ras9` FOREIGN KEY (`id_image`) REFERENCES `image` (`id_image`),
  CONSTRAINT `FKrdih0wp2upu5ndj48jllb4v8y` FOREIGN KEY (`id_courtyard`) REFERENCES `courtyard` (`id_courtyard`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (19,'',2490000.00,'Da tổng hợp mỏng nhẹ','ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK',22,'',' Đế đệm Foam êm ái và bám sân ',NULL,1,13,5,38,'Đỏ',NULL,'asics toque 6 tf - classic red/diva pink',NULL,'2022-01-28 21:00:00',NULL,NULL,NULL,_binary '\0',1550000.00),(20,'White/Black.',1800000.00,' Da tổng hợp độc quyền','ASICS DS LIGHT WD FG - WHITE/BLACK',2,'Ineista...','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,12,5,33,'Trắng',NULL,'asics ds light wd fg - white/black',NULL,'2022-02-17 23:27:17',NULL,4,5,_binary '\0',1200000.00),(21,'',1990000.00,'','ASICS ULTREZZA CLUB 2 AI SAFETY YELLOW/MAKO BLUE',12,'','',NULL,2,11,5,33,'Vàng',NULL,'asics ultrezza club 2 ai safety yellow/mako blue',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(23,'',1990000.00,' Da tổng hợp độc quyền','NIKE MERCURIAL SUPERFLY 8 ACADEMY MG RENEW - BLACKIRON GREY',10,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,3,3,33,'Vàng',NULL,'nike mercurial superfly 8 academy mg renew - blackiron grey',NULL,'2022-03-12 20:55:33',NULL,4.5,3,_binary '\0',NULL),(24,'',1990000.00,' Da tổng hợp độc quyền','NIKE TIEMPO LEGEND 9 PRO TF MOTIVATION - WHITEVOLTBRIGHT CRIMSON',11,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,4,3,33,'Vàng',NULL,'nike tiempo legend 9 pro tf motivation - whitevoltbright crimson',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(25,'',1990000.00,' Da tổng hợp độc quyền','PUMA FUTURE 6.1 NETFIT FGAG TURBO - LUMINOUS PINKPUMA BLACK',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,5,3,33,'Vàng',NULL,'puma future 6.1 netfit fgag turbo - luminous pinkpuma black',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(26,'',1990000.00,' Da tổng hợp độc quyền','PUMA ULTRA 1.1. FGAG TURBO - PUMA BLACKLUMINOUS PINK',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,6,3,33,'Vàng',NULL,'puma ultra 1.1. fgag turbo - puma blackluminous pink',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(27,'',1990000.00,' Da tổng hợp độc quyền','PUMA ULTRA 3.1 FGAG TURBO - PUMA BLACKLUMINOUS PINK',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,7,3,33,'Vàng',NULL,'puma ultra 3.1 fgag turbo - puma blackluminous pink',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(28,'',1990000.00,' Da tổng hợp độc quyền','ADIDAS COPA SENSE .1 FG WHITESPARK - FOOTWEAR WHITESOLAR REDIRON METAL',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,8,3,33,'Vàng',NULL,'adidas copa sense .1 fg whitespark - footwear whitesolar rediron metal',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(29,'',1990000.00,' Da tổng hợp độc quyền','ADIDAS PREDATOR FREAK .1 LOW FG WHITESPARK - FOOTWEAR WHITEIRON METALSOLAR RED',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,9,3,33,'Vàng',NULL,'adidas predator freak .1 low fg whitespark - footwear whiteiron metalsolar red',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(30,'',1990000.00,' Da tổng hợp độc quyền','ADIDAS PREDATOR FREAK .3 FGAG ESCAPELIGHT - CORE BLACKFOOTWEAR WHITE',12,'','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',2019,2,10,3,33,'Vàng',NULL,'adidas predator freak .3 fgag escapelight - core blackfootwear white',NULL,'2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(35,'White/Black.',1990000.00,' Da tổng hợp độc quyền','ASICS TOQUE 6 TF - CLASSIC RED/DIVA PINK',8,'Ineista...','Khuôn đế đệm GEL đàn hồi êm ái, 2 đinh tán cố định chắc chắn ở khuôn đế giày và cổ rời linh hoạt.',1234,1,12,5,40,'Đỏ',NULL,'asics toque 6 tf - classic red/diva pink',NULL,'2022-01-28 21:00:00',NULL,NULL,NULL,_binary '\0',1550000.00),(39,'HoatDZ',1990000.00,'afdfas','Thang',4,'HoatDZ',' Đế đệm Foam êm ái và bám sân ',2019,2,15,1,38,'Vàng',NULL,'thang','2021-12-24 21:37:30','2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL),(40,'White/Black.',2490000.00,' Da tổng hợp độc quyền','NIKE MERCURIAL SUPERFLY 8 ACADEMY MG CR7 SPARK POSITIVITY - CHILE REDBLACKWHITETOTAL ORANGE',12,'Ineista...',' Đế đệm Foam êm ái và bám sân ',2019,2,11,1,34,'Trắng',NULL,'nike mercurial superfly 8 academy mg cr7 spark positivity - chile redblackwhitetotal orange','2021-12-24 21:40:27','2022-01-18 20:14:31',NULL,NULL,NULL,_binary '\0',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_rating`
--

DROP TABLE IF EXISTS `product_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_rating` (
  `id_product_rating` bigint NOT NULL AUTO_INCREMENT,
  `id_product` bigint NOT NULL,
  `rate` int NOT NULL,
  `username` varchar(255) NOT NULL,
  `id_order` bigint DEFAULT NULL,
  PRIMARY KEY (`id_product_rating`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_rating`
--

LOCK TABLES `product_rating` WRITE;
/*!40000 ALTER TABLE `product_rating` DISABLE KEYS */;
INSERT INTO `product_rating` VALUES (6,25,5,'hoat',19),(8,39,5,'hoat',20),(9,40,2,'hoat',21),(10,20,4,'hoat',22),(11,20,5,'hoat',23),(12,20,5,'hoat99',36),(13,20,1,'hoat99',37),(14,23,4,'abc',NULL),(15,20,5,'abc',NULL),(16,23,5,'abc',NULL),(17,23,4,'hoat',NULL);
/*!40000 ALTER TABLE `product_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_code`
--

DROP TABLE IF EXISTS `role_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_code` (
  `id_role_code` bigint NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_code`
--

LOCK TABLES `role_code` WRITE;
/*!40000 ALTER TABLE `role_code` DISABLE KEYS */;
INSERT INTO `role_code` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selected_banner`
--

DROP TABLE IF EXISTS `selected_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selected_banner` (
  `content` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `short_description` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `img` varchar(500) COLLATE utf8mb4_bin NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selected_banner`
--

LOCK TABLES `selected_banner` WRITE;
/*!40000 ALTER TABLE `selected_banner` DISABLE KEYS */;
INSERT INTO `selected_banner` VALUES ('Football Shoes','Best shoes in the world','http://localhost:8080/img/558a1e93-3148-4cad-b48a-26be24fbb6f1.jpg',16);
/*!40000 ALTER TABLE `selected_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper` (
  `id_shipper` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_shipper`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id_status` bigint NOT NULL,
  `delivery_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Chờ xác nhận'),(2,'Đang lấy hàng'),(3,'Đang giao hàng'),(4,'Đã nhận hàng');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strademark`
--

DROP TABLE IF EXISTS `strademark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `strademark` (
  `id_strademark` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_strademark`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strademark`
--

LOCK TABLES `strademark` WRITE;
/*!40000 ALTER TABLE `strademark` DISABLE KEYS */;
INSERT INTO `strademark` VALUES (1,'Adidas','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/905d53cb87333d26e54c9b08cc6083c1--adidas-logo-adidas-brand.jpg?alt=media&token=344d870b-3f09-4758-a54b-62ace62a95a3'),(2,'Puma','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/PUMA_Logo_Cat_black.jpg?alt=media&token=16b2afaf-8ee4-4be9-97b6-687eab749921'),(3,'Nike','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/Nike583783.jpg?alt=media&token=cabfa8db-c4fd-456e-95f2-f851b3282bb4'),(5,'Asics','https://firebasestorage.googleapis.com/v0/b/imagestorage-739d0.appspot.com/o/93b30f7b6eebb69225189b386f78aa71.png?alt=media&token=4c9c8914-65b8-4d83-a2f0-8d14a8cc3229');
/*!40000 ALTER TABLE `strademark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribers`
--

DROP TABLE IF EXISTS `subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscribers` (
  `email` varchar(255) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribers`
--

LOCK TABLES `subscribers` WRITE;
/*!40000 ALTER TABLE `subscribers` DISABLE KEYS */;
INSERT INTO `subscribers` VALUES ('nongvanhoat1999@gmail.com',3),('nonghoat113@gmail.com',4),('nong1999@gmail.com',5);
/*!40000 ALTER TABLE `subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (2,'2022-03-19 15:47:05','2022-03-19 15:47:05','abc','Hoạt Nông');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_role_code` bigint DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `reset_password_token` varchar(30) DEFAULT NULL,
  `verification_code` varchar(64) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK9j23b8r0le6sxk16a3su7jisc` (`id_role_code`),
  CONSTRAINT `FK9j23b8r0le6sxk16a3su7jisc` FOREIGN KEY (`id_role_code`) REFERENCES `role_code` (`id_role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('103886852746063048342','nongvanhoat1999@gmail.com',NULL,'Hoạt Nông','$2a$10$M43KWXf37I2wuAm3VTotKO2aKGNisYqz9Hs.oN6F2qz.ZKmN1W99C',NULL,1,NULL,NULL,NULL,NULL),('104899024899786328514','nonghoatt99@gmail.com',NULL,'Dân IT','$2a$10$ctjqp6g0bgXFKC1kLOISWOd1cjCnn6Hz8yAFrGTW/SF5ODfam/Whu',NULL,1,NULL,NULL,NULL,NULL),('abc','nonghoatt99999@gmail.com','Nam',NULL,'$2a$10$vLcVqqkDYkHqJB3UNkvx1uvyQV5i6cS5tjymsAI08vMNpabEdLdLS','0377254742',1,'Lạng Sơn',NULL,NULL,_binary ''),('hoat','nonghoat113@gmail.com','Nam',NULL,'$2a$10$/2Y24OFj2U19KM1/AA9Ewe/.BXSuQYcB9Cqx.F3m9svHWcDhTsKrS','0377254742',2,'Lạng Sơn',NULL,NULL,_binary ''),('hoat1','nongvanhoat19998@gmail.com',NULL,NULL,'$2a$10$8d9Jace2vmgFSpv1oQZqu.GWGdvGuzCicZ5drR6HB/D3JnitYKxj.',NULL,1,NULL,NULL,NULL,NULL),('hoat112','nongvanhoat192@gmail.com',NULL,NULL,'$2a$10$MEJX5lAHXM2X6/XLl5HwKuDGurdbqljbb5ISQi7/7MUBzfBSao0Nm',NULL,1,NULL,NULL,NULL,_binary '\0'),('hoat2','nongvanhoat1999121@gmail.com',NULL,NULL,'$2a$10$lShFQ5MJJa6lufDsCr7lceVqeXfCCwgl2Uffl0lNr8/T3uyEdCFTK',NULL,1,NULL,NULL,NULL,NULL),('hoat99','nongvanhoat1999@gmail.com',NULL,NULL,'$2a$10$dwbfXRNCRHR0iKngh8GwTO44RHeexR561LMMTc7WyAVS714rX0/yK',NULL,1,NULL,NULL,NULL,_binary ''),('user1','',NULL,NULL,'$2a$10$TlL23k25ivmaokn7Zrmmm.44L52WnjrpXgkL4xM5M31WCd35uqjGe','',1,NULL,NULL,NULL,NULL),('user2','','Nam','Hoạt Nông','$2a$10$OoalN7msAbmXIE8gkjac.u7gYKgCBapQkTliSO.cYhu6KXim7f4ri','0377254742',1,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-04-11 11:24:20
