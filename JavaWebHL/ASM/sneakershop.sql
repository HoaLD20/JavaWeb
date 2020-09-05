-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 30, 2020 at 12:26 PM
-- Server version: 8.0.21-0ubuntu0.20.04.3
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kvt`
--

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE `ads` (
  `aId` int NOT NULL,
  `aImage` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `aURL` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `ads`
--

INSERT INTO `ads` (`aId`, `aImage`, `aURL`) VALUES
(1, 'upload/poni.jpg', 'https://daihoc.fpt.edu.vn/khoa-hoc-quang-cao-mien-phi-danh-cho-fptuers/'),
(2, 'upload/poni.jpg', 'https://www.behance.net/gallery/18745337/Drive-me-to-the-Moon-Lamborghini-Advertisement'),
(3, 'upload/poni.jpg', 'https://www.wessanen.com/organic-september-brings-feel-good-brands-together-first-time/');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartId` int NOT NULL,
  `uId` int NOT NULL,
  `pId` int NOT NULL,
  `cartQuantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartId`, `uId`, `pId`, `cartQuantity`) VALUES
(2, 3, 5, 1),
(3, 7, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cId` int NOT NULL,
  `cName` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cId`, `cName`) VALUES
(1, 'Shoes type 1'),
(2, 'Shoes type 2'),
(3, 'Shoes type 3');

-- --------------------------------------------------------

--
-- Table structure for table `charge`
--

