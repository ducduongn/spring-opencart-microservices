-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: opencart
-- ------------------------------------------------------
-- Server version	8.0.20

CREATE DATABASE opencart;
USE opencart;

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand`
(
    `brandId`          int           NOT NULL AUTO_INCREMENT,
    `brandName`        varchar(45)   NOT NULL,
    `brandDescription` varchar(1000) NOT NULL,
    PRIMARY KEY (`brandId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart`
(
    `customerId` int      NOT NULL,
    `dateAdded`  datetime NOT NULL,
    `quantity`   int      NOT NULL,
    PRIMARY KEY (`customerId`),
    CONSTRAINT `CART_FK_CUSTOMER` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart-product`
--

DROP TABLE IF EXISTS `cart-product`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart-product`
(
    `customerId` int NOT NULL,
    `productId`  int NOT NULL,
    KEY `FK_CART_PRODUCT2_idx` (`productId`),
    KEY `FK_CART_PRODUCT1_idx` (`customerId`),
    CONSTRAINT `FK_CART_PRODUCT1` FOREIGN KEY (`customerId`) REFERENCES `cart` (`customerId`),
    CONSTRAINT `FK_CART_PRODUCT2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category`
(
    `categoryId`          int           NOT NULL AUTO_INCREMENT,
    `name`                varchar(45)   NOT NULL,
    `categoryDescription` varchar(1000) NOT NULL,
    PRIMARY KEY (`categoryId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category-product`
--

DROP TABLE IF EXISTS `category-product`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category-product`
(
    `catetogoryId` int NOT NULL,
    `productId`    int NOT NULL,
    PRIMARY KEY (`catetogoryId`, `productId`),
    KEY `FK_PRODUCT_idx` (`productId`),
    CONSTRAINT `FK_CATEGORY_PRODUCT1` FOREIGN KEY (`catetogoryId`) REFERENCES `category` (`categoryId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `FK_CATEGORY_PRODUCT2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer`
(
    `customerId`   int          NOT NULL AUTO_INCREMENT,
    `firstName`    varchar(45)  NOT NULL,
    `lastName`     varchar(45)  NOT NULL,
    `email`        varchar(45)  NOT NULL,
    `phone`        varchar(45)  NOT NULL,
    `accountName`  varchar(45)  NOT NULL,
    `password`     varchar(500) NOT NULL,
    `addressLine1` varchar(500) NOT NULL,
    `addressLine2` varchar(500) NOT NULL,
    `city`         varchar(45)  NOT NULL,
    `country`      varchar(45)  NOT NULL,
    PRIMARY KEY (`customerId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order`
(
    `orderId`      int         NOT NULL AUTO_INCREMENT,
    `orderDate`    date        NOT NULL,
    `requiredDate` date        NOT NULL,
    `shippedDate`  date        NOT NULL,
    `status`       varchar(15) NOT NULL,
    `customerId`   int         NOT NULL,
    PRIMARY KEY (`orderId`),
    KEY `ORDER_FK_CUSTOMER_idx` (`customerId`),
    CONSTRAINT `ORDER_FK_CUSTOMER` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail`
(
    `orderId`       int NOT NULL,
    `productId`     int NOT NULL,
    `quantityOrder` int NOT NULL,
    `description`   varchar(1000) DEFAULT NULL,
    PRIMARY KEY (`orderId`, `productId`),
    KEY `ORDERDETAIL_FK_PRODUCT_idx` (`productId`),
    CONSTRAINT `ORDERDETAIL_FK_ORDER` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `ORDERDETAIL_FK_PRODUCT` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product`
(
    `productId`    int           NOT NULL AUTO_INCREMENT,
    `brandId`      int           NOT NULL,
    `description`  varchar(1000) NOT NULL,
    `productName`  varchar(45)   NOT NULL,
    `quantity`     int           NOT NULL,
    `dateAdded`    date          NOT NULL,
    `dateModified` date DEFAULT NULL,
    `priceunit`    double        NOT NULL,
    PRIMARY KEY (`productId`),
    KEY `PRODUCT_FK_BRAND_idx` (`brandId`),
    CONSTRAINT `PRODUCT_FK_BRAND` FOREIGN KEY (`brandId`) REFERENCES `brand` (`brandId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 27
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist`
(
    `customerId` int         NOT NULL,
    `status`     varchar(15) NOT NULL,
    PRIMARY KEY (`customerId`),
    KEY `WISHLIST_FK_CUSTOMER_idx` (`customerId`),
    CONSTRAINT `WISHLIST_FK_CUSTOMER` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wishlist-product`
--

DROP TABLE IF EXISTS `wishlist-product`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist-product`
(
    `customerId` int NOT NULL,
    `productId`  int NOT NULL,
    KEY `FK_WISHLIST_PRODUCT2_idx` (`productId`),
    KEY `FK_WISHLIST_PRODUCT1_idx` (`customerId`),
    CONSTRAINT `FK_WISHLIST_PRODUCT1` FOREIGN KEY (`customerId`) REFERENCES `wishlist` (`customerId`),
    CONSTRAINT `FK_WISHLIST_PRODUCT2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2020-07-31 23:56:52

/* Ignore Foreign Key Check */
SET FOREIGN_KEY_CHECKS = 0;