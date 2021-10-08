<?php 
    include 'config.php';

    $id_mobilall=$_POST['id_mobilall'];
    $link_img_all=$_POST['link_img_all'];
    $nama_mobil=$_POST['nama_mobil'];
    $varian_mobil=$_POST['varian_mobil'];
    $tipebody_mobil_all=$_POST['tipebody_mobil_all'];
    $bb_mobil=$_POST['bb_mobil'];
    $transmisi_mobil=$_POST['transmisi_mobil'];
    $harga_mobil=$_POST['harga_mobil'];
    $data_topsis=$_POST['data_topsis'];
    $desc_mobil_all=$_POST['desc_mobil_all'];
    $alamat_dealer_mobil_all=$_POST['alamat_dealer_mobil_all'];
    $no_tlp_mobil_all=$_POST['no_tlp_mobil_all'];

    $query = "INSERT INTO tbl_allbrand
    (id_mobilall,
    link_img_all,
    nama_mobil,
    varian_mobil,
    tipebody_mobil_all,
    bb_mobil,
    transmisi_mobil,
    harga_mobil,
    data_topsis,
    desc_mobil_all,
    alamat_dealer_mobil_all,
    no_tlp_mobil_all)
    VALUES ('$id_mobilall',
    '$link_img_all',
    '$nama_mobil',
    '$varian_mobil',
    '$tipebody_mobil_all',
    '$bb_mobil',
    '$transmisi_mobil',
    '$harga_mobil',
    '$data_topsis',
    '$desc_mobil_all',
    '$alamat_dealer_mobil_all',
    '$no_tlp_mobil_all')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location:./index.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>