package wearetests.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;
import wearetests.enums.TestData;

import java.io.IOException;

import static wearetests.api.Requests.*;

public class PostTests extends WEareBaseApiTest {

    private static Response response;

    @Test
    public void testCreatePost() throws IOException {
        response = createPost();
        System.out.println("Response Body: " + response.body().asString());
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void testEditPost() {
        response = editPost("66");
        response.then().log().ifValidationFails().statusCode(200);
    }

    @Test
    public void testDeletePost() {
     response = deletePost("66");
     response.then().assertThat().statusCode(200);
    }
}
