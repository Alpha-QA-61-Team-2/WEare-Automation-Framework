package com.weare.pages.header;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnonHeader extends BaseHeader{

    protected final By registerBtn = By.xpath("//a[text()='REGISTER']");
    protected final By signInBtn = By.xpath("//a[contains(text(),'SIGN')]");

    public void clickRegister() {
        driver().findElement(registerBtn).click();
    }

    public void clickSignIn() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
        driver().findElement(signInBtn).click();
    }
}
