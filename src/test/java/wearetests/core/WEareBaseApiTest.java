package wearetests.core;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import org.junit.jupiter.api.*;
import testframework.PropertiesManager;
import testframework.core.BaseApiTest;
import wearetests.api.Requests;
import wearetests.enums.TestData;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;


public class WEareBaseApiTest extends BaseApiTest {

    public static final int EXPECTED_STATUS_CODE = 200;
    public static final String REGISTRATION_CONFIRM_STRING = "was created";

    @Getter
    private static String sessionCookie;

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
        RestAssured.baseURI = PropertiesManager.getConfigProperties().getProperty("weareBaseUrl");

        /*Response loginResponse = given()
                .config(RestAssured.config().encoderConfig(encoderConfig()
                        .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("Content-Type"
                        , "multipart/form-data; boundary=<calculated when request is sent>")
                .formParam("username", "milko")
                .formParam("password", "123456")
                .post("/authenticate");
        sessionCookie = loginResponse.getCookie("JSESSIONID");
        System.out.println("Login response status: " + loginResponse.getStatusCode());
        System.out.println("Session cookie: " + sessionCookie);*/
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

    protected void verifyStatusCodeIs200(Response response) {
        Assertions.assertEquals(EXPECTED_STATUS_CODE, response.statusCode(), "Status code should be 200.");
    }

    protected void verifyBodyContainsString(Response response, String s) {
        Assertions.assertTrue(response.body().asString().contains(s),
                "Response body should contain '" + s + "'.");
    }
}
