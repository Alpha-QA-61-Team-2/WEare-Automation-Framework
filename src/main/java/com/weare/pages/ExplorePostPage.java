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
    protected final By likeCommentBtn = By.cssSelector("input[value='Like']");
    protected final By likeCommentBtnDislike = By.cssSelector("input[value='Dislike']");
    protected final By editCommentBtn = By.linkText("Edit comment");
    protected final By deleteCommentBtn = By.linkText("Delete comment");
    protected final By commentTextField = By.id("message");
    protected final By postCommentBtn = By.cssSelector("input[value*='Post']");


    public void clickShowCommentsButton() {
        driver.findElement(showCommentsBtn).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WebElement deleteButtonElement = driver.findElement(deleteCommentBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButtonElement);
    }


    public void clickDeleteCommentsButton() {
        driver.findElement(deleteCommentBtn).click();
    }

    public void clickLikeButton() {
        // Click the "Like" button
        driver.findElement(likeCommentBtn).click();
    }

    public void clickDisLikeButton() {
        // Click the "Like" button
        driver.findElement(likeCommentBtnDislike).click();
    }

    public boolean islikeButtonVisible() {
        boolean isVisible;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(likeCommentBtn));
            isVisible = true;
        } catch (TimeoutException e) {
            isVisible = false;
        }
        // Print the result in the console
        System.out.println("Is Like button visible? " + isVisible);
        return isVisible;
    }

    public boolean isDislikeButtonVisible() {
        boolean isVisible;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(likeCommentBtnDislike));
            isVisible = true;
        } catch (TimeoutException e) {
            isVisible = false;
        }
        // Print the result in the console
        System.out.println("Is Dislike button visible? " + isVisible);
        return isVisible;
    }
    }


