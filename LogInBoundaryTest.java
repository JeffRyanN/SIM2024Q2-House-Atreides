package application.Boundary;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class LogInBoundaryTest extends JFrame {
    private LogInBoundaryTest loginPageUi;
    private boolean isTest;
    private JTextField loginIdField;
    private JTextField passwordField;
    private JButton btnLogin;
    private Object[] nameString;

    @Before
    public void start() throws Exception {
        this.loginPageUi = new LogInBoundaryTest();
        // Initialize UI components
        loginIdField = new JTextField();
        passwordField = new JTextField();
        btnLogin = new JButton();
    }


    @After
    public void end() throws Exception {
        this.loginPageUi.dispose();
    }

    @Test
    public void testLoginFailWrongId() {
        try {
            loginPageUi.isTest = true;
            Thread.sleep(1000);
            loginIdField.setText("incorrectUser");
            Thread.sleep(1000);
            passwordField.setText("incorrectPassword");
            Thread.sleep(1000);
            btnLogin.doClick();
            Thread.sleep(1000);
            // expected result is null as user does not exist thus name could not be found.
            assertEquals("testLoginFailWrongId", null, loginPageUi.nameString);
            Thread.sleep(1000);
            loginPageUi.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
