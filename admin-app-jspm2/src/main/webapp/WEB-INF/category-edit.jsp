<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category edit</title>
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
.button-design{
	background-color:white;
	color:#3f51b5;
	border:0px;
	border-radius:4px;
	font-size:15px;
}
</style>
</head>
<body class="background">
	<div class="display">
	<img src="images/web-shop-logo-white.png" class="image" style="margin-bottom:7px">
	<form method="post" action="CategoryServlet?action=update" class="display">
	<div style="margin-bottom:7px">
    <input type="hidden" name="id" value="${category.id}">
    <label for="name" style="color:white;">Category Name:</label>
    <input type="text" name="name" value="${category.name}">
    </div>
    <input type="submit" value="Save" class="button-design"style="margin-bottom:7px;">
    <a href="CategoryServlet" style="color:white" style="margin-bottom:7px">Back</a>
    
</form>
</div>
</body>
</html>