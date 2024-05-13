package application.Controller;

import application.Entity.ProfileEntity;


public class ViewUserProfileController {

	public static boolean updateUserProfile(String name,String description){
		ProfileEntity a = new ProfileEntity();
		boolean result = a.updateProfile(name, description);
		return result;
		
	}
	
}
