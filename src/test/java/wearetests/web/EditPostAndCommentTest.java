package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class EditPostAndCommentTest extends WEareBaseWebTest {

    @Test
    public void commentIsEdited_when_confirmed() {
        createComment();
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.viewComments();
        explorePostPage.editComment();
        explorePostPage.fillTextInCommentField();
        explorePostPage.editCommentSubmit();
        explorePostPage.viewComments();
        Assertions.assertTrue(explorePostPage.isCommentTextCorrect());
    }


    //todo test fails if first post is private
    @Test
    public void postIsEdited_when_confirmed() {
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.clickEditPostButton();
        explorePostPage.fillTextInCommentField();
        postCreationEditPage.submitPost();
        Assertions.assertTrue(explorePostPage.isTextPresentOnPage());
    }
}

