package application.Controller;

import application.Entity.PropertyListingEntity;

public class UpdatePropertyController {
	private static PropertyListingEntity propertyListingEntity = new PropertyListingEntity();
	
	public static void updateProperty(int id, String location, int room, String propertyType, 
			String propertyCondition, double price, String username1, 
			String profile1, String username2, String profile2, String status) {
		
		propertyListingEntity.updateProperty(id, location, room, propertyType, propertyCondition, price, username1, profile1, username2, profile2, status);
		
	}

}
