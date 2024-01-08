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
import ip.jspm2.beans.ShopUserBean;
import ip.jspm2.dto.Category;
import ip.jspm2.dto.ShopUser;

@WebServlet("/ShopUserServlet")
public class ShopUserServlet extends HttpServlet{

	private static final long serialVersionUID = -2469656399462091023L;

	public ShopUserServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/user.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		session.setAttribute("notification", "");
		session.setAttribute("shopUserBean", new ShopUserBean());

		if (action == null || action.equals("")) {
			address= "/WEB-INF/user.jsp";
		}else if( action.equals("create")) {
			
			ShopUserBean shopUserBean = new ShopUserBean();
			ShopUser shopUser = new ShopUser();
			shopUser.setFirstName(request.getParameter("firstName"));
			shopUser.setLastName(request.getParameter("lastName"));
			shopUser.setCity(request.getParameter("city"));
			shopUser.setEmail(request.getParameter("email"));
			shopUser.setActive(Boolean.parseBoolean(request.getParameter("active")));
			shopUser.setPin(Integer.parseInt(request.getParameter("pin")));
			shopUser.setUsername(request.getParameter("username"));
			shopUser.setPassword(request.getParameter("password"));
		
			shopUserBean.insertShopUser(shopUser);
			session.setAttribute("shopUserBean", shopUserBean);
			address = "/WEB-INF/user.jsp";
			
		}else if(action.equals("edit")) {
			
			ShopUserBean shopUserBean = new ShopUserBean();
			ShopUser shopUser = new ShopUser();
			int userId = Integer.parseInt(request.getParameter("id"));
            shopUser = shopUserBean.getShopUserById(userId);
            request.setAttribute("user", shopUser);
            address = "/WEB-INF/user-edit.jsp";
            
		}else if(action.equals("update")) {
			
			ShopUserBean shopUserBean = new ShopUserBean();
			int userId = Integer.parseInt(request.getParameter("id"));
			ShopUser shopUser = new ShopUser();
			shopUser.setId(userId);
			shopUser.setFirstName(request.getParameter("firstName"));
			shopUser.setLastName(request.getParameter("lastName"));
			shopUser.setCity(request.getParameter("city"));
			shopUser.setEmail(request.getParameter("email"));
			shopUser.setActive(Boolean.parseBoolean(request.getParameter("active")));
			shopUser.setPin(Integer.parseInt(request.getParameter("pin")));
			shopUser.setUsername(request.getParameter("username"));
			//shopUser.setPassword(request.getParameter("password"));
            shopUserBean.updateShopUser(shopUser);
            address="/WEB-INF/user.jsp";
            
		}else if(action.equals("delete")) {
			ShopUserBean shopUserBean = new ShopUserBean();
			int userId = Integer.parseInt(request.getParameter("id"));
			shopUserBean.deleteShopUser(userId);
			address="/WEB-INF/user.jsp";
		}else if(action.equals("back")) {
			address="/WEB-INF/menu.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

}
