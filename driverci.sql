-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2018 at 02:23 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `driverci`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver_detail`
--

CREATE TABLE `driver_detail` (
  `id_detail` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `fotoSim` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver_detail`
--

INSERT INTO `driver_detail` (`id_detail`, `id_driver`, `status`, `fotoSim`) VALUES
(1, 6, 'dipesan', 'icon.png'),
(2, 11, 'kosong', 'icon.png'),
(3, 12, 'dipesan', 'icon.png'),
(4, 21, 'dipesan', 'icon.png'),
(5, 3, 'dipesan', 'icon.png'),
(6, 48, 'dipesan', 'icon.png'),
(7, 49, 'kosong', 'icon.png'),
(8, 79, 'kosong', 'icon.png');

-- --------------------------------------------------------

--
-- Table structure for table `harga`
--

CREATE TABLE `harga` (
  `idHarga` int(11) NOT NULL,
  `harga` double NOT NULL,
  `wilayah` varchar(50) NOT NULL,
  `jam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`idHarga`, `harga`, `wilayah`, `jam`) VALUES
(1, 150000, 'Dalam Kota Jatim (Radius 35 Km)', 4),
(2, 250000, 'Dalam Kota Jatim (Radius 35 Km)', 6),
(3, 350000, 'Dalam Kota Jatim (Radius 35 Km)', 8),
(4, 450000, 'Dalam Kota Jatim (Radius 35 Km)', 10),
(5, 550000, 'Dalam Kota Jatim (Radius 35 Km)', 12),
(6, 700000, 'Luar Kota Jatim', 12),
(7, 1100000, 'Luar Kota Jatim', 48);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `id_rating` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `transaksi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`id_rating`, `rating`, `transaksi_id`) VALUES
(2, 5, 219),
(3, 5, 220),
(4, 4, 222),
(5, 3, 223),
(6, 3, 224),
(7, 4, 225),
(8, 3, 226),
(9, 3, 228),
(10, 3, 230),
(11, 3, 231),
(12, 3, 232),
(13, 3, 233),
(14, 4, 233),
(15, 3, 236),
(16, 4, 237),
(17, 4, 253),
(18, 3, 254),
(19, 3, 256),
(20, 3, 260),
(21, 3, 261),
(22, 3, 262),
(23, 5, 264),
(24, 4, 269),
(25, 4, 270),
(26, 4, 271),
(27, 5, 274),
(28, 4, 275),
(29, 5, 276),
(30, 4, 278),
(31, 4, 280),
(32, 5, 281),
(33, 3, 282),
(34, 5, 284),
(35, 4, 287),
(36, 3, 289),
(37, 5, 292),
(38, 5, 293);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `idReq` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `tujuan` varchar(500) NOT NULL,
  `lat` double NOT NULL,
  `longs` double NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`idReq`, `id_driver`, `id_user`, `tujuan`, `lat`, `longs`, `status`) VALUES
