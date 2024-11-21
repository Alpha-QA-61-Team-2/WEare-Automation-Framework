package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class OtherUserProfilePage extends LoggedHeader {

    protected final By professionField = By.xpath("//input[@value='connect']");
    protected final By requestSentMsg = By.xpath("//div[contains(text(),'You have send')]");
    //"//a[contains(text(),'profile')]"

    public void sendConnectionRequest() {
        driver().findElement(professionField).click();
    }

    public boolean isSuccessMsgDisplayed() {
        return driver().findElement(requestSentMsg).isDisplayed();
    }
}
