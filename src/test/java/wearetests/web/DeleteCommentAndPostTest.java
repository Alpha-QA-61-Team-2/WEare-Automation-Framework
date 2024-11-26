package wearetests.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class DeleteCommentAndPostTest extends WEareBaseWebTest {

    @BeforeEach
    public void setup() {
        createPost();
        createComment();
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
    }
    
    @Test
    public void commentIsDeleted_when_confirmed() {
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.viewComments();
        explorePostPage.deleteComment();
        deleteConfirmationPage.confirmCommentDeletion();
        Assertions.assertTrue(deleteConfirmationPage.isCommentDeletedSuccessfullyVisible());
    }

    @Test
    public void postIsDeleted_when_confirmed() {
        baseHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.clickDeletePostButton();
        deleteConfirmationPage.confirmPostDeletion();
        Assertions.assertTrue(deleteConfirmationPage.isPostDeletedSuccessfullyVisible());
    }
}
