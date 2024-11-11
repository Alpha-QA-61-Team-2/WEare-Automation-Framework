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
    public void userCanUpdateProfile_when_validDaraProvided() {
        loggedHeader.goToPersonalProfile();
        personalProfilePage.openEditor();
        profileEditorPage.submitUpdateForm();
    }
}
