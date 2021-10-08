<?php
include 'config.php';
$id_mobil_toyota = $_GET['id_mobil_toyota'];

mysqli_query($con, "DELETE FROM tbl_toyota WHERE id_mobil_toyota='$id_mobil_toyota'");

echo "<script>alert('Database Deleted');</script>";
echo "<script>location='./tbltoyota.php';</script>";
