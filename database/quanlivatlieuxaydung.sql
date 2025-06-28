-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2023 at 04:05 AM
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
-- Database: `quanlivatlieuxaydung`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`fullName`, `userName`, `password`, `role`, `status`, `email`) VALUES
('Admin', 'admin', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Admin', 1, 'inet.nhannhan.v3@gmail.com'),
('Gia Huy', 'giahuy', '$2a$12$anUcQ4I2fISB5EQQ4HScSeESPPL3.ko6pEYJgoDxVbJ.s05jQ97FO', 'Nhân viên xuất', 1, 'inet.nhannhan.v3@gmail.com'),
('Haibui', 'haibui', '$2a$12$M1Z1psmahav3A4NH7HcDleLWqVDM/kgQqTFHCriFITQqnhgg9BLq.', 'Nhân viên nhập', 1, 'inet.nhannhan.v3@gmail.com'),
('Thành Nhân', 'thanhnhan', '$2a$12$ZTWUHCB.fA1HfbR0/2a4iucTXzs8YudcdZI9O0twqZLc6oraU2qvG', 'Quản lý kho', 1, 'inet.nhannhan.v3@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `maSP` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `maSP` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`maPhieu`, `maSP`, `soLuong`, `donGia`) VALUES
('PX28', 'CachAm1', 100, 30000),
('PX28', 'Gach2', 20, 80000),
('PX29', 'CachAm1', 1000, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNhaCungCap` varchar(50) NOT NULL,
  `tenNhaCungCap` varchar(50) DEFAULT NULL,
  `Sdt` varchar(50) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `Sdt`, `diaChi`) VALUES
('HOAPHAT', 'Công Ty Cổ Phần Thép Hòa Phát', '02835109735', '86/21 Phan Tây Hồ, P. 7, Q. Phú Nhuận TP. Hồ Chí Minh'),
('Viglacera', 'Tổng công ty Viglacera-CTCP', '02838115345', '622/16/5 Cộng Hòa, Phường 13, Quận Tân Bình, TP HCM'),
('Vicostone', 'Công Ty Cổ Phần Vicostone', '02873023456', '261 - 263 Khánh Hội, P2, Q4, TP. Hồ Chí Minh'),
('MagisStone', 'Magis Stone', '1900 1903', 'Số 129 - 131, phố Lê Thanh Nghị, Phường Đồng Tâm, Quận Hai Bà Trưng, Hà Nội');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NULL DEFAULT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `maNhaCungCap` varchar(50) DEFAULT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `maNhaCungCap`, `tongTien`) VALUES
('PN1', '2022-12-01 13:59:09', 'admin', 'HOAPHAT', 42980000),
('PN2', '2022-12-07 18:04:19', 'admin', 'HOAPHAT', 112440000),
('PN3', '2022-12-07 18:48:21', 'admin', 'MagisStone', 98300000),
('PN4', '2022-12-16 02:19:48', 'admin', 'Vicostone', 39880000);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nguoiTao` varchar(50) NOT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `tongTien`) VALUES
('PX1', '2022-12-01 14:10:44', 'admin', 291860000),
('PX10', '2022-12-07 18:41:08', 'admin', 57160000),
('PX12', '2022-12-07 19:06:56', 'admin', 45370000),
('PX13', '2022-12-08 12:31:48', 'admin', 109420000),
('PX14', '2022-12-08 16:30:10', 'admin', 78650000),
('PX15', '2022-12-12 22:31:09', 'admin', 86850000),
('PX16', '2022-12-14 15:04:47', 'admin', 136740000),
('PX17', '2022-12-14 15:34:07', 'admin', 51980000),
('PX18', '2022-12-15 20:32:57', 'admin', 151730000),
('PX19', '2022-12-16 02:20:15', 'Admin', 59360000),
('PX2', '2022-12-04 16:45:43', 'admin', 70660000),
('PX20', '2022-12-16 13:26:33', 'Admin', 79140000),
('PX21', '2022-12-16 13:36:43', 'Admin', 60850000),
('PX22', '2022-12-16 16:39:41', 'Admin', 35780000),
('PX23', '2022-12-16 17:18:54', 'Admin', 41460000),
('PX24', '2022-12-16 17:25:10', 'Admin', 63360000),
('PX25', '2022-12-16 18:51:31', 'Admin', 92550000),
('PX26', '2022-12-17 00:19:47', 'Admin', 94760000),
('PX27', '2023-11-30 15:29:51', 'Admin', 129950000),
('PX3', '2022-12-04 16:45:52', 'admin', 89350000),
('PX4', '2022-12-04 16:45:59', 'admin', 58170000),
('PX5', '2022-12-06 19:10:13', 'admin', 85250000),
('PX6', '2022-12-06 19:19:12', 'admin', 71460000),
('PX7', '2022-12-06 19:25:43', 'admin', 52370000),
('PX8', '2022-12-07 18:39:54', 'admin', 39880000),
('PX9', '2022-12-07 18:40:22', 'admin', 36680000),
('PX28', '2023-12-15 21:51:49', 'Admin', 4600000),
('PX29', '2023-12-16 02:18:24', 'Admin', 30000000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `maSP` varchar(50) NOT NULL,
  `tenSP` varchar(100) DEFAULT NULL,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `gia` double NOT NULL DEFAULT 0,
  `phanLoai` varchar(50) DEFAULT NULL,
  `xuatXu` varchar(50) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`maSP`, `tenSP`, `soLuong`, `gia`, `phanLoai`, `xuatXu`, `trangThai`) VALUES
('Gach1', 'Gạch ốp', 1000, 300000, 'Loại gạch', 'Trung Quốc', 1),
('Gach2', 'Gạch lót', 3000, 500000, 'Loại gạch', 'Đài Loan', 1),
('Gach3', 'Gạch nhỏ lát tường', 1200, 250000, 'Loại gạch', 'Việt Nam', 1),
('Ngoi1', 'Ngói đơn giản', 1000, 80000, 'Loại ngói', 'Đài Loan', 1),
('CachAm1', 'Xốp cách âm', 4000, 30000, 'Cách âm', 'Trung Quốc', 1),
('TrangTri1', 'Đèn trần', 500, 1200000, 'Trang trí', 'Nhật Bản', 1),
('NoiThat1', 'Sofa loại 1', 300, 3000000, 'Nội thất', 'Nhật Bản', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userName`) USING BTREE;

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maPhieu`,`maSP`),
  ADD KEY `FK_ChiTietPhieuNhap_MayTinh` (`maSP`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`maPhieu`,`maSP`),
  ADD KEY `FK_ChiTietPhieuXuat_MayTinh` (`maSP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
