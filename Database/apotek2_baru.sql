-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2021 at 06:24 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek2_baru`
--

-- --------------------------------------------------------

--
-- Table structure for table `golongan_obat`
--

CREATE TABLE `golongan_obat` (
  `KODE_GOLONGAN` int(11) NOT NULL,
  `KETERANGAN` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `golongan_obat`
--

INSERT INTO `golongan_obat` (`KODE_GOLONGAN`, `KETERANGAN`) VALUES
(1, 'Obat keras'),
(2, 'Obat sedang'),
(3, 'Obat biasa'),
(4, 'Resep Dokter'),
(5, 'biasa');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `ID_KARYAWAN` int(11) NOT NULL,
  `NAMA` varchar(50) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `NO_TELEPON` varchar(13) DEFAULT NULL,
  `JABATAN` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`ID_KARYAWAN`, `NAMA`, `ALAMAT`, `NO_TELEPON`, `JABATAN`) VALUES
(2220, 'Bagas', 'Jl.Semangka', '804579', 'Manager'),
(12212, 'zandi', 'jl.anggrek', '098789', 'pegawai'),
(22212, 'Bambang', 'Jl. Perak', '956342', 'Pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `ID_Obat` int(20) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Jumlah` int(20) NOT NULL,
  `Total_Harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `membeli`
--

CREATE TABLE `membeli` (
  `NO_SUPPLY` int(11) NOT NULL,
  `ID_OBAT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `membeli`
--

INSERT INTO `membeli` (`NO_SUPPLY`, `ID_OBAT`) VALUES
(11, 17);

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `ID_OBAT` int(11) NOT NULL,
  `KODE_GOLONGAN` int(11) DEFAULT NULL,
  `NAMA` varchar(50) DEFAULT NULL,
  `JENIS` varchar(20) DEFAULT NULL,
  `HARGA` int(11) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `KETERANGAN_` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`ID_OBAT`, `KODE_GOLONGAN`, `NAMA`, `JENIS`, `HARGA`, `STOCK`, `KETERANGAN_`) VALUES
(11, 1, 'Paramex', 'Obat kepala', 10000, 100, 'Tersedia'),
(12, 2, 'Bodrek', 'Obat kepala', 5000, 100, 'Tersedia'),
(13, 2, 'Promaag', 'Obat lambung', 5000, 100, 'Tersedia'),
(14, 3, 'Mylanta', 'Obat lambung', 10000, 100, 'Tersedia'),
(15, 3, 'Cortidex', 'Obat tenggorokan', 10000, 100, 'Tersedia'),
(16, 3, 'Antangin', 'Imunitas', 3000, 100, 'Tersedia'),
(17, 2, 'Oskadon', 'Obat kepala', 5000, 100, 'Tersedia'),
(18, 3, 'TOLAKANGIN', 'Imunitas', 3000, 100, 'Tersedia'),
(19, 3, 'Demacolin', 'Obat batuk', 5000, 100, 'Tersedia'),
(20, 2, 'Ranitidin', 'Obat lambung', 10000, 100, 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `ID_PELANGGAN` int(11) NOT NULL,
  `NAMA` varchar(50) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `JENIS_KELAMIN` varchar(10) DEFAULT NULL,
  `PEKERJAAN` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`ID_PELANGGAN`, `NAMA`, `ALAMAT`, `JENIS_KELAMIN`, `PEKERJAAN`) VALUES
(123, 'Zuhdi', 'Jl. in aja', 'L', 'Tukang Kebun'),
(3489, 'Ardian', 'Jl. Alpukat', 'L', 'Staf HRD'),
(4256, 'Dolog', 'Jl.Pasar Kembang', 'L', 'Tukang Servis'),
(7621, 'Isa', 'Jl.Pisang', 'P', 'Customer Service'),
(9843, 'Horsea', 'Jl.Nanas', 'L', 'HRD');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `NO_SUPPLY` int(11) NOT NULL,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `ID_KARYAWAN` int(11) DEFAULT NULL,
  `TANGGAL` date DEFAULT NULL,
  `TOTAL` decimal(30,0) DEFAULT NULL,
  `PAJAK` decimal(30,0) DEFAULT NULL,
  `TOTAL_BAYAR` decimal(30,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`NO_SUPPLY`, `ID_SUPPLIER`, `ID_KARYAWAN`, `TANGGAL`, `TOTAL`, `PAJAK`, `TOTAL_BAYAR`) VALUES
(11, 1221, 22212, '2021-12-20', '50', '10', '55');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `NO_PENJUALAN` int(11) NOT NULL,
  `ID_OBAT` int(11) DEFAULT NULL,
  `ID_KARYAWAN` int(11) DEFAULT NULL,
  `ID_PELANGGAN` int(11) DEFAULT NULL,
  `TANGGAL` date DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `TOTAL` decimal(30,0) DEFAULT NULL,
  `PAJAK` decimal(30,0) DEFAULT NULL,
  `TOTAL_BAYAR` decimal(30,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`NO_PENJUALAN`, `ID_OBAT`, `ID_KARYAWAN`, `ID_PELANGGAN`, `TANGGAL`, `JUMLAH`, `TOTAL`, `PAJAK`, `TOTAL_BAYAR`) VALUES
(1, 11, 22212, 123, '2021-12-20', 1, '10000', '10', '11000');

-- --------------------------------------------------------

--
-- Table structure for table `rincian_pembelian`
--

