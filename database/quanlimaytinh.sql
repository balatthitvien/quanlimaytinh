-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2025 at 04:52 PM
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
('Nguyen Tien Hung', 'hung', '$2a$12$DYWXqBfB9ka8Lc1IipIlCO/VI6K5VL3LVRfsmDsMypWcdLUHKFJA2', 'Quản lý kho', 1, '3latthitvien@gmail.com'),
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
('PN1', 'SP02', 10, 5000),
('PN2', 'SP08', 8, 40000),
('PN3', 'SP03', 10, 120000);

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
('PX10', 'SP09', 1, 96000),
('PX11', 'SP09', 1, 96000),
('PX12', 'SP09', 1, 96000),
('PX13', 'SP09', 1, 96000),
('PX14', 'SP09', 1, 120000),
('PX15', 'SP06', 10, 2800),
('PX16', 'SP09', 1, 96000),
('PX17', 'SP08', 1, 60000),
('PX18', 'SP09', 1, 120000),
('PX19', 'SP09', 1, 120000),
('PX2', 'SP03', 1, 150000),
('PX2', 'SP04', 1, 3000),
('PX20', 'SP09', 1, 120000),
('PX21', 'SP09', 1, 96000),
('PX22', 'SP09', 1, 96000),
('PX23', 'SP09', 1, 120000),
('PX24', 'SP09', 1, 120000),
('PX25', 'SP08', 1, 48000),
('PX25', 'SP09', 1, 120000),
('PX26', 'SP09', 1, 96000),
('PX27', 'SP09', 1, 96000),
('PX28', 'SP09', 1, 96000),
('PX29', 'SP08', 1, 45000),
('PX29', 'SP09', 1, 96000),
('PX3', 'SP05', 1, 70000),
('PX30', 'SP09', 1, 96000),
('PX31', 'SP05', 1, 56000),
('PX31', 'SP09', 1, 96000),
('PX32', 'SP09', 1, 120000),
('PX33', 'SP05', 1, 56000),
('PX33', 'SP09', 1, 90000),
('PX34', 'SP04', 2, 3000),
('PX35', 'SP04', 1, 3000),
('PX35', 'SP05', 1, 70000),
('PX35', 'SP08', 1, 60000),
('PX35', 'SP09', 1, 90000),
('PX36', 'SP09', 2, 120000),
('PX37', 'SP08', 2, 45000),
('PX37', 'SP09', 1, 120000),
('PX38', 'SP04', 1, 3000),
('PX38', 'SP05', 2, 56000),
('PX38', 'SP09', 1, 90000),
('PX39', 'SP09', 1, 120000),
('PX4', 'SP08', 1, 60000),
('PX4', 'SP10', 1, 900000),
('PX40', 'SP05', 2, 56000),
('PX40', 'SP08', 2, 45000),
('PX40', 'SP09', 1, 90000),
('PX41', 'SP04', 1, 3000),
('PX41', 'SP08', 1, 60000),
('PX41', 'SP09', 1, 90000),
('PX42', 'SP09', 1, 90000),
('PX43', 'SP04', 1, 3000),
('PX43', 'SP08', 1, 60000),
('PX43', 'SP09', 1, 120000),
('PX44', 'SP09', 1, 120000),
('PX45', 'SP12', 1, 12000),
('PX5', 'SP05', 1, 56000),
('PX6', 'SP05', 1, 70000),
('PX6', 'SP06', 1, 3500),
('PX7', 'SP09', 1, 96000),
('PX8', 'SP08', 1, 48000),
('PX9', 'SP09', 1, 120000);

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
('2/9', 'Thực phẩm', 20, '2025-07-02', '2025-07-03', 'heello', 0),
('30/4', 'Thực phẩm', 100, '2025-07-02', '2025-07-04', '....', 0),
('HappyValentine', 'Mỹ phẩm', 30, '2025-06-25', '2025-06-28', 'Chúc mừng cặp đôi', 0),
('HappyWomanDay', 'Mỹ phẩm', 20, '2025-06-25', '2025-07-17', 'Chúc mừng', 1),
('NhaGiaoVN', 'Văn phòng phẩm', 20, '2025-06-26', '2025-06-30', 'xin chao', 0),
('Sale7', 'Thực phẩm', 25, '2025-07-08', '2025-08-08', 'sale 1 month', 1);

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
('NC009', 'cá vịnh', '0904990959', 'Vinh'),
('NCC01', 'Cá tươi Hải Anh', '0904990958', 'Hà Nội'),
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
('PN1', '2025-06-25 00:08:12', 'admin', 'NC002', 50000),
('PN2', '2025-07-10 03:20:04', 'admin', 'NC002', 320000),
('PN3', '2025-07-11 04:33:10', 'anhsu', 'NC002', 1200000);

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
('PX10', '2025-07-01 17:44:43', 'admin', 96000),
('PX11', '2025-07-01 17:48:35', 'admin', 96000),
('PX12', '2025-07-01 17:51:16', 'admin', 96000),
('PX13', '2025-07-01 18:14:37', 'admin', 96000),
('PX14', '2025-07-01 18:18:46', 'admin', 120000),
('PX15', '2025-07-08 06:32:34', 'admin', 28000),
('PX16', '2025-07-08 06:49:04', 'admin', 96000),
('PX17', '2025-07-08 06:49:30', 'admin', 60000),
('PX18', '2025-07-08 06:49:39', 'admin', 120000),
('PX19', '2025-07-08 06:49:56', 'admin', 120000),
('PX2', '2025-06-25 01:35:29', 'bobo', 153000),
('PX20', '2025-07-08 06:55:06', 'admin', 120000),
('PX21', '2025-07-08 06:55:30', 'admin', 96000),
('PX22', '2025-07-08 07:07:21', 'admin', 96000),
('PX23', '2025-07-08 07:20:00', 'admin', 120000),
('PX24', '2025-07-08 07:41:07', 'admin', 120000),
('PX25', '2025-07-08 07:41:38', 'admin', 168000),
('PX26', '2025-07-08 07:48:22', 'admin', 96000),
('PX29', '2025-07-09 16:32:54', 'admin', 135000),
('PX3', '2025-06-25 01:35:51', 'bobo', 70000),
('PX30', '2025-07-09 16:46:18', 'admin', 120000),
('PX31', '2025-07-09 16:54:09', 'admin', 120000),
('PX32', '2025-07-09 03:06:47', 'admin', 120000),
('PX33', '2025-07-09 16:54:34', 'admin', 120000),
('PX34', '2025-07-10 15:10:30', 'admin', 6000),
('PX35', '2025-07-09 16:57:52', 'admin', 120000),
('PX36', '2025-07-09 16:58:27', 'admin', 120000),
('PX37', '2025-07-09 16:58:39', 'admin', 120000),
('PX38', '2025-07-09 16:58:45', 'admin', 120000),
('PX39', '2025-07-09 16:15:15', 'admin', 120000),
('PX4', '2025-06-25 01:38:13', 'bobo', 960000),
('PX40', '2025-07-09 16:58:53', 'admin', 120000),
('PX41', '2025-07-09 17:08:20', 'admin', 120000),
('PX42', '2025-07-09 17:08:59', 'admin', 90000),
('PX43', '2025-07-09 17:09:39', 'admin', 183000),
('PX44', '2025-07-09 17:10:04', 'admin', 120000),
('PX45', '2025-10-04 16:58:36', 'thienan', 12000),
('PX5', '2025-06-28 09:55:57', 'admin', 56000),
('PX6', '2025-06-30 16:10:16', 'bobo', 3500),
('PX7', '2025-07-01 17:26:10', 'admin', 96000),
('PX8', '2025-07-01 17:27:10', 'admin', 48000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `Masp` varchar(50) NOT NULL,
  `Tensp` varchar(100) DEFAULT NULL,
  `Anhpath` varchar(255) NOT NULL,
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

INSERT INTO `sanpham` (`Masp`, `Tensp`, `Anhpath`, `Donvitinh`, `Soluong`, `Gianhap`, `Giaban`, `Loaisp`, `Mancc`, `Ghichu`, `Trangthai`, `Ngaysanxuat`, `Hansudung`) VALUES
('SP01', 'Ca tuoi', '', 'con', 10, 70000, 100000, 'Thực phẩm', 'NC002', '', 0, '2025-06-17', '2025-06-24'),
('SP02', 'kẹo kéo', '', 'miếng', 20, 5000, 10000, 'Thực phẩm', 'NC002', '', 0, '2025-06-23', '2025-06-25'),
('SP03', 'bánh ly que quẻ', '', 'túi', 29, 120000, 150000, 'Thực phẩm', 'NC002', '', 1, '2025-06-11', '2025-06-27'),
('SP04', 'bút bi', '', 'chiếc', 93, 1000, 3000, 'Văn phòng phẩm', 'NCC01', '', 1, '2025-06-17', '2026-04-24'),
('SP05', 'Son dưỡng', '', 'Cái', 10, 50000, 70000, 'Mỹ phẩm', 'NCC04', '', 1, '2025-06-23', '2026-06-24'),
('SP06', 'Mì hảo hảo', '', 'Gói', 89, 2000, 3500, 'Thực phẩm', 'NCC07', '', 1, '2025-06-17', '2026-06-26'),
('SP07', 'Bột canh Hảo hảo', '', 'hộp', 20, 7000, 10000, 'Thực phẩm', 'NCC07', '', 1, '2025-06-17', '2026-06-25'),
('SP08', 'Bánh Bông Lan', '', 'Hộp', 16, 40000, 60000, 'Thực phẩm', 'NCC08', '', 1, '2025-06-17', '2026-06-26'),
('SP09', 'Mì tám tôm', '', 'Thùng', 356, 100000, 120000, 'Thực phẩm', 'NCC06', '', 1, '2025-06-17', '2026-06-02'),
('SP10', 'Ghế văn phòng công thái học', '', 'Chiếc', 39, 600000, 900000, 'Văn phòng phẩm', 'NCC05', '', 0, '2025-06-24', '2027-06-26'),
('SP11', 'bánh đa', '', 'túi', 20, 10000, 15000, 'Thực phẩm', 'NC002', '', 1, '2025-07-09', '2025-07-01'),
('SP12', 'Bút chì kim', 'C:\\Users\\ADMIn\\quanlimaytinh\\images\\SP12.jpeg', 'chiếc', 19, 8000, 12000, 'Văn phòng phẩm', 'NCC03', 'bút', 1, '2025-10-03', '2026-10-22');

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
