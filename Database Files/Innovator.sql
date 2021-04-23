-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2021 at 11:02 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `innovator`
--

CREATE TABLE `innovator` (
  `innovatorID` int(11) NOT NULL,
  `innovatorName` varchar(45) DEFAULT NULL,
  `projName` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `project` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `innovator`
--

INSERT INTO `innovator` (`innovatorID`, `innovatorName`, `projName`, `price`, `project`) VALUES
(2, 'Hiran', 'itpm', '5000', 'bad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `innovator`
--
ALTER TABLE `innovator`
  ADD PRIMARY KEY (`innovatorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `innovator`
--
ALTER TABLE `innovator`
  MODIFY `innovatorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
