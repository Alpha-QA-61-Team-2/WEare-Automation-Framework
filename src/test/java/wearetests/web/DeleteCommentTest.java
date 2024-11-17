package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;

public class DeleteCommentTest extends WEareBaseWebTest {

    @Test
    public void deleteCommentTest() {
        authenticateWithUser("admin");

        navigationPage.goToLatestPosts();
        deletePostPage.navigateToLatestPosts();
        deletePostPage.openAndEditPost();
        deletePostPage.showComments();
        deletePostPage.deleteComment();
        deletePostPage.isCommentDeletedSuccessfullyVisible();
    }

}
