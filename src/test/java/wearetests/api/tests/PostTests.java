package wearetests.api.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseApiTest;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static wearetests.api.requests.PostRequests.*;
import static wearetests.api.requests.PostRequests.deleteComment;

public class PostTests extends WEareBaseApiTest {

    private static int postId;
    private static Response createResponse;

    @BeforeEach
    public void setUp() throws IOException {
        createResponse = createPost();
        postId = createResponse.jsonPath().getInt("postId");
    }

    @AfterEach
    public void tearDown() {
        deletePost(String.valueOf(postId));
    }

    @Test
    public void testGetAllPosts() {
        Response response = getAllPosts();
        verifyStatusCodeIs200(response);
        verifyBodyContainsString(response,"id");
    }

    @Test
    public void testCreatePost() {
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

    @Test
    public void testLikeUnlikePost() {
        Response response = likeUnlikePost(String.valueOf(postId));
        response.then().assertThat().statusCode(EXPECTED_STATUS_CODE)
                .assertThat().body("postId", equalTo(postId));
    }

    @Test
    public void testAddComment() throws IOException {
        Response response = addComment(String.valueOf(postId));
        response.then().assertThat().statusCode(EXPECTED_STATUS_CODE)
                .assertThat().body("commentId", notNullValue());
        deleteComment(String.valueOf(response.jsonPath().getInt("commentId")));
    }

    @Test
    public void testLikeUnlikeComment() throws IOException {
        int commentId = addComment(String.valueOf(postId)).jsonPath().getInt("commentId");
        Response response = likeUnlikeComment(String.valueOf(commentId));
        response.then().assertThat().statusCode(EXPECTED_STATUS_CODE)
                .assertThat().body("commentId", equalTo(commentId));
        deleteComment(String.valueOf(commentId));
    }
}
