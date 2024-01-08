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
import ip.jspm2.dto.Category;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet{

	private static final long serialVersionUID = 6677977153641269029L;

	public CategoryServlet() {
		super();
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 	request.setCharacterEncoding("UTF-8");
			String address = "/WEB-INF/category.jsp";
			String action = request.getParameter("action");
			HttpSession session = request.getSession();

			session.setAttribute("notification", "");
			session.setAttribute("categoryBean", new CategoryBean());

			if (action == null || action.equals("")) {
				address= "/WEB-INF/category.jsp";
			}else if( action.equals("create")) {
				
				CategoryBean categoryBean = new CategoryBean();
				Category category = new Category();
				category.setName(request.getParameter("categoryName"));
				categoryBean.insertCategory(category);
				session.setAttribute("categoryBean", categoryBean);
				address = "/WEB-INF/category.jsp";
				
			}else if(action.equals("edit")) {
				
				CategoryBean categoryBean = new CategoryBean();
				Category category = new Category();
				int categoryId = Integer.parseInt(request.getParameter("id"));
	            category = categoryBean.getCategoryById(categoryId);
	            request.setAttribute("category", category);
	            address = "/WEB-INF/category-edit.jsp";
	            
			}else if(action.equals("update")) {
				
				CategoryBean categoryBean = new CategoryBean();
				int categoryId = Integer.parseInt(request.getParameter("id"));
	            String newName = request.getParameter("name");
	            Category category = new Category();
	            category.setId(categoryId);
	            category.setName(newName);
	            categoryBean.updateCategory(category);
	            address="/WEB-INF/category.jsp";
	            
			}else if(action.equals("delete")) {
				CategoryBean categoryBean = new CategoryBean();
				int categoryId = Integer.parseInt(request.getParameter("id"));
				categoryBean.deleteCategory(categoryId);
				address="/WEB-INF/category.jsp";
			}else if(action.equals("attributes")) {
				int categoryId = Integer.parseInt(request.getParameter("id"));
				session.setAttribute("categoryId", categoryId);
				address="AttributeServlet";
			}else if(action.equals("back")) {
				address="/WEB-INF/menu.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 doPost(request,response);
	 }
	
	

}
