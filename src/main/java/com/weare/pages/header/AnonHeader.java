package com.weare.pages.header;

import org.openqa.selenium.By;

public class AnonHeader extends BaseHeader{

    protected final By registerBtn = By.linkText("REGISTER");
    protected final By signInBtn = By.xpath("//a[contains(text(),'SIGN')]");

    public void clickRegister() {
        driver().findElement(registerBtn).click();
    }

    public void clickSignIn() {
        driver().findElement(signInBtn).click();
    }
}
