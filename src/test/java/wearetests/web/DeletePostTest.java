package wearetests.web;

import org.junit.jupiter.api.Assertions;
import wearetests.core.WEareBaseWebTest;
import org.junit.jupiter.api.Test;
import wearetests.enums.TestData;


public class DeletePostTest extends WEareBaseWebTest {

    //todo figure out what todo
    @Test
    public void postIsDeleted_when_confirmed() {
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        baseHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.clickDeletePostButton();
        deleteConfirmationPage.confirmPostDeletion();
        Assertions.assertTrue(deleteConfirmationPage.isPostDeletedSuccessfullyVisible());
    }
}

