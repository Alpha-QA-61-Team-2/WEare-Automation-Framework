package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class LoginTests extends WEareBaseWebTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        anonHeader.clickSignIn();
        loginPage.submitLoginForm(TestData.USERNAME.getValue(), TestData.PASSWORD.getValue());
        Assertions.assertTrue(loggedHeader.logoutBtnIsVisible());
    }
}
