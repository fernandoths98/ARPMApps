<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_allbrand ORDER BY data_topsis ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    echo json_encode($row);
    array_push($result, array
    ('id_mobilall'=>$row["0"], 
    'link_img_all'=>$row["1"], 
    'nama_mobil'=>$row["2"], 
    'varian_mobil'=>$row["3"], 
    'tipebody_mobil_all'=>$row["4"], 
    'bb_mobil'=>$row["5"], 
    'transmisi_mobil'=>$row["6"], 
    'harga_mobil'=>$row["7"], 
    'data_topsis'=>$row["8"],
    'desc_mobil_all'=>$row["9"], 
    'alamat_dealer_mobil_all'=>$row["10"], 
    'no_tlp_mobil_all'=>$row["11"]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}