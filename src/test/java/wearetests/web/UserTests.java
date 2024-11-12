package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTests extends WEareBaseWebTest {

    //todo find a way to make tests run together

    @Test
    public void userCreated_when_validDataProvided() {
        anonHeader.clickRegister();
        registrationPage.submitRegistrationForm(TestData.USERNAME_CREATE.getValue(),
                TestData.EMAIL.getValue(), TestData.PASSWORD.getValue(), TestData.CONFIRM_PASSWORD.getValue());
        Assertions.assertTrue(registrationPage.pageTitleIsSuccessful(),
                "Page title should change to 'Successful Registration'");
    }

    @Test
    public void userCanUpdateProfile_when_validDataProvided() {
        authenticateWithUser(TestData.USER_3.getValue());
        loggedHeader.goToPersonalProfile();
        personalProfilePage.openEditor();
        profileEditorPage.submitUpdateForm(TestData.FIRST_NAME.getValue(), TestData.LAST_NAME.getValue());
        assertAll(
                () -> Assertions.assertTrue(profileEditorPage.updatedDetailsAreSaved(TestData.LAST_NAME.getValue())
                        , "Last name field should be populated."),
                () -> Assertions.assertTrue(profileEditorPage.isEmailChanged(TestData.EMAIL.getValue())
                        , "Email should be changed.")
        );
    }
}
