package wearetests.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class WEareBaseWebTest extends BaseWebTest {

    //Todo List all pages as fields

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts
        //Todo initialize all fields

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("sauceDemoBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
        // perform some code after each test has finished
    }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }

    // Extract methods that use multiple pages
    public void authenticateWithUser(String username, String pass) {

    }
}

