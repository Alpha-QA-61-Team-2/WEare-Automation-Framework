package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class LoginLogoutTests extends WEareBaseWebTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        authenticateWithUser(TestData.USER_3.getValue());
        Assertions.assertTrue(loggedHeader.isLogoutBtnVisible(), "Logout button should be visible.");
    }

    @Test
    public void userNotAuthenticated_when_invalidCredentialsProvided() {
        anonHeader.clickSignIn();
        loginPage.submitLoginForm(TestData.USER_1.getValue(), TestData.WRONG_PASSWORD.getValue());
        Assertions.assertTrue(loginPage.isInvalidCredentialsMsgDisplayed()
                , "Invalid credentials message should be displayed.");
    }

    @Test
    public void userCanLogoutSuccessfully() {
        authenticateWithUser(TestData.USER_1.getValue());
        loggedHeader.clickLogoutBtn();
        Assertions.assertTrue(loginPage.isLoggedOutMsgDisplayed(), "Log out message should be displayed.");
    }
}
