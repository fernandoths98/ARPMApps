<?php
include 'config.php';
$id_matakuliah = $_GET['id_matakuliah'];

mysqli_query($con, "DELETE FROM tbl_matakuliah_mahasiswa WHERE id_matakuliah='$id_matakuliah'");

echo "<script>alert('Data Mata Kuliah dihapus');</script>";
echo "<script>location='index.php';</script>";