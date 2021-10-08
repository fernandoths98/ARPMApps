<?php 
    include 'config.php';

    $nama_mahasiswa=$_POST['nama_mahasiswa'];
    $jenis_kelamin_mahasiswa=$_POST['jenis_kelamin_mahasiswa'];
    $no_hp_mahasiswa=$_POST['no_hp_mahasiswa'];
    $jurusan_mahasiswa=$_POST['jurusan_mahasiswa'];
    $usia_mahasiswa=$_POST['usia_mahasiswa'];
    $alamat_mahasiswa=$_POST['alamat_mahasiswa'];

    $query = "INSERT INTO tbl_mahasiswa
    (nama_mahasiswa,jenis_kelamin_mahasiswa,no_hp_mahasiswa
    ,jurusan_mahasiswa,usia_mahasiswa,alamat_mahasiswa)
    VALUES ('$nama_mahasiswa','$jenis_kelamin_mahasiswa',
    '$no_hp_mahasiswa','$jurusan_mahasiswa','$usia_mahasiswa','$alamat_mahasiswa')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location: index.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>