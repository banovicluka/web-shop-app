package ip.jspm2.beans;

import java.io.Serializable;
import java.util.ArrayList;

import ip.jspm2.dao.AttributeDAO;
import ip.jspm2.dto.Attribute;

public class AttributeBean implements Serializable {

	public AttributeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Attribute> getAllAttributesOfCategory(Integer categoryId){
		return AttributeDAO.getAttributesOfCategory(categoryId);
	}
	
	public void insertAttribute(Attribute attribute) {
		AttributeDAO.insertAttribute(attribute);
	}
	
	public void updateAttribute(Attribute attribute) {
		AttributeDAO.updateAttribute(attribute);
	}
	
	public void deleteAttribute(Integer attributeId) {
		AttributeDAO.deleteAttribute(attributeId);
	}
	
	public Attribute getAttributeById(Integer id) {
		return AttributeDAO.getAttributeById(id);
	}
}
