package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class ConnectionRequestsPage extends LoggedHeader {

    protected final By approveBtn = By.cssSelector("input[value*='Approve']");
    protected final By thereAreNoRequestsMsg = By.xpath("/html/body/div[1]/div[2]/div/div/h3");

    public void approveFriendRequest() {
        driver().findElement(approveBtn).click();
    }

    public boolean isSuccessMsgDisplayed() {
        return driver().findElement(thereAreNoRequestsMsg).getText().contains("There are no requests");
    }
}
