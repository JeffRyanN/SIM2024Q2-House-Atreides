package application;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LogInLogOutTest {

    private Map<String, Boolean> sessionMap;

    @Before
    public void setUp() {
        sessionMap = new HashMap<>();
    }

    @Test
    public void testAdminLoginSuccess() {
        assertEquals("Login success", login("admin", "admin", "admin123"));
    }

    @Test
    public void testAdminLoginFailIncorrectUsername() {
        assertEquals("Login fail", login("admin", "notAdmin", "admin123"));
    }

    @Test
    public void testAdminLoginFailIncorrectPassword() {
        assertEquals("Login fail", login("admin", "admin", "notAdmin123"));
    }

    @Test
    public void testAdminLoginFailIncorrectUsernameAndPassword() {
        assertEquals("Login fail", login("admin", "notAdmin", "notAdmin123"));
    }

    @Test
    public void testAdminLoginFailEmptyUsername() {
        assertEquals("Login fail", login("admin", "", "admin123"));
    }

    @Test
    public void testAdminLoginFailEmptyPassword() {
        assertEquals("Login fail", login("admin", "admin", ""));
    }

    @Test
    public void testBuyerLoginSuccess() {
        assertEquals("Login success", login("buyer", "buyer", "buyer123"));
    }

    @Test
    public void testBuyerLoginFailIncorrectUsername() {
        assertEquals("Login fail", login("buyer", "notBuyer", "buyer123"));
    }

    @Test
    public void testBuyerLoginFailIncorrectPassword() {
        assertEquals("Login fail", login("buyer", "buyer", "notBuyer123"));
    }

    @Test
    public void testBuyerLoginFailIncorrectUsernameAndPassword() {
        assertEquals("Login fail", login("buyer", "notBuyer", "notBuyer123"));
    }

    @Test
    public void testBuyerLoginFailEmptyUsername() {
        assertEquals("Login fail", login("buyer", "", "buyer123"));
    }

    @Test
    public void testBuyerLoginFailEmptyPassword() {
        assertEquals("Login fail", login("buyer", "buyer", ""));
    }

    @Test
    public void testSellerLoginSuccess() {
        assertEquals("Login success", login("seller", "seller", "seller123"));
    }

    @Test
    public void testSellerLoginFailIncorrectUsername() {
        assertEquals("Login fail", login("seller", "notSeller", "seller123"));
    }

    @Test
    public void testSellerLoginFailIncorrectPassword() {
        assertEquals("Login fail", login("seller", "seller", "notSeller123"));
    }

    @Test
    public void testSellerLoginFailIncorrectUsernameAndPassword() {
        assertEquals("Login fail", login("seller", "notSeller", "notSeller123"));
    }

    @Test
    public void testSellerLoginFailEmptyUsername() {
        assertEquals("Login fail", login("seller", "", "seller123"));
    }

    @Test
    public void testSellerLoginFailEmptyPassword() {
        assertEquals("Login fail", login("seller", "seller", ""));
    }

    @Test
    public void testAgentLoginSuccess() {
        assertEquals("Login success", login("agent", "agent", "agent123"));
    }

    @Test
    public void testAgentLoginFailIncorrectUsername() {
        assertEquals("Login fail", login("agent", "notAgent", "agent123"));
    }

    @Test
    public void testAgentLoginFailIncorrectPassword() {
        assertEquals("Login fail", login("agent", "agent", "notAgent123"));
    }

    @Test
    public void testAgentLoginFailIncorrectUsernameAndPassword() {
        assertEquals("Login fail", login("agent", "notAgent", "notAgent123"));
    }

    @Test
    public void testAgentLoginFailEmptyUsername() {
        assertEquals("Login fail", login("agent", "", "agent123"));
    }

    @Test
    public void testAgentLoginFailEmptyPassword() {
        assertEquals("Login fail", login("agent", "agent", ""));
    }

    @Test
    public void testAdminLogout() {
        login("admin", "admin", "admin123");
        assertEquals("Logout success", logout("admin"));
    }

    @Test
    public void testBuyerLogout() {
        login("buyer", "buyer", "buyer123");
        assertEquals("Logout success", logout("buyer"));
    }

    @Test
    public void testSellerLogout() {
        login("seller", "seller", "seller123");
        assertEquals("Logout success", logout("seller"));
    }

    @Test
    public void testAgentLogout() {
        login("agent", "agent", "agent123");
        assertEquals("Logout success", logout("agent"));
    }

    // Method to simulate login functionality
    private String login(String profileType, String username, String password) {
        if (checkLogin(profileType, username, password)) {
            sessionMap.put(profileType, true);
            return "Login success";
        } else {
            return "Login fail";
        }
    }

    // Method to validate login credentials
    private boolean checkLogin(String profileType, String username, String password) {
        switch (profileType) {
            case "admin":
                return username.equals("admin") && password.equals("admin123");
            case "buyer":
                return username.equals("buyer") && password.equals("buyer123");
            case "seller":
                return username.equals("seller") && password.equals("seller123");
            case "agent":
                return username.equals("agent") && password.equals("agent123");
            default:
                return false;
        }
    }

    // Method to simulate logout functionality
    private String logout(String profileType) {
        if (sessionMap.containsKey(profileType) && sessionMap.get(profileType)) {
            sessionMap.put(profileType, false);
            return "Logout success";
        } else {
            return "Logout fail";
        }
    }
}