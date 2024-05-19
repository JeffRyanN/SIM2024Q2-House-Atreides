package application.Controller;


import java.util.ArrayList;

import application.Entity.AccountPass;
import application.Entity.Property;
import application.Entity.PropertyListingEntity;
import application.Entity.UseraccountEntity;
import application.Entity.BuyListEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageSavedPropertyController {
	public static ObservableList<Property> retriveData() {
		BuyListEntity a = new BuyListEntity();
		PropertyListingEntity property = new PropertyListingEntity();
		ObservableList<Property> allProperties = property.getAllPropertyListings();
		ObservableList<Property> savedPropertiesData = FXCollections.observableArrayList();
		ArrayList <Integer> savedPropertiesId = a.getBuyList(AccountPass.userName, AccountPass.profile);
		for(int id: savedPropertiesId) {
			System.out.print(id);
		}
		for(int id:savedPropertiesId) {
			for(Property property1:allProperties) {
				if(id == property1.getPropertyId()) {
					savedPropertiesData.add(property1);
				}
			}
		}
		
		return savedPropertiesData;
		
	}
	public static void deleteSavedProperty(String username,String profile,int id) {
		BuyListEntity a = new BuyListEntity();
		a.deleteProperty(username, profile, id);
	}
	
}
