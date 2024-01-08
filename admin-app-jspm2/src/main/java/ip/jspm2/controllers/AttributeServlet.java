package ip.jspm2.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ip.jspm2.beans.AttributeBean;
import ip.jspm2.beans.CategoryBean;
import ip.jspm2.dto.Attribute;
import ip.jspm2.dto.Category;

@WebServlet("/AttributeServlet")
public class AttributeServlet extends HttpServlet{

	public AttributeServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/attribute.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		session.setAttribute("notification", "");
		session.setAttribute("attributeBean", new AttributeBean());

		if (action == null || action.equals("")) {
			address= "/WEB-INF/attribute.jsp";
		}else if(action.equals("create")) {
			AttributeBean attributeBean = new AttributeBean();
			Attribute attribute = new Attribute();
			attribute.setName(request.getParameter("attributeName"));
			attribute.setCategoryId((Integer)session.getAttribute("categoryId"));
			attributeBean.insertAttribute(attribute);
			session.setAttribute("attributeBean", attributeBean);
			address = "/WEB-INF/attribute.jsp";
		}else if(action.equals("edit")) {
			AttributeBean attributeBean = new AttributeBean();
			Attribute attribute = new Attribute();
			int attributeId = Integer.parseInt(request.getParameter("id"));
            attribute = attributeBean.getAttributeById(attributeId);
            request.setAttribute("attribute", attribute);
            address = "/WEB-INF/attribute-edit.jsp";
		}else if(action.equals("update")) {
			AttributeBean attributeBean = new AttributeBean();
			int attributeId = Integer.parseInt(request.getParameter("id"));
            String newName = request.getParameter("name");
            Attribute attribute = new Attribute();
            attribute.setId(attributeId);
            attribute.setName(newName);
            attributeBean.updateAttribute(attribute);
            address="/WEB-INF/attribute.jsp";
		}else if(action.equals("delete")) {
			AttributeBean attributeBean = new AttributeBean();
			int attributeId = Integer.parseInt(request.getParameter("id"));
			attributeBean.deleteAttribute(attributeId);
			address="/WEB-INF/attribute.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
