<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jspm2.dto.ShopUser" %>
<%@ page import="ip.jspm2.beans.ShopUserBean" %>
<jsp:useBean id="shopUserBean" type="ip.jspm2.beans.ShopUserBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
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
td,a,h1,h2,label {
	color:white;
}
</style>
</head>

<body class="background">
	<div class="display">
	<h1>Shop Users Management</h1>
    
    <h2>Create New User</h2>
    <form method="post" action="ShopUserServlet?action=create" style="display:flex;flex-direction:row">
    	<div class="display">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        </div>
         <div class=display>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
       
        <label for="pin">PIN:</label>
        <input type="text" id="pin" name="pin" required><br>
        
        <label for="active">Active:</label>
        <input type="checkbox" id="active" name="active"><br>
        </div>
        <div class="display">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <div class="display">
        <input type="submit" value="Create">
        </div>
        </div>
    </form>
    
    <h2>Existing Users</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>City</th>
            <th>Email</th>
            <th>PIN</th>
            <th>Active</th>
            <th>Username</th>
            <!-- <th>Password</th> -->
            <th>Actions</th>
        </tr>
        <% for(ShopUser user: shopUserBean.getAllShopUsers()) { %>
            <tr>
                <td ><%= user.getId() %></td>
                <td ><%= user.getFirstName() %></td>
                <td ><%= user.getLastName() %></td>
                <td ><%= user.getCity() %></td>
                <td ><%= user.getEmail() %></td>
                <td ><%= user.getPin() %></td>
                <td ><%= user.getActive() %></td>
                <td ><%= user.getUsername() %></td>
                <%-- <td ><%= user.getPassword() %></td> --%>
                <td>
                    <a href="ShopUserServlet?action=edit&id=<%= user.getId() %>">Edit</a>
                    <a href="ShopUserServlet?action=delete&id=<%= user.getId() %>">Delete</a>
                    
                </td>
            </tr>
        <% } %>
    </table>
    <h3><%= session.getAttribute("notification").toString() %></h3>
    <a href="ShopUserServlet?action=back">Back</a>
    </div>
</body>
</body>
</html>