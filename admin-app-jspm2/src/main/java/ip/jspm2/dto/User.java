package ip.jspm2.dto;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -6864258041682507319L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	
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


	public User() {
		// TODO Auto-generated constructor stub
	}

}