(1, 11, 4, 'Jatimulyo, Lowokwaru, Malang City, East Java, Indonesia', -7.947767, 112.616845, 'diterima'),
(2, 11, 4, 'Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.7974565, 110.370697, 'diterima'),
(3, 11, 4, 'South Jakarta City, Jakarta, Indonesia', -6.2689913, 106.8060388, 'ditolak'),
(4, 11, 4, 'Jatimulyo, Lowokwaru, Malang City, East Java, Indonesia', -7.947767, 112.616845, 'diterima'),
(5, 11, 4, 'Jl. Raya Uluwatu No.45, Jimbaran, Kuta Sel., Kabupaten Badung, Bali 80361, Indonesia', -8.799095, 115.16165300000002, 'diterima'),
(6, 11, 4, 'Yogyakarta, Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.795579799999998, 110.3694896, 'diterima'),
(7, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'diterima'),
(8, 11, 4, 'Perumnas Way Halim, Kedaton, Bandar Lampung City, Lampung, Indonesia', -5.377779299999999, 105.27653509999999, 'diterima'),
(9, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(10, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(11, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(12, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(13, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(14, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'ditolak'),
(15, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'ditolak'),
(16, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'ditolak'),
(17, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'ditolak'),
(18, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'ditolak'),
(19, 11, 4, 'Central Java, Indonesia', -7.150974999999999, 110.14025939999999, 'ditolak'),
(20, 11, 4, 'Lombok, West Nusa Tenggara, Indonesia', -8.650979, 116.3249438, 'diterima'),
(21, 11, 4, 'Lampung, Indonesia', -4.5585849, 105.40680789999999, 'diterima'),
(22, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(23, 11, 4, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', -7.328853599999999, 108.2192175, 'diterima'),
(24, 11, 4, 'Lembang, West Bandung Regency, West Java, Indonesia', -6.8145434, 107.6229532, 'diterima'),
(25, 11, 4, 'Malang, Malang City, East Java, Indonesia', -7.966620399999998, 112.63263210000001, 'diterima'),
(26, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(27, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(28, 11, 4, 'Medan, Medan City, North Sumatra, Indonesia', 3.5951956000000003, 98.6722227, 'diterima'),
(29, 11, 4, 'Kalibata, Pancoran, South Jakarta City, Jakarta, Indonesia', -6.264140599999999, 106.83701219999999, 'diterima'),
(30, 11, 4, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', -7.1440092, 112.61539529999999, 'diterima'),
(31, 11, 4, 'Central Jakarta City, Jakarta, Indonesia', -6.186467400000001, 106.8296372, 'diterima'),
(32, 11, 4, 'Jl. Jalur Sutera Boulevard No.Kav.45, Kunciran, Pinang, Kota Tangerang, Banten 15320, Indonesia', -6.2204109999999995, 106.663112, 'diterima'),
(33, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(34, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(35, 11, 4, 'Jl. Margonda Raya No.A / 37, Depok, Pancoran MAS, Kota Depok, Jawa Barat 16431, Indonesia', -6.3930409, 106.8230633, 'diterima'),
(36, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(37, 11, 4, 'Jalan Husein Sastranegara No.Kav. 1, Benda, Kota Tangerang, Banten 15125, Indonesia', -6.1137739, 106.6869876, 'diterima'),
(38, 11, 4, 'Jl. Palapa No.Z/3, Cilinaya, Cakranegara, Kota Mataram, Nusa Tenggara Bar. 83239, Indonesia', -8.587685700000002, 116.12094889999999, 'diterima'),
(39, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(40, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(41, 11, 4, 'Jl. Leuwi Panjang No.H-10, Situsaeur, Bojongloa Kidul, Kota Bandung, Jawa Barat 40233, Indonesia', -6.9433115, 107.5956453, 'diterima'),
(42, 11, 4, 'Banten, Indonesia', -6.405817199999999, 106.0640179, 'diterima'),
(43, 11, 4, 'Cirebon, Cirebon City, West Java, Indonesia', -6.7320229000000005, 108.5523164, 'diterima'),
(44, 11, 4, '75, Jl. Purnawirawan Raya No.V, Gn. Terang, Langkapura, Kota Bandar Lampung, Lampung 35152, Indonesia', -5.382398599999999, 105.23342, 'diterima'),
(45, 11, 4, 'Husen Sastranegara, Cicendo, Bandung City, West Java, Indonesia', -6.9011355, 107.5771444, 'diterima'),
(46, 11, 4, 'Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.7974565, 110.370697, 'diterima'),
(47, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(48, 11, 4, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', -7.1440092, 112.61539529999999, 'diterima'),
(49, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(50, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(51, 11, 4, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', -7.328853599999999, 108.2192175, 'diterima'),
(52, 11, 4, 'Badung Regency, Bali, Indonesia', -8.5819296, 115.1770586, 'diterima'),
(53, 11, 4, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.299508299999999, 106.7770054, 'diterima'),
(54, 11, 4, 'Halim Perdana Kusumah, Makasar, East Jakarta City, Jakarta, Indonesia', -6.246114200000001, 106.8864928, 'diterima'),
(55, 11, 4, 'Yogyakarta, Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.795579799999998, 110.3694896, 'diterima'),
(56, 11, 4, 'Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.946528900000002, 112.6155368, 'diterima'),
(57, 11, 4, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', -7.328853599999999, 108.2192175, 'diterima'),
(58, 11, 4, 'Jl. Cemara Raya, Cibodasari, Karawaci, Kota Tangerang, Banten 15116, Indonesia', -6.2074237, 106.6135517, 'diterima'),
(59, 11, 4, 'Belakang Hotel Imara, Dekat Universitas, Jl. Kapten Marzuki No.528 C, 20 Ilir D. III, Ilir Tim. I, Kota Palembang, Sumatera Selatan 30129, Indonesia', -2.9715487, 104.74937709999999, 'diterima'),
(60, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(61, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(62, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(63, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(64, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(65, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(66, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(67, 11, 4, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', -7.919654999999999, 112.59559019999999, 'diterima'),
(68, 11, 4, 'Semarang, Semarang City, Central Java, Indonesia', -7.005145300000001, 110.43812539999999, 'diterima'),
(69, 11, 4, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', -7.1440092, 112.61539529999999, 'diterima'),
(70, 11, 4, 'Pasuruan, East Java, Indonesia', -7.785996099999999, 112.858217, 'diterima'),
(71, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(72, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(73, 11, 4, 'Jl. Raya Narogong No.F86, Bantargebang, Kota Bks, Jawa Barat 17151, Indonesia', -6.3137183, 106.987535, 'diterima'),
(74, 11, 4, 'Riau, Indonesia', 0.29334689999999997, 101.70682939999999, 'diterima'),
(75, 11, 4, 'Jakarta, Indonesia', -6.180495, 106.8283415, 'diterima'),
(76, 11, 4, 'Jl. Pahlawan Seribu No.R5, Lengkong Karya, Serpong Utara, Kota Tangerang Selatan, Banten 15322, Indonesia', -6.275869500000001, 106.65950459999999, 'diterima'),
(77, 11, 4, 'Jl. Pahlawan Seribu No.R5, Lengkong Karya, Serpong Utara, Kota Tangerang Selatan, Banten 15322, Indonesia', -6.275869500000001, 106.65950459999999, 'diterima'),
(78, 11, 4, 'South Jakarta City, Jakarta, Indonesia', -6.2689913, 106.8060388, 'diterima'),
(79, 11, 4, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957331500000001, 112.61864519999999, 'diterima'),
(80, 11, 4, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957331500000001, 112.61864519999999, 'diterima'),
(81, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(82, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(83, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(84, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(85, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(86, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(87, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(88, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(89, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(90, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(91, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(92, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(93, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'ditolak'),
(94, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(95, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(96, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(97, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(98, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(99, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(100, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(101, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(102, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(103, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(104, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(105, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(106, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(107, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(108, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(109, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(110, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(111, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(112, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(113, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(114, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(115, 11, 4, 'Malang, Malang City, East Java, Indonesia', -7.966620399999998, 112.63263210000001, 'diterima'),
(116, 11, 4, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957132599999998, 112.61908400000002, 'diterima'),
(117, 11, 4, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', -7.976469099999998, 112.6344924, 'diterima'),
(118, 11, 4, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.929553500000001, 112.59690619999999, 'diterima'),
(119, 11, 4, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', -7.976469099999998, 112.6344924, 'diterima'),
(120, 11, 4, 'Malang Town Square, Jl. Veteran Malang, Penanggungan, Klojen, Kota Malang, Jawa Timur 65145, Indonesia', -7.9567936999999995, 112.6187475, 'diterima'),
(121, 11, 4, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957331500000001, 112.61864519999999, 'diterima'),
(122, 11, 4, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957132599999998, 112.61908400000002, 'diterima'),
(123, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(124, 11, 4, 'Malang, Malang City, East Java, Indonesia', -7.966620399999998, 112.63263210000001, 'diterima'),
(125, 11, 4, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957132599999998, 112.61908400000002, 'diterima'),
(126, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(127, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(128, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'ditolak'),
(129, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(130, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(131, 11, 4, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.979551999999998, 112.629515, 'diterima'),
(132, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(133, 11, 4, 'Jatimulyo, Lowokwaru, Malang City, East Java, Indonesia', -7.947767, 112.616845, 'diterima'),
(134, 11, 4, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', -7.976469099999998, 112.6344924, 'diterima'),
(135, 11, 4, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -7.942246, 112.610717, 'diterima'),
(136, 11, 4, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', -7.976469099999998, 112.6344924, 'diterima'),
(137, 11, 4, 'Jl. Besar Ijen No.84, Oro-oro Dowo, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.964338000000001, 112.62523069999999, 'diterima');

-- --------------------------------------------------------

--
-- Table structure for table `saldo`
--

CREATE TABLE `saldo` (
  `idSaldo` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `saldoEpay` double NOT NULL,
  `rekening` varchar(500) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saldo`
--

INSERT INTO `saldo` (`idSaldo`, `id_user`, `saldoEpay`, `rekening`, `status`) VALUES
(1, 6, 600000, '728278178212', 'sudah dikonfirmasi'),
(2, 11, 600000, '323232323232', 'sudah dikonfirmasi'),
(3, 4, 200000, '1273647367266', 'sudah dikonfirmasi'),
(4, 4, 100000, '1672622736', 'sudah dikonfirmasi'),
(5, 4, 600000, '787878999999', 'sudah dikonfirmasi'),
(6, 4, 100000, '647637763743', 'sudah dikonfirmasi'),
(7, 4, 200000, '98598495998', 'sudah dikonfirmasi'),
(8, 4, 100000, '76768667', 'sudah dikonfirmasi');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_driver` int(11) DEFAULT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime DEFAULT NULL,
  `totalHarga` double NOT NULL,
  `latJem` double NOT NULL,
  `longJem` double NOT NULL,
  `lokasi_jemput` varchar(5000) NOT NULL,
  `latTuj` double NOT NULL,
  `longTuj` double NOT NULL,
  `tujuan` varchar(5000) NOT NULL,
  `status` varchar(50) NOT NULL,
  `id_harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_driver`, `startTime`, `endTime`, `totalHarga`, `latJem`, `longJem`, `lokasi_jemput`, `latTuj`, `longTuj`, `tujuan`, `status`, `id_harga`) VALUES
(179, 4, 11, '2018-12-04 17:26:02', '2018-12-17 17:29:33', 5184140, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -5.377779299999999, 105.27653509999999, 'Perumnas Way Halim, Kedaton, Bandar Lampung City, Lampung, Indonesia', 'selesai', NULL),
(180, 4, 11, '2018-12-04 21:10:17', NULL, 12285, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(181, 4, 11, '2018-12-04 21:14:53', NULL, 12285, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(182, 4, 11, '2018-12-04 21:58:30', NULL, 1885005, -7.150974999999999, 110.14025939999999, 'Central Java, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(183, 4, 11, '2018-12-04 22:14:08', NULL, 4078305, -6.1137739, 106.6869876, 'Jalan Husein Sastranegara No.Kav. 1, Benda, Kota Tangerang, Banten 15125, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(184, 4, 11, '2018-12-04 23:26:20', NULL, 2721955, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -8.650979, 116.3249438, 'Lombok, West Nusa Tenggara, Indonesia', 'selesai', NULL),
(185, 4, 11, '2018-12-04 23:43:49', NULL, 4862755, 0.29334689999999997, 101.70682939999999, 'Riau, Indonesia', -4.5585849, 105.40680789999999, 'Lampung, Indonesia', 'selesai', NULL),
(186, 4, 11, '2018-12-04 23:49:45', NULL, 4404120, -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(187, 4, 11, '2018-12-05 00:08:44', NULL, 3155900, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.328853599999999, 108.2192175, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', 'selesai', NULL),
(188, 4, 11, '2018-12-05 00:18:19', NULL, 754035, -6.246114200000001, 106.8864928, 'Halim Perdana Kusumah, Makasar, East Jakarta City, Jakarta, Indonesia', -6.8145434, 107.6229532, 'Lembang, West Bandung Regency, West Java, Indonesia', 'selesai', NULL),
(189, 4, 11, '2018-12-05 02:29:37', NULL, 38145, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.966620399999998, 112.63263210000001, 'Malang, Malang City, East Java, Indonesia', 'selesai', NULL),
(190, 4, 11, '2018-12-05 02:34:26', NULL, 3963295, -6.2179295, 106.83040919999999, 'Jl. H. R. Rasuna Said No.X-7, RT.6/RW.7, Kuningan, Karet Kuningan, Kecamatan Setiabudi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12940, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(191, 4, 11, '2018-12-05 02:37:01', NULL, 4402290, -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(192, 4, 11, '2018-12-05 02:45:27', NULL, 2203185, 4.695135, 96.7493993, 'Aceh, Indonesia', 3.5951956000000003, 98.6722227, 'Medan, Medan City, North Sumatra, Indonesia', 'selesai', NULL),
(193, 4, 11, '2018-12-05 02:50:40', NULL, 58410, -6.180495, 106.8283415, 'Jakarta, Indonesia', -6.264140599999999, 106.83701219999999, 'Kalibata, Pancoran, South Jakarta City, Jakarta, Indonesia', 'selesai', NULL),
(194, 4, 11, '2018-12-05 06:39:20', NULL, 600675, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.1440092, 112.61539529999999, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', 'selesai', NULL),
(195, 4, 11, '2018-12-05 06:53:01', NULL, 98165, -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.186467400000001, 106.8296372, 'Central Jakarta City, Jakarta, Indonesia', 'selesai', NULL),
(196, 4, 11, '2018-12-05 06:56:43', NULL, 45945, -6.2074237, 106.6135517, 'Jl. Cemara Raya, Cibodasari, Karawaci, Kota Tangerang, Banten 15116, Indonesia', -6.2204109999999995, 106.663112, 'Jl. Jalur Sutera Boulevard No.Kav.45, Kunciran, Pinang, Kota Tangerang, Banten 15320, Indonesia', 'selesai', NULL),
(197, 4, 11, '2018-12-05 07:00:29', NULL, 4065880, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(198, 4, 11, '2018-12-05 07:17:49', NULL, 12285, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(199, 4, 11, '2018-12-05 07:25:07', NULL, 4082070, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.3930409, 106.8230633, 'Jl. Margonda Raya No.A / 37, Depok, Pancoran MAS, Kota Depok, Jawa Barat 16431, Indonesia', 'selesai', NULL),
(200, 4, 11, '2018-12-05 07:32:15', NULL, 2329430, -7.150974999999999, 110.14025939999999, 'Central Java, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(201, 4, 11, '2018-12-05 07:36:08', NULL, 146860, -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -6.1137739, 106.6869876, 'Jalan Husein Sastranegara No.Kav. 1, Benda, Kota Tangerang, Banten 15125, Indonesia', 'selesai', NULL),
(202, 4, 11, '2018-12-05 07:41:06', NULL, 2636755, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -8.587685700000002, 116.12094889999999, 'Jl. Palapa No.Z/3, Cilinaya, Cakranegara, Kota Mataram, Nusa Tenggara Bar. 83239, Indonesia', 'selesai', NULL),
(203, 4, 11, '2018-12-05 07:56:52', NULL, 29390, -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(204, 4, 11, '2018-12-05 08:06:17', NULL, 4402290, -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(205, 4, 11, '2018-12-05 08:14:35', NULL, 6593115, -8.587685700000002, 116.12094889999999, 'Jl. Palapa No.Z/3, Cilinaya, Cakranegara, Kota Mataram, Nusa Tenggara Bar. 83239, Indonesia', -6.9433115, 107.5956453, 'Jl. Leuwi Panjang No.H-10, Situsaeur, Bojongloa Kidul, Kota Bandung, Jawa Barat 40233, Indonesia', 'selesai', NULL),
(206, 4, 11, '2018-12-05 08:18:50', NULL, 4976285, -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -6.405817199999999, 106.0640179, 'Banten, Indonesia', 'selesai', NULL),
(207, 4, 11, '2018-12-05 08:23:13', NULL, 1256595, -7.150974999999999, 110.14025939999999, 'Central Java, Indonesia', -6.7320229000000005, 108.5523164, 'Cirebon, Cirebon City, West Java, Indonesia', 'selesai', NULL),
(208, 4, 11, '2018-12-05 08:29:18', NULL, 3475160, -7.150974999999999, 110.14025939999999, 'Central Java, Indonesia', -5.382398599999999, 105.23342, '75, Jl. Purnawirawan Raya No.V, Gn. Terang, Langkapura, Kota Bandar Lampung, Lampung 35152, Indonesia', 'selesai', NULL),
(209, 4, 11, '2018-12-05 09:13:36', NULL, 3999815, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.9011355, 107.5771444, 'Husen Sastranegara, Cicendo, Bandung City, West Java, Indonesia', 'selesai', NULL),
(210, 4, 11, '2018-12-05 09:21:29', NULL, 3998700, -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(211, 4, 11, '2018-12-05 09:23:14', NULL, 600675, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.1440092, 112.61539529999999, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', 'selesai', NULL),
(212, 4, 11, '2018-12-05 09:29:34', NULL, 41070, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL),
(213, 4, 11, '2018-12-05 09:32:28', NULL, 3968765, -6.186467400000001, 106.8296372, 'Central Jakarta City, Jakarta, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(214, 4, 11, '2018-12-05 12:11:37', NULL, 1478650, -7.7974565, 110.370697, 'Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.328853599999999, 108.2192175, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', 'selesai', NULL),
(215, 4, 11, '2018-12-05 17:24:34', NULL, 1955995, -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', -8.5819296, 115.1770586, 'Badung Regency, Bali, Indonesia', 'selesai', NULL),
(216, 4, 11, '2018-12-05 17:33:21', NULL, 4065880, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.299508299999999, 106.7770054, 'Jl. Lebak Bulus Raya No.Z-24, RT.4/RW.5, Lb. Bulus, Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12440, Indonesia', 'selesai', NULL),
(217, 4, 11, '2018-12-05 17:42:49', NULL, 2260215, -7.150974999999999, 110.14025939999999, 'Central Java, Indonesia', -6.246114200000001, 106.8864928, 'Halim Perdana Kusumah, Makasar, East Jakarta City, Jakarta, Indonesia', 'selesai', NULL),
(218, 4, 11, '2018-12-05 17:44:27', NULL, 1651535, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.795579799999998, 110.3694896, 'Yogyakarta, Yogyakarta City, Special Region of Yogyakarta, Indonesia', 'selesai', NULL),
(219, 4, 11, '2018-12-05 19:44:42', NULL, 16935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.946528900000002, 112.6155368, 'Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', 'selesai', NULL),
(220, 4, 11, '2018-12-05 19:50:41', NULL, 3155900, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.328853599999999, 108.2192175, 'Yudanagara, Cihideung, Tasikmalaya, West Java, Indonesia', 'selesai', NULL),
(221, 4, 11, '2018-12-05 19:55:54', NULL, 4172815, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.2074237, 106.6135517, 'Jl. Cemara Raya, Cibodasari, Karawaci, Kota Tangerang, Banten 15116, Indonesia', 'selesai', NULL),
(222, 4, 11, '2018-12-05 19:57:44', NULL, 6987980, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -2.9715487, 104.74937709999999, 'Belakang Hotel Imara, Dekat Universitas, Jl. Kapten Marzuki No.528 C, 20 Ilir D. III, Ilir Tim. I, Kota Palembang, Sumatera Selatan 30129, Indonesia', 'selesai', NULL),
(223, 4, 11, '2018-12-05 19:59:57', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(224, 4, 11, '2018-12-05 20:07:28', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(225, 4, 11, '2018-12-05 20:10:41', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(226, 4, 11, '2018-12-05 20:27:22', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(227, 4, 11, '2018-12-05 20:31:03', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(228, 4, 11, '2018-12-05 20:34:13', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(229, 4, 11, '2018-12-05 20:37:50', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(230, 4, 11, '2018-12-05 21:06:31', NULL, 8935, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.919654999999999, 112.59559019999999, 'Jl. Karyawiguna No.90, Babatan, Tegalgondo, Karangploso, Malang, Jawa Timur 65152, Indonesia', 'selesai', NULL),
(231, 4, 11, '2018-12-05 21:15:23', NULL, 655040, -7.7974565, 110.370697, 'Yogyakarta City, Special Region of Yogyakarta, Indonesia', -7.005145300000001, 110.43812539999999, 'Semarang, Semarang City, Central Java, Indonesia', 'selesai', NULL),
(232, 4, 11, '2018-12-05 21:44:16', NULL, 600675, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.1440092, 112.61539529999999, 'Yosowilangun, Manyar, Gresik Regency, East Java, Indonesia', 'selesai', NULL),
(233, 4, 11, '2018-12-05 21:46:58', NULL, 257820, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -7.785996099999999, 112.858217, 'Pasuruan, East Java, Indonesia', 'selesai', NULL),
(234, 4, 11, '2018-12-12 00:00:00', '2018-12-12 00:00:00', 12, 12, 12, 'ewew', 12, 12, 'jjjskjasa', 'selesai', NULL),
(235, 4, 11, '2018-12-06 09:47:00', '2018-12-06 09:47:00', 4167685, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.275869500000001, 106.65950459999999, 'Jl. Pahlawan Seribu No.R5, Lengkong Karya, Serpong Utara, Kota Tangerang Selatan, Banten 15322, Indonesia', 'selesai', NULL),
(236, 4, 11, '2018-12-06 09:56:06', NULL, 4041540, -7.92861, 112.5968883, 'Perum Puri 24C, Landungsari, Kota, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', -6.2689913, 106.8060388, 'South Jakarta City, Jakarta, Indonesia', 'selesai', NULL),
(237, 4, 11, '2018-12-10 09:13:35', NULL, 15750, -7.943869, 112.6144782, 'Jl. Simpang Remujung No.100, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.957331500000001, 112.61864519999999, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'selesai', NULL),
(238, 4, 11, '2018-12-11 18:54:50', NULL, 16320, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.957331500000001, 112.61864519999999, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'baru', NULL),
(239, 4, 11, '2018-12-11 18:57:22', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'baru', NULL),
(240, 4, 11, '2018-12-11 18:59:57', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'baru', NULL),
(241, 4, 11, '2018-12-11 19:04:20', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'baru', NULL),
(242, 4, 11, '2018-12-11 19:08:03', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(243, 4, 11, '2018-12-11 19:10:34', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(244, 4, 11, '2018-12-11 19:15:04', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(245, 4, 11, '2018-12-11 19:19:18', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(246, 4, 11, '2018-12-11 19:25:53', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(247, 4, 11, '2018-12-11 19:28:14', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(248, 4, 11, '2018-12-11 19:31:18', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(249, 4, 11, '2018-12-11 19:37:38', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(250, 4, 11, '2018-12-11 19:41:59', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(251, 4, 11, '2018-12-11 19:55:51', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(252, 4, 11, '2018-12-11 19:58:16', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(253, 4, 11, '2018-12-11 20:08:47', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(254, 4, 11, '2018-12-11 21:50:11', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(255, 4, 11, '2018-12-11 21:54:15', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(256, 4, 11, '2018-12-11 21:54:15', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(257, 4, 11, '2018-12-11 22:00:49', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(258, 4, 11, '2018-12-11 22:00:49', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(259, 4, 11, '2018-12-11 22:04:18', NULL, 31565, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'baru', NULL),
(260, 4, 11, '2018-12-11 22:07:43', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'selesai', NULL),
(261, 4, 11, '2018-12-11 22:13:16', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(262, 4, 11, '2018-12-11 22:16:15', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(263, 4, 11, '2018-12-11 22:20:27', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(264, 4, 11, '2018-12-11 22:23:07', NULL, 31565, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL),
(265, 4, 11, '2018-12-11 22:48:32', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'baru', NULL),
(266, 4, 11, '2018-12-11 22:54:02', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(267, 4, 11, '2018-12-11 22:57:23', NULL, 31565, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'baru', NULL),
(268, 4, 11, '2018-12-11 22:57:23', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(269, 4, 11, '2018-12-11 22:57:23', NULL, 31565, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL),
(270, 4, 11, '2018-12-11 23:06:34', NULL, 5120, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(271, 4, 11, '2018-12-11 23:11:21', NULL, 31565, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL),
(272, 4, 11, '2018-12-12 07:10:21', NULL, 28640, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.966620399999998, 112.63263210000001, 'Malang, Malang City, East Java, Indonesia', 'baru', NULL),
(273, 4, 11, '2018-12-12 07:12:34', NULL, 16955, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.957132599999998, 112.61908400000002, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'baru', NULL),
(274, 4, 11, '2018-12-12 07:12:34', NULL, 28040, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.976469099999998, 112.6344924, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', 'selesai', NULL),
(275, 4, 11, '2018-12-12 08:35:43', NULL, 15925, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.929553500000001, 112.59690619999999, 'Jl. Tirto Rahayu, Dusun Rambaan, Landungsari, Dau, Malang, Jawa Timur 65151, Indonesia', 'selesai', NULL),
(276, 4, 11, '2018-12-13 12:35:37', NULL, 28040, -7.94555, 112.6156217, 'Jl. Semanggi No.2, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.976469099999998, 112.6344924, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', 'selesai', NULL),
(277, 4, 11, '2018-12-13 14:14:45', NULL, 18040, -7.9465992, 112.6151948, 'Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.9567936999999995, 112.6187475, 'Malang Town Square, Jl. Veteran Malang, Penanggungan, Klojen, Kota Malang, Jawa Timur 65145, Indonesia', 'baru', NULL),
(278, 4, 11, '2018-12-17 16:21:38', NULL, 16615, -7.9465617, 112.6150803, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.957331500000001, 112.61864519999999, 'Malang Town Square, Jl. Veteran No.9C, Sumbersari, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'selesai', NULL),
(279, 4, 11, '2018-12-17 16:22:44', NULL, 17250, -7.9466491, 112.6150527, 'Jl. M.T. Haryono No.72, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.957132599999998, 112.61908400000002, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'baru', NULL),
(280, 4, 11, '2018-12-17 16:35:15', NULL, 5415, -7.9465614, 112.6151634, 'Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(281, 4, 11, '2018-12-17 16:45:41', NULL, 28935, -7.9465761, 112.61509, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.966620399999998, 112.63263210000001, 'Malang, Malang City, East Java, Indonesia', 'selesai', NULL),
(282, 4, 11, '2018-12-17 16:46:59', NULL, 17250, -7.9465924, 112.6150505, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.957132599999998, 112.61908400000002, 'Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', 'selesai', NULL),
(283, 4, 11, '2018-12-17 16:51:29', NULL, 5415, -7.9465928, 112.6150615, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(284, 4, 11, '2018-12-17 16:51:29', '2018-12-17 16:56:16', 5415, -7.9465928, 112.6150615, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(285, 4, 11, '2018-12-17 17:18:52', NULL, 5415, -7.9465173, 112.615084, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(286, 4, 11, '2018-12-17 17:21:35', NULL, 5415, -7.9465727, 112.6150604, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(287, 4, 11, '2018-12-17 17:29:10', '2018-12-17 17:29:33', 31860, -7.9465938, 112.6150658, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.979551999999998, 112.629515, 'Jl. Jenderal Basuki Rahmat No.V/17, Kauman, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL),
(288, 4, 11, '2018-12-17 17:30:29', '2018-12-17 17:30:46', 5415, -7.9465869, 112.6150528, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'selesai', NULL),
(289, 4, 11, '2018-12-17 17:32:31', '2018-12-17 17:33:02', 8890, -7.9464186, 112.6151037, 'Jl. Soekarno Hatta No.09, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141, Indonesia', -7.947767, 112.616845, 'Jatimulyo, Lowokwaru, Malang City, East Java, Indonesia', 'selesai', NULL),
(290, 4, 11, '2018-12-17 17:45:20', '2018-12-17 17:48:57', 28335, -7.9465913, 112.6150883, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.976469099999998, 112.6344924, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', 'selesai', NULL),
(291, 4, 11, '2018-12-17 17:48:35', NULL, 5415, -7.9466026, 112.6150954, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.942246, 112.610717, 'Jl. M.T. Haryono No.XI/368, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144, Indonesia', 'baru', NULL),
(292, 4, 11, '2018-12-17 17:50:06', '2018-12-17 17:50:37', 28335, -7.9466244, 112.6150825, 'Jl. M.T. Haryono No.72, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145, Indonesia', -7.976469099999998, 112.6344924, 'sman 4, Klojen, Kota Malang, Jawa Timur 65111, Indonesia', 'selesai', NULL),
(293, 4, 11, '2018-12-18 14:41:22', '2018-12-18 14:53:06', 18045, -7.9465735, 112.6151209, 'Jl. Soekarno Hatta No: 9, Jatimulyo, Lowokwaru, Malang City, East Java 65141, Indonesia', -7.964338000000001, 112.62523069999999, 'Jl. Besar Ijen No.84, Oro-oro Dowo, Klojen, Kota Malang, Jawa Timur 65119, Indonesia', 'selesai', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nik` varchar(25) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `noHp` varchar(15) NOT NULL,
  `level` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `foto` varchar(255) NOT NULL,
  `totalSaldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nik`, `nama`, `noHp`, `level`, `email`, `username`, `password`, `foto`, `totalSaldo`) VALUES
(1, '12212121', 'rmillenia', 'i9113u31221332', 'customer', 'wweewewe', 'ewewew', 'ewewe', '', 0),
(3, '12345678', 'sasasasa', '3456756789', 'admin', 'sasa@gmail.com', 'sasa', 'f45731e3d39a1b2330bbf93e9b3de59e', 'icon.png', 0),
(4, '12345678', 'lala la', '98765345678', 'customer', 'rmillenia96@yahoo.com', 'lala', '2e3817293fc275dbee74bd71ce6eb056', 'icon.png', 491755),
(5, '6767677', 'yasmini', '0987587998980', 'customer', 'yasmini@1234', 'yasmini', '0bad1b8571cd7ad70fb02939a1f9b6fb', 'icon.png', 0),
(6, '7654321234', 'meli', '9876542345', 'driver', 'meli@123.com', 'meli', '315fef7b8d30f99d6964f489ee4c9828', 'icon.png\r\n', 0),
(7, '6767677', '3424142415', '4567890', 'customer', 'rmillenia96@yahoo.com', 'yayaya', 'a1d123a63936abbee87823e2f1affa9b', 'icon.png', 0),
(9, '111', '3424142415', '4567890', 'admin', 'rmillenia96@yahoo.com', 'yayaya', 'b59c67bf196a4758191e42f76670ceba', '', 0),
(10, '0989212', 'yaaaazzzzzz', '1222', 'admin', '1WAd@asdas', 'yazzz', 'ecb5c1f6d44162db1631c41459c9b592', '', 0),
(11, '23456789', 'farinda', '098765789654', 'driver', 'enjokeek@gmail.com', 'farinda', 'cdb5a4b49663335ecc449f9608023641', '', 2126415),
(12, '34567969', 'Malak', '907398286278637', 'driver', 'mlkdiana1@gmail.com', 'malak', '72ea813a17bcff1b9f07b286c5ff7de4', '', 0),
(13, '61t28', 'salsa', '0987273672', 'customer', '1@adsm', 'salsa', '13e8592797e78b06eb987a10e5ca5db1', '', 0),
(15, '162672676', 'wildan', '76236848', 'admin', 'hdishd@gmail.com', 'sasas', 'dce8c1f63dfc752c7502e823763179a9', '', 0),
(16, '15424243', 'medik', '36235757', 'customer', 'medik@gmail.com', 'medik', 'f45731e3d39a1b2330bbf93e9b3de59e', '', 0),
(17, '42552656', 'rudi', '747847778', 'admin', 'gshdjshdj@gmail.com', 'rudi', 'f45731e3d39a1b2330bbf93e9b3de59e', '', 0),
(18, '513652', 'refly', '7467344676', 'admin', 'refly@gmail.com', 'refly', '826a0b5a71b3c82d29804d657f56ae8c', '', 0),
(19, '14525673', 'hadi', '53767376', 'admin', 'hadi@gmail', 'hadiah', 'b350d900b2768a426755eeb78a8a05f5', '', 0),
(20, '098765456789', 'cuk', '889577869869', 'customer', 'cuk@gmail.com', 'jancuk', '42059b2e8bd844a3f8de2beb91a14993', '', 0),
(21, '98645788768', 'cucuk', '907398286278637', 'driver', 'rmillenia96@gmail.com', 'cucu', '487427b0c082fbada24b1afd1880136b', '', 0),
(22, '8765432134', 'Putra', '081279576113', 'customer', 'rmillenia96@yahoo.com', 'putra', '5e0c5a0bf82decdd43b2150b622c66c5', '', 0),
(23, '35757547', 'fairuz', '6372648486', 'admin', 'jbdfjsdfj@gmail', 'fairuz', '408e631e9f27e96802d349725a0e979d', '', 0),
(24, '64876484', 'yuhuhuhuhuhuh', '4567890987654', 'admin', 'lala@tuhu.com', 'hansip', 'd05ba879bccd0b902593d11228102491', '', 0),
(25, '6156252', 'fairz', '763456789', 'customer', 'fairz@yuhu.com', 'fairz', '35a9b7b89359e9bff4fc7480afab49c6', '', 0),
(26, '676767655', 'Yusuf', '081293039774', 'customer', 'nia.meli@rocketmail.com', 'yusuf', 'dd2eb170076a5dec97cdbbbbff9a4405', 'icon.png', 0),
(27, '6767677332', 'Cila', '889577869869', 'admin', 'cila@123', 'cila', '2e318f4b5f5029835a08ad123c5f58b2', '', 0),
(28, '6767677332', 'Cila', '889577869869', 'admin', 'cila@123', 'cila', '2e318f4b5f5029835a08ad123c5f58b2', '', 0),
(29, '9834884121', 'Susi', '081222334341', 'admin', 'susi@123', 'susi', '536931d80decb18c33db9612bdd004d4', '', 0),
(34, '98645678', 'yahya', '45678909876', 'driver', 'Malak@123', 'yahya', '59202463fd4c312b063293b88f6063b2', '', 0),
(35, '98645678', 'yahya', '45678909876', 'driver', 'Malak@123', 'yahya', 'c50303bee26c312d8d284b7abf372645', '', 0),
(38, '3456789', 'lala', '45678909876', 'admin', 'Malak@123', 'lahya', 'bc17f95dbaa364c36f44be86c3b7339a', '', 0),
(39, '6777689900', 'Malak', '4567890987654', 'driver', 'mlkdiana1@gmail.com', 'mama', 'eeafbf4d9b3957b139da7b7f2e7f2d4a', '', 0),
(48, '6767677', 'Putra Prima Arhandi', '78798789', 'driver', 'mlkdiana1@gmail.com', 'put', '07f396710909d00f32a5474fa420929d', '', 0),
(49, '9797987979', 'hiyat', '345678909876', 'driver', 'mlkdiana1@gmail.com', 'hiyat', '590b9fc1c80804e4345e3fd8615cf76c', '', 0),
(50, '787878787', 'Masyaallah', '4567890987654', 'admin', 'Malak@123', 'masya', 'b1b9aa88397d417b9a3991969165de70', '', 0),
(52, '7871871212', 'suprat', '8728972729272', 'driver', 'nia.meli@rocketmail.com', 'suprat', '6be1bf650ce0e69df300458c3807b9b1', '', 0),
(53, '898590522', 'palala', '83982910312', 'driver', 'rmillenia96@yahoo.com', 'palala', '688908125292d71e5c947a77e82311e8', '', 0),
(54, '67776899023232323', 'Suicide', '', 'driver', '', 'suicide', '70a5d255a4109da344424e6bc9bb40c0', '', 0),
(55, '898989898', 'yha', '456789987569', 'driver', 'yha@email.com', 'yha', '', '', 0),
(79, '2345678900', 'yah', '34097676868768', 'driver', 'yah@email.com', 'yah', 'yah', '', 0),
(80, '787878', 'huhu', '5656565', 'customer', 'huhu', 'huhu', 'huhu', '', 0),
(81, '125712521', 'yasmintul', '0819282928', 'customer', 'yasmintul@123', 'mintul', 'mintul', '', 0),
(82, '131313313', 'susanti', '0878778777878', 'customer', 'susan', 'susan', 'susan', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `driver_detail`
--
ALTER TABLE `driver_detail`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `fk_driverid` (`id_driver`);

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`idHarga`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_rating`),
  ADD KEY `fk_rate` (`transaksi_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`idReq`),
  ADD KEY `fk_driveruser` (`id_driver`),
  ADD KEY `fk_useruser` (`id_user`);

--
-- Indexes for table `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`idSaldo`),
  ADD KEY `fk_iduserEpay` (`id_user`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_drivertransaksi` (`id_driver`),
  ADD KEY `fk_usertransaksi` (`id_user`),
  ADD KEY `fk_hargaharga` (`id_harga`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `driver_detail`
--
ALTER TABLE `driver_detail`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `harga`
--
ALTER TABLE `harga`
  MODIFY `idHarga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `id_rating` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `idReq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT for table `saldo`
--
ALTER TABLE `saldo`
  MODIFY `idSaldo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=294;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `driver_detail`
--
ALTER TABLE `driver_detail`
  ADD CONSTRAINT `fk_driverid` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `fk_rate` FOREIGN KEY (`transaksi_id`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `fk_driveruser` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `fk_useruser` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `saldo`
--
ALTER TABLE `saldo`
  ADD CONSTRAINT `fk_iduserEpay` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_drivertransaksi` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_hargaharga` FOREIGN KEY (`id_harga`) REFERENCES `harga` (`idHarga`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usertransaksi` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
