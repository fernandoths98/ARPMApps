<?php 
    include 'config.php';

    $id_mobil_honda=$_POST['id_mobil_honda'];
    $link_img_honda=$_POST['link_img_honda'];
    $nama_mobil_honda=$_POST['nama_mobil_honda'];
    $varian_mobil_honda=$_POST['varian_mobil_honda'];
    $tipebody_mobil_honda=$_POST['tipebody_mobil_honda'];
    $bb_mobil_honda=$_POST['bb_mobil_honda'];
    $transmisi_mobil_honda=$_POST['transmisi_mobil_honda'];
    $harga_mobil_honda=$_POST['harga_mobil_honda'];
    $data_topsis_honda=$_POST['data_topsis_honda'];
    $desc_mobil_honda=$_POST['desc_mobil_honda'];
    $alamat_dealer_mobil_honda=$_POST['alamat_dealer_mobil_honda'];
    $no_tlp_mobil_honda=$_POST['no_tlp_mobil_honda'];

    $query = "INSERT INTO tbl_honda
    (id_mobil_honda,
    link_img_honda,
    nama_mobil_honda,
    varian_mobil_honda,
    tipebody_mobil_honda,
    bb_mobil_honda,
    transmisi_mobil_honda,
    harga_mobil_honda,
    data_topsis_honda,
    desc_mobil_honda,
    alamat_dealer_mobil_honda,
    no_tlp_mobil_honda)
    VALUES ('$id_mobil_honda',
    '$link_img_honda',
    '$nama_mobil_honda',
    '$varian_mobil_honda',
    '$tipebody_mobil_honda',
    '$bb_mobil_honda',
    '$transmisi_mobil_honda',
    '$harga_mobil_honda',
    '$data_topsis_honda',
    '$desc_mobil_honda',
    '$alamat_dealer_mobil_honda',
    '$no_tlp_mobil_honda')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location:./tblhonda.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>