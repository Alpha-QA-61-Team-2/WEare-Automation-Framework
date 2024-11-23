package wearetests.api.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.weare.api.WEareApi.getCookie;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequests {

    public static Response createPost() throws IOException {
        return given()
                .cookie("JSESSIONID", getCookie())
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/create-post.json")))
                .post("/api/post/auth/creator");
    }

    public static Response editPost(String id) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .cookie("JSESSIONID", getCookie())
                .body("{\n" +
                        "  \"content\": \"Update post\",\n" +
                        "  \"picture\": \"string\",\n" +
                        "  \"public\": true\n" +
                        "}")
                .put("/api/post/auth/editor?postId=" + id);
    }

    public static Response deletePost(String id) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .cookie("JSESSIONID", getCookie())
                .delete("/api/post/auth/manager?postId=" + id);
    }

    public static Response getAllPosts() {
        return given()
                .baseUri(baseURI)
                .get("/api/post/");
    }
}
