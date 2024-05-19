package application.Controller;


import application.Entity.BuyListEntity;
import application.Entity.Property;
import application.Entity.PropertyListingEntity;
import application.Entity.UseraccountEntity;
import application.Entity.BuyListEntity;
import javafx.collections.ObservableList;

public class ViewPropertyListingsController {
	public static ObservableList<Property> retriveData() {
		PropertyListingEntity a = new PropertyListingEntity();
		ObservableList<Property> users = a.getAllPropertyListings();
		return users;
		
	}
	public static void saveProperty(String username,String profile,int id) {
		BuyListEntity a = new BuyListEntity();
		a.saveProperty(username, profile, id);
	}
	
	public static void viewProperty() {
		BuyListEntity a = new BuyListEntity();
		a.viewProperty();
	}
	
}
