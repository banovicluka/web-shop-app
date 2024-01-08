package ip.jspm2.beans;

import java.io.Serializable;
import java.util.ArrayList;

import ip.jspm2.dao.CategoryDAO;
import ip.jspm2.dto.Category;

public class CategoryBean implements Serializable {

	private static final long serialVersionUID = -55328824047699748L;

	public CategoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Category> getCategories() {
		return CategoryDAO.getAllCategories();
	}
	
	public void insertCategory(Category category) {
		CategoryDAO.insertCategory(category);
	}
	
	public void updateCategory(Category category) {
		CategoryDAO.updateCategory(category);
	}
	
	public void deleteCategory(Integer categoryId) {
		CategoryDAO.deleteCategory(categoryId);
	}
	
	public Category getCategoryById(Integer id){
		return CategoryDAO.getCategoryById(id);
	}

}
