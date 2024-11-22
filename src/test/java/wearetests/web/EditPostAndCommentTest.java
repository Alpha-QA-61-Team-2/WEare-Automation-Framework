package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static com.weare.pages.ExplorePostPage.PIXELS_DOWN_2500;


public class EditPostAndCommentTest extends WEareBaseWebTest {

    @Test
    public void commentIsEdited_when_confirmed() {
        writeAComment();
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
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.explorePost();
        explorePostPage.clickEditPostButton();
        explorePostPage.fillTextInCommentField();
        postCreationEditPage.submitPost();
        Assertions.assertTrue(explorePostPage.isTextPresentOnPage());
}

}

