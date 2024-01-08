package ip.jspm2.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ip.jspm2.beans.CategoryBean;
import ip.jspm2.beans.LogsBean;

@WebServlet("/LogsServlet")
public class LogsServlet extends HttpServlet{

	public LogsServlet() {
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/logs.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		session.setAttribute("notification", "");
		session.setAttribute("logsBean", new LogsBean());
		
		if (action == null || action.equals("")) {
			address= "/WEB-INF/logs.jsp";
		}else if(action.equals("back")) {
			address="/WEB-INF/menu.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	

}
