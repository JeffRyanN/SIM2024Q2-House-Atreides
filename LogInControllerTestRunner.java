package application.Controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LogInControllerTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LogInControllerTest.class);
        System.out.println("Is the test successful?: " + result.wasSuccessful());
        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }
}
