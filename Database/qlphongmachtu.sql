-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2019 at 01:51 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlphongmachtu`
--

-- --------------------------------------------------------

--
-- Table structure for table `benhnhan`
--

CREATE TABLE `benhnhan` (
  `MaBenhNhan` int(11) NOT NULL,
  `TenBenhNhan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` int(11) NOT NULL,
  `NamSinh` int(11) NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cachdung`
--

CREATE TABLE `cachdung` (
  `MaCachDung` int(11) NOT NULL,
  `TenCachDung` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctphieukhambenh`
--

CREATE TABLE `ctphieukhambenh` (
  `MaPhieuKhamBenh` int(11) NOT NULL,
  `MaThuoc` int(11) NOT NULL,
  `MaCachDung` int(11) NOT NULL,
  `DonGia` float NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donvi`
--

CREATE TABLE `donvi` (
  `MaDonVi` int(11) NOT NULL,
  `TenDonVi` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `NgayThanhToan` datetime NOT NULL,
  `TienKham` float NOT NULL,
  `TongTien` float NOT NULL,
  `MaPhieuKhamBenh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaibenh`
--

CREATE TABLE `loaibenh` (
  `MaLoaiBenh` int(11) NOT NULL,
  `TenLoaiBenh` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `TenDangNhap` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `HoTenNV` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TinhTrang` int(11) NOT NULL,
  `MaCV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieukhambenh`
--

CREATE TABLE `phieukhambenh` (
  `MaPhieuKhamBenh` int(11) NOT NULL,
  `MaBenhNhan` int(11) NOT NULL,
  `NgayKham` datetime NOT NULL,
  `TrieuChung` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TongTienThuoc` float NOT NULL,
  `MaLoaiBenh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quidinh`
--

CREATE TABLE `quidinh` (
  `MaQuiDinh` int(11) NOT NULL,
  `TenQuiDinh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `GiaTri` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thuoc`
--

CREATE TABLE `thuoc` (
  `MaThuoc` int(11) NOT NULL,
  `TenThuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` int(11) NOT NULL,
  `TinhTrang` int(11) NOT NULL,
  `MaDonVi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `benhnhan`
--
ALTER TABLE `benhnhan`
  ADD PRIMARY KEY (`MaBenhNhan`);

--
-- Indexes for table `cachdung`
--
ALTER TABLE `cachdung`
  ADD PRIMARY KEY (`MaCachDung`);

--
-- Indexes for table `ctphieukhambenh`
--
ALTER TABLE `ctphieukhambenh`
  ADD PRIMARY KEY (`MaPhieuKhamBenh`,`MaThuoc`),
  ADD KEY `fk_ctphieukhambenh_thuoc` (`MaThuoc`),
  ADD KEY `fk_ctphieukhambenh_cachdung` (`MaCachDung`);

--
-- Indexes for table `donvi`
--
ALTER TABLE `donvi`
  ADD PRIMARY KEY (`MaDonVi`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `fk_hoadon_phieukhambenh` (`MaPhieuKhamBenh`);

--
-- Indexes for table `loaibenh`
--
ALTER TABLE `loaibenh`
  ADD PRIMARY KEY (`MaLoaiBenh`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`TenDangNhap`);

--
-- Indexes for table `phieukhambenh`
--
ALTER TABLE `phieukhambenh`
  ADD PRIMARY KEY (`MaPhieuKhamBenh`,`MaLoaiBenh`),
  ADD KEY `fk_phieukhambenh_benhnhan` (`MaBenhNhan`),
  ADD KEY `fk_phieukhambenh_loaibenh` (`MaLoaiBenh`);

--
-- Indexes for table `quidinh`
--
ALTER TABLE `quidinh`
  ADD PRIMARY KEY (`MaQuiDinh`);

--
-- Indexes for table `thuoc`
--
ALTER TABLE `thuoc`
  ADD PRIMARY KEY (`MaThuoc`),
  ADD KEY `fk_thuoc_donvi` (`MaDonVi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `benhnhan`
--
ALTER TABLE `benhnhan`
  MODIFY `MaBenhNhan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cachdung`
--
ALTER TABLE `cachdung`
  MODIFY `MaCachDung` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `donvi`
--
ALTER TABLE `donvi`
  MODIFY `MaDonVi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaibenh`
--
ALTER TABLE `loaibenh`
  MODIFY `MaLoaiBenh` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieukhambenh`
--
ALTER TABLE `phieukhambenh`
  MODIFY `MaPhieuKhamBenh` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quidinh`
--
ALTER TABLE `quidinh`
  MODIFY `MaQuiDinh` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `thuoc`
--
ALTER TABLE `thuoc`
  MODIFY `MaThuoc` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctphieukhambenh`
--
ALTER TABLE `ctphieukhambenh`
  ADD CONSTRAINT `fk_ctphieukhambenh_cachdung` FOREIGN KEY (`MaCachDung`) REFERENCES `cachdung` (`MaCachDung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ctphieukhambenh_phieukhambenh` FOREIGN KEY (`MaPhieuKhamBenh`) REFERENCES `phieukhambenh` (`MaPhieuKhamBenh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ctphieukhambenh_thuoc` FOREIGN KEY (`MaThuoc`) REFERENCES `thuoc` (`MaThuoc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_hoadon_phieukhambenh` FOREIGN KEY (`MaPhieuKhamBenh`) REFERENCES `phieukhambenh` (`MaPhieuKhamBenh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieukhambenh`
--
ALTER TABLE `phieukhambenh`
  ADD CONSTRAINT `fk_phieukhambenh_benhnhan` FOREIGN KEY (`MaBenhNhan`) REFERENCES `benhnhan` (`MaBenhNhan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_phieukhambenh_loaibenh` FOREIGN KEY (`MaLoaiBenh`) REFERENCES `loaibenh` (`MaLoaiBenh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `thuoc`
--
ALTER TABLE `thuoc`
  ADD CONSTRAINT `fk_thuoc_donvi` FOREIGN KEY (`MaDonVi`) REFERENCES `donvi` (`MaDonVi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
