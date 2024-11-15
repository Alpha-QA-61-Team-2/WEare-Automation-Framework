package wearetests.core;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.core.BaseApiTest;


public class WEareBaseApiTest extends BaseApiTest {

    public static final int EXPECTED_STATUS_CODE = 200;
    public static final String REGISTRATION_CONFIRM_STRING = "was created";


    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }

    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }


    // close driver
    @AfterEach
    public void afterTest() {
        // perform some code after each test has finished
    }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }
}
