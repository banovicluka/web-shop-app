<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jspm2.dto.Attribute" %>
<%@ page import="ip.jspm2.beans.AttributeBean" %>
<jsp:useBean id="attributeBean" type="ip.jspm2.beans.AttributeBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attributes</title>
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
	<h1 style="color:white">Attributes Management</h1>
    
    <h2 style="color:white">Create New Attribute</h2>
    <form method="post" action="AttributeServlet?action=create">
        <label for="attributeName" style="color:white">Attribute Name:</label>
        <input type="text" id="attributeName" name="attributeName" required>
        <input type="submit" value="Create" class="button-design">
    </form>
    
    <h2 style="color:white">Existing Attributes</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <% for(Attribute attribute: attributeBean.getAllAttributesOfCategory((Integer)session.getAttribute("categoryId"))) { %>
            <tr>
                <td><%= attribute.getId() %></td>
                <td ><%= attribute.getName() %></td>
                <td>
                    <a href="AttributeServlet?action=edit&id=<%= attribute.getId() %>">Edit</a>
					<a href="AttributeServlet?action=delete&id=<%= attribute.getId() %>">Delete</a>
					
                </td>
            </tr>
        <% } %>
    </table>
    <h3 style="color:white"><%= session.getAttribute("notification").toString() %></h3>
    <a href="CategoryServlet" style="color:white">Back</a>
    </div>
</body>
</html>