package ip.jspm2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ip.jspm2.dto.Category;
import ip.jspm2.dto.ShopUser;
import org.mindrot.jbcrypt.BCrypt;

public class ShopUserDAO {

	public ShopUserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static ArrayList<ShopUser> getAllShopUsers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ShopUser> users = new ArrayList<ShopUser>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.user";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ShopUser user = new ShopUser();
				user.setId(Integer.parseInt(resultSet.getString(1)));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setCity(resultSet.getString(4));
				user.setEmail(resultSet.getString(6));
				user.setPin(resultSet.getInt(7));
				user.setActive(resultSet.getBoolean(8));
				user.setUsername(resultSet.getString(9));
				user.setPassword(resultSet.getString(10));
				users.add(user);
			
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
		return users;
	}
	
	public static void insertShopUser(ShopUser user) {
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
			String query = "INSERT INTO `mydb`.`user` (`first_name`, `last_name`, `city`, `avatar`, `email`, `pin`, `active`, `username`, `password`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?);";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getCity());
			preparedStatement.setString(4, "/");
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPin().toString());
			if(user.getActive()) {
				preparedStatement.setString(7, "1");
			}else {
				preparedStatement.setString(7, "0");
			}
			preparedStatement.setString(8, user.getUsername());
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			preparedStatement.setString(9, hashedPassword);
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
	
	public static void updateShopUser(ShopUser user) {
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
			String query = "UPDATE mydb.user SET first_name = ?,last_name=?,city=?,email=?,pin=?,active=?,username=? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, user.getFirstName());
	        preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getCity());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPin().toString());
			if(user.getActive()) {
				preparedStatement.setString(6, "1");
			}else {
				preparedStatement.setString(6, "0");
			}
			
			preparedStatement.setString(7, user.getUsername());
			preparedStatement.setString(8, user.getId().toString());
	        
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
	
	public static void deleteUser(Integer userId) {
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
			String query = "DELETE FROM mydb.user WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, userId);
	        
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
	
	public static ShopUser getShopUserById(Integer id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ShopUser user = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.user where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new ShopUser();
				user.setId(Integer.parseInt(resultSet.getString(1)));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setCity(resultSet.getString(4));
				user.setEmail(resultSet.getString(6));
				user.setPin(resultSet.getInt(7));
				user.setActive(resultSet.getBoolean(8));
				user.setUsername(resultSet.getString(9));
				String hashedPassword = BCrypt.hashpw(resultSet.getString(10), BCrypt.gensalt());
				user.setPassword(hashedPassword);
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
		return user;
	}
}
