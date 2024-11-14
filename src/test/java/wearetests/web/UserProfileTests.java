package wearetests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UserProfileTests extends WEareBaseWebTest {

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
    public void userNotCreated_when_providingAlreadyRegisteredUsername() {
        anonHeader.clickRegister();
        registrationPage.submitRegistrationForm(TestData.USER_3.getValue(), TestData.EMAIL.getValue()
                , TestData.PASSWORD.getValue()
                , TestData.CONFIRM_PASSWORD.getValue());
        Assertions.assertTrue(registrationPage.isExistingUsernameMsgDisplayed(),
                "Existing username message should be displayed.");
    }

    //failing test - bug logged in Shortcut
    @Test
    public void userNotCreated_when_providingAlreadyRegisteredEmail() {
        anonHeader.clickRegister();
        registrationPage.submitRegistrationForm("testmest", "some@abv.bg", TestData.PASSWORD.getValue()
                , TestData.CONFIRM_PASSWORD.getValue());
        Assertions.assertFalse(registrationPage.pageTitleIsSuccessful(),
                "User should not be created.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "VThyJLiSFuAAAIYEkRGDB" })
    public void userNotCreated_when_providingInvalidUsername(String username) {
        anonHeader.clickRegister();
        registrationPage.submitRegistrationForm(username, TestData.EMAIL.getValue(), TestData.PASSWORD.getValue()
                , TestData.CONFIRM_PASSWORD.getValue());
        Assertions.assertFalse(registrationPage.pageTitleIsSuccessful(),
                "User should not be created.");
    }

    @Test
    public void userCanUpdateProfile_when_validDataProvided() {
        authenticateWithUser(TestData.USER_1.getValue());
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
