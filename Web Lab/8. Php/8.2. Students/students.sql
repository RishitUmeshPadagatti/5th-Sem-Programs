-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2024 at 08:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `usn` varchar(20) NOT NULL,
  `branch` varchar(205) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `usn`, `branch`, `email`, `address`) VALUES
(1, 'Braham Kumar', '1ME21CS001', 'DS', 'braham@gmail.com', 'Nepal'),
(2, 'Aman Kumar', '1ME21CS002', 'CSE', 'aman@gmail.com', 'Chennai'),
(3, 'Sunil Kumar', '1ME21CS003', 'CIVIL', 'sunil@gmail.com', 'Delhi, India'),
(4, 'Shubham Kumar', '1ME21CS004', 'CSE', 'shubham@gmail.com', 'Ghaziabad'),
(5, 'Bikash Kumar Singh', '1ME21CS005', 'CSE', 'bikash@gmail.com', 'Mumbai, India'),
(6, 'Shaoib Akhtar', '1ME21CS006', 'AI&ML', 'shoaib@gmail.com', 'Patna, India'),
(7, 'Shiv Kumar Yadav', '1ME21CS007', 'ECE', 'shiv@gmail.com', 'Lucknow'),
(8, 'Arun Kumar', '1ME21CS008', 'CSE', 'arun@gmail.com', 'Bhopal'),
(9, 'Dipesh Kumar Mandal', '1ME21CS009', 'ISE', 'dipesh@gmail.com', 'Indore'),
(10, 'Shyam Kumar Singh', '1ME21CS010', 'ME', 'shyam@gmail.com', 'Pune');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
