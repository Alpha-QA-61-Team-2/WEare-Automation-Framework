package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static com.weare.pages.ExplorePostPage.*;
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
        //1 login
        authenticateWithUser(TestData.USER_1.getValue());
        // 2 find element post in navigation bar and click it:
        homePage.clickAddNewPost();
        // 3 Scroll down:
        postCreationEditPage.scrollDown();
        // 4 select public post and fill body of the post:
        postCreationEditPage.selectFromDropdownAndClickInBodyOfThePost();
        // 5 find element post button and click on it:
        postCreationEditPage.submitPost();
        // 6 Check that the confirmation message text matches the expected message content:
        assertTrue(postCreationEditPage.isSuccessMessageVisible(), ERROR_MESSAGE_IF_POST_IS_NOT_CREATED);
    }

    @Test
    @Order(2)
    public void createCommentTest_when_validCredentialsProvided() {
        authenticateWithUser(TestData.USER_1.getValue());

        // find latest posts
        homePage.clickLatestPost();
        loggedPostsPage.explorePost();

        //fill text in comment field and submit:
        explorePostPage.fillTextInCommentField();
        explorePostPage.submitComment();

        // click show comments button:
        explorePostPage.viewComments();

        //  Assert that the date in the meta element contains today’s date
        assertTrue(explorePostPage.isDateOfThePostCorrect(), ERROR_MESSAGE_FOR_DATE_ASSERT);

        //  Assert that the comment text matches what was entered
        assertTrue(explorePostPage.isTextCorrect(), ERROR_MESSAGE_FOR_COMMENT_CONTENT);

        //  Assert that the username is displayed correctly
        assertTrue(explorePostPage.isUsernameCorrectlyDisplayed(TestData.USER_1.getValue()), ERROR_MESSAGE_FOR_USERNAME);
    }
}
