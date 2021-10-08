<?php
include 'config.php';
$id_mobilall = $_GET['id_mobilall'];

mysqli_query($con, "DELETE FROM tbl_allbrand WHERE id_mobilall='$id_mobilall'");

echo "<script>alert('Database Deleted');</script>";
echo "<script>location='./index.php';</script>";
