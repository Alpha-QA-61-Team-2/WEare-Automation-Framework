package wearetests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;

import java.io.IOException;

import static com.weare.api.Requests.registerUser;

public class UserApiTests extends WEareBaseApiTest {

    private static final Response response;

    static {
        try {
            response = registerUser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyStatusCodeIs200() {
        Assertions.assertEquals(EXPECTED_STATUS_CODE, response.statusCode(), "Status code should be 200.");
    }

    @Test
    public void verifyBodyContainsString() {
        Assertions.assertTrue(response.body().asString().contains(REGISTRATION_CONFIRM_STRING),
                "Response body should contain '" + REGISTRATION_CONFIRM_STRING + "'.");
    }
}
