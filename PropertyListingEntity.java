package application.Entity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PropertyListingEntity {
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username3 = "root";
	private String password2 = "zaw123";
	
	
	public ObservableList<Property> getAllPropertyListings () {
		 
		ObservableList<Property> a =FXCollections.observableArrayList();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username3, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT * FROM propertyListings;";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				      // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    while (resultSet.next()) {
				    	
				    	a.add(new Property(resultSet.getInt("id"),resultSet.getString("location"),resultSet.getInt("room"),resultSet.getString("propertyType"),resultSet.getString("propertyCondition"),resultSet.getDouble("price"),resultSet.getString("username1"),resultSet.getString("username2"),resultSet.getString("status")));
				    	
				        
				    } 
				    
				
			 } catch (SQLException e) {
		         e.printStackTrace();
		     } 
	         
		 } catch (SQLException e) {
	         System.out.println("Connection failed!");
	         e.printStackTrace();
		 }
		 return a;
	 }
	
	
	 public boolean createProperty (String location, int room, String propertyType, 
				String propertyCondition, double price, String username1, 
				String profile1, String username2, String profile2, String status) {
		 
		 int rowsAffected = 0;
		 
		 try {
	         Connection connection = DriverManager.getConnection(url, username3, password2);
	         
	         // Use this connection to execute queries
	         // connection.createStatement()...
	         Statement statement = null;

	         try {
	             statement = connection.createStatement();

	             String insert = "INSERT INTO propertyListings (location, room, propertyType, propertyCondition, price, username1, profile1, username2, profile2, status) VALUES ('" 
	             + location + "', '" + room + "', '" + propertyType + "', '" + propertyCondition + "', '" 
	             + price + "', '" + username1 + "', '" + profile1 + "', '" + username2 + "', '" + profile2 + "', '" + status + "');";
	             
	             rowsAffected = statement.executeUpdate(insert); 
	             
			 } catch (SQLException e) {
		         e.printStackTrace();
		     } finally {
	             // Close the statement in the finally block
	             if (statement != null) {
	                 try {
	                     statement.close();
	                 } catch (SQLException e) {
	                     e.printStackTrace();
	                 }
	             }
	         }
		 } catch (SQLException e) {
         System.out.println("Connection failed!");
         e.printStackTrace();
		 }
		 
		 if (rowsAffected > 0) {
             return true;
         } else {
             return false;
         }
	 }
	
	 
	 public boolean updateProperty (int id, String location, int room, String propertyType, 
				String propertyCondition, double price, String username1, 
				String profile1, String username2, String profile2, String status) {
		 
		 int rowsAffected = 0;
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username3, password2);
			 
			 try {
				// Define the SQL UPDATE statement with placeholders
				String sql = "UPDATE propertyListings SET location = ?, room = ?, propertyType = ?, propertyCondition = ?, price = ?, username1 = ?, profile1 = ?, username2 = ?, profile2 = ?, status = ? WHERE id = ?;";
				
				// Create a PreparedStatement with the SQL statement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				// Set new password and username for the update operation
				preparedStatement.setString(1, location);         
	            preparedStatement.setInt(2, room);             
	            preparedStatement.setString(3, propertyType);            
	            preparedStatement.setString(4, propertyCondition);     
	            preparedStatement.setDouble(5, price);      
	            preparedStatement.setString(6, username1);
	            preparedStatement.setString(7, profile1);
	            preparedStatement.setString(8, username2);     
	            preparedStatement.setString(9, profile2); 
	            preparedStatement.setString(10, status);
	            preparedStatement.setInt(11, id);
				
				// Execute the PreparedStatement to perform the update
				rowsAffected = preparedStatement.executeUpdate();
				
				
			 } catch (SQLException e) {
		         e.printStackTrace();
		     } 
	         
		 } catch (SQLException e) {
	         System.out.println("Connection failed!");
	         e.printStackTrace();
		 }
		 if (rowsAffected > 0) {
			return true;
		 } else {
			return false;
		 }
	 }
	 
	 
	 
}
