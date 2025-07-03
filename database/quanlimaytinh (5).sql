-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2025 at 12:06 PM
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
-- Database: `quanlimaytinh`
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
('Admin', 'admin', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Admin', 1, 'sinhbaoreact2003@gmail.com'),
('anhsu', 'anhsu', '$2a$12$Rn.O85eDspOTe.W9F3Y.K.WRCtH7H.IkWTeBeHA4nXi/vHifYY7bW', 'Nhân viên nhập', 1, 'mrcauut007@gmail.com'),
('Hoàng Gia Bảo', 'bobo', '$2a$12$PhiTGBbHjHoB3dbS6BmCC.rzdMCBqDrdK9Y8Ae8GPcKe1RpHiWARO', 'Nhân viên xuất', 1, 'hgiabao2k3@gmail.com'),
('Nguyen Tien Hung', 'hung', '$2a$12$gO3vzBvL2bUBOU/sZtD/NuTs.jKCXYoTzITMfIhbY20RolBeAppce', 'Quản lý kho', 1, '3latthitvien@gmail.com'),
('Trần Nhật Sinh', 'sinhsinh1122', '$2a$12$89As1J0AB0yrqGjnQUHtpevc6voGyvzAd8OvzkS1vGDo3YPO2P.Ia', 'Nhân viên nhập', 1, 'transinh342@gmail.com'),
('Nguyễn Thiên Ân', 'thienan', '$2a$12$myOaq0kATMzNkbxgzQEkPu8ht2K0pXOGzZMZo6nSBowq6EyoLo7tS', 'Quản lý kho', 1, 'a11611112003@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `Maphieu` varchar(50) NOT NULL,
  `Masp` varchar(50) NOT NULL,
  `Soluong` int(11) DEFAULT NULL,
  `Gianhap` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`Maphieu`, `Masp`, `Soluong`, `Gianhap`) VALUES
('PN1', 'SP02', 10, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `Maphieu` varchar(50) NOT NULL,
  `Masp` varchar(50) NOT NULL,
  `Soluong` int(11) DEFAULT NULL,
  `Giaban` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`Maphieu`, `Masp`, `Soluong`, `Giaban`) VALUES
('PX2', 'SP03', 1, 150000),
('PX2', 'SP04', 1, 3000),
('PX3', 'SP05', 1, 70000),
('PX4', 'SP08', 1, 60000),
('PX4', 'SP10', 1, 900000),
('PX5', 'SP05', 1, 56000),
('PX6', 'SP05', 1, 49000),
('PX6', 'SP10', 1, 720000),
('PX7', 'SP10', 1, 720000),
('PX8', 'SP10', 1, 900000),
('PX9', 'SP03', 1, 105000),
('PX9', 'SP08', 1, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `giamgia`
--

CREATE TABLE `giamgia` (
  `Magiamgia` varchar(20) NOT NULL,
  `Loaisp` varchar(50) DEFAULT NULL,
  `Phantramgiam` int(11) DEFAULT NULL CHECK (`Phantramgiam` >= 0 and `Phantramgiam` <= 100),
  `Ngaybatdau` date DEFAULT NULL,
  `Ngayketthuc` date DEFAULT NULL,
  `Mota` text DEFAULT NULL,
  `Trangthai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giamgia`
--

INSERT INTO `giamgia` (`Magiamgia`, `Loaisp`, `Phantramgiam`, `Ngaybatdau`, `Ngayketthuc`, `Mota`, `Trangthai`) VALUES
('HappyValentine', 'Mỹ phẩm', 30, '2025-06-25', '2025-06-28', 'Chúc mừng cặp đôi', 1),
('HappyWomanDay', 'Mỹ phẩm', 20, '2025-06-25', '2025-07-17', 'Chúc mừng', 1),
('Monngonthang6', 'Thực phẩm', 30, '2025-07-02', '2025-07-12', '', 1),
('NhaGiaoVN', 'Văn phòng phẩm', 20, '2025-06-26', '2025-06-30', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Mancc` varchar(50) NOT NULL,
  `Tenncc` varchar(50) DEFAULT NULL,
  `Sdt` varchar(50) DEFAULT NULL,
  `Diachi` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`Mancc`, `Tenncc`, `Sdt`, `Diachi`) VALUES
('NC002', 'Đồ ăn vặt bà Tuyết', '0904990580', 'Hải Dương'),
('NCC01', 'Cá tươi Hải Anh', '0378325727', 'Hà Nội'),
('NCC03', 'Văn phòng phẩm Đức Anh', '0904927473', 'Hải Phòng'),
('NCC04', 'Son Channel', '0386263773', 'Hà Nội'),
('NCC05', 'Ghế Đức Anh', '0932832732', 'Hà Nội'),
('NCC06', 'Mì tám tôm', '0382786372', 'Nghệ An'),
('NCC07', 'Hảo Hảo', '0373826327', 'Hà Nội'),
('NCC08', 'Bánh kẹo Kingdom', '02732883733', 'Tp Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `Maphieu` varchar(50) NOT NULL,
  `Thoigiantao` timestamp NULL DEFAULT NULL,
  `Nguoitao` varchar(50) DEFAULT NULL,
  `Mancc` varchar(50) DEFAULT NULL,
  `Tongtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`Maphieu`, `Thoigiantao`, `Nguoitao`, `Mancc`, `Tongtien`) VALUES
('PN1', '2025-06-25 00:08:12', 'admin', 'NC002', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `Maphieu` varchar(50) NOT NULL,
  `Thoigiantao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Nguoitao` varchar(50) NOT NULL,
  `Tongtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`Maphieu`, `Thoigiantao`, `Nguoitao`, `Tongtien`) VALUES
('PX1', '2025-06-21 10:00:49', 'admin', 750000),
('PX2', '2025-06-25 01:35:29', 'bobo', 153000),
('PX3', '2025-06-25 01:35:51', 'bobo', 70000),
('PX4', '2025-06-25 01:38:13', 'bobo', 960000),
('PX5', '2025-06-28 09:55:57', 'admin', 56000),
('PX6', '2025-06-28 10:13:32', 'admin', 769000),
('PX7', '2025-07-01 15:55:18', 'admin', 720000),
('PX8', '2025-07-01 15:57:33', 'admin', 900000),
('PX9', '2025-07-03 10:05:58', 'admin', 165000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `Masp` varchar(50) NOT NULL,
  `Tensp` varchar(100) DEFAULT NULL,
  `Donvitinh` varchar(20) NOT NULL DEFAULT '0',
  `Soluong` int(50) NOT NULL DEFAULT 0,
  `Gianhap` double NOT NULL DEFAULT 0,
  `Giaban` double DEFAULT NULL,
  `Loaisp` varchar(50) NOT NULL DEFAULT '0',
  `Mancc` varchar(20) DEFAULT NULL,
  `Ghichu` varchar(50) DEFAULT NULL,
  `Trangthai` int(10) DEFAULT NULL,
  `Ngaysanxuat` date NOT NULL,
  `Hansudung` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`Masp`, `Tensp`, `Donvitinh`, `Soluong`, `Gianhap`, `Giaban`, `Loaisp`, `Mancc`, `Ghichu`, `Trangthai`, `Ngaysanxuat`, `Hansudung`) VALUES
('SP01', 'Ca tuoi', 'con', 10, 70000, 100000, 'Thực phẩm', 'NC002', '', 0, '2025-06-17', '2025-06-24'),
('SP02', 'kẹo kéo', 'miếng', 20, 5000, 10000, 'Thực phẩm', 'NC002', '', 0, '2025-06-23', '2025-06-25'),
('SP03', 'bánh ly que quẻ', 'túi', 18, 120000, 150000, 'Thực phẩm', 'NC002', '', 1, '2025-06-11', '2025-06-27'),
('SP04', 'bút bi', 'chiếc', 99, 1000, 3000, 'Văn phòng phẩm', 'NCC01', '', 1, '2025-06-17', '2026-04-24'),
('SP05', 'Son dưỡng', 'Cái', 17, 50000, 70000, 'Mỹ phẩm', 'NCC04', '', 1, '2025-06-23', '2026-06-24'),
('SP06', 'Mì hảo hảo', 'Gói', 100, 2000, 3500, 'Thực phẩm', 'NCC07', '', 1, '2025-06-17', '2026-06-26'),
('SP07', 'Bột canh Hảo hảo', 'hộp', 20, 7000, 10000, 'Thực phẩm', 'NCC07', '', 1, '2025-06-17', '2026-06-25'),
('SP08', 'Bánh Bông Lan', 'Hộp', 18, 40000, 60000, 'Thực phẩm', 'NCC08', '', 1, '2025-06-17', '2026-06-26'),
('SP09', 'Mì tám tôm', 'Thùng', 400, 100000, 120000, 'Thực phẩm', 'NCC06', '', 0, '2025-06-17', '2026-06-25'),
('SP10', 'Ghế văn phòng công thái học', 'Chiếc', 36, 600000, 900000, 'Văn phòng phẩm', 'NCC05', '', 0, '2025-06-24', '2027-06-26');

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
  ADD PRIMARY KEY (`Maphieu`,`Masp`),
  ADD KEY `FK_ChiTietPhieuNhap_MayTinh` (`Masp`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`Maphieu`,`Masp`),
  ADD KEY `FK_ChiTietPhieuXuat_MayTinh` (`Masp`);

--
-- Indexes for table `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`Magiamgia`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Mancc`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`Maphieu`),
  ADD KEY `FK_PhieuNhap_NhaCungCap` (`Mancc`),
  ADD KEY `FK_PhieuNhap_Account` (`Nguoitao`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`Maphieu`),
  ADD KEY `FK_PhieuXuat_Account` (`Nguoitao`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`Masp`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_MayTinh` FOREIGN KEY (`Masp`) REFERENCES `sanpham` (`Masp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_PhieuNhap` FOREIGN KEY (`Maphieu`) REFERENCES `phieunhap` (`Maphieu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_MayTinh` FOREIGN KEY (`Masp`) REFERENCES `sanpham` (`Masp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PhieuNhap_Account` FOREIGN KEY (`Nguoitao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PhieuNhap_NhaCungCap` FOREIGN KEY (`Mancc`) REFERENCES `nhacungcap` (`Mancc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PhieuXuat_Account` FOREIGN KEY (`Nguoitao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
