package wearetests.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseApiTest;

import java.io.IOException;

import static org.hamcrest.Matchers.notNullValue;
import static wearetests.api.requests.PostRequests.*;

public class PostTests extends WEareBaseApiTest {

    private static int postId;
    private static Response createResponse;

    @BeforeAll
    public static void setUp() throws IOException {
        createResponse = createPost();
        postId = createResponse.jsonPath().getInt("postId");
    }

    @AfterAll
    public static void tearDown() throws IOException {
        deletePost(String.valueOf(postId));
    }

    @Test
    public void testGetAllPosts() {
        Response response = getAllPosts();
        verifyStatusCodeIs200(response);
        verifyBodyContainsString(response,"id");
    }

    @Test
    public void testCreatePost() throws IOException {
        createResponse.then().assertThat().statusCode(EXPECTED_STATUS_CODE)
                .assertThat().body("postId", notNullValue());
    }

    @Test
    public void testEditPost() {
        Response response = editPost(String.valueOf(postId));
        response.then().log().ifValidationFails().statusCode(EXPECTED_STATUS_CODE);
    }

    @Test
    public void testDeletePost() {
     Response response = deletePost(String.valueOf(postId));
     response.then().assertThat().statusCode(EXPECTED_STATUS_CODE);
    }
}
