package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class DeleteCommentTest extends WEareBaseWebTest {

    @Test
    public void deleteCommentTest() {
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.viewComments();
        explorePostPage.deleteComment();
        deleteConfirmationPage.confirmCommentDeletion();
        Assertions.assertTrue(deleteConfirmationPage.isCommentDeletedSuccessfullyVisible());
    }
}