CREATE TABLE `charge` (
  `chargeId` int NOT NULL,
  `chargeCardNumber` tinytext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `chargeValue` int NOT NULL,
  `chargeUsed` tinyint(1) NOT NULL,
  `chargeTaken` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `charge`
--

INSERT INTO `charge` (`chargeId`, `chargeCardNumber`, `chargeValue`, `chargeUsed`, `chargeTaken`) VALUES
(3, '2c1d10816677996c', 50000, 0, 0),
(4, 'a56056437839727a', 50000, 0, 0),
(5, '9e96a75983a77f25', 50000, 0, 0),
(6, '3595a61e7a1a9991', 50000, 0, 0),
(7, '8d43534d921f2719', 50000, 0, 0),
(8, '634d7e859ba783a6', 100000, 0, 0),
(9, '9f35691242634a16', 100000, 0, 0),
(10, '8b65849c836f9f43', 100000, 0, 0),
(11, '8f339e836e3d8b33', 100000, 0, 0),
(12, '10819d59663a9256', 100000, 0, 0),
(13, '804a43386b623f15', 200000, 0, 0),
(14, '9aa5494d1641647e', 200000, 0, 0),
(15, '17147f4c50584011', 200000, 0, 0),
(16, 'a41f572a7e78a69c', 200000, 0, 0),
(17, '889e541232142999', 200000, 0, 0),
(18, '6314579277a7a618', 500000, 0, 1),
(19, '824486893787295e', 500000, 0, 0),
(20, '234a525a186d8544', 500000, 0, 0),
(21, '781a3565418b4d58', 500000, 0, 0),
(22, '1e4b30465b109d8e', 500000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `hId` int NOT NULL,
  `uId` int NOT NULL,
  `pId` int NOT NULL,
  `hDate` varchar(25) NOT NULL,
  `hQuantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `pId` int NOT NULL,
  `cId` int DEFAULT NULL,
  `pName` varchar(255) DEFAULT NULL,
  `pImage` varchar(255) DEFAULT NULL,
  `pPrice` double DEFAULT NULL,
  `pWeight` int DEFAULT NULL,
  `pDescription` text,
  `pQuantity` int DEFAULT NULL,
  `pCreateDate` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pId`, `cId`, `pName`, `pImage`, `pPrice`, `pWeight`, `pDescription`, `pQuantity`, `pCreateDate`) VALUES
(2, 1, 'Shoes', 'upload/shoe3.jpg', 5000000, 60, 'meow meow', 100, '2020-28-02'),
(3, 2, 'shoes', 'upload/shoe7.jpg', 6000000, 60, 'made in Chiana', 200, '2020-28-20'),
(5, 3, 'shoes', 'upload/shoe5.jpg', 2000000, 39, 'Made in China', 200, '2020-28-02'),
(6, 2, 'shoes', 'upload/shoe6.jpg', 150000, 75, 'Made in China', 300, '2020-28-03'),
(7, 1, 'shoes', 'upload/shoe2.jpeg', 150000, 90, 'Made in China', 200, '2020-28-03'),
(8, 1, 'Shoes', 'upload/shoe4.jpg', 150000000, 65, 'Made in China', 200, '2020-28-03'),
(29, 3, 'shoes', 'upload/shoe1.jpg', 8000000, 200, 'meow meow', 100, '2020-07-20');

-- --------------------------------------------------------

--
-- Table structure for table `slides`
--

CREATE TABLE `slides` (
  `sId` int NOT NULL,
  `pId` int NOT NULL,
  `sTitle` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sSubtitle` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sDescription` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sImage` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `slides`
--

INSERT INTO `slides` (`sId`, `pId`, `sTitle`, `sSubtitle`, `sDescription`, `sImage`) VALUES
(1, 22, 'Shoes type 3', 'High Quality Shoes ', 'Made in China', 'upload/shoe1.jpg'),
(2, 2, 'Shoes type 2', 'High Quality Shoes', 'Made in China', 'upload/shoe3.jpg'),
(3, 29, 'Shoes type 1', 'High Quality Shoes', 'made in China', 'upload/shoe8.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uId` int NOT NULL,
  `uName` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uEmail` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uAddress` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uJob` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uPassword` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uCreditCard` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uCash` double NOT NULL,
  `uRole` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uPhoto` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'upload/profile.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uId`, `uName`, `uEmail`, `uAddress`, `uJob`, `uPassword`, `uCreditCard`, `uCash`, `uRole`, `uPhoto`) VALUES
(2, 'hoadepzai', 'hoadepzai@gmail.com', 'can tho', 'student', '202cb962ac59075b964b07152d234b70', '8888-8888-8888-8888 	', 0, 'admin', 'upload/admin.png'),
(3, 'hoa', 'hoa@gmail.com', 'can tho', 'meow', '202cb962ac59075b964b07152d234b70', '8888-8888-8888-8888', 0, 'user', 'upload/user.png'),
(7, 'Da', 'Daql@fe.edu.vn', 'Can Tho', 'meow', '827ccb0eea8a706c4c34a16891f84e7b', '8888-8888-8888-8886', 0, 'user', 'upload/user.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ads`
--
ALTER TABLE `ads`
  ADD PRIMARY KEY (`aId`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartId`),
  ADD KEY `user_id` (`uId`),
  ADD KEY `product_id` (`pId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cId`),
  ADD KEY `id` (`cId`);

--
-- Indexes for table `charge`
--
ALTER TABLE `charge`
  ADD PRIMARY KEY (`chargeId`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`hId`),
  ADD KEY `user_id` (`uId`),
  ADD KEY `product_id` (`pId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `cId` (`cId`),
  ADD KEY `pId` (`pId`);

--
-- Indexes for table `slides`
--
ALTER TABLE `slides`
  ADD PRIMARY KEY (`sId`),
  ADD KEY `product_id` (`pId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uId`),
  ADD UNIQUE KEY `username` (`uName`),
  ADD UNIQUE KEY `email` (`uEmail`),
  ADD UNIQUE KEY `creaditCard` (`uCreditCard`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ads`
--
ALTER TABLE `ads`
  MODIFY `aId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `charge`
--
ALTER TABLE `charge`
  MODIFY `chargeId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `hId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `pId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `slides`
--
ALTER TABLE `slides`
  MODIFY `sId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `uId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `products` (`pId`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`uId`) REFERENCES `users` (`uId`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `products` (`pId`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`uId`) REFERENCES `users` (`uId`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`cId`) REFERENCES `category` (`cId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
