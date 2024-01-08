package ip.jsp.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 2095318015337247572L;
	
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	

	private Boolean loggedIn;
	

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String returnInfo() {
		return "username:" + this.getUsername() + " password:" + this.getPassword();
	}

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

}
