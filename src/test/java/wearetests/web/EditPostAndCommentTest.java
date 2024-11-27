package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import java.io.IOException;

public class EditPostAndCommentTest extends WEareBaseWebTest {

    @BeforeEach
    public void setup() throws IOException {
        createPost();
        createComment();
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
    }

    @Test
    public void commentIsEdited_when_confirmed() {
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.viewComments();
        explorePostPage.editComment();
        explorePostPage.fillTextInCommentField();
        explorePostPage.editCommentSubmit();
        explorePostPage.viewComments();
        Assertions.assertTrue(explorePostPage.isCommentTextCorrect());
    }

    @Test
    public void postIsEdited_when_confirmed() {
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.clickEditPostButton();
        postCreationEditPage.selectFromDropdownAndClickInBodyOfThePost();
        explorePostPage.fillTextInCommentField();
        postCreationEditPage.submitPost();
        Assertions.assertTrue(explorePostPage.isTextPresentOnPage());
    }
}

