package application.Entity;

public class Profile {

	private String name = "null";
	private String description = "null";
	
	public Profile() {
		
	}
	
	public Profile(String name, String description) {
		
		this.name = name;
		this.description = description;
		
	}
	
	//Get values
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Set values
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}