-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2016 at 03:25 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oxyplast`
--

-- --------------------------------------------------------

--
-- Table structure for table `aanvraag`
--

CREATE TABLE IF NOT EXISTS `aanvraag` (
  `id` int(11) NOT NULL,
  `klantid` int(11) NOT NULL,
  `aanvraag` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personen`
--

CREATE TABLE IF NOT EXISTS `personen` (
  `id` int(11) NOT NULL,
  `emailadres` varchar(255) DEFAULT NULL,
  `familienaam` varchar(255) DEFAULT NULL,
  `paswoord` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personen`
--

INSERT INTO `personen` (`id`, `emailadres`, `familienaam`, `paswoord`, `status`, `voornaam`) VALUES
(1, 'test@test.com', 'Lesuisse', 'Lesuisse', 'test', 'Thibault');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL,
  `teamid` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `naam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `teamid`, `status`, `naam`) VALUES
(46, 50, 'h', 'NIET'),
(47, 50, 'nieuw', 'Alice@gjh.com'),
(48, 10, 'DAO', 'Thib@gmail.com'),
(49, 5, 'nieuws', 'v@s.com'),
(50, 4, 'In werking', 'Dubai');

-- --------------------------------------------------------

--
-- Table structure for table `prototype`
--

CREATE TABLE IF NOT EXISTS `prototype` (
  `id` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `formule` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rollen`
--

CREATE TABLE IF NOT EXISTS `rollen` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `usernaam` varchar(255) DEFAULT NULL,
  `sessie_id` int(11) DEFAULT NULL,
  `persoon_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rollen`
--

INSERT INTO `rollen` (`type`, `id`, `status`, `usernaam`, `sessie_id`, `persoon_id`) VALUES
('Administrator', 1, 'aktief', 'thibault', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sessies`
--

CREATE TABLE IF NOT EXISTS `sessies` (
  `id` int(11) NOT NULL,
  `begin_tijdstip` datetime DEFAULT NULL,
  `eind_tijdstip` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `titel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('user','admin','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aanvraag`
--
ALTER TABLE `aanvraag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `personen`
--
ALTER TABLE `personen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IPersoon_naam` (`voornaam`),
  ADD KEY `IPersoon_email` (`emailadres`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IProject_naam` (`naam`),
  ADD KEY `IProject_status` (`status`);

--
-- Indexes for table `prototype`
--
ALTER TABLE `prototype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rollen`
--
ALTER TABLE `rollen`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usernaam` (`usernaam`),
  ADD KEY `IRol_usernaam` (`usernaam`),
  ADD KEY `FKC8D761E6E431D823` (`sessie_id`),
  ADD KEY `FKC8D761E6C95BA6B1` (`persoon_id`);

--
-- Indexes for table `sessies`
--
ALTER TABLE `sessies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aanvraag`
--
ALTER TABLE `aanvraag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `personen`
--
ALTER TABLE `personen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `prototype`
--
ALTER TABLE `prototype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rollen`
--
ALTER TABLE `rollen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `sessies`
--
ALTER TABLE `sessies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `rollen`
--
ALTER TABLE `rollen`
  ADD CONSTRAINT `FKC8D761E6C95BA6B1` FOREIGN KEY (`persoon_id`) REFERENCES `personen` (`id`),
  ADD CONSTRAINT `FKC8D761E6E431D823` FOREIGN KEY (`sessie_id`) REFERENCES `sessies` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
