<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_daihatsu ORDER BY data_topsis_daihatsu ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array(
    'id_mobil_daihatsu'=>$row[0], 
    'link_img_daihatsu'=>$row[1], 
    'nama_mobil_daihatsu'=>$row[2], 
    'varian_mobil_daihatsu'=>$row[3], 'tipebody_mobil_daihatsu'=>$row[4], 'bb_mobil_daihatsu'=>$row[5], 
    'transmisi_mobil_daihatsu'=>$row[6], 'harga_mobil_daihatsu'=>$row[7], 'data_topsis_daihatsu'=>$row[8],
    'desc_mobil_daihatsu'=>$row[9], 'alamat_dealer_mobil_daihatsu'=>$row[10], 'no_tlp_mobil_daihatsu'=>$row[11]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}