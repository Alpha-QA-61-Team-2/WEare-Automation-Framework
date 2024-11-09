package com.weare.pages.header;

import org.openqa.selenium.By;

public class LoggedHeader extends BaseHeader{

    public LoggedHeader(String pageSpecificUrl) {
        super("/");
    }

    protected final By personalProfileBtn = By.xpath("//a[contains(text(),'Profile')]");
    public final By addPostBtn = By.xpath("//a[contains(text(),'Add')]");
    protected final By logoutBtn = By.linkText("LOGOUT");

}
