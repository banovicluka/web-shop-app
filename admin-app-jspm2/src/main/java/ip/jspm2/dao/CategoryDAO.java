package ip.jspm2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ip.jspm2.dto.Category;
import ip.jspm2.dto.User;

public class CategoryDAO {

	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static public ArrayList<Category> getAllCategories(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Category> categories = new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.category";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Category category = new Category();
				category.setId(Integer.parseInt(resultSet.getString(1)));
				category.setName(resultSet.getString(2));
				categories.add(category);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return categories;
	}
	
	static public void insertCategory(Category category) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "INSERT INTO mydb.category (name) VALUES (?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category.getName());
			preparedStatement.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			try {
			
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public static void updateCategory(Category category) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "UPDATE mydb.category SET name = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, category.getName());
	        preparedStatement.setInt(2, category.getId());
	        
	        preparedStatement.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			try {
			
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void deleteCategory(Integer categoryId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "DELETE FROM mydb.category WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, categoryId);
	        
	        preparedStatement.executeUpdate();;
	        
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			try {
			
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static Category getCategoryById(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Category category = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.category where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				category = new Category();
				category.setId(Integer.parseInt(resultSet.getString(1)));
				category.setName(resultSet.getString(2));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return category;
		
	}
	
	
	
}
