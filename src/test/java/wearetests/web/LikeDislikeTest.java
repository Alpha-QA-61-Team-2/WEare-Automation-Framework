package wearetests.web;

import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;


public class LikeDislikeTest extends WEareBaseWebTest {


    @Test
    public void postLike () {
        authenticateWithUser("admin");
        navigationPage.goToLatestPosts();
        explorePostPage.clickLikeButton();
        explorePostPage.isDislikeButtonVisible();
    }

    @Test
    public void postDisLike () {
        authenticateWithUser("admin");
        navigationPage.goToLatestPosts();
        explorePostPage.clickDisLikeButton();
        explorePostPage.islikeButtonVisible();
    }

}
