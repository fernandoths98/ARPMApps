<?php 
    include 'config.php';

    $id_mobil_daihatsu=$_POST['id_mobil_daihatsu'];
    $link_img_daihatsu=$_POST['link_img_daihatsu'];
    $nama_mobil_daihatsu=$_POST['nama_mobil_daihatsu'];
    $varian_mobil_daihatsu=$_POST['varian_mobil_daihatsu'];
    $tipebody_mobil_daihatsu=$_POST['tipebody_mobil_daihatsu'];
    $bb_mobil_daihatsu=$_POST['bb_mobil_daihatsu'];
    $transmisi_mobil_daihatsu=$_POST['transmisi_mobil_daihatsu'];
    $harga_mobil_daihatsu=$_POST['harga_mobil_daihatsu'];
    $data_topsis_daihatsu=$_POST['data_topsis_daihatsu'];
    $desc_mobil_daihatsu=$_POST['desc_mobil_daihatsu'];
    $alamat_dealer_mobil_daihatsu=$_POST['alamat_dealer_mobil_daihatsu'];
    $no_tlp_mobil_daihatsu=$_POST['no_tlp_mobil_daihatsu'];

    $query = "INSERT INTO tbl_daihatsu
    (id_mobil_daihatsu,
    link_img_daihatsu,
    nama_mobil_daihatsu,
    varian_mobil_daihatsu,
    tipebody_mobil_daihatsu,
    bb_mobil_daihatsu,
    transmisi_mobil_daihatsu,
    harga_mobil_daihatsu,
    data_topsis_daihatsu,
    desc_mobil_daihatsu,
    alamat_dealer_mobil_daihatsu,
    no_tlp_mobil_daihatsu)
    VALUES ('$id_mobil_daihatsu',
    '$link_img_daihatsu',
    '$nama_mobil_daihatsu',
    '$varian_mobil_daihatsu',
    '$tipebody_mobil_daihatsu',
    '$bb_mobil_daihatsu',
    '$transmisi_mobil_daihatsu',
    '$harga_mobil_daihatsu',
    '$data_topsis_daihatsu',
    '$desc_mobil_daihatsu',
    '$alamat_dealer_mobil_daihatsu',
    '$no_tlp_mobil_daihatsu')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location:./tbldaihatsu.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>