package ip.jspm2.beans;

import java.io.Serializable;
import java.util.ArrayList;

import ip.jspm2.dao.ShopUserDAO;
import ip.jspm2.dto.ShopUser;

public class ShopUserBean implements Serializable {

	public ShopUserBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ShopUser> getAllShopUsers(){
		return ShopUserDAO.getAllShopUsers();
	}
	
	public void insertShopUser(ShopUser user) {
		ShopUserDAO.insertShopUser(user);
	}
	
	public void updateShopUser(ShopUser user) {
		ShopUserDAO.updateShopUser(user);
	}
	
	public void deleteShopUser(Integer userId) {
		ShopUserDAO.deleteUser(userId);
	}
	
	public ShopUser getShopUserById(Integer userId) {
		return ShopUserDAO.getShopUserById(userId);
	}

}
