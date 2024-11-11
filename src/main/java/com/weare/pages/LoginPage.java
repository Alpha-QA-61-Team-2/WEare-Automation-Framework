package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AnonHeader {

    protected LoggedHeader loggedHeader;

    public LoginPage() {
        loggedHeader = new LoggedHeader();
    }

    protected final By usernameField = By.id("username");
    protected final By passwordField = By.id("password");
    protected final By loginBtn = By.cssSelector("input[value='Login']");

    public void submitLoginForm(String username, String password)  {
        driver().findElement(usernameField).sendKeys(username);
        driver().findElement(passwordField).sendKeys(password);
        driver().findElement(loginBtn).click();
    }
}
