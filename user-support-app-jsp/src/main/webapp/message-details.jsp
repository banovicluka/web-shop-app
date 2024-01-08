<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ip.jsp.beans.MessageBean" %>
<jsp:useBean id="messageManager" class="ip.jsp.beans.MessageManager" scope="application"></jsp:useBean>
<jsp:useBean id="userBean" class="ip.jsp.beans.UserBean" scope="session"></jsp:useBean>
<%
	Integer messageId = Integer.parseInt(request.getParameter("id"));
	MessageBean message = messageManager.getMessageById(messageId);
	messageManager.setSeen(message);
	if(request.getParameter("submit") !=null){
		if(request.getParameter("replyContent")!=null){
			String replyContent = request.getParameter("replyContent");
			System.out.println("sasd");
			messageManager.sendReply(message.getSenderId(), replyContent, userBean);
			response.sendRedirect("main-page.jsp");
		}
	}
%>
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
	<img src="images/web-shop-logo-white.png" class="image"> 
	<h1 style="color:white">Detalji poruke</h1>
   
   <div>
       <h2 style="color:white">Subject: <%= message.getSubject() %></h2>
       <p style="color:white">From: <%= message.getSender() %></p>
       
       <p style="color:white"><%= message.getContent() %></p>
   </div>
   
   <h2 style="color:white">Odgovori</h2>
    <form method="post" action="message-details.jsp?id=<%= message.getId()%>">
        <input type="hidden" name="messageId" value="<%= message.getId() %>">
        <textarea  name="replyContent" rows="4" cols="50"></textarea>
        <br>
        <div class="display">
        <input type="submit" name="submit" value="Posalji odgovor" class="button-design">
        </div>
    </form>
    
    <a href="main-page.jsp" style="color:white">Povratak na inbox</a>
    </div>
</body>
</html>