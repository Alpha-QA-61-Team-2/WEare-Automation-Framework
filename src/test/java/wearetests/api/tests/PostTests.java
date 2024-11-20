package wearetests.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;

import java.io.IOException;

import static wearetests.api.Requests.createPost;

public class PostTests extends WEareBaseApiTest {

    private static Response response;

    @Test
    public void testCreatePost() throws IOException {
        response = createPost();
        System.out.println("Response Body: " + response.body().asString());
        response.then().assertThat().statusCode(200);
    }
}
