<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin menu</title>
<style type="text/css">
.background{
	background-color:#3f51b5;
	width:100%;
	height:100%;
}
.display{
	display: flex;
	flex-direction: column;
	align-items:center;
	justify-content:center;
	margin:10px;
}

.image{
	width:600px;
	height:150px;
}
a,li{
	color:white;
	font-size:50px;
	text-decoration:none;
}
</style>
</head>
<body class="background">
  <div class="display">
  	<img src="images/web-shop-logo-white.png" class="image" style="margin-bottom:60px">
  	<h2 style="color:white;font-size:55px">Administratorske akcije:</h2>
  	<ul>
        <li><a href="CategoryServlet" style="margin-bottom:15px">Kategorije</a></li>
        <li><a href="ShopUserServlet" style="margin-bottom:15px">Korisnici</a></li>
        <li><a href="LogsServlet">Statistika</a></li>
  </ul>
  </div>
  
</body>
</html>