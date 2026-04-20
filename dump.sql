-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bak
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `address_id` int NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `receiver_name` varchar(50) NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(20) NOT NULL COMMENT '收货人电话',
  `detail_address` varchar(255) NOT NULL COMMENT '详细地址',
  `is_default` tinyint DEFAULT '0' COMMENT '是否默认: 0-否 1-是',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`address_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,13,'测试','13222333444','还阿斯阿斯阿斯阿斯啊是',1,'2025-12-26 17:18:05','2026-01-03 01:49:59'),(2,13,'thexpxp233','13242884791','你好你好你好你好你好你好你好你好你好你好你好你好你好你好',0,'2026-01-03 01:49:24','2026-01-03 01:49:59');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(100) NOT NULL COMMENT '分类名称',
  `category_description` text COMMENT '分类描述',
  `status` tinyint DEFAULT '1' COMMENT '状态: 0-禁用 1-启用',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `image` varchar(255) DEFAULT NULL COMMENT '分类图片URL',
  `shop_id` int DEFAULT NULL COMMENT '店铺ID（NULL表示系统分类）',
  PRIMARY KEY (`category_id`),
  KEY `idx_shop_id` (`shop_id`),
  CONSTRAINT `category_ibfk_shop` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='鲜花分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (18,'百合','纯洁的百合花',1,'2025-12-23 18:21:46','2025-12-29 18:10:25','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a6d39e2e3b6cf3cfe18d1.png',6),(19,'123123132','132123213123132',1,'2025-12-23 18:55:58','2025-12-23 18:55:58','',7),(20,'玫瑰花','小玫瑰',1,'2025-12-24 01:10:00','2025-12-29 18:14:16','',6),(21,'康乃馨','温馨的康乃馨',1,'2025-12-29 18:17:59','2025-12-29 18:17:59','',6),(22,'郁金香','美丽的郁金香',1,'2025-12-29 18:18:15','2025-12-29 18:18:15','',6),(23,'向日葵','太阳种的向日葵',1,'2025-12-29 18:18:46','2025-12-29 18:18:46','',6),(24,'多肉植物','可爱的多肉盆栽',1,'2025-12-29 18:25:17','2025-12-29 18:25:17','',7),(25,'水仙','水水的仙仙',1,'2025-12-29 18:25:27','2025-12-29 18:25:27','',7),(26,'盆栽','绿植盆栽',1,'2025-12-29 18:25:53','2025-12-29 18:25:53','',7);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `favorite_id` int NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `flower_id` int NOT NULL COMMENT '鲜花ID',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`favorite_id`),
  UNIQUE KEY `uk_user_flower` (`user_id`,`flower_id`),
  KEY `flower_id` (`flower_id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`flower_id`) REFERENCES `flowers` (`flower_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flower_tags`
--

DROP TABLE IF EXISTS `flower_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flower_tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) NOT NULL COMMENT '标签名称',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态：0-禁用，1-启用',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tag_name` (`tag_name`),
  KEY `idx_status` (`status`) COMMENT '状态索引'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flower_tags`
--

LOCK TABLES `flower_tags` WRITE;
/*!40000 ALTER TABLE `flower_tags` DISABLE KEYS */;
INSERT INTO `flower_tags` VALUES (1,'玫瑰',1,'2026-01-02 13:58:57','2026-01-02 17:17:01'),(2,'百合',1,'2026-01-02 13:58:57','2026-01-02 17:17:00'),(3,'康乃馨',1,'2026-01-02 13:58:57','2026-01-02 17:16:59'),(4,'郁金香',0,'2026-01-02 13:58:57','2026-01-02 17:18:07'),(5,'热门',1,'2026-01-02 13:58:57','2026-01-02 13:58:57'),(8,'爱情',1,'2026-01-02 17:18:30','2026-01-02 17:18:29'),(9,'告白',1,'2026-01-02 17:19:01','2026-01-02 17:19:00'),(10,'商务',1,'2026-01-02 17:19:07','2026-01-02 17:19:07');
/*!40000 ALTER TABLE `flower_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flowers`
--

DROP TABLE IF EXISTS `flowers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flowers` (
  `flower_id` int NOT NULL AUTO_INCREMENT COMMENT '鲜花ID',
  `flower_name` varchar(100) NOT NULL COMMENT '鲜花名称',
  `category_id` int NOT NULL COMMENT '分类ID',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `main_image` varchar(255) NOT NULL COMMENT '主图',
  `description` mediumtext COMMENT '商品描述',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签(逗号分隔)',
  `season` varchar(50) DEFAULT NULL COMMENT '花期',
  `meaning` text COMMENT '花语',
  `care_tips` text COMMENT '养护提示',
  `status` tinyint DEFAULT '1' COMMENT '状态: 0-下架 1-上架',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `shop_id` int DEFAULT NULL COMMENT '店铺ID',
  `source_type` tinyint DEFAULT '0' COMMENT '来源类型: 0-店铺商品 1-平台商品',
  PRIMARY KEY (`flower_id`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_status` (`status`),
  KEY `idx_shop_id` (`shop_id`),
  CONSTRAINT `flowers_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `flowers_ibfk_shop` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='鲜花商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flowers`
--

LOCK TABLES `flowers` WRITE;
/*!40000 ALTER TABLE `flowers` DISABLE KEYS */;
INSERT INTO `flowers` VALUES (22,'白百合花束',18,12.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png','9支白百合清新花束，纯洁优雅','百合,白色,花束','春夏季','纯洁、庄严、百年好合','放置在阴凉处，保持水分',1,'2025-12-23 19:34:20','2025-12-29 18:15:53',6,0),(26,'玫瑰',20,123.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525212e2e315b20a8292ce.png','表达爱意的完美之选，包含 11 朵新鲜红玫瑰，搭配尤加利叶与质感丝带包装，花头饱满，浪漫感十足','热门,情人节,爱情,浪漫, 告白 , 纪念日 ,玫瑰花','鲜切花 7-10 天（常温养护）','炽热爱恋、真心告白、一生挚爱','斜剪花茎 45°，去除花刺及水下叶片；每 1-2 天换一次清水，水位没过花茎 1/3，避免阳光直射和空调直吹',1,'2025-12-24 01:14:12','2025-12-29 18:04:58',6,0),(28,'粉色康乃馨',21,128.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525635e2e315b20a8292d0.png','12支粉色康乃馨，温馨祝福','康乃馨,粉色,温馨','全年','母爱、温馨、祝福','避免高温环境',1,'2025-12-29 18:22:10','2025-12-29 18:22:10',6,0),(29,'梦幻混色郁金香',22,126.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952567be2e315b20a8292d1.png','春日浪漫的清新之选，包含 12 朵新鲜混色郁金香（粉 / 白 / 紫搭配），搭配满天星与浅蓝雾面包装，花型优雅，自带温柔氛围感','热门,春日,浪漫,告白,闺蜜礼,婚礼伴手礼','鲜切花 5-7 天（常温养护，适宜温度 15-20℃）','浪漫告白、优雅祝福、纯洁美好','花茎斜剪 3-4cm，保留少量叶片；水位没过花茎 1/2，每天换一次清水，避免阳光直射和高温环境（超过 25℃易蔫）',1,'2025-12-29 18:23:12','2026-01-02 21:48:01',6,0),(30,'阳光金向日葵',23,255.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png','活力满满的正能量之选，包含 8 朵新鲜向日葵，搭配橙色包装纸与麦穗装饰，花盘饱满，向阳而生','热门,毕业季,励志,阳光,祝福,友情','鲜切花 5-8 天（常温养护）','勇敢追求、阳光开朗、沉默的爱、忠诚','花茎斜剪 5cm，去除底部叶片；水位没过花茎 1/2，每天换一次清水，避免放置在闷热环境',1,'2025-12-29 18:23:53','2025-12-29 19:38:40',6,0),(31,'多肉组合盆栽',24,88.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png','多种多肉植物组合盆栽，可爱易养','多肉,盆栽,组合','全年','坚韧、可爱、希望','少浇水，多晒太阳',1,'2025-12-29 18:29:59','2025-12-29 18:29:59',7,0),(32,'清逸黄水仙',25,592.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png','清雅脱俗的年宵花之选，包含 3-5 球带花剑水仙种球，搭配陶瓷浅盆（含营养液），水培观赏，花期长久','热门,春节,清雅,室内观赏,年宵花','盆栽 / 水培 1-2 个月（适宜温度 10-18℃）','纯洁吉祥、思念、团圆','水培时水位没过种球底部 1cm，每周换一次营养液；放置于散光处，避免高温暴晒',1,'2025-12-29 19:12:48','2025-12-29 19:12:48',7,0),(33,'多肉组合盆栽',26,88.00,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69526259e2e315b20a8292d5.png','多种多肉植物组合盆栽，可爱易养','多肉,盆栽,组合','全年','坚韧、可爱、希望','少浇水，多晒太阳',1,'2025-12-29 19:13:44','2025-12-29 19:13:44',7,0);
/*!40000 ALTER TABLE `flowers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flowers_inventory`
--

DROP TABLE IF EXISTS `flowers_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flowers_inventory` (
  `inventory_id` int NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `flower_id` int NOT NULL COMMENT '鲜花ID',
  `shop_id` int NOT NULL COMMENT '店铺ID',
  `stock_quantity` int NOT NULL DEFAULT '0' COMMENT '库存数量',
  `sold_quantity` int NOT NULL DEFAULT '0' COMMENT '已售数量',
  `safety_stock` int NOT NULL DEFAULT '0' COMMENT '安全库存',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`inventory_id`),
  UNIQUE KEY `uk_flower_id` (`flower_id`),
  CONSTRAINT `flowers_inventory_ibfk_1` FOREIGN KEY (`flower_id`) REFERENCES `flowers` (`flower_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flowers_inventory`
--

LOCK TABLES `flowers_inventory` WRITE;
/*!40000 ALTER TABLE `flowers_inventory` DISABLE KEYS */;
INSERT INTO `flowers_inventory` VALUES (1,22,6,51,5,15,'2025-12-23 19:34:20','2026-01-03 05:19:01'),(2,26,6,50,5,10,'2025-12-24 01:14:12','2026-01-03 04:56:24'),(4,28,6,19,3,10,'2025-12-29 18:22:10','2026-01-03 04:56:24'),(5,29,6,16,4,10,'2025-12-29 18:23:12','2026-01-03 04:56:24'),(6,30,6,14,5,10,'2025-12-29 18:23:53','2026-01-03 05:23:11'),(7,31,7,15,6,10,'2025-12-29 18:29:59','2026-01-03 05:19:03'),(8,32,7,14,6,10,'2025-12-29 19:12:48','2026-01-03 05:20:44'),(9,33,7,15,5,10,'2025-12-29 19:13:44','2026-01-03 04:58:22');
/*!40000 ALTER TABLE `flowers_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL AUTO_INCREMENT COMMENT '订单项ID',
  `order_id` int NOT NULL COMMENT '订单ID',
  `flower_id` int NOT NULL COMMENT '鲜花ID',
  `flower_name` varchar(100) NOT NULL COMMENT '鲜花名称(下单时)',
  `flower_image` varchar(255) NOT NULL COMMENT '鲜花图片(下单时)',
  `unit_price` decimal(10,2) NOT NULL COMMENT '单价(下单时)',
  `quantity` int NOT NULL COMMENT '数量',
  `subtotal` decimal(10,2) NOT NULL COMMENT '小计金额',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shop_id` int DEFAULT NULL COMMENT '店铺ID',
  `shop_status` tinyint DEFAULT '0' COMMENT '店铺订单状态: 0-待确认 1-待支付 2-待接单 3-待发货 4-已发货 5-已完成 6-已取消 7-已评价',
  `shop_updated_at` datetime DEFAULT NULL COMMENT '店铺状态更新时间',
  PRIMARY KEY (`order_item_id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_flower_id` (`flower_id`),
  KEY `idx_order_items_shop` (`shop_id`,`shop_status`),
  KEY `idx_order_items_order_shop` (`order_id`,`shop_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,26,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,1,123.00,'2025-12-26 17:17:48',NULL,7,NULL),(2,27,22,'123123312','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a7e34e2e3b6cf3cfe18d4.png',123123.00,1,123123.00,'2025-12-28 02:39:19',6,6,NULL),(3,27,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,2,246.00,'2025-12-28 02:39:19',6,6,NULL),(4,27,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,1,5.00,'2025-12-28 02:39:19',7,6,NULL),(7,29,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,1,5.00,'2025-12-28 15:18:30',NULL,2,NULL),(8,30,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,1,5.00,'2025-12-28 15:27:44',7,6,NULL),(9,31,22,'123123312','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a7e34e2e3b6cf3cfe18d4.png',123123.00,1,123123.00,'2025-12-28 15:30:06',NULL,2,NULL),(10,31,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,1,123.00,'2025-12-28 15:30:06',NULL,2,NULL),(11,31,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,1,5.00,'2025-12-28 15:30:06',NULL,2,NULL),(12,32,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,1,123.00,'2025-12-28 15:33:58',6,7,NULL),(13,32,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,2,10.00,'2025-12-28 15:33:58',7,5,NULL),(14,33,22,'123123312','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a7e34e2e3b6cf3cfe18d4.png',123123.00,1,123123.00,'2025-12-28 16:42:25',6,7,NULL),(15,34,27,'测试测试测试测试测试测试测试测试','http://118.178.18.207:9000/thexpxp233/flower/2025/12/27/694fc154e2e31ae0c191a476.png',5.00,1,5.00,'2025-12-28 20:50:38',NULL,2,NULL),(16,35,22,'123123312','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a7e34e2e3b6cf3cfe18d4.png',123123.00,1,123123.00,'2025-12-29 16:37:12',NULL,2,NULL),(17,35,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,1,123.00,'2025-12-29 16:37:12',NULL,2,NULL),(18,36,26,'12312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/24/694acd43e2e3b6cf3cfe18d6.png',123.00,1,123.00,'2025-12-29 16:43:53',6,6,NULL),(19,37,29,'梦幻混色郁金香','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952567be2e315b20a8292d1.png',126.00,1,126.00,'2025-12-30 00:27:33',6,2,NULL),(20,37,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2025-12-30 00:27:33',6,2,NULL),(21,38,26,'玫瑰','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525212e2e315b20a8292ce.png',123.00,1,123.00,'2025-12-30 00:33:48',6,2,NULL),(22,39,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2025-12-30 01:12:46',7,6,NULL),(23,40,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2025-12-30 01:26:54',7,6,NULL),(24,41,33,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69526259e2e315b20a8292d5.png',88.00,1,88.00,'2025-12-30 01:30:33',7,6,NULL),(25,42,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2025-12-31 17:59:54',6,6,NULL),(26,43,28,'粉色康乃馨','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525635e2e315b20a8292d0.png',128.00,1,128.00,'2025-12-31 18:03:13',6,6,NULL),(27,44,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2025-12-31 18:44:07',6,6,NULL),(28,45,22,'白百合花束','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png',12.00,1,12.00,'2025-12-31 18:47:20',6,6,NULL),(29,46,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2025-12-31 18:48:49',6,6,NULL),(30,47,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2025-12-31 18:49:20',6,6,NULL),(31,48,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2026-01-03 02:01:33',6,2,NULL),(32,48,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2026-01-03 02:01:33',7,7,NULL),(33,49,28,'粉色康乃馨','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525635e2e315b20a8292d0.png',128.00,1,128.00,'2026-01-03 03:22:10',6,6,NULL),(34,49,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2026-01-03 03:22:10',7,6,NULL),(35,50,28,'粉色康乃馨','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525635e2e315b20a8292d0.png',128.00,1,128.00,'2026-01-03 03:34:53',6,5,NULL),(36,50,31,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png',88.00,1,88.00,'2026-01-03 03:34:53',7,2,NULL),(37,51,22,'白百合花束','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png',12.00,1,12.00,'2026-01-03 03:52:33',6,5,NULL),(38,51,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2026-01-03 03:52:33',7,5,NULL),(39,52,22,'白百合花束','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png',12.00,1,12.00,'2026-01-03 04:08:36',6,7,NULL),(40,52,31,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png',88.00,1,88.00,'2026-01-03 04:08:36',7,7,NULL),(41,53,26,'玫瑰','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525212e2e315b20a8292ce.png',123.00,1,123.00,'2026-01-03 04:28:44',6,7,NULL),(42,53,31,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png',88.00,1,88.00,'2026-01-03 04:28:44',7,7,NULL),(43,54,29,'梦幻混色郁金香','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952567be2e315b20a8292d1.png',126.00,1,126.00,'2026-01-03 04:34:00',6,7,NULL),(44,54,33,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69526259e2e315b20a8292d5.png',88.00,1,88.00,'2026-01-03 04:34:00',7,7,NULL),(45,55,29,'梦幻混色郁金香','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952567be2e315b20a8292d1.png',126.00,2,252.00,'2026-01-03 04:49:17',6,5,NULL),(46,55,33,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69526259e2e315b20a8292d5.png',88.00,2,176.00,'2026-01-03 04:49:17',7,5,NULL),(47,56,22,'白百合花束','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png',12.00,1,12.00,'2026-01-03 04:54:59',6,5,NULL),(48,56,26,'玫瑰','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525212e2e315b20a8292ce.png',123.00,1,123.00,'2026-01-03 04:54:59',6,5,NULL),(49,56,28,'粉色康乃馨','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525635e2e315b20a8292d0.png',128.00,2,256.00,'2026-01-03 04:54:59',6,5,NULL),(50,56,29,'梦幻混色郁金香','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952567be2e315b20a8292d1.png',126.00,1,126.00,'2026-01-03 04:54:59',6,5,NULL),(51,56,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,4,1020.00,'2026-01-03 04:54:59',6,5,NULL),(52,56,31,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png',88.00,3,264.00,'2026-01-03 04:54:59',7,5,NULL),(53,56,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,3,1776.00,'2026-01-03 04:54:59',7,5,NULL),(54,56,33,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69526259e2e315b20a8292d5.png',88.00,2,176.00,'2026-01-03 04:54:59',7,5,NULL),(55,57,22,'白百合花束','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695254d8e2e315b20a8292cf.png',12.00,1,12.00,'2026-01-03 05:19:05',6,2,NULL),(56,57,31,'多肉组合盆栽','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69525819e2e315b20a8292d3.png',88.00,1,88.00,'2026-01-03 05:19:05',7,2,NULL),(57,58,32,'清逸黄水仙','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/6952621ee2e315b20a8292d4.png',592.00,1,592.00,'2026-01-03 05:20:48',7,2,NULL),(58,59,30,'阳光金向日葵','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695256a9e2e315b20a8292d2.png',255.00,1,255.00,'2026-01-03 05:23:14',6,2,NULL);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_no` varchar(32) NOT NULL COMMENT '订单编号',
  `user_id` int NOT NULL COMMENT '用户ID',
  `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `shipping_fee` decimal(10,2) DEFAULT '0.00' COMMENT '运费',
  `final_amount` decimal(10,2) NOT NULL COMMENT '实付金额',
  `payment_method` tinyint DEFAULT NULL COMMENT '支付方式: 0-微信 1-支付宝 2-银行卡 3-余额支付',
  `payment_status` tinyint DEFAULT '0' COMMENT '支付状态: 0-待确认 1-待支付 2-已支付 3-支付失败 4-已退款',
  `order_status` tinyint DEFAULT '0' COMMENT '订单状态: 0-待确认 1-待支付 2-待接单 3-待发货 4-派送中 5-已完成 6-已取消',
  `shipping_address` text NOT NULL COMMENT '收货地址',
  `receiver_name` varchar(50) NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(20) NOT NULL COMMENT '收货人电话',
  `order_notes` text COMMENT '订单备注',
  `paid_time` datetime DEFAULT NULL COMMENT '支付时间',
  `shipped_time` datetime DEFAULT NULL COMMENT '发货时间',
  `completed_time` datetime DEFAULT NULL COMMENT '完成时间',
  `cancelled_time` datetime DEFAULT NULL COMMENT '取消时间',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `rejection_reason` varchar(255) DEFAULT NULL COMMENT '拒单原因',
  `cancellation_reason` varchar(255) DEFAULT NULL COMMENT '取消原因',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_no` (`order_no`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_order_status` (`order_status`),
  KEY `idx_created_at` (`created_at`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (26,'202512261717480001',13,123.00,0.00,123.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','测试测试','2025-12-26 17:18:19','2025-12-26 17:18:43','2025-12-26 17:18:47',NULL,'2025-12-26 17:17:48','2025-12-26 17:18:47',NULL,NULL),(27,'202512280239190001',13,123374.00,0.00,123374.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','测试测试123123123','2025-12-28 04:01:00',NULL,NULL,'2025-12-28 15:05:31','2025-12-28 02:39:19','2025-12-28 15:05:31','\"联系不上客户\"',NULL),(29,'202512281518300001',13,5.00,10.00,15.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123213','2025-12-28 15:26:25',NULL,NULL,'2025-12-28 15:27:17','2025-12-28 15:18:30','2025-12-28 15:27:16',NULL,'\"不想要了\"'),(30,'202512281527440001',13,5.00,10.00,15.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','111111111','2025-12-28 15:28:04',NULL,NULL,'2025-12-28 15:29:16','2025-12-28 15:27:44','2025-12-28 15:29:16','\"订单信息有误\"',NULL),(31,'202512281530060002',13,123251.00,0.00,123251.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132132132','2025-12-28 15:30:16',NULL,NULL,'2025-12-28 15:33:27','2025-12-28 15:30:06','2025-12-28 15:33:26',NULL,'123213'),(32,'202512281533580003',13,133.00,0.00,133.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123213213213213','2025-12-28 15:34:24',NULL,NULL,NULL,'2025-12-28 15:33:58','2025-12-28 16:41:45',NULL,NULL),(33,'202512281642250001',13,123123.00,0.00,123123.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132321','2025-12-28 16:42:34',NULL,NULL,NULL,'2025-12-28 16:42:25','2025-12-28 16:42:56',NULL,NULL),(34,'202512282050380001',13,5.00,10.00,15.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123321','2025-12-29 16:38:19',NULL,NULL,'2025-12-29 16:41:12','2025-12-28 20:50:38','2025-12-29 16:41:11',NULL,'\"不要哦了\"'),(35,'202512291637120001',13,123246.00,0.00,123246.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','321312','2025-12-29 16:38:51',NULL,NULL,'2025-12-29 16:40:51','2025-12-29 16:37:12','2025-12-29 16:40:50',NULL,'\"测试一下，我不想要了，不要打我了\"'),(36,'202512291643530002',13,123.00,0.00,123.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123123123','2025-12-30 01:09:39',NULL,NULL,'2025-12-30 01:11:20','2025-12-29 16:43:53','2025-12-30 01:11:19',NULL,'\"不要了\"'),(37,'202512300027330001',13,381.00,0.00,381.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123213132','2025-12-30 00:28:09',NULL,NULL,'2025-12-30 00:33:16','2025-12-30 00:27:33','2025-12-30 00:33:16',NULL,'\"不要了，233333\"'),(38,'202512300033480002',13,123.00,0.00,123.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','312132','2025-12-30 00:36:11',NULL,NULL,'2025-12-31 18:02:32','2025-12-30 00:33:48','2025-12-31 18:02:31','\"库存不足\"','\"不要了23333\"'),(39,'202512300112460001',13,592.00,0.00,592.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132123','2025-12-30 01:13:03',NULL,NULL,'2025-12-30 01:13:08','2025-12-30 01:12:46','2025-12-30 01:13:08',NULL,'132132132'),(40,'202512300126540002',13,592.00,0.00,592.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2025-12-30 01:27:04',NULL,NULL,'2025-12-30 01:27:09','2025-12-30 01:26:54','2025-12-30 01:27:09',NULL,'1'),(41,'202512300130330003',13,88.00,10.00,98.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132','2025-12-30 01:30:47',NULL,NULL,'2025-12-30 01:30:53','2025-12-30 01:30:33','2025-12-30 01:30:52',NULL,'321321'),(42,'202512311759540001',13,255.00,0.00,255.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123213','2025-12-31 18:00:04',NULL,NULL,'2025-12-31 18:02:00','2025-12-31 17:59:54','2025-12-31 18:02:00',NULL,'\"buyaole\"'),(43,'202512311803130002',13,128.00,0.00,128.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132321','2025-12-31 18:03:25',NULL,NULL,'2025-12-31 18:42:10','2025-12-31 18:03:13','2025-12-31 18:42:09',NULL,'111'),(44,'202512311844070003',13,255.00,0.00,255.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2025-12-31 18:44:14',NULL,NULL,'2025-12-31 18:46:56','2025-12-31 18:44:07','2025-12-31 18:46:56',NULL,'123213213'),(45,'202512311847200004',13,12.00,10.00,22.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','132132','2025-12-31 18:47:35',NULL,NULL,'2026-01-03 04:07:14','2025-12-31 18:47:20','2026-01-03 04:07:13',NULL,'1'),(46,'202512311848490005',13,255.00,0.00,255.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','312','2025-12-31 18:48:59',NULL,NULL,'2026-01-03 04:06:23','2025-12-31 18:48:49','2026-01-03 04:06:23',NULL,'1'),(47,'202512311849200006',13,255.00,0.00,255.00,0,4,6,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2025-12-31 18:49:32',NULL,NULL,'2026-01-03 04:06:21','2025-12-31 18:49:20','2026-01-03 04:06:21',NULL,'1'),(48,'202601030201330001',13,847.00,0.00,847.00,0,2,5,'你好你好你好你好你好你好你好你好你好你好你好你好你好你好','thexpxp233','13242884791','','2026-01-03 02:01:48',NULL,NULL,NULL,'2026-01-03 02:01:33','2026-01-03 02:36:14',NULL,NULL),(49,'202601030322100001',13,720.00,0.00,720.00,0,4,6,'你好你好你好你好你好你好你好你好你好你好你好你好你好你好','thexpxp233','13242884791','123123','2026-01-03 03:22:19',NULL,NULL,'2026-01-03 03:34:29','2026-01-03 03:22:10','2026-01-03 03:34:28',NULL,'111'),(50,'202601030334530001',13,216.00,0.00,216.00,0,4,6,'你好你好你好你好你好你好你好你好你好你好你好你好你好你好','thexpxp233','13242884791','1','2026-01-03 03:35:08',NULL,NULL,'2026-01-03 04:06:03','2026-01-03 03:34:53','2026-01-03 04:06:02','\"库存不足\"',NULL),(51,'202601030352330001',13,604.00,0.00,604.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2026-01-03 03:52:41',NULL,NULL,NULL,'2026-01-03 03:52:33','2026-01-03 03:57:54',NULL,NULL),(52,'202601030408360001',13,100.00,0.00,100.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','123123','2026-01-03 04:08:46',NULL,NULL,NULL,'2026-01-03 04:08:36','2026-01-03 04:28:07',NULL,NULL),(53,'202601030428440001',13,211.00,0.00,211.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2026-01-03 04:28:52',NULL,NULL,NULL,'2026-01-03 04:28:44','2026-01-03 04:29:59',NULL,NULL),(54,'202601030434000001',13,214.00,0.00,214.00,0,2,5,'你好你好你好你好你好你好你好你好你好你好你好你好你好你好','thexpxp233','13242884791','111','2026-01-03 04:34:09','2026-01-03 04:35:22','2026-01-03 04:35:44',NULL,'2026-01-03 04:34:00','2026-01-03 04:35:44',NULL,NULL),(55,'202601030449170001',13,428.00,0.00,428.00,0,2,5,'你好你好你好你好你好你好你好你好你好你好你好你好你好你好','thexpxp233','13242884791','123321','2026-01-03 04:49:26','2026-01-03 04:54:06','2026-01-03 04:54:12',NULL,'2026-01-03 04:49:17','2026-01-03 04:54:11',NULL,NULL),(56,'202601030454590001',13,3753.00,0.00,3753.00,0,2,5,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','1111','2026-01-03 04:55:18','2026-01-03 04:58:20','2026-01-03 04:58:22',NULL,'2026-01-03 04:54:59','2026-01-03 04:58:22',NULL,NULL),(57,'202601030519050001',13,100.00,0.00,100.00,0,2,2,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2026-01-03 05:19:14',NULL,NULL,NULL,'2026-01-03 05:19:05','2026-01-03 05:19:14',NULL,NULL),(58,'202601030520480002',13,592.00,0.00,592.00,0,2,2,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2026-01-03 05:20:59',NULL,NULL,NULL,'2026-01-03 05:20:48','2026-01-03 05:20:59',NULL,NULL),(59,'202601030523140003',13,255.00,0.00,255.00,0,2,2,'还阿斯阿斯阿斯阿斯啊是','测试','13222333444','','2026-01-03 05:23:20',NULL,NULL,NULL,'2026-01-03 05:23:14','2026-01-03 05:23:20',NULL,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `review_id` int NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `order_id` int NOT NULL COMMENT '订单ID',
  `flower_id` int NOT NULL COMMENT '鲜花ID',
  `rating` tinyint NOT NULL COMMENT '评分: 1-5分',
  `content` text NOT NULL COMMENT '评论内容',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`review_id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  KEY `flower_id` (`flower_id`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `reviews_ibfk_3` FOREIGN KEY (`flower_id`) REFERENCES `flowers` (`flower_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,13,33,22,5,'测试','2025-12-29 22:55:35'),(2,13,32,26,5,'测试123123','2025-12-29 23:16:20'),(5,13,26,26,5,'1231232333333','2025-12-29 23:17:25'),(6,13,48,32,5,'很好啊','2026-01-03 02:36:34'),(7,13,52,31,5,'123123','2026-01-03 04:21:09'),(8,13,52,22,5,'222','2026-01-03 04:26:54'),(9,13,53,31,5,'11111','2026-01-03 04:29:45'),(10,13,53,26,5,'111111','2026-01-03 04:30:24'),(11,13,54,29,5,'11111','2026-01-03 04:40:14'),(12,13,54,33,5,'123123123','2026-01-03 04:40:21');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `cart_item_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车项ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `flower_id` int NOT NULL COMMENT '鲜花ID',
  `quantity` int NOT NULL DEFAULT '1' COMMENT '数量',
  `selected` tinyint DEFAULT '1' COMMENT '是否选中: 0-否 1-是',
  `added_price` decimal(10,2) DEFAULT NULL COMMENT '加入时的价格',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `shop_id` int DEFAULT NULL COMMENT '店铺ID',
  `shop_name` varchar(100) DEFAULT NULL COMMENT '店铺名称',
  PRIMARY KEY (`cart_item_id`),
  UNIQUE KEY `uk_user_flower` (`user_id`,`flower_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `flower_id` (`flower_id`),
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `shoppingcart_ibfk_2` FOREIGN KEY (`flower_id`) REFERENCES `flowers` (`flower_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
  `shop_id` int NOT NULL AUTO_INCREMENT COMMENT '店铺ID',
  `shop_name` varchar(100) NOT NULL COMMENT '店铺名称',
  `shop_description` text COMMENT '店铺描述',
  `owner_id` int NOT NULL COMMENT '店主ID（关联用户表）',
  `contact_phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `shop_logo` varchar(255) DEFAULT NULL COMMENT '店铺Logo',
  `shop_banner` varchar(255) DEFAULT NULL COMMENT '店铺横幅',
  `status` tinyint DEFAULT '0' COMMENT '状态: 0-休息中 1-营业中 2-封禁状态',
  `business_hours` varchar(100) DEFAULT NULL COMMENT '营业时间',
  `rating` decimal(3,2) DEFAULT '0.00' COMMENT '店铺评分',
  `total_sales` int DEFAULT '0' COMMENT '总销量',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ban_reason` varchar(500) DEFAULT NULL COMMENT '封禁原因',
  PRIMARY KEY (`shop_id`),
  KEY `idx_owner_id` (`owner_id`),
  KEY `idx_status` (`status`),
  CONSTRAINT `shops_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (6,'采花大盗店铺123','很好很好',8,'13222444555','广东交通职业技术学院清远校区清新C','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69519692e2e3c743e7b0069c.png','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694994d9e2e38deb09e47e23.png',1,'09:00-20:00',5.00,10,'2025-12-23 03:01:29','2025-12-31 02:07:00',NULL),(7,'牛马店铺','12312312312312',9,'13222444555','312321321312321','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69519730e2e3c743e7b0069f.png','http://118.178.18.207:9000/thexpxp233/flower/2025/12/23/694a7434e2e3b6cf3cfe18d3.png',1,'09:00-20:00',5.00,13,'2025-12-23 18:51:35','2026-01-03 04:58:22',NULL),(8,'广交花店','测试数据，这是广交花店',10,'13222444555','广东交通职业技术学院','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69519737e2e3c743e7b006a0.png','http://118.178.18.207:9000/thexpxp233/flower/2025/12/26/694d6374e2e326c439d669e2.png',1,'09:00-20:00',4.50,0,'2025-12-26 00:17:19','2025-12-29 04:46:48',NULL),(9,'清新花店','清新花店，2333333333333',11,'13233444555','清新花店','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/69519706e2e3c743e7b0069e.png','http://118.178.18.207:9000/thexpxp233/flower/2025/12/26/694d63bae2e326c439d669e4.png',0,'09:00-20:00',4.60,0,'2025-12-26 00:18:16','2026-01-03 02:00:59',NULL),(10,'交通花店','交通花店233333333333',12,'13222333444','交通花店233333333333','http://118.178.18.207:9000/thexpxp233/flower/2025/12/29/695196fbe2e3c743e7b0069d.png','http://118.178.18.207:9000/thexpxp233/flower/2025/12/26/694d644ce2e326c439d669e6.png',1,'09:00-20:00',4.10,0,'2025-12-26 00:20:46','2025-12-29 21:06:15',NULL);
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gender` tinyint DEFAULT '0' COMMENT '性别: 0-未知 1-男 2-女',
  `status` tinyint DEFAULT '1' COMMENT '状态: 0-禁用 1-正常',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role` varchar(20) DEFAULT 'USER' COMMENT '用户角色: SHOP_OWNER-超级管理员, SHOP_ADMIN-店铺管理员, USER-普通用户',
  `shop_id` int DEFAULT NULL COMMENT '关联的店铺ID（如果是店铺管理员）',
  `is_shop_owner` tinyint DEFAULT '0' COMMENT '是否是店主: 0-否 1-是',
  `image` varchar(255) DEFAULT NULL COMMENT '用户头像URL',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `idx_shop_id` (`shop_id`),
  CONSTRAINT `users_ibfk_shop` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','13800138001','超级管理员',1,1,'2026-01-03 01:16:54','2025-11-04 16:46:17','2026-01-03 01:16:53','SUPER_ADMIN',NULL,0,NULL),(8,'owner1','e10adc3949ba59abbe56e057f20f883e','13800000001','BUG',1,1,'2026-01-03 03:55:35','2025-12-22 04:52:50','2026-01-03 03:55:34','SHOP_OWNER',6,1,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/28/6951149be2e3a8ccbdbc61ce.png'),(9,'owner2','e10adc3949ba59abbe56e057f20f883e','13800000002','店主二号',2,1,'2026-01-03 03:54:33','2025-12-22 04:52:50','2026-01-03 03:54:33','SHOP_OWNER',7,1,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/22/69485d97e2e3369fa9258ac1.png'),(10,'owner3','e10adc3949ba59abbe56e057f20f883e','13800000003','店主三号',0,1,'2025-12-29 21:05:42','2025-12-22 04:52:50','2025-12-29 21:05:41','SHOP_OWNER',8,1,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/22/69485d97e2e3369fa9258ac1.png'),(11,'owner4','e10adc3949ba59abbe56e057f20f883e','13800000004','店主四号',1,1,'2025-12-29 21:05:56','2025-12-22 04:52:50','2025-12-29 21:05:55','SHOP_OWNER',9,1,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/22/69485d97e2e3369fa9258ac1.png'),(12,'owner5','e10adc3949ba59abbe56e057f20f883e','13800000005','店主五号',2,1,'2025-12-29 21:06:05','2025-12-22 04:52:50','2025-12-29 21:06:04','SHOP_OWNER',10,1,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/22/69485d97e2e3369fa9258ac1.png'),(13,'thexpxp123','0f1a89424608bc8c7dcb0b8fd0f63798','13242884791','你好',1,1,'2026-01-03 05:22:58','2025-12-25 23:47:36','2026-01-03 05:22:57','USER',NULL,0,'http://118.178.18.207:9000/thexpxp233/flower/2025/12/20/6945931ee2e3b64eaf1abe32.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-03  5:32:03
