package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import org.openqa.selenium.By;

public class RegistrationPage extends AnonHeader {

    public RegistrationPage(String pageSpecificUrl) {
        super("/register");
    }

    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPassField = By.id("confirm");
    private final By categorySelect = By.id("category.id");
    private final By regBtn = By.cssSelector("input[value='Register']");

    public void registerUser() {

    }
}
