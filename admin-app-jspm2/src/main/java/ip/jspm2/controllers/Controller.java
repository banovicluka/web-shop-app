package ip.jspm2.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ip.jspm2.beans.UserBean;

@WebServlet("/Controller")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = -7541893636374470928L;

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	request.setCharacterEncoding("UTF-8");
			String address = "/WEB-INF/login.jsp";
			String action = request.getParameter("action");
			HttpSession session = request.getSession();

			session.setAttribute("notification", "");

			if (action == null || action.equals("")) {
				address= "/WEB-INF/login.jsp";
			}else if(action.equals("logout")) {
				session.invalidate();
				address= "/WEB-INF/login.jsp";
			}else if(action.equals("login")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				UserBean userBean = new UserBean();
				if(userBean.login(username, password)) {
					session.setAttribute("userBean", userBean);
					System.out.println("asdasda");
					address= "/WEB-INF/menu.jsp";
				}else {
					session.setAttribute("notification", "Pogresni parametri za pristup");
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
	        
	    }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 doPost(request,response);
	 }

}
