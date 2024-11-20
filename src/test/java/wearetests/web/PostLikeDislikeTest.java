package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;


public class PostLikeDislikeTest extends WEareBaseWebTest {


    @Test
    public void click_like_lost () {
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.clickLike();
        Assertions.assertTrue(loggedPostsPage.isDislikeButtonVisible(), "Dislike button should be visible");
    }

    @Test
    public void click_disLike_post () {
        authenticateWithUser(TestData.ADMIN_PROFILE.getValue());
        adminHeader.viewLatestPosts();
        loggedPostsPage.clickDislike();
        Assertions.assertTrue(loggedPostsPage.islikeButtonVisible(), "Like button should be visible");
    }
}
