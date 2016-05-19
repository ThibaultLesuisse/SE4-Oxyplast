-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 19 mei 2016 om 22:52
-- Serverversie: 5.6.26
-- PHP-versie: 5.6.12

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

CREATE TABLE IF NOT EXISTS `aanvraag` (
  `id` int(11) NOT NULL,
  `klantid` int(11) NOT NULL,
  `aanvraag` varchar(500) NOT NULL,
  `aanvraagaanvaard` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `aanvraag`
--

INSERT INTO `aanvraag` (`id`, `klantid`, `aanvraag`, `aanvraagaanvaard`) VALUES
(1, 1, 'Een nieuwe soort verf voor buitengebruik in zeer koude landen', b'1'),
(2, 2, 'Een nieuwe soort verf voor buitengebruik in zeer warme landen', b'1'),
(3, 3, 'Nieuwe stadionverf', b'1');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bestelling`
--

CREATE TABLE IF NOT EXISTS `bestelling` (
  `bestellingid` int(11) NOT NULL,
  `aantal` int(11) NOT NULL,
  `leverancierid` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `prototypeid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `bestelling`
--

INSERT INTO `bestelling` (`bestellingid`, `aantal`, `leverancierid`, `projectid`, `prototypeid`) VALUES
(1, 5, 1, 50, 3),
(2, 5, 2, 51, 4);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `prototypeid` int(11) DEFAULT NULL,
  `partnerid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `feedback`
--

INSERT INTO `feedback` (`id`, `feedback`, `prototypeid`, `partnerid`) VALUES
(0, 'Fantastisch', 1, 1),
(1, 'Fantastisch', 1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `klanten`
--

CREATE TABLE IF NOT EXISTS `klanten` (
  `klantid` int(11) NOT NULL,
  `klantnaam` varchar(255) DEFAULT NULL,
  `klantvoornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `klanten`
--

INSERT INTO `klanten` (`klantid`, `klantnaam`, `klantvoornaam`) VALUES
(0, 'Bram', 'de Bram'),
(1, 'Van Rossum', 'Fiona'),
(2, 'Geoffrey', 'Mohammed Jadoul'),
(3, 'Bram', 'de Bram');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `leverancier`
--

CREATE TABLE IF NOT EXISTS `leverancier` (
  `id` int(11) NOT NULL,
  `adres` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `telefoonnummer` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `leverancier`
--

INSERT INTO `leverancier` (`id`, `adres`, `email`, `telefoonnummer`) VALUES
(1, 'vrijheidslaan 23 1081 Koekelberg', ' thib@thib.com', 24146489),
(2, 'vrijheidslaan 28 1081 Koekelberg', 'deman@deman.com', 241464897);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `onderzoeker`
--

CREATE TABLE IF NOT EXISTS `onderzoeker` (
  `onderzoekerid` int(11) NOT NULL,
  `onderzoekernaam` varchar(255) DEFAULT NULL,
  `onderzoekervoornaam` varchar(255) DEFAULT NULL,
  `onderzoekerteamid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `onderzoeker`
--

INSERT INTO `onderzoeker` (`onderzoekerid`, `onderzoekernaam`, `onderzoekervoornaam`, `onderzoekerteamid`) VALUES
(0, 'DeBrandere', 'Jacques', 1),
(1, 'DeBrandere', 'Jacques', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `partner`
--

CREATE TABLE IF NOT EXISTS `partner` (
  `partnerid` int(11) NOT NULL,
  `partnernaam` varchar(255) DEFAULT NULL,
  `partnervoornaam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `personen`
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
-- Gegevens worden geëxporteerd voor tabel `personen`
--

INSERT INTO `personen` (`id`, `emailadres`, `familienaam`, `paswoord`, `status`, `voornaam`) VALUES
(1, 'test@test.com', 'Lesuisse', 'Lesuisse', 'test', 'Thibault');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL,
  `teamid` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `formule` varchar(100) DEFAULT NULL,
  `startdatum` date NOT NULL,
  `einddatum` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `project`
--

INSERT INTO `project` (`id`, `teamid`, `status`, `naam`, `formule`, `startdatum`, `einddatum`) VALUES
(47, 1, 'nieuw', 'Fiona@gjh.com', NULL, '2016-05-02', '2016-05-25'),
(48, 1, 'DAO', 'Thib@gmail.com', NULL, '2016-04-13', '2016-05-31'),
(49, 1, 'nieuws', 'v@s.com', NULL, '2016-05-10', '2016-06-23'),
(50, 1, 'In Actie', 'DubaiWorks', NULL, '2016-05-23', '2016-06-30'),
(51, 1, 'Gebruikt', 'HANS', NULL, '2016-05-09', '2016-08-18'),
(52, 1, 'Nieuw', 'Alex', NULL, '2016-05-11', '2016-06-22');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `prototype`
--

CREATE TABLE IF NOT EXISTS `prototype` (
  `id` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `formule` varchar(500) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `prototype`
--

INSERT INTO `prototype` (`id`, `projectid`, `formule`) VALUES
(3, 50, 'NatriumChloride'),
(4, 51, 'NatriumBiChloride');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `rollen`
--

CREATE TABLE IF NOT EXISTS `rollen` (
  `type` varchar(31) NOT NULL,
  `rolid` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `usernaam` varchar(255) DEFAULT NULL,
  `sessie_id` int(11) DEFAULT NULL,
  `persoon_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `rollen`
--

INSERT INTO `rollen` (`type`, `rolid`, `status`, `usernaam`, `sessie_id`, `persoon_id`) VALUES
('Administrator', 1, 'aktief', 'thibault', NULL, 1),
('Accountverantwoordelijke', 2, 'aktief', 'thibaultLesuisse', NULL, 1),
('Onderzoeker', 3, 'Aktief', 'DenieuweOnderozker', NULL, 1),
('Klant', 4, 'Aanvaard', NULL, NULL, 1),
('Klant', 5, 'Aanvaard', NULL, NULL, 1),
('Partner', 6, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sessies`
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
-- Tabelstructuur voor tabel `team`
--

CREATE TABLE IF NOT EXISTS `team` (
  `teamid` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `omschrijving` int(11) NOT NULL,
  `actief` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `team`
--

INSERT INTO `team` (`teamid`, `projectid`, `omschrijving`, `actief`) VALUES
(1, 50, 2, 1);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `aanvraag`
--
ALTER TABLE `aanvraag`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `klantid` (`klantid`);

--
-- Indexen voor tabel `bestelling`
--
ALTER TABLE `bestelling`
  ADD PRIMARY KEY (`bestellingid`);

--
-- Indexen voor tabel `klanten`
--
ALTER TABLE `klanten`
  ADD UNIQUE KEY `klantid` (`klantid`);

--
-- Indexen voor tabel `leverancier`
--
ALTER TABLE `leverancier`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `onderzoeker`
--
ALTER TABLE `onderzoeker`
  ADD PRIMARY KEY (`onderzoekerid`);

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
  ADD PRIMARY KEY (`rolid`),
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
  ADD PRIMARY KEY (`teamid`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `aanvraag`
--
ALTER TABLE `aanvraag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `bestelling`
--
ALTER TABLE `bestelling`
  MODIFY `bestellingid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `leverancier`
--
ALTER TABLE `leverancier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `personen`
--
ALTER TABLE `personen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT voor een tabel `prototype`
--
ALTER TABLE `prototype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT voor een tabel `rollen`
--
ALTER TABLE `rollen`
  MODIFY `rolid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT voor een tabel `sessies`
--
ALTER TABLE `sessies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `team`
--
ALTER TABLE `team`
  MODIFY `teamid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
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
