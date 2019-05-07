-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2019 at 09:27 AM
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
  `ID` int(11) NOT NULL,
  `MaBenhNhan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenBenhNhan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `NamSinh` int(11) NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benhnhan`
--

INSERT INTO `benhnhan` (`ID`, `MaBenhNhan`, `TenBenhNhan`, `GioiTinh`, `NamSinh`, `DiaChi`) VALUES
(6, 'BN1', 'xyz', 'Nam', 1994, 'adsgusagdua'),
(7, 'BN2', 'Huỳnh Mẫn Duy', 'Nam', 1993, 'adsgusagduadsadas'),
(8, 'BN3', 'Nguyễn Công Hậu ', 'Khác', 1995, 'Bùi Viện'),
(9, 'BN4', 'Lionel Messi', 'Nam', 1989, 'Catalunya'),
(10, 'BN5', 'Captain America', 'Nam', 1945, 'Boston'),
(11, 'BN6', 'aln', 'Nam', 1992, 'adsgusagdua');

-- --------------------------------------------------------

--
-- Table structure for table `cachdung`
--

CREATE TABLE `cachdung` (
  `ID` int(11) NOT NULL,
  `MaCachDung` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenCachDung` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cachdung`
--

INSERT INTO `cachdung` (`ID`, `MaCachDung`, `TenCachDung`) VALUES
(2, 'CD1', 'Sáng - Trưa'),
(3, 'CD2', 'Sáng - Tối'),
(4, 'CD3', 'Trưa - Tối'),
(5, 'CD4', 'Sáng - Trưa - Tối');

-- --------------------------------------------------------

--
-- Table structure for table `ctbenhnhan`
--

CREATE TABLE `ctbenhnhan` (
  `ID_BenhNhan` int(11) NOT NULL,
  `ID_PhieuKhamBenh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctloaibenh`
--

CREATE TABLE `ctloaibenh` (
  `ID_LoaiBenh` int(11) NOT NULL,
  `ID_PhieuKhamBenh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctthuoc`
--

CREATE TABLE `ctthuoc` (
  `ID_Thuoc` int(11) NOT NULL,
  `ID_PhieuKhamBenh` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donvi`
--

CREATE TABLE `donvi` (
  `ID` int(11) NOT NULL,
  `MaDonVi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenDonVi` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `donvi`
--

INSERT INTO `donvi` (`ID`, `MaDonVi`, `TenDonVi`) VALUES
(2, 'DV1', 'Chai'),
(3, 'DV2', 'Ống'),
(4, 'DV3', 'Viên');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `ID` int(11) NOT NULL,
  `MaHoaDon` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgayThanhToan` datetime NOT NULL,
  `TienKham` float NOT NULL,
  `TongTien` float NOT NULL,
  `ID_PhieuKhamBenh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaibenh`
--

CREATE TABLE `loaibenh` (
  `ID` int(11) NOT NULL,
  `MaLoaiBenh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenLoaiBenh` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `TrieuChung` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaibenh`
--

INSERT INTO `loaibenh` (`ID`, `MaLoaiBenh`, `TenLoaiBenh`, `TrieuChung`) VALUES
(1, 'LB1', 'Cảm', 'Nóng, Sổ Mũi'),
(2, 'LB2', 'Lao', 'Ngứa, Ho,Yếu trong nguời'),
(3, 'LB3', 'Tiêu Chảy', 'Hay đi phân lỏng,mất sức, khô môi');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ID` int(11) NOT NULL,
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
  `ID` int(11) NOT NULL,
  `MaPhieuKhamBenh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgayKham` datetime NOT NULL,
  `TongTienThuoc` float NOT NULL,
  `TinhTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quidinh`
--

CREATE TABLE `quidinh` (
  `ID` int(11) NOT NULL,
  `MaQuiDinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenQuiDinh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `GiaTri` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thuoc`
--

CREATE TABLE `thuoc` (
  `ID` int(11) NOT NULL,
  `MaThuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenThuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` float NOT NULL,
  `TinhTrang` int(11) NOT NULL,
  `ID_DonVi` int(11) NOT NULL,
  `ID_CachDung` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `benhnhan`
--
ALTER TABLE `benhnhan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cachdung`
--
ALTER TABLE `cachdung`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ctbenhnhan`
--
ALTER TABLE `ctbenhnhan`
  ADD PRIMARY KEY (`ID_BenhNhan`,`ID_PhieuKhamBenh`),
  ADD KEY `fk_ctphieubenhnhan_phieukhambenh` (`ID_PhieuKhamBenh`);

--
-- Indexes for table `ctloaibenh`
--
ALTER TABLE `ctloaibenh`
  ADD PRIMARY KEY (`ID_LoaiBenh`,`ID_PhieuKhamBenh`),
  ADD KEY `fk_ctloaibenh_phieukhambenh` (`ID_PhieuKhamBenh`);

--
-- Indexes for table `ctthuoc`
--
ALTER TABLE `ctthuoc`
  ADD PRIMARY KEY (`ID_Thuoc`,`ID_PhieuKhamBenh`),
  ADD KEY `fk_ctthuoc_phieukhambenh` (`ID_PhieuKhamBenh`);

--
-- Indexes for table `donvi`
--
ALTER TABLE `donvi`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_hoadon_phieukhambenh` (`ID_PhieuKhamBenh`);

--
-- Indexes for table `loaibenh`
--
ALTER TABLE `loaibenh`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `phieukhambenh`
--
ALTER TABLE `phieukhambenh`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `quidinh`
--
ALTER TABLE `quidinh`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `thuoc`
--
ALTER TABLE `thuoc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_thuoc_donvi` (`ID_DonVi`),
  ADD KEY `fk_thuoc_cachdung` (`ID_CachDung`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `benhnhan`
--
ALTER TABLE `benhnhan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `cachdung`
--
ALTER TABLE `cachdung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `donvi`
--
ALTER TABLE `donvi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaibenh`
--
ALTER TABLE `loaibenh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieukhambenh`
--
ALTER TABLE `phieukhambenh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `quidinh`
--
ALTER TABLE `quidinh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `thuoc`
--
ALTER TABLE `thuoc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctbenhnhan`
--
ALTER TABLE `ctbenhnhan`
  ADD CONSTRAINT `fk_ctbenhnhan_benhnhan` FOREIGN KEY (`ID_BenhNhan`) REFERENCES `benhnhan` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ctphieubenhnhan_phieukhambenh` FOREIGN KEY (`ID_PhieuKhamBenh`) REFERENCES `phieukhambenh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctloaibenh`
--
ALTER TABLE `ctloaibenh`
  ADD CONSTRAINT `fk_ctloaibenh_loaibenh` FOREIGN KEY (`ID_LoaiBenh`) REFERENCES `loaibenh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ctloaibenh_phieukhambenh` FOREIGN KEY (`ID_PhieuKhamBenh`) REFERENCES `phieukhambenh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctthuoc`
--
ALTER TABLE `ctthuoc`
  ADD CONSTRAINT `fk_ctthuoc_phieukhambenh` FOREIGN KEY (`ID_PhieuKhamBenh`) REFERENCES `phieukhambenh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ctthuoc_thuoc` FOREIGN KEY (`ID_Thuoc`) REFERENCES `thuoc` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_hoadon_phieukhambenh` FOREIGN KEY (`ID_PhieuKhamBenh`) REFERENCES `phieukhambenh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `thuoc`
--
ALTER TABLE `thuoc`
  ADD CONSTRAINT `fk_thuoc_cachdung` FOREIGN KEY (`ID_CachDung`) REFERENCES `cachdung` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_thuoc_donvi` FOREIGN KEY (`ID_DonVi`) REFERENCES `donvi` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
