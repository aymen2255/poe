-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2014 at 07:21 AM
-- Server version: 5.5.35
-- PHP Version: 5.3.10-1ubuntu3.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `Address`
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE IF NOT EXISTS `Department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE IF NOT EXISTS `Employee` (
  `statut` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b2uj6gqstji4yr1029cbs0hsv` (`address_id`),
  KEY `FK_lk0a412kck2kdc6slousi528s` (`department_id`),
  KEY `FK_4p6o0ltcblvgj68bnrpfqygq` (`manager_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_phoneNumbers`
--

CREATE TABLE IF NOT EXISTS `Employee_phoneNumbers` (
  `Employee_id` int(11) NOT NULL,
  `phoneNumbers` varchar(255) DEFAULT NULL,
  KEY `FK_sw6lodt7b256b38s6ucdyn7xg` (`Employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_Project`
--

CREATE TABLE IF NOT EXISTS `Employee_Project` (
  `employees_id` int(11) NOT NULL,
  `projects_id` int(11) NOT NULL,
  KEY `FK_5q8xj4rq504h1nlheo6exssau` (`projects_id`),
  KEY `FK_85serqn7tjhwk6evp45tw8ul1` (`employees_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Project`
--

CREATE TABLE IF NOT EXISTS `Project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Employee`
--
ALTER TABLE `Employee`
  ADD CONSTRAINT `FK_4p6o0ltcblvgj68bnrpfqygq` FOREIGN KEY (`manager_id`) REFERENCES `Employee` (`id`),
  ADD CONSTRAINT `FK_b2uj6gqstji4yr1029cbs0hsv` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`),
  ADD CONSTRAINT `FK_lk0a412kck2kdc6slousi528s` FOREIGN KEY (`department_id`) REFERENCES `Department` (`id`);

--
-- Constraints for table `Employee_phoneNumbers`
--
ALTER TABLE `Employee_phoneNumbers`
  ADD CONSTRAINT `FK_sw6lodt7b256b38s6ucdyn7xg` FOREIGN KEY (`Employee_id`) REFERENCES `Employee` (`id`);

--
-- Constraints for table `Employee_Project`
--
ALTER TABLE `Employee_Project`
  ADD CONSTRAINT `FK_85serqn7tjhwk6evp45tw8ul1` FOREIGN KEY (`employees_id`) REFERENCES `Employee` (`id`),
  ADD CONSTRAINT `FK_5q8xj4rq504h1nlheo6exssau` FOREIGN KEY (`projects_id`) REFERENCES `Project` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
