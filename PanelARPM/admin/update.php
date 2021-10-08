<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM tbl_allbrand WHERE id_mobilall='$_GET[id_mobilall]'";
  $res = mysqli_query($con,$sql);
  $result = array();
  echo json_encode(array("value"=>1,"result"=>$result));  
  mysqli_close($con);
}