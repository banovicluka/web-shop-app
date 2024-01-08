package ip.jspm2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ip.jspm2.dto.Attribute;
import ip.jspm2.dto.Category;

public class AttributeDAO {

	public AttributeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Attribute> getAttributesOfCategory(Integer categoryId){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Attribute> attributes = new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.attribute where category_id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, categoryId.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Attribute attribute = new Attribute();
				attribute.setId(Integer.parseInt(resultSet.getString(1)));
				attribute.setName(resultSet.getString(2));
				attribute.setCategoryId(Integer.parseInt(resultSet.getString(3)));
				attributes.add(attribute);
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
		return attributes;
	}
	
	public static void insertAttribute(Attribute attribute) {
		
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
			String query = "INSERT INTO mydb.attribute (name,category_id) VALUES (?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, attribute.getName());
			preparedStatement.setString(2, attribute.getCategoryId().toString());
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
	
	public static void updateAttribute(Attribute attribute) {
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
			String query = "UPDATE mydb.attribute SET name = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, attribute.getName());
	        preparedStatement.setInt(2, attribute.getId());
	        
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
	
	public static void deleteAttribute(Integer attributeId) {
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
			String query = "DELETE FROM mydb.attribute WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, attributeId);
	        
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
	
	public static Attribute getAttributeById(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Attribute attribute = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.attribute where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				attribute = new Attribute();
				attribute.setId(Integer.parseInt(resultSet.getString(1)));
				attribute.setName(resultSet.getString(2));
				attribute.setCategoryId(Integer.parseInt(resultSet.getString(3)));
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
		return attribute;
	}
}
