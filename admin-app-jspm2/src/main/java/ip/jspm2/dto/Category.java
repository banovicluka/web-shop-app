package ip.jspm2.dto;

import java.io.Serializable;

public class Category implements Serializable{

	private static final long serialVersionUID = -8114238926128491404L;
	
	private Integer id;
	private String name;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
