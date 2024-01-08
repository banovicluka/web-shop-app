<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jsp.beans.MessageBean" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="messageManager" class="ip.jsp.beans.MessageManager" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h1 style="color:white">Primljene poruke</h1>
<table class="table">
	<tr>
		<th>ID</th>
		<th>Subject</th>
		<th>Status</th>
		<th>Sender</th>
		<th>Action</th>
	</tr>
	<%
		List<MessageBean> messages = messageManager.getMessages();
		for(MessageBean message: messages){
	%> 
		<tr>
			<td><%= message.getId() %></td>
			<td><%= message.getSubject() %></td>
			<% if(message.getStatus()){%>
			<td>Procitana</td>
			<%}else{ %>
			<td>Neprocitana</td>
			<%} %>
			
			<td><%= message.getSender()%></td>
			<td><a href="message-details.jsp?id=<%= message.getId()%>">Pogledaj</a></td>
		</tr>
	<%
		}	
	%>
</table>
</div>
</body>
</html>