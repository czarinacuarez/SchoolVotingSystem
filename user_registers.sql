-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2022 at 12:57 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user_registers`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `studentid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `middlename` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL,
  `section` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `course` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`studentid`, `username`, `pass`, `lastname`, `firstname`, `middlename`, `year`, `section`, `age`, `gender`, `course`) VALUES
('2021123456', 'admin', 'admin', 'ADMIN', 'SAMPLE', '', 'GRADE 12', 'ABM1', 18, 'MALE', 'ABM');

-- --------------------------------------------------------

--
-- Table structure for table `candidates_info`
--

CREATE TABLE `candidates_info` (
  `studentid` varchar(10) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `middlename` varchar(20) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `year` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `party` varchar(50) NOT NULL,
  `vote_count` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

--
-- Dumping data for table `candidates_info`
--

INSERT INTO `candidates_info` (`studentid`, `lastname`, `firstname`, `middlename`, `fullname`, `gender`, `year`, `position`, `party`, `vote_count`) VALUES
('2010210193', 'PADILLA', 'DANIEL', '', 'PADILLA DANIEL ', 'MALE', 'GRADE 12', 'ASSISTANT SECRETARY', 'BULAKLAK', 1),
('2012019021', 'LUSTRE', 'NADINE', '', 'LUSTRE NADINE ', 'FEMALE', 'GRADE 12', 'AUDITOR', 'BULAKLAK', 1),
('2019021902', 'GIL', 'ENRIQUE', '', 'GIL ENRIQUE ', 'FEMALE', 'GRADE 12', 'VICE-PRESIDENT', 'SAMPAGUITA', 1),
('2021021021', 'METRILLO', 'WENDELL', '', 'METRILLO WENDELL ', 'MALE', 'GRADE 12', 'PRESIDENT', 'MAKABAYAN', 1),
('2021091039', 'REID', 'JAMES', '', 'REID JAMES ', 'MALE', 'GRADE 12', 'TREASURER', 'BULAKLAK', 1),
('2021122322', 'SOBERANO', 'LIZA', '', 'SOBERANO LIZA ', 'FEMALE', 'GRADE 12', 'PRESIDENT', 'BULAKLAK', 0),
('2138103810', 'BERNANDO', 'KATH', '', 'BERNANDO KATH ', 'FEMALE', 'GRADE 12', 'SECRETARY', 'BULAKLAK', 1);

-- --------------------------------------------------------

--
-- Table structure for table `party`
--

CREATE TABLE `party` (
  `num` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`name`) VALUES
('ASSISTANT SECRETARY'),
('AUDITOR'),
('PRESIDENT'),
('SECRETARY'),
('TREASURER'),
('VICE-PRESIDENT');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `studentid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `middlename` varchar(20) NOT NULL,
  `course` varchar(20) NOT NULL,
  `year` varchar(50) NOT NULL,
  `section` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `vote_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`studentid`, `username`, `pass`, `lastname`, `firstname`, `middlename`, `course`, `year`, `section`, `age`, `gender`, `vote_count`) VALUES
('2012010921', 'student', 'student', 'MACARAIG', 'JM', '', 'ICT', 'GRADE 12', 'ICT1', 21, 'MALE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `votes`
--

CREATE TABLE `votes` (
  `totalvotes` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin7;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `voterid` (`studentid`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `candidates_info`
--
ALTER TABLE `candidates_info`
  ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `party`
--
ALTER TABLE `party`
  ADD PRIMARY KEY (`num`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `voterid` (`studentid`),
  ADD UNIQUE KEY `username` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
