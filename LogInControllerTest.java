import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LogInControllerTest {
    private LogInController testSubject;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new LogInController();
    }

    @After
    public void tearDown() throws Exception {
        testSubject = null;
    }

    @Test
    public void testCheckLoginSuccess() throws IOException {
        String username = "testuser";
        String password = "testpassword";
        String profile = "Admin";
        assertEquals("Success", testSubject.checkLogin(username, password, profile));
    }

    @Test
    public void testCheckLoginEmptyFields() throws IOException {
        String username = "";
        String password = "";
        String profile = "Admin";
        assertEquals("Empty", testSubject.checkLogin(username, password, profile));
    }

    @Test
    public void testCheckLoginInvalidCredentials() throws IOException {
        String username = "invaliduser";
        String password = "invalidpassword";
        String profile = "Admin";
        assertEquals("Wrong", testSubject.checkLogin(username, password, profile));
    }
}
