package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;

public class ExplorePostPage extends LoggedHeader {

    protected final By allPostsByUserBtn = By.cssSelector("input[value*='All']");
    protected final By editPostBtn = By.linkText("Edit post");
    protected final By deletePostBtn = By.linkText("Delete post");

    protected final By seeProfileBtn = By.linkText("See profile");

    protected final By showCommentsBtn = By.xpath("//button[contains(text(),'Comments')]");
    protected final By editCommentBtn = By.linkText("Edit comment");
    protected final By deleteCommentBtn = By.linkText("Delete comment");
    protected final By commentTextField = By.id("message");
    protected final By postCommentBtn = By.cssSelector("input[value*='Post']");


    public void clickDeletePostButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(deletePostBtn));
        driver().findElement(deletePostBtn).click();
    }

    public void viewComments() {
        driver().findElement(showCommentsBtn).click();
    }

    //todo fix
    public void deleteComment() {
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript("arguments[0].scrollIntoView(true);", deleteCommentBtn);
        driver().findElement(deleteCommentBtn).click();
    }
}


