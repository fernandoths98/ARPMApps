<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_toyota WHERE id_mobil_toyota='$_GET[id_mobil_toyota]'";
  $res = mysqli_query($con,$sql);
  $result = array();
  echo json_encode(array("value"=>1,"result"=>$result));  
  mysqli_close($con);
}