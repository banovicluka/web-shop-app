package ip.jsp.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

//import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;


public class MessageManager implements Serializable {
	
	private ArrayList<MessageBean> messages = new ArrayList<MessageBean>();
	
	
	public ArrayList<MessageBean> getMessages() {
		messages.clear();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * from mydb.message";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MessageBean message = new MessageBean();
				message.setId(Integer.parseInt(resultSet.getString(1)));
				message.setSubject(resultSet.getString(2));
				message.setContent(resultSet.getString(3));
				if("0".equals(resultSet.getString(4))) {
					message.setStatus(false);
				}else {
					message.setStatus(true);
				}
				message.setSenderId(Integer.parseInt(resultSet.getString(6)));
				Integer userId = message.getSenderId();
				
				String query2 = "SELECT * FROM mydb.user where id = ?";
				preparedStatement = connection.prepareStatement(query2);
				preparedStatement.setString(1,userId.toString());
				resultSet2 = preparedStatement.executeQuery();
				if(resultSet2.next()) {
					message.setSender(resultSet2.getString(9));
				}
				messages.add(message);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(resultSet2!=null) resultSet2.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return messages;
	}

	public void setMessages(ArrayList<MessageBean> messages) {
		this.messages = messages;
	}
	
	public MessageBean getMessageById(Integer id) {
		for(MessageBean message: messages) {
			if(message.getId() == id) {
				return message;
			}
		}
		return null;
	}
	
	
	public void sendReply(Integer senderId,String replyContent,UserBean user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String email = "";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "SELECT * FROM user where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, senderId.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				email = resultSet.getString(6);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Use your SMTP server
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new Authenticator() 
				 {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("banovic456@gmail.com", "cgwidwvizkwaxtfd");
                    }
                });
		
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("banovic456@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email)); 
            message.setSubject("Reply to Your Message - WEB SHOP");
            message.setText(replyContent);

            Transport.send(message);
            System.out.println("as");
           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void setSeen(MessageBean message) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=CET",
					"root","rootroot");
			String query = "UPDATE `mydb`.`message` SET `seen` = '1' WHERE (`id` = ?)";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, message.getId().toString());
			preparedStatement.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	public MessageManager() {
		// TODO Auto-generated constructor stub
	}

}
