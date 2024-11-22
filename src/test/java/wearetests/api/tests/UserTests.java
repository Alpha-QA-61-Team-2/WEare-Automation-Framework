package wearetests.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;
import wearetests.enums.TestData;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
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
        updateUserProfile(TestData.VALID_USER_ID.getValue());
        /*verifyStatusCodeIs200(response);
        verifyBodyContainsString(response, "id");*/
    }

    @Test
    public void req() {
        String cookie = getCookie();
        Response response = given()
                // Base URL
                // API Path
                .contentType(ContentType.JSON)
                .header("Accept", "*/*") // Header: Content-Type application/json
                .cookie("JSESSIONID", cookie)
                .body("""
        {
            "id": 0,
            "firstName": "Mилко",
            "lastName": "Антов",
            "sex": "MALE",
            "location": {},
            "birthYear": "2001-01-02",
            "personalReview": "",
            "memberSince": "2023-11-14T15:30:00",
            "picture": "",
            "picturePrivacy": true
        }
        """)                  // Request Body
                .post("http://localhost:8081/api/users/auth/49/personal") ;                       // POST Method

        response.then().log().body()
                .assertThat().statusCode(200);
    }
}
