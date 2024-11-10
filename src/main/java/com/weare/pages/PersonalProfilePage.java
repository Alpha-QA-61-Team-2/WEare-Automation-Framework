package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class PersonalProfilePage extends LoggedHeader {

    protected final By friendRequestsBtn = By.cssSelector("input[type='submit']");
    protected final By editProfileBtn = By.xpath("//a[contains(text(),'edit')]");

    public void openEditor() {
        driver().findElement(editProfileBtn).click();
    }
}
