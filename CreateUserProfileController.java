package application.Controller;

import application.Entity.ProfileEntity;
import application.Entity.UseraccountEntity;

public class CreateUserProfileController {

	public static boolean createProfile(String name, String description) {
		ProfileEntity a = new ProfileEntity();
		boolean result = a.createAccount(name, description);
		return result;
	}
	
}
