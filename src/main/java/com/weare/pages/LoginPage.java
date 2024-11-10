package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import org.openqa.selenium.By;

public class LoginPage extends AnonHeader {

    protected final By usernameField = By.id("username");
    protected final By passwordField = By.id("password");
    protected final By loginBtn = By.cssSelector("input[value='Login']");
}