CREATE TABLE `rincian_pembelian` (
  `SEQBELI` int(11) NOT NULL,
  `NO_SUPPLY` int(11) DEFAULT NULL,
  `ID_OBAT` int(11) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `HARGA__SATUAN` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rincian_pembelian`
--

INSERT INTO `rincian_pembelian` (`SEQBELI`, `NO_SUPPLY`, `ID_OBAT`, `JUMLAH`, `HARGA__SATUAN`) VALUES
(111, 11, 17, 50, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `rincian_penjualan`
--

CREATE TABLE `rincian_penjualan` (
  `SEQJUAL` int(11) NOT NULL,
  `NO_PENJUALAN` int(11) DEFAULT NULL,
  `ID_OBAT` int(11) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `HARGA_SATUAN` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rincian_penjualan`
--

INSERT INTO `rincian_penjualan` (`SEQJUAL`, `NO_PENJUALAN`, `ID_OBAT`, `JUMLAH`, `HARGA_SATUAN`) VALUES
(2176, 1, 17, 1, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `ID_SUPPLIER` int(11) NOT NULL,
  `NAMA` varchar(50) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `KOTA` varchar(50) DEFAULT NULL,
  `NO_TELEPON` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`ID_SUPPLIER`, `NAMA`, `ALAMAT`, `KOTA`, `NO_TELEPON`) VALUES
(1221, 'Bintang', 'Jl.Simo', 'Surabaya', '673259'),
(1357, 'Ryo', 'Jl.Apel', 'Malang', '64286'),
(2120, 'Doni', 'Jl.Kembang Kuning', 'Surabaya', '345879'),
(2464, 'Amar', 'Jl.Pagesangan', 'Surabaya', '876589'),
(9192, 'Brian', 'Jl.Rungkut', 'Surabaya', '0204567');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `golongan_obat`
--
ALTER TABLE `golongan_obat`
  ADD PRIMARY KEY (`KODE_GOLONGAN`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`ID_KARYAWAN`);

--
-- Indexes for table `membeli`
--
ALTER TABLE `membeli`
  ADD PRIMARY KEY (`NO_SUPPLY`,`ID_OBAT`),
  ADD KEY `FK_MEMBELI2` (`ID_OBAT`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`ID_OBAT`),
  ADD KEY `FK_MEMPUNYAI5` (`KODE_GOLONGAN`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`ID_PELANGGAN`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`NO_SUPPLY`),
  ADD KEY `FK_CATAT` (`ID_KARYAWAN`),
  ADD KEY `FK_SUPPLY` (`ID_SUPPLIER`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`NO_PENJUALAN`),
  ADD UNIQUE KEY `ID_OBAT` (`ID_OBAT`),
  ADD UNIQUE KEY `ID_OBAT_2` (`ID_OBAT`),
  ADD KEY `FK_MELAKUKAN` (`ID_KARYAWAN`),
  ADD KEY `FK_MEMILIKI` (`ID_PELANGGAN`);

--
-- Indexes for table `rincian_pembelian`
--
ALTER TABLE `rincian_pembelian`
  ADD PRIMARY KEY (`SEQBELI`),
  ADD KEY `FK_MEMPUNYAI` (`ID_OBAT`),
  ADD KEY `FK_MEMPUNYAI1` (`NO_SUPPLY`);

--
-- Indexes for table `rincian_penjualan`
--
ALTER TABLE `rincian_penjualan`
  ADD PRIMARY KEY (`SEQJUAL`),
  ADD KEY `FK_MEMPUNYAI3` (`NO_PENJUALAN`),
  ADD KEY `FK_MEMPUNYAI4` (`ID_OBAT`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`ID_SUPPLIER`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `membeli`
--
ALTER TABLE `membeli`
  ADD CONSTRAINT `FK_MEMBELI` FOREIGN KEY (`NO_SUPPLY`) REFERENCES `pembelian` (`NO_SUPPLY`),
  ADD CONSTRAINT `FK_MEMBELI2` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);

--
-- Constraints for table `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `FK_MEMPUNYAI5` FOREIGN KEY (`KODE_GOLONGAN`) REFERENCES `golongan_obat` (`KODE_GOLONGAN`);

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `FK_CATAT` FOREIGN KEY (`ID_KARYAWAN`) REFERENCES `karyawan` (`ID_KARYAWAN`),
  ADD CONSTRAINT `FK_SUPPLY` FOREIGN KEY (`ID_SUPPLIER`) REFERENCES `supplier` (`ID_SUPPLIER`);

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `FK_MELAKUKAN` FOREIGN KEY (`ID_KARYAWAN`) REFERENCES `karyawan` (`ID_KARYAWAN`),
  ADD CONSTRAINT `FK_MEMILIKI` FOREIGN KEY (`ID_PELANGGAN`) REFERENCES `pelanggan` (`ID_PELANGGAN`),
  ADD CONSTRAINT `FK_TERDAFTAR` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);

--
-- Constraints for table `rincian_pembelian`
--
ALTER TABLE `rincian_pembelian`
  ADD CONSTRAINT `FK_MEMPUNYAI` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`),
  ADD CONSTRAINT `FK_MEMPUNYAI1` FOREIGN KEY (`NO_SUPPLY`) REFERENCES `pembelian` (`NO_SUPPLY`);

--
-- Constraints for table `rincian_penjualan`
--
ALTER TABLE `rincian_penjualan`
  ADD CONSTRAINT `FK_MEMPUNYAI3` FOREIGN KEY (`NO_PENJUALAN`) REFERENCES `penjualan` (`NO_PENJUALAN`),
  ADD CONSTRAINT `FK_MEMPUNYAI4` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
