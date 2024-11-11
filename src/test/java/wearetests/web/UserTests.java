package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class UserTests extends WEareBaseWebTest {

    @Test
    public void userCreated_when_validDataProvided() {
        anonHeader.clickRegister();
        registrationPage.submitRegistrationForm(TestData.USERNAME.getValue(),
                TestData.EMAIL.getValue(), TestData.PASSWORD.getValue(), TestData.CONFIRM_PASSWORD.getValue());
        Assertions.assertTrue(registrationPage.pageTitleIsSuccessful());
    }

    @Test
    public void userCanUpdateProfile_when_validDataProvided() {
        anonHeader.clickSignIn();
        loginPage.submitLoginForm(TestData.USERNAME.getValue(), TestData.PASSWORD.getValue());
        loggedHeader.goToPersonalProfile();
        personalProfilePage.openEditor();
        profileEditorPage.submitUpdateForm(TestData.FIRST_NAME.getValue(), TestData.LAST_NAME.getValue());
        Assertions.assertTrue(profileEditorPage.updatedDetailsAreSaved(TestData.LAST_NAME.getValue()));
    }
}
