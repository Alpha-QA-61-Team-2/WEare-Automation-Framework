package com.weare.pages;

import com.weare.pages.header.AdminHeader;
import com.weare.pages.header.AnonHeader;
import com.weare.pages.header.BaseHeader;
import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends BaseHeader {

    //todo finish class

    private AnonHeader anonHeader;
    private LoggedHeader loggedHeader;
    private AdminHeader adminHeader;

    public HomePage() {
        this.anonHeader = new AnonHeader();
        this.loggedHeader = new LoggedHeader();
        this.adminHeader = new AdminHeader();
    }

    protected final By professionField = By.id("searchParam1");
    protected final By nameField = By.id("searchParam2");
    protected final By searchBtn = By.cssSelector("button[type=submit]");
    protected final By userProfileBtn = By.xpath("//h2[@type='text']");

    public void selectUser() {
        JavascriptExecutor js = (JavascriptExecutor) driver().getWebDriver();
        js.executeScript("window.scrollBy(0, 2500);");
        driver().findElement(userProfileBtn).click();
    }

}
