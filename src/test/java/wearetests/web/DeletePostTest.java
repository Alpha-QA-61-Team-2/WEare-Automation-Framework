package wearetests.web;

import com.weare.pages.NavigationPage;
import com.weare.pages.DeletePostPage;
import org.junit.jupiter.api.Assertions;
import wearetests.core.WEareBaseWebTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static testframework.DriverManager.getDriver;

public class DeletePostTest extends WEareBaseWebTest {

    @Test
    public void deletePostTest() {
        navigationPage.goToLatestPosts();
        deletePostPage.navigateToLatestPosts();
        deletePostPage.openAndEditPost();
        deletePostPage.deletePost();
        deletePostPage.isPostDeletedSuccessfullyVisible();

    }

}

