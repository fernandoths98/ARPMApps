<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;900&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300" rel="stylesheet">
	<script src="script.js"></script>
</head>
<body>
	<div class="containerr">
          <h1>Login</h1>
            <form method="POST" action="cek_login.php" onSubmit="return validasi()">
                <label>NPM</label><br>
                <input name="npm_mahasiswa" type="text" id="npm_mahasiswa"><br>
                <label>Password</label><br>
                <input type="password" name="password_mahasiswa" id="password_mahasiswa"><br>
                <button name="login" value="login">Log in</button>
                
            </form>
        </div>
<style>
 *{
    margin: 0;
    padding: 0;
    outline: 0;
    font-family: 'Open Sans', sans-serif;
}
body{
    height: 100vh;
    background-image: url(https://1.bp.blogspot.com/-9cAaPugMvkk/X7qXr4H5hqI/AAAAAAAAAH8/3d-XnEKRUg4obSR-bpLRU8OS-2k-wxJjgCNcBGAsYHQ/s1920/bg-masthead.jpg);
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}
p {
  color: white;
  font-family: 'Open Sans', sans-serif;
  padding-top: 10px;
}

h1 {
  text-align: center;
  padding-left: 100px;
  padding-bottom: 20px;
}

a {
  color: white;
  font-family: 'Open Sans', sans-serif;
}
.containerr{
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    padding: 20px 25px;
    width: 300px;

    background-color: rgba(0,0,0,.7);
    box-shadow: 0 0 10px rgba(255,255,255,.3);
}
.containerr h1{
    text-align: left;
    color: #fafafa;
    margin-bottom: 30px;
    text-transform: uppercase;
    border-bottom: 4px solid #752BEA;
}
.containerr label{
    text-align: left;
    color: #90caf9;
}
.containerr form input{
    width: calc(100% - 20px);
    padding: 8px 10px;
    margin-bottom: 15px;
    border: none;
    background-color: transparent;
    border-bottom: 2px solid #752BEA;
    color: #fff;
    font-size: 20px;
}
.containerr form button{
    width: 100%;
    height: 40px;
    padding: 5px 0;
    border: none;
    background-color:#752BEA;
    font-size: 18px;
    color: #fafafa;
    border-radius: 20px;
}



</style>

</body>
<script>
 $("#login-button").click(function(event){
		 event.preventDefault();
	 
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
});
</script>

<script type="text/javascript">
function validasi() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (user != "" && pass !="") {
	return true;
}else {
	alert('Username dan Password harus di isi !');
    return false;
        }
}
</script>

</html> 