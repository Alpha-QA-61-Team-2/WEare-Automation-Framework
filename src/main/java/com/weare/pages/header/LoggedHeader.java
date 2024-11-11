package com.weare.pages.header;

import org.openqa.selenium.By;

public class LoggedHeader extends BaseHeader {

    protected final By personalProfileBtn = By.xpath("//a[contains(text(),'Profile')]");
    public final By addPostBtn = By.xpath("//a[contains(text(),'Add')]");
    public final By logoutBtn = By.linkText("LOGOUT");

    public void goToPersonalProfile() {
        driver().findElement(personalProfileBtn).click();
    }

    public boolean logoutBtnIsVisible() {
        return driver().findElement(logoutBtn).isDisplayed();
    }
}
