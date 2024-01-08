<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jspm2.dto.Category" %>
<%@ page import="ip.jspm2.beans.CategoryBean" %>
<jsp:useBean id="categoryBean" type="ip.jspm2.beans.CategoryBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
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
.table{
	width:60%;
	height:60%;
	border-collapse:collapse;
}
th, td {
        border: 1px solid white;
        text-align: left;
        padding: 8px;
}
th{
	background-color:white;
	color:#3f51b5;
}
td,a {
	color:white;
}
</style>
</head>
<body class="background">
	<div class="display">
	<img src="images/web-shop-logo-white.png" class="image">
	<h1 style="color:white">Categories Management</h1>
    
    <h2 style="color:white">Create New Category</h2>
    <form method="post" action="CategoryServlet?action=create">
        <label for="categoryName" style="color:white">Category Name:</label>
        <input type="text" id="categoryName" name="categoryName" required>
        <input type="submit" value="Create" class="button-design">
    </form>
    
    <h2 style="color:white">Existing Categories</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <% for(Category category: categoryBean.getCategories()) { %>
            <tr>
                <td><%= category.getId() %></td>
                <td contenteditable="true"><%= category.getName() %></td>
                <td>
                    <a href="CategoryServlet?action=edit&id=<%= category.getId() %>">Edit</a>
					<a href="CategoryServlet?action=delete&id=<%= category.getId() %>">Delete</a>
					<a href="CategoryServlet?action=attributes&id=<%= category.getId() %>">Atributi</a>
                </td>
            </tr>
        <% } %>
    </table>
    <h3 style="color:white"><%= session.getAttribute("notification").toString() %></h3>
    <a href="CategoryServlet?action=back">Back</a>
    </div>
</body>
</html>