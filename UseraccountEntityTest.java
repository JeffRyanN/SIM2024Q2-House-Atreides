package application.Entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UseraccountEntityTest {
    private static final String TEST_DB_URL = "jdbc:mysql://localhost:3306/CSIT314";
    private static final String TEST_DB_USERNAME = "root";
    private static final String TEST_DB_PASSWORD = "Py3rhbm7@";

    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        // Connect to the test database
        connection = DriverManager.getConnection(TEST_DB_URL, TEST_DB_USERNAME, TEST_DB_PASSWORD);

        // Create necessary tables or initialize test data
        createTestTables();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        // Close the database connection after all tests
        if (connection != null) {
            connection.close();
        }
    }
    
    private static void createTestTables() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Drop the table if it exists
            statement.executeUpdate("DROP TABLE IF EXISTS Accounts");

            // Create the Accounts table
            statement.executeUpdate("CREATE TABLE Accounts (username VARCHAR(255), password VARCHAR(255), name VARCHAR(255), email VARCHAR(255), phone_number VARCHAR(255), agency_name VARCHAR(255), license_number VARCHAR(255), profile VARCHAR(255), status VARCHAR(255))");

            // Insert test data
            statement.executeUpdate("INSERT INTO Accounts (username, password, name, email, phone_number, agency_name, license_number, profile, status) VALUES ('admin', 'admin123', 'Admin Name', 'admin@example.com', '1234567890', 'Agency', 'License123', 'Admin', 'active')");
        }
    }

    @Test
    public void testCheckLogin_ValidCredentials() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        // Perform test operation
        boolean result = useraccountEntity.checkLogin("admin", "admin123", "Admin");

        // Assert the result
        assertTrue("Login with valid credentials failed", result);
    }
    
    @Test
    public void testCheckUsername_ExistingUsername() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        boolean result = useraccountEntity.checkUsername("admin");

        assertTrue("Checking existing username failed", result);
    }

    @Test
    public void testCheckUsername_NonExistingUsername() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        // Perform test operation
        boolean result = useraccountEntity.checkUsername("non_existing_username");

        // Assert the result
        assertFalse("Checking non-existing username failed", result);
    }

    @Test
    public void testGetUser_ExistingUsername() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        // Perform test operation
        Useraccount user = useraccountEntity.getUser("admin");

        // Assert the result
        assertFalse("Getting user details for existing username should not return null", user == null);
    }

    @Test
    public void testGetUser_NonExistingUsername() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        // Perform test operation
        Useraccount user = useraccountEntity.getUser("non_existing_username");

        // Assert the result
        assertNull("Getting user details for non-existing username should return null", user);
    }

    @Test
    public void testUpdateAccount_ExistingUsername() throws Exception {
        UseraccountEntity useraccountEntity = new UseraccountEntity();

        // Perform test operation
        boolean result = useraccountEntity.updateAccount("admin", "new_password", "New Name", "new_email@example.com", "9876543210", "New Agency", "New License", "Admin", "active");

        // Assert the result
        assertTrue("Updating existing account failed", result);
    }
}
