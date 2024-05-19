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

public class ReviewEntity {
	private String url = "jdbc:mysql://localhost:3306/CSIT314";
	private String username3 = "root";
	private String password2 = "Py3rhbm7@";

	public boolean createReview(int star, String review, String username1, String profile1, String username2,
			String profile2) {

		int rowsAffected = 0;

		try {
			Connection connection = DriverManager.getConnection(url, username3, password2);

			// Use this connection to execute queries
			// connection.createStatement()...
			Statement statement = null;

			try {
				statement = connection.createStatement();

				String insert = "INSERT INTO review (star, review, username1, profile1, username2, profile2) VALUES ('"
						+ star + "', '" + review + "', '" + username1 + "', '" + profile1 + "', '" + username2 + "', '"
						+ profile2 + "');";

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
	// SELECT AVG( column_name ) FROM table_name;

	public ObservableList<Review> getReviews(String username1, String profile1) {

		ObservableList<Review> a = FXCollections.observableArrayList();

		try {
			Connection connection = DriverManager.getConnection(url, username3, password2);

			try {
				// Define the SQL SELECT statement with placeholders
				String sql = "SELECT * FROM review WHERE username1 = '" + username1 + "' AND profile1 = '" + profile1
						+ "';";

				// Create a PreparedStatement with the SQL statement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// Set the value for the parameter in the PreparedStatement
				// Specify the username to retrieve

				// Execute the PreparedStatement to perform the SELECT operation
				ResultSet resultSet = preparedStatement.executeQuery();

				// Process the ResultSet to retrieve account details
				while (resultSet.next()) {

					a.add(new Review(resultSet.getInt("star"), resultSet.getString("review"),
							resultSet.getString("username2"), resultSet.getString("profile2")));

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
	
	public int getAverageRatings() {
		int averageRating = 0;

		try {
			Connection connection = DriverManager.getConnection(url, username3, password2);

			// Use this connection to execute queries
			// connection.createStatement()...
			Statement statement = null;
			ResultSet resultSet = null;

			try {
				statement = connection.createStatement();
				//SELECT AVG( column_name ) FROM table_name;
				// SQL query to select all data from the buylist table
				String query = "SELECT AVG(star) FROM review;";

				resultSet = statement.executeQuery(query);

				// Process each row in the result set

				while (resultSet.next()) {
					averageRating = resultSet.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// Close the result set and statement in the finally block
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			connection.close(); // Remember to close the connection
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		return averageRating;
	}

}
