package wearetests.api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import lombok.Getter;
import testframework.PropertiesManager;
import wearetests.core.WEareBaseApiTest;
import wearetests.core.WEareBaseWebTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class Requests {

    public static String getCookie() {
        Response loginResponse = given()
                .config(RestAssured.config().encoderConfig(encoderConfig()
                        .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("Content-Type"
                        , "multipart/form-data; boundary=<calculated when request is sent>")
                .formParam("username", "tanq")
                .formParam("password", "111111")
                .post("/authenticate");
        System.out.println(loginResponse.getCookie("JSESSIONID"));
        return loginResponse.getCookie("JSESSIONID");
    }


    public static Response registerUser() throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/register-user.json")))
                .log().all()
                .post("/api/users/");
    }


    public static Response getUserById(String id) {
        return given()
                .cookie("JSESSIONID", getCookie())
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .get("/api/users/auth/" + id);
    }

    public static void updateUserProfile(String id) throws IOException {
        Response response = given().contentType(APPLICATION_JSON)
                .header("Accept", "*/*")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .cookie("JSESSIONID", getCookie())
                .body("""
                        {
                            "id": 43,
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
                        """)
                .log().cookies()
                .log().all()
                .post("/api/users/auth/" + id + "/personal");

        response.then().log().body()
                .assertThat().statusCode(200);

        /*return given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", WEareBaseApiTest.getSessionCookie())
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/update-profile.json")))
                .post("/api/users/auth/" + id + "/personal");*/
    }


    public static Response createPost() throws IOException {
        return given()
                .header("Cookie", "JSESSIONID=" + WEareBaseApiTest.getSessionCookie())
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .header("Postman-Token", UUID.randomUUID().toString())
                //.cookie("JSESSIONID", WEareBaseApiTest.getSessionCookie())
                .baseUri("http://localhost:8081")
                .body("{\n" +
                        "  \"content\": \"API post creation ...\",\n" +
                        "  \"picture\": \"\",\n" +
                        "  \"public\": true\n" +
                        "}")
                .log().all()
                .post("/api/post/auth/creator");
    }

    public static Response editPost(String id) {
        return given()
                .header("Cookie", "JSESSIONID=" + WEareBaseApiTest.getSessionCookie())
                .header("Content-Type", "application/json")
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body("{\n" +
                        "  \"content\": \"Update post\",\n" +
                        "  \"picture\": \"string\",\n" +
                        "  \"public\": true\n" +
                        "}")
                .log().all()
                .put("/api/post/auth/editor?postId=" + id);
    }

    public static Response deletePost(String id) {
        return given()
                .header("Cookie", "JSESSIONID=" + WEareBaseApiTest.getSessionCookie())
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .delete("/api/post/auth/manager?postId=" + id);
    }
}
