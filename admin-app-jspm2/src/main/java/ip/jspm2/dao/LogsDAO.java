package ip.jspm2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ip.jspm2.dto.Category;
import ip.jspm2.dto.Log;

public class LogsDAO {

	public LogsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static public ArrayList<Log> getAllLogs(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Log> logs = new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.log";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Log log = new Log();
				log.setId(Integer.parseInt(resultSet.getString(1)));
				log.setUsername(resultSet.getString(2));
				log.setDate(resultSet.getString(3));
				log.setAction(resultSet.getString(4));
				logs.add(log);
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
		return logs;
	}
	

}
