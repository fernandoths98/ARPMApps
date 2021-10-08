<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_toyota ORDER BY data_topsis_toyota ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array
    ('id_mobil_toyota'=>$row["0"], 
    'link_img_toyota'=>$row["1"], 
    'nama_mobil_toyota'=>$row["2"], 
    'varian_mobil_toyota'=>$row["3"], 
    'tipebody_mobil_toyota'=>$row["4"], 
    'bb_mobil_toyota'=>$row["5"], 
    'transmisi_mobil_toyota'=>$row["6"], 
    'harga_mobil_toyota'=>$row["7"], 
    'data_topsis_toyota'=>$row["8"],
    'desc_mobil_toyota'=>$row["9"], 
    'alamat_dealer_mobil_toyota'=>$row["10"], 
    'no_tlp_mobil_toyota'=>$row["11"]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}