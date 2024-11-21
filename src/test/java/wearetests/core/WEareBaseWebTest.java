package wearetests.core;

import com.weare.pages.*;
import com.weare.pages.header.AdminHeader;
import com.weare.pages.header.AnonHeader;
import com.weare.pages.header.BaseHeader;
import com.weare.pages.header.LoggedHeader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import testframework.PropertiesManager;
import testframework.core.BaseWebTest;
import wearetests.enums.TestData;

public class WEareBaseWebTest extends BaseWebTest {

    protected AdminHeader adminHeader;
    protected AnonHeader anonHeader;
    protected BaseHeader baseHeader;
    protected LoggedHeader loggedHeader;
    protected HomePage homePage;
    protected AnonPostsPage anonPostsPage;
    protected ConnectionRequestsPage connectionRequestsPage;
    protected DeleteConfirmationPage deleteConfirmationPage;
    protected ExplorePostPage explorePostPage;
    protected LoggedPostsPage loggedPostsPage;
    protected LoginPage loginPage;
    protected PersonalProfilePage personalProfilePage;
    protected PostCreationEditPage postCreationEditPage;
    protected ProfileEditorPage profileEditorPage;
    protected RegistrationPage registrationPage;
    protected OtherUserProfilePage profilePage;

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts
        this.adminHeader = new AdminHeader();
        this.anonHeader = new AnonHeader();
        this.baseHeader = new BaseHeader();
        this.loggedHeader = new LoggedHeader();
        this.homePage = new HomePage();
        this.anonPostsPage = new AnonPostsPage();
        this.connectionRequestsPage = new ConnectionRequestsPage();
        this.deleteConfirmationPage = new DeleteConfirmationPage();
        this.explorePostPage = new ExplorePostPage();
        this.loggedPostsPage = new LoggedPostsPage();
        this.loginPage = new LoginPage();
        this.personalProfilePage = new PersonalProfilePage();
        this.postCreationEditPage = new PostCreationEditPage();
        this.profileEditorPage = new ProfileEditorPage();
        this.registrationPage = new RegistrationPage();
        this.profilePage = new OtherUserProfilePage();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
        // perform some code after each test has finished
    }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }

    // Extract methods that use multiple pages
    public void authenticateWithUser(String username) {
        anonHeader.clickSignIn();
        loginPage.submitLoginForm(username, TestData.PASSWORD.getValue());
    }
}

