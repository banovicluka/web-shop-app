<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
<style type="text/css">
.image{
	width: 270px;
    height: 220px;
}
.display{
	display: flex;
	flex-direction: column;
	align-items:center;
	justify-content:center;
	margin:10px;
}
.button-design{
	background-color: #3f51b5;
	color:white;
	border:0px;
	border-radius:4px
}
</style>
</head>
<body>
	<div class="display">
	<img src="images/web-shop-logo-blue.png" class="image">
	<h1 style="color: #3f51b5;">Administratorska aplikacija WEB SHOP</h1>
	<h2 style="color: #3f51b5;">Prijava na sistem</h2>
	<form method="post" action="?action=login">
        <input type="text" name="username" placeholder="Username" style="height:25px"><br>
        <input type="password" name="password" placeholder="Password" style="height:25px"><br>
        <input type="submit" value="Log In" class="button-design">
    </form>
    </div>
</body>
</html>