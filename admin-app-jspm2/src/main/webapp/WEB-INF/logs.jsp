<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jspm2.beans.LogsBean" %>
<%@ page import="ip.jspm2.dto.Log" %>
<jsp:useBean id="logsBean" type="ip.jspm2.beans.LogsBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logs</title>
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
<body>
<body class="background">
	<div class="display">
	<img src="images/web-shop-logo-white.png" class="image">
	<h1 style="color:white">Logs Management</h1>
	<a href="LogsServlet?action=back">Back</a>
	<h2 style="color:white">Logs table</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Date</th>
            <th>Action</th>
        </tr>
        <% for(Log log: logsBean.getAllLogs()) { %>
            <tr>
                <td><%= log.getId() %></td>
                <td><%= log.getUsername() %></td>
                <td><%= log.getDate() %></td>
                <td><%= log.getAction() %></td>
            </tr>
        <% } %>
    </table>
    
    
	</div>
</body>
</html>