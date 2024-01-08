package ip.jspm2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ip.jspm2.dto.User;

public class UserDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static public User findUserByUsernameAndPassword(String username,String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.administrator where username= ? and password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setId(Integer.parseInt(resultSet.getString(1)));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setUsername(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
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
