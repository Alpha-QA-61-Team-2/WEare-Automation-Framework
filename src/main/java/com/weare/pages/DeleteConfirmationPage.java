package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import static testframework.core.BaseWebTest.driver;

public class DeleteConfirmationPage extends LoggedHeader {

    protected final By actionSelect = By.id("StringListId");
    protected final By submitBtn = By.cssSelector("input[type='submit']");
    protected final By postDeletedMsg = By.xpath("//*[contains(text(),'Post deleted successfully')]");
    protected final By commentDeletedMsg = By.xpath("//*[contains(text(),'Comment deleted successfully')]");

    public void confirmPostDeletion() {
        Select action = new Select(driver().findElement(actionSelect));
        action.selectByVisibleText("Delete post");
        driver().findElement(submitBtn).click();
    }

    public void confirmCommentDeletion() {
        Select action = new Select(driver().findElement(actionSelect));
        action.selectByVisibleText("Delete comment");
        driver().findElement(submitBtn).click();
    }

    public boolean isPostDeletedSuccessfullyVisible() {
        try {
            return driver().findElement(postDeletedMsg).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCommentDeletedSuccessfullyVisible() {
        try {
            return driver().findElement(commentDeletedMsg).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
