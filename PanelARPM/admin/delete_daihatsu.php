<?php
include 'config.php';
$id_mobil_daihatsu = $_GET['id_mobil_daihatsu'];

mysqli_query($con, "DELETE FROM tbl_daihatsu WHERE id_mobil_daihatsu='$id_mobil_daihatsu'");

echo "<script>alert('Database Deleted');</script>";
echo "<script>location='./tbldaihatsu.php';</script>";
