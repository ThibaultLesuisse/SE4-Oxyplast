-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 28 apr 2016 om 03:34
-- Serverversie: 10.1.13-MariaDB
-- PHP-versie: 5.6.20

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
-- Tabelstructuur voor tabel `aanvraag`
--

CREATE TABLE `aanvraag` (
  `id` int(11) NOT NULL,
  `klantid` int(11) NOT NULL,
  `aanvraag` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `prototypeid` int(11) DEFAULT NULL,
  `partnerid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `feedback`
--

INSERT INTO `feedback` (`id`, `feedback`, `prototypeid`, `partnerid`) VALUES
(1, 'feedback lijn 1', 1, 1),
(2, 'feedback testje 2', 1, 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klanten`
--

CREATE TABLE `klanten` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `onderzoeker`
--

CREATE TABLE `onderzoeker` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL,
  `teamid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `partners`
--

CREATE TABLE `partners` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `partners`
--

INSERT INTO `partners` (`id`, `naam`, `voornaam`) VALUES
(1, 'Karel', 'Kerel'),
(2, 'Annie', 'Anne');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `personen`
--

CREATE TABLE `personen` (
  `id` int(11) NOT NULL,
  `emailadres` varchar(255) DEFAULT NULL,
  `familienaam` varchar(255) DEFAULT NULL,
  `paswoord` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `personen`
--

INSERT INTO `personen` (`id`, `emailadres`, `familienaam`, `paswoord`, `status`, `voornaam`) VALUES
(1, 'test@test.com', 'Lesuisse', 'Lesuisse', 'test', 'Thibault');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `teamid` int(11) DEFAULT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `aanvraagid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `project`
--

INSERT INTO `project` (`id`, `teamid`, `naam`, `status`, `aanvraagid`) VALUES
(46, 50, 'NIET', 'h', NULL),
(47, 50, 'Alice@gjh.com', 'nieuw', NULL),
(48, 10, 'Thib@gmail.com', 'DAO', NULL),
(50, 4, 'Dubai', 'In werking', NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `prototype`
--

CREATE TABLE `prototype` (
  `id` int(11) NOT NULL,
  `formule` varchar(500) NOT NULL,
  `projectid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `prototype`
--

INSERT INTO `prototype` (`id`, `formule`, `projectid`) VALUES
(1, 'test', 50);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `rollen`
--

CREATE TABLE `rollen` (
  `type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `usernaam` varchar(255) DEFAULT NULL,
  `sessie_id` int(11) DEFAULT NULL,
  `persoon_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `rollen`
--

INSERT INTO `rollen` (`type`, `id`, `status`, `usernaam`, `sessie_id`, `persoon_id`) VALUES
('Administrator', 1, 'aktief', 'thibault', NULL, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sessies`
--

CREATE TABLE `sessies` (
  `id` int(11) NOT NULL,
  `begin_tijdstip` datetime DEFAULT NULL,
  `eind_tijdstip` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `titel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `team`
--

INSERT INTO `team` (`id`, `naam`) VALUES
(5, 'testTeam');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('user','admin','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `aanvraag`
--
ALTER TABLE `aanvraag`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `klanten`
--
ALTER TABLE `klanten`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `onderzoeker`
--
ALTER TABLE `onderzoeker`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `partners`
--
ALTER TABLE `partners`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `personen`
--
ALTER TABLE `personen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IPersoon_naam` (`voornaam`),
  ADD KEY `IPersoon_email` (`emailadres`);

--
-- Indexen voor tabel `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IProject_naam` (`naam`),
  ADD KEY `IProject_status` (`status`);

--
-- Indexen voor tabel `prototype`
--
ALTER TABLE `prototype`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `rollen`
--
ALTER TABLE `rollen`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usernaam` (`usernaam`),
  ADD KEY `IRol_usernaam` (`usernaam`),
  ADD KEY `FKC8D761E6E431D823` (`sessie_id`),
  ADD KEY `FKC8D761E6C95BA6B1` (`persoon_id`);

--
-- Indexen voor tabel `sessies`
--
ALTER TABLE `sessies`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `aanvraag`
--
ALTER TABLE `aanvraag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT voor een tabel `klanten`
--
ALTER TABLE `klanten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `onderzoeker`
--
ALTER TABLE `onderzoeker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `partners`
--
ALTER TABLE `partners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `personen`
--
ALTER TABLE `personen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT voor een tabel `prototype`
--
ALTER TABLE `prototype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `rollen`
--
ALTER TABLE `rollen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `sessies`
--
ALTER TABLE `sessies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT voor een tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `rollen`
--
ALTER TABLE `rollen`
  ADD CONSTRAINT `FKC8D761E6C95BA6B1` FOREIGN KEY (`persoon_id`) REFERENCES `personen` (`id`),
  ADD CONSTRAINT `FKC8D761E6E431D823` FOREIGN KEY (`sessie_id`) REFERENCES `sessies` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
