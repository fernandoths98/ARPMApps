<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_honda ORDER BY data_topsis_honda ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array
    ('id_mobil_honda'=>$row["0"], 
    'link_img_honda'=>$row["1"], 
    'nama_mobil_honda'=>$row["2"], 
    'varian_mobil_honda'=>$row["3"], 
    'tipebody_mobil_honda'=>$row["4"], 
    'bb_mobil_honda'=>$row["5"], 
    'transmisi_mobil_honda'=>$row["6"], 
    'harga_mobil_honda'=>$row["7"], 
    'data_topsis_honda'=>$row["8"],
    'desc_mobil_honda'=>$row["9"], 
    'alamat_dealer_mobil_honda'=>$row["10"], 
    'no_tlp_mobil_honda'=>$row["11"]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}