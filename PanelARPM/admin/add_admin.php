<?php 
    include 'config.php';

    $id_admin=$_POST['id_admin'];
    $username_admin=$_POST['username_admin'];
    $nama_admin=$_POST['nama_admin'];
    $password_admin=$_POST['password_admin'];
   

    $query = "INSERT INTO tbl_admin
    (id_admin,username_admin,nama_admin,password_admin)
    VALUES ('$id_admin','$username_admin','$nama_admin','$password_admin')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location: index.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>