package application.Entity;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {
	
	public static ObservableList<Property> retriveData() {
		ObservableList<Property> properties = null;
		BuyListEntity a = new BuyListEntity();
		ArrayList <Integer> savedProperties = a.getBuyList("buyer", "Buyer");
		for(int num:savedProperties) {
			System.out.println(num);
		}
		return properties;
		
	}
	public static ObservableList<Property> retriveData1() {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObservableList<Property> testData=Test.retriveData1();
		for(Property data:testData) {
			System.out.println(data.getPropertyId());
		}
	}

}
