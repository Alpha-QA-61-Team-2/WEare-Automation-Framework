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

    @BeforeAll
    public static void setup() throws IOException {
        registerResponse = registerUser();
        userId = registerResponse.getBody().asString().split(" ")[6];
    }

    @Test
    public void testUserRegistration() {
        verifyStatusCodeIs200(registerResponse);
        verifyBodyContainsString(registerResponse, REGISTRATION_CONFIRM_STRING);
    }

    @Test
    public void testGetUserById() {
        Response response = getUserById(userId);
        verifyStatusCodeIs200(response);
    }


    //todo fix below
    @Test
    public void testUpdateUserProfile() throws IOException {
        Response response = updateUserProfile("41");
        verifyStatusCodeIs200(response);
        Assert.assertNotNull(response.jsonPath().get("id"));
    }

    @Test
    public void testSendFriendRequest() {
        Response response = sendFriendRequest();
        response.then().assertThat().statusCode(EXPECTED_STATUS_CODE);
    }


    //todo fix below or remove
    @Test
    public void testApproveFriendRequest() {
        Response response = approveFriendRequest("41", "29");
        response.then().assertThat().statusCode(EXPECTED_STATUS_CODE);
    }
}
