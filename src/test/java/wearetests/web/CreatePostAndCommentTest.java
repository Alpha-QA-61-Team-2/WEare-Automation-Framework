package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreatePostAndCommentTest extends WEareBaseWebTest {

    public static final String ERROR_MESSAGE_IF_POST_IS_NOT_CREATED = "There is no post, containing the input text!";
    public static final String ERROR_MESSAGE_FOR_DATE_ASSERT = "Date of post is incorrect in the comment.";
    public static final String ERROR_MESSAGE_FOR_COMMENT_CONTENT = "Comment text does not match.";
    public static final String ERROR_MESSAGE_FOR_USERNAME = "Username is incorrect in the comment.";

    @Test
    @Order(1)
    public void createPostTest_when_validCredentialsProvided() {
        createPost();
        //Check that the confirmation message text matches the expected message content:
        assertTrue(postCreationEditPage.isSuccessMessageVisible(), ERROR_MESSAGE_IF_POST_IS_NOT_CREATED);
    }

    @Test
    @Order(2)
    public void createCommentTest_when_validCredentialsProvided() {
        createCommentLogic();

        //  Assert that the date in the meta element contains today’s date
        assertTrue(explorePostPage.isDateOfThePostCorrect(), ERROR_MESSAGE_FOR_DATE_ASSERT);
    }

    @Test
    @Order(3)
    public void createCommentTest_when_validCredentialsProvided1() {
        createCommentLogic();

        //  Assert that the comment text matches what was entered
        assertTrue(explorePostPage.isCommentTextCorrect(), ERROR_MESSAGE_FOR_COMMENT_CONTENT);
    }

    @Test
    @Order(4)
    public void createCommentTest_when_validCredentialsProvided2() {
        createCommentLogic();

        //Assert that the username is displayed correctly
        assertTrue(explorePostPage.isUsernameCorrectlyDisplayed(TestData.USER_1.getValue()), ERROR_MESSAGE_FOR_USERNAME);
    }

    private void createCommentLogic() {
        authenticateWithUser(TestData.USER_1.getValue());

        // find latest posts
        loggedHeader.clickLatestPost();
        loggedPostsPage.explorePost();

        //fill text in comment field and submit:
        explorePostPage.fillTextInCommentField();
        explorePostPage.submitComment();

        // click show comments button:
        explorePostPage.viewComments();
    }
}

