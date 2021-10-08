-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2021 at 04:19 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_arpm`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` int(11) NOT NULL,
  `username_admin` varchar(20) DEFAULT NULL,
  `nama_admin` varchar(20) DEFAULT NULL,
  `password_admin` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `username_admin`, `nama_admin`, `password_admin`) VALUES
(1, 'nando', 'nando', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_allbrand`
--

CREATE TABLE `tbl_allbrand` (
  `id_mobilall` int(11) NOT NULL,
  `link_img_all` varchar(255) DEFAULT NULL,
  `nama_mobil` varchar(30) DEFAULT NULL,
  `varian_mobil` varchar(25) DEFAULT NULL,
  `tipebody_mobil_all` varchar(25) DEFAULT NULL,
  `bb_mobil` varchar(20) DEFAULT NULL,
  `transmisi_mobil` varchar(20) DEFAULT NULL,
  `harga_mobil` int(25) DEFAULT NULL,
  `data_topsis` varchar(50) DEFAULT NULL,
  `desc_mobil_all` text DEFAULT NULL,
  `alamat_dealer_mobil_all` text DEFAULT NULL,
  `no_tlp_mobil_all` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_allbrand`
--

INSERT INTO `tbl_allbrand` (`id_mobilall`, `link_img_all`, `nama_mobil`, `varian_mobil`, `tipebody_mobil_all`, `bb_mobil`, `transmisi_mobil`, `harga_mobil`, `data_topsis`, `desc_mobil_all`, `alamat_dealer_mobil_all`, `no_tlp_mobil_all`) VALUES
(1, 'https://imgcdn.oto.com/large/gallery/exterior/14/1995/honda-brio-front-angle-low-view-746781.jpg', 'Honda Brio', 'Satya S', 'Hatchback', 'Bensin', 'Manual', 151400000, '0,134155694', 'Di tengah kompetisi berat antar sesama LCGC, Satya mampu menunjukkan berbagai keunggulan. Mulai dari mesin terbesar (1,2-liter 4-silinder), performa terbaik, impresi berkendara paling menyenangkan dan tak kalah irit dari para pesaingnya bermesin 3-silinder. Namun sayang, tidak ada opsi transmisi otomatis untuk Satya saat itu.  Perubahan penting pun dilakukan Honda untuk seluruh varian Honda Brio, tepatnya di Indonesia International Motor Show (IIMS) 2016. Penyegaran bagian wajah diikuti penggantian desain dasbor sama seperti milik Mobilio. Paling signifikan, penggunaan CVT sebagai pilihan menggantikan transmisi otomatis konvensional. Tidak ada lagi varian Brio bermesin 1,3-liter, sehingga konsumen harus menerima pilihan satu mesin 1,2-liter saja. Untuk Brio non-LCGC, namanya berubah menjadi Brio RS dengan tampilan lebih sporty.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15411', '08981152982'),
(2, 'https://imgcdn.oto.com/large/gallery/exterior/7/1731/daihatsu-ayla-front-angle-low-view-169248.jpg', 'Daihatsu Ayla', '1.0L D MT', 'Hatchback', 'Bensin', 'Manual', 102150000, '0,147667844', 'Daihatsu Ayla kembali bersolek agar tak termakan umur. Tak tanggung ada 7 varian yang akan memberi keleluasaan bagi konsumen untuk memilih sesuai kebutuhan. Dari varian sebanyak itu, terbagi lagi menjadi dua tipe mesin yakni 1,0-liter dan 1,2-liter.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(3, 'https://imgcdn.oto.com/large/gallery/exterior/38/1732/toyota-agya-front-angle-low-view-925597.jpg', 'Toyota Agya', '1.0L G M/T', 'Hatchback', 'Bensin', 'Manual', 143800000, '0,147667844', 'Akhirnya, setelah beredar di dunia maya lewat rangkaian bocoran, New Toyota Agya versi terbaru resmi diluncurkan pada tahun 2020. Untuk facelift edisi kedua sejak pertama kali diluncurkan, Agya hadir mengusung tagline “Start to Never Stop”, dengan penampilan lebih sporty dan fitur lebih lengkap.\r\n\r\nMenyusul pembaruan dan penyegaran ini, New Agya mengalami perubahan harga dari versi sebelumnya. Untuk edisi facelift 2020, TAM menawarkan New Agya dengan rentang harga dari Rp 143,8 juta sampai dengan Rp 169,290 juta, dalam kondisi OTR DKI Jakarta.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15310\r\n', '08981152982'),
(4, 'https://imgcdn.oto.com/large/gallery/exterior/14/98/honda-mobilio-front-angle-low-view-835646.jpg\r\n', 'Honda Mobilio 1.5 E', 'CVT', 'MPV', 'Bensin', 'Manual', 235800000, '0,117386232', 'Salah satu dari lini produk tersebut adalah Honda Mobilio, yang hadir dalam bentuk MPV mini tujuh kursi dan pertama kali diproduksi Honda, pada tahun 2001.\r\n\r\nMobil ini kembali dimunculkan pada tahun 2013, atas prakarsa Honda Prospect Motor dan Honda Thailand, dengan perubahan yang signifikan menggunakan platform Honda Brio. Varian yang lebih sporty, dinamakan dengan Honda Mobilio RS kemudian dirilis pada tahun 2014 oleh Honda Prospect Motor (HPM).\r\n\r\nPerubahan model MPV ini terbilang cepat. Awal tahun 2016, HPM merilis perubahan wajah dan interior. Saat itu, perubahan di bagian eksterior terbilang minim, namun penyematan pengendali AC digital di kabin memberikan nilai lebih, dan membuatnya terlihat canggih.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15412\r\n', '08981152982'),
(5, 'https://imgcdn.oto.com/large/gallery/exterior/14/1970/honda-hr-v-front-angle-low-view-470426.jpg\r\n', 'Honda HR-V 1.5L E', 'CVT', 'SUV', 'Bensin', 'Otomatis', 331200000, '0,067077847', 'Honda HR-V kembali menjadi kekuatan Honda Prospect Indonesia (HPM), pemegang merek mobil Honda di Indonesia, di segmen Low SUV dan crossover. Kelas yang sedang naik daun beberapa tahun belakangan, menggantikan redupnya compact hatchback dan small sedan. Desain keren, fitur lengkap merupakan suatu kewajiban agar mampu memikat pasar. Itulah yang dimiliki HR-V, sehingga penjualannya laris manis.\r\n\r\nSiklus hidup Honda HR-V berlanjut ke fase penyegaran setelah memasuki tahun keempat. Waktu yang tergolong pas untuk pembenahan agar tetap kuat di pasaran. HPM mengambil momen tepat saat pameran Gaikindo Indonesia International Auto Show (GIIAS) 2018 berlangsung.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15413\r\n', '08981152982'),
(6, 'https://imgcdn.oto.com/large/gallery/exterior/14/891/honda-br-v-front-angle-low-view-355616.jpg\r\n', 'Honda BR-V S ', '6MT', 'SUV', 'Bensin', 'Manual', 248900000, '0,100616771', 'Honda BR-V adalah jawaban Honda terhadap kebutuhan mobil dengan ground clearance tinggi, memiliki kapasitas tujuh tempat duduk, dan harganya terjangkau. Yang menarik, Honda selalu menjadi yang terakhir memasuki pasar, setelah sebelumnya seolah mengamati apa yang dilakukan oleh para kompetitor di kelas yang diincarnya.\r\n\r\nTidak percaya? Coba lihat kapan Honda Mobilio masuk dan menggempur pasar low MPV? Saat konsumen di kelas ini sudah mulai jenuh dengan pilihan yang ada, hadir Mobilio dan langsung menggairahkan kembali pasar tersebut. Hal yang sama berlaku untuk BR-V, yang diarahkan untuk masuk di pasar low SUV/crossover.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15414\r\n', '08981152982'),
(7, 'https://imgcdn.oto.com/large/gallery/exterior/14/1734/honda-cr-v-front-angle-low-view-378288.jpg\r\n', 'Honda CR-V 2.0L', 'i-VTEC', 'SUV', 'Bensin', 'Manual', 489000000, '0,083847309', 'Honda CR-V saat ini masuk dalam generasi ke-5. Lahir pada 2017 lalu, dengan segenap perubahan. Tampangnya disesuaikan dengan zaman maupun bahasa desain paling modern Honda. Fitur canggih nan segar tak lupa disematkan. Ubahan paling signifikan dibanding generasi sebelum, sektor jantung pacu dan performa. Honda CR-V facelift pada 2021 masih ditawarkan dalam tiga varian. Namun kini hanya ada empat warna: White Orchid Pearl, Lunar Silver Metallic, Modern Steel Metallic dan Crystal Black Pearl. Untuk harga Honda CR-V 2021, Rp 489 juta varian 2.0L i-VTEC, CR-V 1.5L Turbo Rp 522,5 juta dan Honda CR-V 1.5L Turbo Prestige Rp 577 juta.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15415\r\n', '08981152982'),
(8, 'https://imgcdn.oto.com/large/gallery/exterior/14/2365/honda-city-hatchback-front-angle-low-view-183553.jpg', 'Honda City Hatchback', 'RS MT', 'Hatchback', 'Bensin', 'Manual', 289000000, '0,109001502', 'Honda CIty Hatchback diluncurkan di Indonesia Maret 2021. Ia akan bertugas mengawal segmen Hatchback di portfolio Honda bagi konsumen Tanah Air. Statusnya adalah produksi lokal di pabrik Honda Prospect Motor di Karawang, Jawa Barat.\r\n\r\nModel hatchback ini hanya tersedia dalam satu varian pada sesi peluncuran perdananya. Versi termewah dan paling agresif, RS ditawarkan di Indonesia. Sayang, saat informasi ini dirilis, harganya belum dipublikasi. Honda City Hatchback RS tersedia dalam 6 pilihan warna, di antaranya Phoenix Orange Pearl, Rallye Red, Crystal Black Pearl, Lunar Silver Metallic, Platinum White Pearl, dan varian warna terbaru adalah Meteoroid Gray Metallic.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15416\r\n', '08981152982'),
(9, 'https://imgcdn.oto.com/large/gallery/exterior/7/69/daihatsu-gran-max-pu-front-angle-low-view-240822.jpg', 'Daihatsu Grandmax PU 1.3 ', '3W FH', 'Pickup', 'Bensin', 'Manual', 141400000, '0,125770963', 'Dalam rangka memenuhi kebutuhan dan utilitas, merek tersebut hadir dalam tiga level trim – Pick up, Blind van, dan Box, yang masing-masing ditawarkan varian bensin 1.3 liter dan 1.5 liter. Dengan mesin 1.3 liter, pikap tersebut mengeluarkan daya maksimum sebesar 88 Ps pada 6000 rpm dan torsi puncak sebesar 114 Nm pada 4400 rpm. Di sisi lain, mesin 1.5 liter menyemburkan tenaga 97 ps pada 6000 rpm, dengan torsi maksimum yang dihasilkan sebesar 133 Nm pada 4400 rpm. Teknologi injeksi yang irit bahan bakar dan VVT-i yang disematkan dalam mesin memungkinkan mobil ini untuk menempuh 13,33 km/L.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982'),
(10, 'https://imgcdn.oto.com/large/gallery/exterior/7/1669/daihatsu-terios-front-angle-low-view-593424.jpg', 'Daihatsu Terios X', 'MT', 'SUV ', 'Bensin', 'Manual', 221800000, '0,100616771', 'All New Terios mengalami perubahan total tidak hanya dari sisi desain, tapi juga fitur yang ditawarkan. Tak lain bertujuan untuk merebut kembali pangsa pasar Low SUV yang beberapa tahun belakangan direnggut Honda BR-V. Apalagi eksistensi semakin terancam setelah kedatangan Mitsubishi Xpander yang ber-DNA SUV walau sebenarnya Low MPV. Tentu pekerjaan yang tak mudah bagi Daihatsu. Meski terkesan pengembangannya sangatlah singkat, Daihatsu tentu tak gegabah merancang mobil sesuai harapan konsumen Indonesia.\r\n\r\nUpaya menggertak para rivalnya, dilakukan dengan cara merancang desain yang lebih dinamis dan membenamkan banyak fitur baru. Tabiat sebagai SUV tetap dipertahankan dengan membiarkan memakai konstruksi unibody. Ya, dengan kata lain, rangka Terios masih sama dengan yang lama, hanya kulitnya saja yang berganti. Struktur semi-monokok mampu menopang ‘kaki-kaki’ lebih jenjang dan ban besar. Alhasil, ground clearance setinggi 220 mm tercipta, setara dengan SUV ladder frame seperti Toyota Fortuner dan Mitsubishi Pajero Sport.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982'),
(11, 'https://imgcdn.oto.com/large/gallery/exterior/7/2040/daihatsu-grand-xenia-front-angle-low-view-843120.jpg', 'Daihatsu Xenia 1.3 STD', 'MT', 'MPV', 'Bensin', 'Manual', 194250000, '0,117386232', 'Daihatsu Xenia, MPV 7-seater yang lahir pada 2003 bersama dengan saudara kembarnya, Toyota Avanza. Sejak kelahirannya, Daihatsu Xenia menjadi favorit banyak masyarakat Indonesia, khususnya sebagai mobil keluarga.\r\nBeragam fitur baru juga diberikan pada Xenia generasi anyar, termasuk peningkatan pada fitur keselamatan.\r\n\r\nAkses ke bangku penumpang dua dan tiga menjadi lebih mudah berkat 1 touch tumble. Pelipatan lebih mudah dan fleksibel. Bahkan bangku ketiga dibuat terpisah sehingga bisa dilipat salah satunya untuk memaksimalkan bagasi dan kursi penumpang.\r\n\r\nSatu lagi yang menjadi fitur standar pada Xenia adalah pendingin kabin sudah didukung dengan double blower untuk baris kedua. Dengannya, kenyamanan baris kedua dan ketiga meningkat dibandingkan model terdahulu tanpa AC double blower.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982'),
(12, 'https://imgcdn.oto.com/large/gallery/exterior/7/2234/daihatsu-sigra-front-angle-low-view-834601.jpg', 'Daihatsu Sigra M', 'MT', 'MPV', 'Bensin', 'Manual', 129900000, '0,125770963', 'Di balik bodi masih belum berubah. Tersimpan teknologi dari tiga tahun lalu. Sepertinya masih cukup untuk berkompetisi hingga tiga atau lima tahun ke depan. Rangka, sasis, mesin tidak berubah. Mobil ini jua masih punya dua pilihan mesin yaitu 1,0 dan 1,2 liter. Sigra juga tetap punya enam varian utama, yang kemudian turun jadi 10 sub-variant.\r\n\r\nSigra pengguna mesin 1,0 liter (D dan M) dijual dengan harga Rp 117,5 sedangkan yang paling mahal (Sigra R DLX) dibanderol 160,25 juta (OTR DKI). ', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982'),
(13, 'https://imgcdn.oto.com/large/gallery/exterior/7/65/daihatsu-luxio-front-angle-low-view-922244.jpg', 'Daihatsu Luxio 1.5 X', 'MT', 'Minibus', 'Bensin', 'Manual', 209600000, '0,117386232', 'Daihatsu Luxio adalah minivan yang dirancang untuk memuat delapan penumpang sekaligus. Mobil ini diperkenalkan pada tahun 2009 dan diproduksi di Indonesia melalui PT. Astra Daihatsu Motor. Luxio tersedia dalam tiga pilihan trim yang dikemas dalam mesin tunggal dengan konfigurasi dua transmisi otomatis dan satu transmisi manual. Minibus lima pintu itu adalah hasil pengembangan dari van multiguna Daihatsu Gran Max. Hanya saja Luxio hadir  dengan ukuran dan kualitas yang sedikit lebih baik. Varian yang tersedia berbeda satu sama lain dalam hal tampilan dan fitur.\r\nDaihatsu Luxio merupakan MPV yang handal dan memiliki kemampuan daya angkut yang sangat baik. Namun tidak ada keunggulan fitur yang dapat dibanggakan dari mobil ini bila dihadapkan dengan para persaingan MPV lainnya.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982'),
(14, 'https://imgcdn.oto.com/large/gallery/exterior/38/1900/toyota-rush-front-angle-low-view-551780.jpg', 'Toyota Rush G', 'MT', 'SUV', 'Bensin', 'Manual', 255200000, '0,134155694', 'Di kelas Low SUV, Rush sebagai kembaran Daihatsu Terios menjadi pionir. Hal itu diklaim oleh Toyota. Meskipun banyak yang menyebut mobil ini sebenarnya penerus dari Daihatsu Taruna, kelas yang sudah ada sejak akhir era 90an.\r\n\r\nBersamaan dengan Rush, Terios juga meluncur. Namun Rush memiliki spesifikasi yang lebih unggul. Dari segi fitur keselamatan hingga pengendaraan, mobil ini memiliki banyak hal yang belum pernah dimiliki sebelumnya. Bahkan ada peranti yang baru pertama kali digunakan Toyota pada modelnya di Indonesia.\r\n\r\nAda dua varian yang ditawarkan TAM. G sebagai pilihan standar dan TRD Sportivo sebagai varian termewah berimbuh peranti bodi dan interior. Kedua varian ini disediakan dengan pilihan transmisi manual dan otomatis.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15310\r\n', '08981152982'),
(15, 'https://imgcdn.oto.com/large/gallery/exterior/38/1240/toyota-kijang-innova-front-angle-low-view-351782.jpg', 'Toyota Kijang Innova G', 'MT', 'MPV', 'Bensin', 'Manual', 337600000, '0,117386232', 'Perubahan terakhir yang tak kalah revolusionernya adalah kehadiran varian baru bernama New Venturer. Tipe ini diplot sebagai kelas tertinggi dari Innova dengan kelengkapan paling komplit dan tampilan berbeda. Agar tidak tumpang-tindih dengan varian yang sudah ada, Toyota Indonesia menghilangkan tipe Q diesel yang sebelumnya berperan sebagai flagship Innova.\r\n\r\nKini, Innova tidak bisa lagi berjalan santai. Pesaingnya datang dari Negeri Cina dengan nama Wuling Cortez. Secara dimensi dan fitur, keduanya bersaing head to head, namun dari segi harga, diperkirakan Cortez akan jauh lebih murah. Wuling belum mengumumkan harga, tapi siap-siap saja, Tahun 2018 kelas ini akan ramai. ', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15311\r\n', '08981152982'),
(16, 'https://imgcdn.oto.com/large/gallery/exterior/38/1798/toyota-vios-front-angle-low-view-997090.jpg\r\n', 'Toyota Vios 1.5 G', 'MT', 'Sedan', 'Bensin', 'Manual', 321750000, '0,125770963', 'Sedan kompak atau B-segment dari Toyota ini, baru mendapat ubahan mekanis akhir 2016 lalu. Sedang di negara tetangga, sudah mendapatkan facelift setelah update mekanikalnya. Kita sedikit tertinggal. Tapi tak perlu khawatir. Toh Toyota Vios 2017 akhirnya datang juga. Facelift di sini merujuk pada penyegaran desain. Paling kentara terjadi di wajah Vios. Kabin juga sedikit diberi sentuhan lebih segar. Tapi soal kualitas kabin secara umum masih sama. Artinya masih banyak ruang yang bisa ditingkatkan nilainya dari kabin Toyota Vios. Mulai dari material yang digunakan, sampai sektor infotainmentnya.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15312\r\n', '08981152982'),
(17, 'https://imgcdn.oto.com/large/gallery/exterior/38/1654/toyota-avanza-2019-front-angle-low-view-187784.jpg', 'Toyota Avanza 1.3 E', 'MT', 'MPV', 'Bensin', 'Manual', 200200000, '0,134155694', 'Varian yang hadir sekarang tetap E, G dan Veloz. Di masing-masing terdapat pilihan mesin 1.3L dan 1.5L serta pilihan transmisi manual dan otomatik. Fokus pada Avanza varian G, di sekujur tubuhnya banyak menggunakan krom sebagai aksesori. Ini bisa menjadi salah satu pembeda antara varian Veloz dan non Veloz, selain desain pelek.\r\n\r\nAvanza (selain Veloz) dimulai dari varian E yang harganya dimulai dari Rp 191.100.000 dan ditutup oleh varian G Rp. 221.250.000. Harganya tidak berubah dari generasi sebelumnya. Dan ini salah satu daya tarik bagi mereka yang mau membeli Avanza.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15313\r\n', '08981152982'),
(18, 'https://imgcdn.oto.com/large/gallery/exterior/38/2233/toyota-calya-front-angle-low-view-361162.jpg', 'Toyota Calya', 'E MT', 'MPV', 'Bensin', 'Manual', 148990000, '0,134155694', 'New Toyota Calya mendapatkan penyegaran. Meski tak signifikan, tapi mampu mengubah tampilannya menjadi semakin atraktif. Low Cost Green Car (LCGC) berpenumpang 7 orang ini disuguhkan dalam 2 varian, E dan G. Masing-masing terbagi lagi menjadi dua tipe. Untuk E sebagai opsi paling bawah, ada manual tanpa ABS (Anti-lock Braking System). Kemudian pilihan dengan ABS yang masih mengusung transmisi manual. Sementara varian G ada tipe manual dan otomatis konvensional. Banderol semuanya naik kisaran Rp 1,4 jutaan hingga Rp 2 juta.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15314\r\n', '08981152982');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_daihatsu`
--

CREATE TABLE `tbl_daihatsu` (
  `id_mobil_daihatsu` int(11) NOT NULL,
  `link_img_daihatsu` varchar(255) DEFAULT NULL,
  `nama_mobil_daihatsu` varchar(30) DEFAULT NULL,
  `varian_mobil_daihatsu` varchar(25) DEFAULT NULL,
  `tipebody_mobil_daihatsu` varchar(25) DEFAULT NULL,
  `bb_mobil_daihatsu` varchar(20) DEFAULT NULL,
  `transmisi_mobil_daihatsu` varchar(20) DEFAULT NULL,
  `harga_mobil_daihatsu` varchar(255) DEFAULT NULL,
  `data_topsis_daihatsu` varchar(50) DEFAULT NULL,
  `desc_mobil_daihatsu` text DEFAULT NULL,
  `alamat_dealer_mobil_daihatsu` text DEFAULT NULL,
  `no_tlp_mobil_daihatsu` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_daihatsu`
--

INSERT INTO `tbl_daihatsu` (`id_mobil_daihatsu`, `link_img_daihatsu`, `nama_mobil_daihatsu`, `varian_mobil_daihatsu`, `tipebody_mobil_daihatsu`, `bb_mobil_daihatsu`, `transmisi_mobil_daihatsu`, `harga_mobil_daihatsu`, `data_topsis_daihatsu`, `desc_mobil_daihatsu`, `alamat_dealer_mobil_daihatsu`, `no_tlp_mobil_daihatsu`) VALUES
(1, 'https://imgcdn.oto.com/large/gallery/exterior/7/1731/daihatsu-ayla-front-angle-low-view-169248.jpg', 'Daihatsu Ayla', '1.0L D MT', 'Hatchback', 'Bensin', 'Manual', '103300000', '0,147667844', 'Daihatsu Ayla kembali bersolek agar tak termakan umur. Tak tanggung ada 7 varian yang akan memberi keleluasaan bagi konsumen untuk memilih sesuai kebutuhan. Dari varian sebanyak itu, terbagi lagi menjadi dua tipe mesin yakni 1,0-liter dan 1,2-liter.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(2, 'https://imgcdn.oto.com/large/gallery/exterior/7/69/daihatsu-gran-max-pu-front-angle-low-view-240822.jpg', 'Daihatsu Grandmax PU 1.3 ', '3W FH', 'Pickup', 'Bensin', 'Manual', '141400000', '0,125770963', 'Dalam rangka memenuhi kebutuhan dan utilitas, merek tersebut hadir dalam tiga level trim – Pick up, Blind van, dan Box, yang masing-masing ditawarkan varian bensin 1.3 liter dan 1.5 liter. Dengan mesin 1.3 liter, pikap tersebut mengeluarkan daya maksimum sebesar 88 Ps pada 6000 rpm dan torsi puncak sebesar 114 Nm pada 4400 rpm. Di sisi lain, mesin 1.5 liter menyemburkan tenaga 97 ps pada 6000 rpm, dengan torsi maksimum yang dihasilkan sebesar 133 Nm pada 4400 rpm. Teknologi injeksi yang irit bahan bakar dan VVT-i yang disematkan dalam mesin memungkinkan mobil ini untuk menempuh 13,33 km/L.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(3, 'https://imgcdn.oto.com/large/gallery/exterior/7/1669/daihatsu-terios-front-angle-low-view-593424.jpg', 'Daihatsu Terios X', 'MT', 'MT', 'Bensin', 'Manual', '221800000', '0,100616771', 'All New Terios mengalami perubahan total tidak hanya dari sisi desain, tapi juga fitur yang ditawarkan. Tak lain bertujuan untuk merebut kembali pangsa pasar Low SUV yang beberapa tahun belakangan direnggut Honda BR-V. Apalagi eksistensi semakin terancam setelah kedatangan Mitsubishi Xpander yang ber-DNA SUV walau sebenarnya Low MPV. Tentu pekerjaan yang tak mudah bagi Daihatsu. Meski terkesan pengembangannya sangatlah singkat, Daihatsu tentu tak gegabah merancang mobil sesuai harapan konsumen Indonesia.\r\n\r\nUpaya menggertak para rivalnya, dilakukan dengan cara merancang desain yang lebih dinamis dan membenamkan banyak fitur baru. Tabiat sebagai SUV tetap dipertahankan dengan membiarkan memakai konstruksi unibody. Ya, dengan kata lain, rangka Terios masih sama dengan yang lama, hanya kulitnya saja yang berganti. Struktur semi-monokok mampu menopang ‘kaki-kaki’ lebih jenjang dan ban besar. Alhasil, ground clearance setinggi 220 mm tercipta, setara dengan SUV ladder frame seperti Toyota Fortuner dan Mitsubishi Pajero Sport.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(4, 'https://imgcdn.oto.com/large/gallery/exterior/7/2040/daihatsu-grand-xenia-front-angle-low-view-843120.jpg', 'Daihatsu Xenia 1.3 STD', 'MT', 'MPV', 'Bensin', 'Manual', '194250000', '0,117386232', 'Daihatsu Xenia, MPV 7-seater yang lahir pada 2003 bersama dengan saudara kembarnya, Toyota Avanza. Sejak kelahirannya, Daihatsu Xenia menjadi favorit banyak masyarakat Indonesia, khususnya sebagai mobil keluarga.\r\nBeragam fitur baru juga diberikan pada Xenia generasi anyar, termasuk peningkatan pada fitur keselamatan.\r\n\r\nAkses ke bangku penumpang dua dan tiga menjadi lebih mudah berkat 1 touch tumble. Pelipatan lebih mudah dan fleksibel. Bahkan bangku ketiga dibuat terpisah sehingga bisa dilipat salah satunya untuk memaksimalkan bagasi dan kursi penumpang.\r\n\r\nSatu lagi yang menjadi fitur standar pada Xenia adalah pendingin kabin sudah didukung dengan double blower untuk baris kedua. Dengannya, kenyamanan baris kedua dan ketiga meningkat dibandingkan model terdahulu tanpa AC double blower.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(5, 'https://imgcdn.oto.com/large/gallery/exterior/7/2234/daihatsu-sigra-front-angle-low-view-834601.jpg', 'Daihatsu Sigra M', 'MT', 'MPV', 'Bensin', 'Manual', '129900000', '0,125770963', 'Di balik bodi masih belum berubah. Tersimpan teknologi dari tiga tahun lalu. Sepertinya masih cukup untuk berkompetisi hingga tiga atau lima tahun ke depan. Rangka, sasis, mesin tidak berubah. Mobil ini jua masih punya dua pilihan mesin yaitu 1,0 dan 1,2 liter. Sigra juga tetap punya enam varian utama, yang kemudian turun jadi 10 sub-variant.\r\n\r\nSigra pengguna mesin 1,0 liter (D dan M) dijual dengan harga Rp 117,5 sedangkan yang paling mahal (Sigra R DLX) dibanderol 160,25 juta (OTR DKI). ', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang', '08981152982'),
(6, 'https://imgcdn.oto.com/large/gallery/exterior/7/65/daihatsu-luxio-front-angle-low-view-922244.jpg', 'Daihatsu Luxio 1.5 X', 'MT', 'Minibus', 'Bensin', 'Manual', '209600000', '0,117386232', 'Daihatsu Luxio adalah minivan yang dirancang untuk memuat delapan penumpang sekaligus. Mobil ini diperkenalkan pada tahun 2009 dan diproduksi di Indonesia melalui PT. Astra Daihatsu Motor. Luxio tersedia dalam tiga pilihan trim yang dikemas dalam mesin tunggal dengan konfigurasi dua transmisi otomatis dan satu transmisi manual. Minibus lima pintu itu adalah hasil pengembangan dari van multiguna Daihatsu Gran Max. Hanya saja Luxio hadir  dengan ukuran dan kualitas yang sedikit lebih baik. Varian yang tersedia berbeda satu sama lain dalam hal tampilan dan fitur.\r\nDaihatsu Luxio merupakan MPV yang handal dan memiliki kemampuan daya angkut yang sangat baik. Namun tidak ada keunggulan fitur yang dapat dibanggakan dari mobil ini bila dihadapkan dengan para persaingan MPV lainnya.', 'Jl. Raya Daan Mogot Km.23 No. 88, Tanah Tinggi, Tangerang, Tangerang\r\n', '08981152982');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_honda`
--

CREATE TABLE `tbl_honda` (
  `id_mobil_honda` int(11) NOT NULL,
  `link_img_honda` varchar(255) DEFAULT NULL,
  `nama_mobil_honda` varchar(30) DEFAULT NULL,
  `varian_mobil_honda` varchar(25) DEFAULT NULL,
  `tipebody_mobil_honda` varchar(25) DEFAULT NULL,
  `bb_mobil_honda` varchar(20) DEFAULT NULL,
  `transmisi_mobil_honda` varchar(20) DEFAULT NULL,
  `harga_mobil_honda` varchar(255) DEFAULT NULL,
  `data_topsis_honda` varchar(50) DEFAULT NULL,
  `desc_mobil_honda` text DEFAULT NULL,
  `alamat_dealer_mobil_honda` text DEFAULT NULL,
  `no_tlp_mobil_honda` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_honda`
--

INSERT INTO `tbl_honda` (`id_mobil_honda`, `link_img_honda`, `nama_mobil_honda`, `varian_mobil_honda`, `tipebody_mobil_honda`, `bb_mobil_honda`, `transmisi_mobil_honda`, `harga_mobil_honda`, `data_topsis_honda`, `desc_mobil_honda`, `alamat_dealer_mobil_honda`, `no_tlp_mobil_honda`) VALUES
(1, 'https://imgcdn.oto.com/large/gallery/exterior/14/1995/honda-brio-front-angle-low-view-746781.jpg', 'Honda Brio', 'Satya S', 'Hatchback', 'Bensin', 'Manual', '151400000', '0,147667844', 'Honda Brio didatangkan utuh (CBU) dari Thailand oleh Honda Prospect Motor 2012 silam. Mesinnya 1,3-liter kala itu, dengan pilihan transmisi manual dan otomatis. Tahun 2014, Honda memutuskan merakitnya secara local (CKD) dan mulai bermain dalam segmen Low Cost Green Car (LCGC) melalui senjata adalannya, Brio Satya. Mesin L13 diganti L12 yang sedikit lebih kecil kapasitas dengan fitur juga sedikit lebih lengkap dari versi CBU.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15411', '08981152982'),
(2, 'https://imgcdn.oto.com/large/gallery/exterior/14/98/honda-mobilio-front-angle-low-view-835646.jpg', 'Honda Mobilio 1.5 E', 'CVT', 'MPV', 'Bensin', 'Manual', '235800000', '0,117386232', 'Salah satu dari lini produk tersebut adalah Honda Mobilio, yang hadir dalam bentuk MPV mini tujuh kursi dan pertama kali diproduksi Honda, pada tahun 2001.\r\n\r\nMobil ini kembali dimunculkan pada tahun 2013, atas prakarsa Honda Prospect Motor dan Honda Thailand, dengan perubahan yang signifikan menggunakan platform Honda Brio. Varian yang lebih sporty, dinamakan dengan Honda Mobilio RS kemudian dirilis pada tahun 2014 oleh Honda Prospect Motor (HPM).\r\n\r\nPerubahan model MPV ini terbilang cepat. Awal tahun 2016, HPM merilis perubahan wajah dan interior. Saat itu, perubahan di bagian eksterior terbilang minim, namun penyematan pengendali AC digital di kabin memberikan nilai lebih, dan membuatnya terlihat canggih.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15412\r\n', '08981152982'),
(3, 'https://imgcdn.oto.com/large/gallery/exterior/14/1970/honda-hr-v-front-angle-low-view-470426.jpg', 'Honda HR-V 1.5L E', 'CVT', 'SUV', 'Bensin', 'Otomatis', '331200000', '0,067077847', 'Honda HR-V kembali menjadi kekuatan Honda Prospect Indonesia (HPM), pemegang merek mobil Honda di Indonesia, di segmen Low SUV dan crossover. Kelas yang sedang naik daun beberapa tahun belakangan, menggantikan redupnya compact hatchback dan small sedan. Desain keren, fitur lengkap merupakan suatu kewajiban agar mampu memikat pasar. Itulah yang dimiliki HR-V, sehingga penjualannya laris manis.\r\n\r\nSiklus hidup Honda HR-V berlanjut ke fase penyegaran setelah memasuki tahun keempat. Waktu yang tergolong pas untuk pembenahan agar tetap kuat di pasaran. HPM mengambil momen tepat saat pameran Gaikindo Indonesia International Auto Show (GIIAS) 2018 berlangsung.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15413\r\n', '08981152982'),
(4, 'https://imgcdn.oto.com/large/gallery/exterior/14/891/honda-br-v-front-angle-low-view-355616.jpg', 'Honda BR-V S ', '6MT', 'SUV', 'Bensin', 'Manual', '248900000', '0,100616771', 'Honda BR-V adalah jawaban Honda terhadap kebutuhan mobil dengan ground clearance tinggi, memiliki kapasitas tujuh tempat duduk, dan harganya terjangkau. Yang menarik, Honda selalu menjadi yang terakhir memasuki pasar, setelah sebelumnya seolah mengamati apa yang dilakukan oleh para kompetitor di kelas yang diincarnya.\r\n\r\nTidak percaya? Coba lihat kapan Honda Mobilio masuk dan menggempur pasar low MPV? Saat konsumen di kelas ini sudah mulai jenuh dengan pilihan yang ada, hadir Mobilio dan langsung menggairahkan kembali pasar tersebut. Hal yang sama berlaku untuk BR-V, yang diarahkan untuk masuk di pasar low SUV/crossover.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15414\r\n', '08981152982'),
(5, 'https://imgcdn.oto.com/large/gallery/exterior/14/2365/honda-city-hatchback-front-angle-low-view-183553.jpg', 'Honda City Hatchback', 'RS MT', 'Hatchback', 'Bensin', 'Manual', '289000000', '0,109001502', 'Honda CIty Hatchback diluncurkan di Indonesia Maret 2021. Ia akan bertugas mengawal segmen Hatchback di portfolio Honda bagi konsumen Tanah Air. Statusnya adalah produksi lokal di pabrik Honda Prospect Motor di Karawang, Jawa Barat.\r\n\r\nModel hatchback ini hanya tersedia dalam satu varian pada sesi peluncuran perdananya. Versi termewah dan paling agresif, RS ditawarkan di Indonesia. Sayang, saat informasi ini dirilis, harganya belum dipublikasi. Honda City Hatchback RS tersedia dalam 6 pilihan warna, di antaranya Phoenix Orange Pearl, Rallye Red, Crystal Black Pearl, Lunar Silver Metallic, Platinum White Pearl, dan varian warna terbaru adalah Meteoroid Gray Metallic.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15416\r\n', '08981152982'),
(6, 'https://imgcdn.oto.com/large/gallery/exterior/14/1734/honda-cr-v-front-angle-low-view-378288.jpg', 'Honda CR-V 2.0L', 'i-VTEC', 'SUV', 'Bensin', 'Manual', '489000000', '0,083847309', 'Honda CR-V saat ini masuk dalam generasi ke-5. Lahir pada 2017 lalu, dengan segenap perubahan. Tampangnya disesuaikan dengan zaman maupun bahasa desain paling modern Honda. Fitur canggih nan segar tak lupa disematkan. Ubahan paling signifikan dibanding generasi sebelum, sektor jantung pacu dan performa. Honda CR-V facelift pada 2021 masih ditawarkan dalam tiga varian. Namun kini hanya ada empat warna: White Orchid Pearl, Lunar Silver Metallic, Modern Steel Metallic dan Crystal Black Pearl. Untuk harga Honda CR-V 2021, Rp 489 juta varian 2.0L i-VTEC, CR-V 1.5L Turbo Rp 522,5 juta dan Honda CR-V 1.5L Turbo Prestige Rp 577 juta.', 'l. RE. Martadinata no. 52 RT/RW: 001/05 Kel. Cipayung Kec Ciputat Tangerang Selatan - Banten 15415\r\n', '08981152982');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_toyota`
--

CREATE TABLE `tbl_toyota` (
  `id_mobil_toyota` int(11) NOT NULL,
  `link_img_toyota` varchar(255) DEFAULT NULL,
  `nama_mobil_toyota` varchar(30) DEFAULT NULL,
  `varian_mobil_toyota` varchar(25) DEFAULT NULL,
  `tipebody_mobil_toyota` varchar(25) DEFAULT NULL,
  `bb_mobil_toyota` varchar(20) DEFAULT NULL,
  `transmisi_mobil_toyota` varchar(20) DEFAULT NULL,
  `harga_mobil_toyota` varchar(255) DEFAULT NULL,
  `data_topsis_toyota` varchar(50) DEFAULT NULL,
  `desc_mobil_toyota` text DEFAULT NULL,
  `alamat_dealer_mobil_toyota` text DEFAULT NULL,
  `no_tlp_mobil_toyota` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_toyota`
--

INSERT INTO `tbl_toyota` (`id_mobil_toyota`, `link_img_toyota`, `nama_mobil_toyota`, `varian_mobil_toyota`, `tipebody_mobil_toyota`, `bb_mobil_toyota`, `transmisi_mobil_toyota`, `harga_mobil_toyota`, `data_topsis_toyota`, `desc_mobil_toyota`, `alamat_dealer_mobil_toyota`, `no_tlp_mobil_toyota`) VALUES
(1, 'https://imgcdn.oto.com/large/gallery/exterior/38/1732/toyota-agya-front-angle-low-view-925597.jpg', 'Toyota Agya', '1.0L G M/T', 'Hatchback', 'Bensin', 'Manual', '144900000', '0,147667844', 'Akhirnya, setelah beredar di dunia maya lewat rangkaian bocoran, New Toyota Agya versi terbaru resmi diluncurkan pada tahun 2020. Untuk facelift edisi kedua sejak pertama kali diluncurkan, Agya hadir mengusung tagline “Start to Never Stop”, dengan penampilan lebih sporty dan fitur lebih lengkap.\r\n\r\nMenyusul pembaruan dan penyegaran ini, New Agya mengalami perubahan harga dari versi sebelumnya. Untuk edisi facelift 2020, TAM menawarkan New Agya dengan rentang harga dari Rp 143,8 juta sampai dengan Rp 169,290 juta, dalam kondisi OTR DKI Jakarta.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15310\r\n', '08981152982'),
(2, 'https://imgcdn.oto.com/large/gallery/exterior/38/1900/toyota-rush-front-angle-low-view-551780.jpg', 'Toyota Rush G', 'MT', 'SUV', 'Bensin', 'Manual', '255200000', '0,134155694', 'Di kelas Low SUV, Rush sebagai kembaran Daihatsu Terios menjadi pionir. Hal itu diklaim oleh Toyota. Meskipun banyak yang menyebut mobil ini sebenarnya penerus dari Daihatsu Taruna, kelas yang sudah ada sejak akhir era 90an.\r\n\r\nBersamaan dengan Rush, Terios juga meluncur. Namun Rush memiliki spesifikasi yang lebih unggul. Dari segi fitur keselamatan hingga pengendaraan, mobil ini memiliki banyak hal yang belum pernah dimiliki sebelumnya. Bahkan ada peranti yang baru pertama kali digunakan Toyota pada modelnya di Indonesia.\r\n\r\nAda dua varian yang ditawarkan TAM. G sebagai pilihan standar dan TRD Sportivo sebagai varian termewah berimbuh peranti bodi dan interior. Kedua varian ini disediakan dengan pilihan transmisi manual dan otomatis.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15310\r\n', '08981152982'),
(3, 'https://imgcdn.oto.com/large/gallery/exterior/38/1240/toyota-kijang-innova-front-angle-low-view-351782.jpg', 'Toyota Kijang Innova G', 'MT', 'MPV', 'Bensin', 'Manual', '337600000', '0,117386232', 'Perubahan terakhir yang tak kalah revolusionernya adalah kehadiran varian baru bernama New Venturer. Tipe ini diplot sebagai kelas tertinggi dari Innova dengan kelengkapan paling komplit dan tampilan berbeda. Agar tidak tumpang-tindih dengan varian yang sudah ada, Toyota Indonesia menghilangkan tipe Q diesel yang sebelumnya berperan sebagai flagship Innova.\r\n\r\nKini, Innova tidak bisa lagi berjalan santai. Pesaingnya datang dari Negeri Cina dengan nama Wuling Cortez. Secara dimensi dan fitur, keduanya bersaing head to head, namun dari segi harga, diperkirakan Cortez akan jauh lebih murah. Wuling belum mengumumkan harga, tapi siap-siap saja, Tahun 2018 kelas ini akan ramai. ', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15311\r\n', '08981152982'),
(4, 'https://imgcdn.oto.com/large/gallery/exterior/38/1798/toyota-vios-front-angle-low-view-997090.jpg', 'Toyota Vios 1.5 G', 'MT', 'Sedan', 'Bensin', 'Manual', '321750000', '0,125770963', 'Sedan kompak atau B-segment dari Toyota ini, baru mendapat ubahan mekanis akhir 2016 lalu. Sedang di negara tetangga, sudah mendapatkan facelift setelah update mekanikalnya. Kita sedikit tertinggal. Tapi tak perlu khawatir. Toh Toyota Vios 2017 akhirnya datang juga. Facelift di sini merujuk pada penyegaran desain. Paling kentara terjadi di wajah Vios. Kabin juga sedikit diberi sentuhan lebih segar. Tapi soal kualitas kabin secara umum masih sama. Artinya masih banyak ruang yang bisa ditingkatkan nilainya dari kabin Toyota Vios. Mulai dari material yang digunakan, sampai sektor infotainmentnya.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15312', '08981152982'),
(5, 'https://imgcdn.oto.com/large/gallery/exterior/38/1654/toyota-avanza-2019-front-angle-low-view-187784.jpg', 'Toyota Avanza 1.3 E', 'MT', 'MPV', 'Bensin', 'Manual', '200200000', '0,134155694', 'Varian yang hadir sekarang tetap E, G dan Veloz. Di masing-masing terdapat pilihan mesin 1.3L dan 1.5L serta pilihan transmisi manual dan otomatik. Fokus pada Avanza varian G, di sekujur tubuhnya banyak menggunakan krom sebagai aksesori. Ini bisa menjadi salah satu pembeda antara varian Veloz dan non Veloz, selain desain pelek.\r\n\r\nAvanza (selain Veloz) dimulai dari varian E yang harganya dimulai dari Rp 191.100.000 dan ditutup oleh varian G Rp. 221.250.000. Harganya tidak berubah dari generasi sebelumnya. Dan ini salah satu daya tarik bagi mereka yang mau membeli Avanza.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15313', '08981152982'),
(6, 'https://imgcdn.oto.com/large/gallery/exterior/38/2233/toyota-calya-front-angle-low-view-361162.jpg', 'Toyota Calya', 'E MT', 'MPV', 'Bensin', 'Manual', '148990000', '0,134155694', 'New Toyota Calya mendapatkan penyegaran. Meski tak signifikan, tapi mampu mengubah tampilannya menjadi semakin atraktif. Low Cost Green Car (LCGC) berpenumpang 7 orang ini disuguhkan dalam 2 varian, E dan G. Masing-masing terbagi lagi menjadi dua tipe. Untuk E sebagai opsi paling bawah, ada manual tanpa ABS (Anti-lock Braking System). Kemudian pilihan dengan ABS yang masih mengusung transmisi manual. Sementara varian G ada tipe manual dan otomatis konvensional. Banderol semuanya naik kisaran Rp 1,4 jutaan hingga Rp 2 juta.', 'Jl. Raya Serpong Km. 7, Pondok Jagung, Tangerang, 15314\r\n', '08981152982');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_allbrand`
--
ALTER TABLE `tbl_allbrand`
  ADD PRIMARY KEY (`id_mobilall`);

--
-- Indexes for table `tbl_daihatsu`
--
ALTER TABLE `tbl_daihatsu`
  ADD PRIMARY KEY (`id_mobil_daihatsu`);

--
-- Indexes for table `tbl_honda`
--
ALTER TABLE `tbl_honda`
  ADD PRIMARY KEY (`id_mobil_honda`);

--
-- Indexes for table `tbl_toyota`
--
ALTER TABLE `tbl_toyota`
  ADD PRIMARY KEY (`id_mobil_toyota`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_allbrand`
--
ALTER TABLE `tbl_allbrand`
  MODIFY `id_mobilall` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tbl_daihatsu`
--
ALTER TABLE `tbl_daihatsu`
  MODIFY `id_mobil_daihatsu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_honda`
--
ALTER TABLE `tbl_honda`
  MODIFY `id_mobil_honda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_toyota`
--
ALTER TABLE `tbl_toyota`
  MODIFY `id_mobil_toyota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
