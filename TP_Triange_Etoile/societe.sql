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

CREATE TABLE IF NOT EXISTS `Adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etat` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

-- --------------------------------------------------------

--
-- Table structure for table `Departement`
--

CREATE TABLE IF NOT EXISTS `Departement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `Employe`
--

CREATE TABLE IF NOT EXISTS `Employe` (
  `statut` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `salaire` int(11) DEFAULT NULL,
  `dateArrivee` datetime DEFAULT NULL,
  `adresse` int(11) DEFAULT NULL,
  `departement` int(11) DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b2uj6gqstji4yr1029cbs0hsv` (`adresse`),
  KEY `FK_lk0a412kck2kdc6slousi528s` (`departement`),
  KEY `FK_4p6o0ltcblvgj68bnrpfqygq` (`manager`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Table structure for table `Numeros`
--

CREATE TABLE IF NOT EXISTS `Numeros` (
  `Employe` int(11) NOT NULL,
  `numeros` varchar(255) DEFAULT NULL,
  KEY `FK_sw6lodt7b256b38s6ucdyn7xg` (`Employe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employe_Project`
--

CREATE TABLE IF NOT EXISTS `Employe_Projet` (
  `employe` int(11) NOT NULL,
  `projets` int(11) NOT NULL,
  KEY `FK_5q8xj4rq504h1nlheo6exssau` (`projets`),
  KEY `FK_85serqn7tjhwk6evp45tw8ul1` (`employe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Projet`
--

CREATE TABLE IF NOT EXISTS `Projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Employe`
--
ALTER TABLE `Employe`
  ADD CONSTRAINT `FK_4p6o0ltcblvgj68bnrpfqygq` FOREIGN KEY (`manager`) REFERENCES `Employe` (`id`),
  ADD CONSTRAINT `FK_b2uj6gqstji4yr1029cbs0hsv` FOREIGN KEY (`adresse`) REFERENCES `Adresse` (`id`),
  ADD CONSTRAINT `FK_lk0a412kck2kdc6slousi528s` FOREIGN KEY (`departement`) REFERENCES `Departement` (`id`);

--
-- Constraints for table `Numeros`
--
ALTER TABLE `Numeros`
  ADD CONSTRAINT `FK_sw6lodt7b256b38s6ucdyn7xg` FOREIGN KEY (`Employe`) REFERENCES `Employe` (`id`);

--
-- Constraints for table `Employe_Project`
--
ALTER TABLE `Employe_Projet`
  ADD CONSTRAINT `FK_85serqn7tjhwk6evp45tw8ul1` FOREIGN KEY (`employe`) REFERENCES `Employe` (`id`),
  ADD CONSTRAINT `FK_5q8xj4rq504h1nlheo6exssau` FOREIGN KEY (`projets`) REFERENCES `Projet` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
