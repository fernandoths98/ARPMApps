<?php
include 'config.php';
$id_mobil_honda = $_GET['id_mobil_honda'];

mysqli_query($con, "DELETE FROM tbl_honda WHERE id_mobil_honda='$id_mobil_honda'");

echo "<script>alert('Database Deleted');</script>";
echo "<script>location='./tblhonda.php';</script>";
