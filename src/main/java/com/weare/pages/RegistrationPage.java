package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import org.openqa.selenium.By;

public class RegistrationPage extends AnonHeader {

    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPassField = By.id("confirm");
    private final By categorySelect = By.id("category.id");
    private final By regBtn = By.cssSelector("input[value='Register']");

    public void submitRegistrationForm(String username, String email, String password, String confirmPassword) {
        driver().findElement(usernameField).sendKeys(username);
        driver().findElement(emailField).sendKeys(email);
        driver().findElement(passwordField).sendKeys(password);
        driver().findElement(confirmPassField).sendKeys(confirmPassword);
        driver().findElement(regBtn).click();
    }

    public boolean welcomeMessageIsDisplayed() {
       return driver().findElement(By.cssSelector("h1[class*='mb-3']")).getText().contains("Welcome");
    }
}
