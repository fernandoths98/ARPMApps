<?php
session_start();
include 'config.php';

$npm_mahasiswa = $_POST['npm_mahasiswa'];
$password_mahasiswa = $_POST['password_mahasiswa'];



$login = mysqli_query($con, "SELECT * FROM akun_mahasiswa WHERE npm_mahasiswa='$npm_mahasiswa' and password_mahasiswa='$password_mahasiswa'");
$cek = mysqli_num_rows($login);
 
if($cek > 0) {
	$data = mysqli_fetch_assoc($login);
	//menyimpan session user, nama, status dan id login
	$_SESSION['npm_mahasiswa'] = $npm_mahasiswa;
	$_SESSION['nama_mahasiswa'] = $data['nama_mahasiswa'];
	$_SESSION['status'] = "sudah_login";
	$_SESSION['id_login'] = $data['id'];
	header("location:index.php");
} else {
	header("location:login_mahasiswa.php?pesan=gagal login data tidak ditemukan.");
}
?>