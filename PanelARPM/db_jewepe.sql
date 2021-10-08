-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2021 at 03:36 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jewepe`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun_mahasiswa`
--

CREATE TABLE `akun_mahasiswa` (
  `npm_mahasiswa` int(11) NOT NULL,
  `id_mahasiswa` int(11) NOT NULL,
  `nama_mahasiswa` varchar(30) NOT NULL,
  `password_mahasiswa` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun_mahasiswa`
--

INSERT INTO `akun_mahasiswa` (`npm_mahasiswa`, `id_mahasiswa`, `nama_mahasiswa`, `password_mahasiswa`) VALUES
(12117322, 5, 'Zuki', '654321'),
(12117323, 4, 'Adi', '654321'),
(12117324, 3, 'Zaki', '123456'),
(12117325, 2, 'Budi', '123456'),
(12117326, 1, 'Fernando', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` int(8) NOT NULL,
  `username_admin` varchar(11) NOT NULL,
  `nama_admin` varchar(30) NOT NULL,
  `no_telp_admin` varchar(15) NOT NULL,
  `password_admin` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `username_admin`, `nama_admin`, `no_telp_admin`, `password_admin`) VALUES
(1, 'nando', 'Fernando Teguh', '0898151625', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_mahasiswa`
--

CREATE TABLE `tbl_mahasiswa` (
  `id_mahasiswa` int(11) NOT NULL,
  `nama_mahasiswa` varchar(30) NOT NULL,
  `jenis_kelamin_mahasiswa` varchar(10) NOT NULL,
  `no_hp_mahasiswa` varchar(16) NOT NULL,
  `jurusan_mahasiswa` varchar(20) NOT NULL,
  `usia_mahasiswa` int(3) NOT NULL,
  `alamat_mahasiswa` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_mahasiswa`
--

INSERT INTO `tbl_mahasiswa` (`id_mahasiswa`, `nama_mahasiswa`, `jenis_kelamin_mahasiswa`, `no_hp_mahasiswa`, `jurusan_mahasiswa`, `usia_mahasiswa`, `alamat_mahasiswa`) VALUES
(2, 'Fernando Teguh', 'Laki Laki', '08981152982', 'Teknik Informatika', 22, 'Batur 1');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_matakuliah`
--

CREATE TABLE `tbl_matakuliah` (
  `id_matakuliah` int(8) NOT NULL,
  `nama_matakuliah` varchar(35) NOT NULL,
  `dosen_matakuliah` varchar(25) NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `jumlah_sks` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_matakuliah`
--

INSERT INTO `tbl_matakuliah` (`id_matakuliah`, `nama_matakuliah`, `dosen_matakuliah`, `jurusan`, `jumlah_sks`) VALUES
(1010201, 'Junior Android Programmer', 'Steve Jobs', 'Sistem Informasi', 2),
(1010202, 'Junior IOS Programmer', 'Mark Zukenberg', 'Sistem Informasi', 3),
(1010203, 'Junior Web Programmer', 'Mark Zukenberg', 'Sistem Informasi', 2),
(1010204, 'Junior React Native', 'Steve Aoki', 'Sistem Informasi', 3),
(1010205, 'Junior Kotlin Programming', 'Steve Jobs', 'Sistem Informasi', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_matakuliah_mahasiswa`
--

CREATE TABLE `tbl_matakuliah_mahasiswa` (
  `id_matakuliah` int(8) NOT NULL,
  `nama_matakuliah` varchar(35) NOT NULL,
  `dosen_matakuliah` varchar(25) NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `jumlah_sks` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_matakuliah_mahasiswa`
--

INSERT INTO `tbl_matakuliah_mahasiswa` (`id_matakuliah`, `nama_matakuliah`, `dosen_matakuliah`, `jurusan`, `jumlah_sks`) VALUES
(1010201, 'Junior Android Programmer', 'Steve Jobs', 'Sistem Informasi', 2),
(1010203, 'Junior Web Programmer', 'Mark Zukenberg', 'Sistem Informasi', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun_mahasiswa`
--
ALTER TABLE `akun_mahasiswa`
  ADD PRIMARY KEY (`npm_mahasiswa`);

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_mahasiswa`
--
ALTER TABLE `tbl_mahasiswa`
  ADD PRIMARY KEY (`id_mahasiswa`);

--
-- Indexes for table `tbl_matakuliah`
--
ALTER TABLE `tbl_matakuliah`
  ADD PRIMARY KEY (`id_matakuliah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun_mahasiswa`
--
ALTER TABLE `akun_mahasiswa`
  MODIFY `npm_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12117327;

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id_admin` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_mahasiswa`
--
ALTER TABLE `tbl_mahasiswa`
  MODIFY `id_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_matakuliah`
--
ALTER TABLE `tbl_matakuliah`
  MODIFY `id_matakuliah` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1010206;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
