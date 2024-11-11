package com.weare.pages;

import com.weare.pages.header.AdminHeader;
import com.weare.pages.header.AnonHeader;
import com.weare.pages.header.BaseHeader;
import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

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

}
