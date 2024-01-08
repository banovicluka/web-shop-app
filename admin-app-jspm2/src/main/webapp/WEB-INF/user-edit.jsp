<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User edit</title>
<style>
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
.button-design{
	background-color:white;
	color:#3f51b5;
	border:0px;
	border-radius:4px;
	font-size:15px;
}
label{
color:white;
}
</style>
</head>
<body class="background">
	<div class="display">
	<img src="images/web-shop-logo-white.png" class="image" style="margin-bottom:7px">
	<form method="post" action="ShopUserServlet?action=update">
    <input type="hidden" name="id" value="${user.id}">
    
    <label for="firstName">First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}" required><br>
    
    <label for="lastName">Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}" required><br>
    
    <label for="city">City:</label>
    <input type="text" name="city" value="${user.city}" required><br>
    
    <label for="email">Email:</label>
    <input type="email" name="email" value="${user.email}" required><br>
    
    <label for="pin">PIN:</label>
    <input type="text" name="pin" value="${user.pin}" required><br>
    
    <label for="active">Active:</label>
    <input type="checkbox" name="active" ${user.active ? 'profile active' : 'profile inactive'}><br>
    
    <label for="username">Username:</label>
    <input type="text" name="username" value="${user.username}" required><br>
    <%-- 
    <label for="password">Password:</label>
    <input type="password" name="password" value="${user.password}" required><br>
     --%>
     <div class="display"> 
    <input type="submit" value="Save" class="button-design">
    </div>
</form>

<a href="ShopUserServlet" style="color:white">Back</a>
</div>
	
</body>
</html>