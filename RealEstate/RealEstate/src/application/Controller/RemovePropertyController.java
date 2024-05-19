package application.Controller;

import application.Entity.PropertyListingEntity;

public class RemovePropertyController {
	private static PropertyListingEntity propertyListingEntity = new PropertyListingEntity();
	
	
	public static void removePropertyListing(int id) {
		propertyListingEntity.deleteProperty(id);
	}

}
