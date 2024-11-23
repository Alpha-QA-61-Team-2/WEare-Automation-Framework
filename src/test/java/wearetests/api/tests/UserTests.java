package wearetests.api.tests;


import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import wearetests.core.WEareBaseApiTest;


import java.io.IOException;

import static wearetests.api.requests.UserRequests.*;

public class UserTests extends WEareBaseApiTest {

    private static String userId;
    private static Response registerResponse;

    //todo find a way to pass newly registered user's creds to getCookie method in WEareApi
    @BeforeAll
    public static void setup() throws IOException {
        registerResponse = registerUser();
        userId = registerResponse.getBody().asString().split(" ")[6];
    }

    //todo fix below so that it can run multiple times
    @Test
    public void testUserRegistration() throws IOException {
        verifyStatusCodeIs200(registerResponse);
        verifyBodyContainsString(registerResponse, REGISTRATION_CONFIRM_STRING);
    }

    @Test
    public void testGetUserById() {
        Response response = getUserById("userId");
        verifyStatusCodeIs200(response);
    }

    @Test
    public void testUpdateUserProfile() throws IOException {
       Response response = updateUserProfile(userId);
        verifyStatusCodeIs200(response);
        Assert.assertNotNull(response.jsonPath().get("id"));
    }
}
