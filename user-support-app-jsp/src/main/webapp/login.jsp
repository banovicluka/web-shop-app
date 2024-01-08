<%@page import="ip.jsp.beans.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="userBean" class="ip.jsp.beans.UserBean" scope="session"></jsp:useBean>
    <jsp:useBean id="userManager" class="ip.jsp.beans.UserManager" scope="application"></jsp:useBean>
    <jsp:setProperty property="username" name="userBean" param="username"/>
    <jsp:setProperty property="password" name="userBean" param="password"/>
<!DOCTYPE html>
<%
	if(request.getParameter("submit")!=null){
		UserBean user= userManager.loginUser(userBean.getUsername(),userBean.getPassword());
		if(user !=null){
			userBean.setFirstName(user.getFirstName());
			userBean.setLastName(user.getLastName());
			userBean.setId(user.getId());
			userBean.setLoggedIn(true);
			session.setAttribute("notification", "");
			response.sendRedirect("main-page.jsp");
		}
		else{
			session.setAttribute("notification", "Unijeli ste neispravno korisnicko ime ili lozinku.");
			userBean.setLoggedIn(false);
		}
	}else{
		session.setAttribute("notification","");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>WEB SHOP</title>
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
<h1 style="color: #3f51b5;">Korisnicka podrska WEB SHOP</h1>
<h2 style="color: #3f51b5;">Prijava na sistem</h2>
<form method="post" action="login.jsp">
<input type="text" name="username" id="username" placeholder="Username" style="height:25px"><br/>
<input type="password"  name="password" id="password" placeholder="Password" style="height:25px"><br/>
<div class="display">
<input type="submit" name="submit" value="Enter" class="button-design">
</div>

</form>
</div>
<h3 style="color: #3f51b5;" class="display"><%=session.getAttribute("notification").toString() %></h3>
</body>
</html>








