package wearetests.api;


import io.restassured.response.Response;
import testframework.PropertiesManager;
import wearetests.core.WEareBaseApiTest;
import wearetests.core.WEareBaseWebTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Requests {


    public static Response registerUser() throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/register-user.json")))
                .post("/api/users/");
    }


    public static Response getUserById(String id) {
        return given()
                .cookie("JSESSIONID", WEareBaseApiTest.getSessionCookie())
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .get("/api/users/auth/" + id);
    }

    public static Response updateUserProfile(String id) throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", WEareBaseApiTest.getSessionCookie())
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/update-profile.json")))
                .post("/api/users/auth/" + id + "/personal");
    }
}
