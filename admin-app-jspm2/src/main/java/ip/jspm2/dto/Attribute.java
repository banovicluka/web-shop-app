package ip.jspm2.dto;

import java.io.Serializable;

public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 4564681314884717822L;
	private Integer id;
	private String name;
	private Integer categoryId;

	
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
	public Attribute() {
		// TODO Auto-generated constructor stub
	}

}
