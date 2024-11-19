package wearetests.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;
import wearetests.enums.TestData;

import java.io.IOException;

import static wearetests.api.Requests.*;

public class UserTests extends WEareBaseApiTest {

    private static Response response;

    @Test
    public void testUserRegistration() throws IOException {
        response = registerUser();
        verifyStatusCodeIs200(response);
        verifyBodyContainsString(response, REGISTRATION_CONFIRM_STRING);
    }

    @Test
    public void testGetUserById() {
        response = getUserById(TestData.VALID_USER_ID.getValue());
        verifyStatusCodeIs200(response);
    }

    @Test
    public void testUpdateUserProfile() throws IOException {
        response = updateUserProfile(TestData.VALID_USER_ID.getValue());
        verifyStatusCodeIs200(response);
        verifyBodyContainsString(response, "id");
    }
}
