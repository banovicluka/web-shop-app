package ip.jspm2.beans;

import ip.jspm2.dao.UserDAO;
import ip.jspm2.dto.User;

public class UserBean {
	
	User user = new User();
	Boolean isLoggedIn=false;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean login(String username, String password) {
		user = UserDAO.findUserByUsernameAndPassword(username, password);
		if( user != null) {
			isLoggedIn = true;
			return true;
		}
		return false;
	}
	
	public Boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	public User getUser() {
		return user;
	}

}
