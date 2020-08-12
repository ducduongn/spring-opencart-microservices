-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: opencart
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand`
    DISABLE KEYS */;
INSERT INTO `brand`
VALUES (1, 'SmartPhone', 'expensive'),
       (2, 'Mam Tom', 'expensive'),
       (3, 'Chao Long', 'expensive'),
       (4, 'Tiet Canh', 'expensive'),
       (5, 'Laptop', 'expensive'),
       (6, 'Camera', 'expensive'),
       (7, 'Car', 'expensive'),
       (8, 'Plane', 'expensive'),
       (9, 'Linh Tinh', 'expensive'),
       (10, 'Moon', 'expensive'),
       (11, 'Bim Bim', 'expensive');
/*!40000 ALTER TABLE `brand`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart`
    DISABLE KEYS */;
INSERT INTO `cart`
VALUES (1, '2020-08-03 10:42:43', 1);
/*!40000 ALTER TABLE `cart`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart-product`
--

LOCK TABLES `cart-product` WRITE;
/*!40000 ALTER TABLE `cart-product`
    DISABLE KEYS */;
INSERT INTO `cart-product`
VALUES (1, 9),
       (1, 1),
       (1, 2);
/*!40000 ALTER TABLE `cart-product`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category`
    DISABLE KEYS */;
INSERT INTO `category`
VALUES (1, 'Electronic Device', 'This category is so expensive\r\n'),
       (2, 'The Fool', 'This category is so cheap');
/*!40000 ALTER TABLE `category`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category-product`
--

LOCK TABLES `category-product` WRITE;
/*!40000 ALTER TABLE `category-product`
    DISABLE KEYS */;
INSERT INTO `category-product`
VALUES (2, 9);
/*!40000 ALTER TABLE `category-product`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer`
    DISABLE KEYS */;
INSERT INTO `customer`
VALUES (1, 'Thanh', 'Dat', 'thanhdat.vnu@gmail.com', '0943883280', 'thanhhdatt', '1', 'Mai Dich', 'Cau Giay', 'Ha Noi',
        'Viet Nam');
/*!40000 ALTER TABLE `customer`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order`
    DISABLE KEYS */;
INSERT INTO `order`
VALUES (1, '2020-08-24', '2020-08-30', '2020-10-30', 'On Arrival', 1);
/*!40000 ALTER TABLE `order`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail`
    DISABLE KEYS */;
INSERT INTO `orderdetail`
VALUES (1, 15, 2, 'Mam tom kham lam');
/*!40000 ALTER TABLE `orderdetail`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product`
    DISABLE KEYS */;
INSERT INTO `product`
VALUES (1, 2, 'Expensive', 'Thinkbook 14', 1, '2020-07-21', '2020-07-13', 12),
       (2, 2, 'Expensive', 'Thinkbook 15', 1, '2020-07-21', '2020-07-13', 13),
       (3, 2, 'Expensive', 'Macbook Pro 13 2018', 1, '2020-07-21', '2020-07-13', 14),
       (4, 2, 'Expensive', 'Macbook Pro 15 2016', 1, '2020-07-21', '2020-07-13', 15),
       (5, 2, 'Expensive', 'Ideapad 720s', 1, '2020-07-21', '2020-07-13', 16),
       (6, 2, 'Expensive', 'Ideapad 730s', 1, '2020-07-21', '2020-07-13', 17),
       (7, 2, 'Expensive', 'Dell XPS 13', 1, '2020-07-21', '2020-07-13', 18),
       (8, 2, 'Expensive', 'Dell XPS 15', 1, '2020-07-21', '2020-07-13', 19),
       (9, 1, 'Kinh lắm', 'Tiết Canh', 5, '2020-07-27', '2020-07-30', 123),
       (10, 1, 'Cute', 'Mèo', 5, '2020-07-27', '2020-07-30', 1),
       (11, 1, 'Cute', 'Sen Đá', 5, '2020-07-27', '2020-07-30', 1),
       (12, 1, 'Chán ', 'Phở', 5, '2020-07-27', '2020-07-30', 123),
       (13, 1, 'Ngon', 'Cây chuối', 5, '2020-07-27', '2020-07-30', 1),
       (14, 1, 'Ngon lắm', 'Lá Ngón', 5, '2020-07-27', '2020-07-30', 2),
       (15, 1, 'Riềng mẻ mắm tôm', 'Chó', 2, '2020-06-30', '2020-07-30', 412),
       (16, 1, 'Riềng mẻ mắm tôm', 'Chó', 3, '2020-07-06', '2020-08-01', 1234),
       (17, 3, 'Canon', 'Canon EOS 5D Mark IV', 1, '2020-07-21', '2020-07-13', 120),
       (18, 3, 'Nikon', 'Nikon EOS D810', 1, '2020-07-21', '2020-07-13', 124),
       (19, 3, 'Sony', 'Sony A7 Mark III EOS R', 1, '2020-07-21', '2020-07-13', 125),
       (20, 1, 'Mắm Tôm', 'Chó', 1, '2020-06-30', '2020-06-30', 10),
       (21, 1, 'Description', 'Chó', 1, '2020-07-06', '2020-07-27', 1.2),
       (22, 3, 'Description', 'Acid B1', 0, '2020-06-28', '2020-07-07', 0),
       (23, 4, 'Hello', 'Thanh Dat', 0, '2020-06-28', '2020-07-10', 0),
       (24, 4, 'Cháo Lòng', 'Tiết Canh', 1, '2020-07-06', '2020-07-13', 123),
       (26, 1, 'Laptop', 'iPhone 6s cộng', 1, '2020-07-21', '2020-07-13', 12);
/*!40000 ALTER TABLE `product`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist`
    DISABLE KEYS */;
INSERT INTO `wishlist`
VALUES (1, 'Favorite');
/*!40000 ALTER TABLE `wishlist`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `wishlist-product`
--

LOCK TABLES `wishlist-product` WRITE;
/*!40000 ALTER TABLE `wishlist-product`
    DISABLE KEYS */;
INSERT INTO `wishlist-product`
VALUES (1, 1);
/*!40000 ALTER TABLE `wishlist-product`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2020-08-03 10:54:15
