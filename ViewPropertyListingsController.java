package application.Controller;


import application.Entity.Property;
import application.Entity.PropertyListingEntity;
import application.Entity.UseraccountEntity;
import javafx.collections.ObservableList;

public class ViewPropertyListingsController {
	public static ObservableList<Property> retriveData() {
		PropertyListingEntity a = new PropertyListingEntity();
		ObservableList<Property> users = a.getAllPropertyListings();
		return users;
		
	}
	
}
