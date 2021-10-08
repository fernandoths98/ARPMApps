<?php 
    include 'config.php';

    $id_mobil_toyota=$_POST['id_mobil_toyota'];
    $link_img_toyota=$_POST['link_img_toyota'];
    $nama_mobil_toyota=$_POST['nama_mobil_toyota'];
    $varian_mobil_toyota=$_POST['varian_mobil_toyota'];
    $tipebody_mobil_toyota=$_POST['tipebody_mobil_toyota'];
    $bb_mobil_toyota=$_POST['bb_mobil_toyota'];
    $transmisi_mobil_toyota=$_POST['transmisi_mobil_toyota'];
    $harga_mobil_toyota=$_POST['harga_mobil_toyota'];
    $data_topsis_toyota=$_POST['data_topsis_toyota'];
    $desc_mobil_toyota=$_POST['desc_mobil_toyota'];
    $alamat_dealer_mobil_toyota=$_POST['alamat_dealer_mobil_toyota'];
    $no_tlp_mobil_toyota=$_POST['no_tlp_mobil_toyota'];

    $query = "INSERT INTO tbl_toyota
    (id_mobil_toyota,
    link_img_toyota,
    nama_mobil_toyota,
    varian_mobil_toyota,
    tipebody_mobil_toyota,
    bb_mobil_toyota,
    transmisi_mobil_toyota,
    harga_mobil_toyota,
    data_topsis_toyota,
    desc_mobil_toyota,
    alamat_dealer_mobil_toyota,
    no_tlp_mobil_toyota)
    VALUES ('$id_mobil_toyota',
    '$link_img_toyota',
    '$nama_mobil_toyota',
    '$varian_mobil_toyota',
    '$tipebody_mobil_toyota',
    '$bb_mobil_toyota',
    '$transmisi_mobil_toyota',
    '$harga_mobil_toyota',
    '$data_topsis_toyota',
    '$desc_mobil_toyota',
    '$alamat_dealer_mobil_toyota',
    '$no_tlp_mobil_toyota')";

if($con->query($query)) {

    //redirect ke halaman index.php 
    header("location:./tbltoyota.php");

} else {

    //pesan error gagal insert data
    echo "Data Gagal Disimpan!";

}
?>