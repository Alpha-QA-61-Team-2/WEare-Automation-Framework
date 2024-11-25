package wearetests.api.requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import wearetests.enums.RandomDataType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.weare.api.WEareApi.getCookie;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserRequests {


    public static Response registerUser() throws IOException {
        String jsonBody = new String(Files.readAllBytes(Paths
                .get("src/test/resources/apitestdata/register-user.json")));
        return given().contentType(ContentType.JSON)
                .baseUri(baseURI)
                .body(jsonBody.replace("{{username}}", RandomDataType.generate(RandomDataType.USERNAME)))
                .post("/api/users/");
    }

    public static Response getUserById(String id) {
        return given()
                .cookie("JSESSIONID", getCookie())
                .baseUri(baseURI)
                .get("/api/users/auth/" + id);
    }

    public static Response updateUserProfile(String id) throws IOException {
       return  given().contentType(ContentType.JSON)
                .cookie("JSESSIONID", getCookie())
                .baseUri(baseURI)
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/update-profile.json")))
                .post("/api/users/auth/" + id + "/personal");
    }


    public static Response sendFriendRequest() {
        return given().contentType(ContentType.JSON)
                .cookie("JSESSIONID", getCookie())
                .baseUri(baseURI)
                .body("{\n" +
                        "  \"id\": 40,\n" +
                        "  \"username\": \"\"\n" +
                        "}")
                .post("/api/auth/request");
    }

    public static Response approveFriendRequest(String senderId, String requestId) {
        return given().contentType(ContentType.JSON)
                .cookie("JSESSIONID", getCookie())
                .baseUri(baseURI)
                .post("/api/auth/users/ " + senderId + "/request/approve?requestId=" + requestId);
    }
}
