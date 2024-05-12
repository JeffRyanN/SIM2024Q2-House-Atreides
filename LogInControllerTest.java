package application.Controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class LogInControllerTest {
    @Before
    public void setUp() throws Exception {
        new LogInController();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCheckLoginSuccess() throws IOException {
        String username = "admin";
        String password = "admin123";
        String profile = "Admin";
        assertEquals("Success", LogInController.checkLogin(username, password, profile));
    }

    @Test
    public void testCheckLoginEmptyFields() throws IOException {
        String username = "";
        String password = "";
        String profile = "Admin";
        assertEquals("Empty", LogInController.checkLogin(username, password, profile));
    }

    @Test
    public void testCheckLoginInvalidCredentials() throws IOException {
        String username = "invaliduser";
        String password = "invalidpassword";
        String profile = "Admin";
        assertEquals("Wrong", LogInController.checkLogin(username, password, profile));
    }
}
