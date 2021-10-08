<?php
session_start();
include 'config.php';

$username_admin = $_POST['username_admin'];
$password_admin = $_POST['password_admin'];



$login = mysqli_query($con, "SELECT * FROM tbl_admin WHERE username_admin='$username_admin' 
and password_admin='$password_admin'");
$cek = mysqli_num_rows($login);
 
if($cek > 0) {
	$data = mysqli_fetch_assoc($login);
	//menyimpan session user, nama, status dan id login
	$_SESSION['username_admin'] = $username_admin;
	$_SESSION['nama_admin'] = $data['nama_admin'];
	$_SESSION['status_admin'] = "sudah_login";
	$_SESSION['id_admin'] = $data['id_admin'];
	header("location:index.php");
} else {
	header("location:login_admin.php?pesan=gagal login data tidak ditemukan.");
}
?>