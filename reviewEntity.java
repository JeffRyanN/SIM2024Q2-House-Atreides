import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class reviewEntity {
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username3 = "root";
	private String password2 = "zaw123";
	
	public boolean createReview (String star, String review, String username1, String profile1, String username2, String profile2) {
	 
	 int rowsAffected = 0;
	 
	 try {
         Connection connection = DriverManager.getConnection(url, username3, password2);
         
         // Use this connection to execute queries
         // connection.createStatement()...
         Statement statement = null;

         try {
             statement = connection.createStatement();

             String insert = "INSERT INTO review (star, review, username1, profile1, username2, profile2) VALUES ('" 
             + star + "', '" + review + "', '" + username1 + "', '" + profile1 + "', '" 
             + username2 + "', '" + profile2 + "');";
             
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
	
	public ArrayList <review> getReviews (String username1, String profile1) {
		 
		 ArrayList <review> a = new ArrayList <review> ();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username3, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT * FROM review WHERE username1 = '" + username1 + "' AND profile1 = '" + profile1 + "';";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				      // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    while (resultSet.next()) {
				    	
				    	a.add(new review (resultSet.getInt("star"),resultSet.getString("review"),resultSet.getString("username2"),resultSet.getString("profile2")));
				    	
				        
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
	
}
