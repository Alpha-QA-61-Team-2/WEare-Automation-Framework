package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggedPostsPage extends AnonPostsPage{

    private LoggedHeader loggedHeader;

    public LoggedPostsPage() {
        this.loggedHeader = new LoggedHeader();
    }

    protected final By likeBtn = By.cssSelector("input[value='Like']");
    protected final By browsePublicBtn = By.xpath("(//input[@value='Browse'])[1]");
    protected final By likeCommentBtnDislike = By.cssSelector("input[value='Dislike']");
    protected final By likeCommentBtn = By.cssSelector("input[value='Like']");

    public void explorePost() {
        driver().findElement(explorePostBtn).click();
    }

    public void clickLike() {
        driver().findElement(likeBtn).click();
    }

    public void clickDislike() {
        driver().findElement(likeCommentBtnDislike).click();
    }

    public boolean isDislikeButtonVisible() {
        boolean isVisible;
        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeCommentBtnDislike));
            isVisible = true;
        } catch (TimeoutException e) {
            isVisible = false;
        }
        // Print the result in the console
        System.out.println("Is Dislike button visible? " + isVisible);
        return isVisible;
    }

    public boolean islikeButtonVisible() {
        boolean isVisible;
        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeCommentBtn));
            isVisible = true;
        } catch (TimeoutException e) {
            isVisible = false;
        }
        // Print the result in the console
        System.out.println("Is Like button visible? " + isVisible);
        return isVisible;
    }
}
