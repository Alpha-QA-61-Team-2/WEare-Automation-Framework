package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AnonHeader {

    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPassField = By.id("confirm");
    private final By categorySelect = By.id("category.id");
    private final By regBtn = By.cssSelector("input[value='Register']");
    private final By usernameExistsMsg = By.xpath("//i[contains(text(),'exist')]");

    public void submitRegistrationForm(String username, String email, String password, String confirmPassword) {
        driver().findElement(usernameField).sendKeys(username);
        driver().findElement(emailField).sendKeys(email);
        driver().findElement(passwordField).sendKeys(password);
        driver().findElement(confirmPassField).sendKeys(confirmPassword);
        driver().findElement(regBtn).click();
    }

    public boolean pageTitleIsSuccessful() {
       return driver().getTitle().equals("Successful Registration");
    }

    public boolean isExistingUsernameMsgDisplayed() {
        return driver().findElement(usernameExistsMsg).isDisplayed();
    }
}
