package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    protected final By locatorOfCreatedComment = By.xpath("//*[@id=\"comments\"]/div[2]/h3");
    protected final By locatorOfContentOfComment = By.cssSelector("#comments > div.comment-body > p:nth-child(3)");
    protected final By locatorOfDateOfComment = By.className("meta");

    protected static final String BODY_OF_THE_COMMENT = "this is a test comment to test the comment send functionality";
    public static final int PIXELS_UP_400 = -400;
    public static final int PIXELS_UP_800 = -800;
    public static final int PIXELS_DOWN_400 = 400;
    public static final int PIXELS_DOWN_2500 = 2500;
    protected static final String DATE_FORMAT = "dd/MM/yyyy";


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

    public void scrollByPixels(int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver().getWebDriver();
        js.executeScript("window.scrollBy(0, " + px + ");");
    }

    public void fillTextInCommentField() {
        scrollByPixels(PIXELS_UP_400);
        driver().findElement(commentTextField).click();
        driver().findElement(commentTextField).sendKeys(BODY_OF_THE_COMMENT);
    }

    public void submitComment() {
        driver().findElement(postCommentBtn).click();
    }

    public boolean isUsernameCorrectlyDisplayed(String username) {
        scrollByPixels(PIXELS_DOWN_400);
        WebElement usernameField = driver().findElement(locatorOfCreatedComment);
        String field = usernameField.getText().toLowerCase();
        return field.equals(username);
    }

    public boolean isDateOfThePostCorrect() {
        WebElement dateElement = driver().findElement(locatorOfDateOfComment);
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        return dateElement.getText().contains(currentDate);
    }

    public boolean isTextCorrect() {
        WebElement commentTextElement = driver().findElement(locatorOfContentOfComment);
        return commentTextElement.getText().contains(BODY_OF_THE_COMMENT);
    }
}


