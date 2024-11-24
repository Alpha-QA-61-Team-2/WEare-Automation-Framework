package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
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
    protected final By editCommentBtn = By.linkText("EDIT COMMENT");
    protected final By deleteCommentBtn = By.linkText("DELETE COMMENT");
    protected final By commentTextField = By.id("message");
    protected final By postCommentBtn = By.cssSelector("input[value*='Post']");
    protected final By editCommentSubmitBtn = By.cssSelector("input[value*='Edit Comment']");
    protected final By locatorOfCreatedComment = By.xpath("//*[@id=\"comments\"]/div[2]/h3");
    protected final By locatorOfContentOfComment = By.cssSelector("#comments > div.comment-body > p:nth-child(3)");
    protected final By locatorOfDateOfComment = By.className("meta");

    protected static final String BODY_OF_THE_COMMENT = "this is a test comment to test the comment send functionality";
    protected static final String DATE_FORMAT = "dd/MM/yyyy";


    public void clickDeletePostButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(deletePostBtn));
        driver().findElement(deletePostBtn).click();
    }

    public void clickEditPostButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(editPostBtn));
        driver().findElement(editPostBtn).click();
    }

    public void viewComments() {
        driver().scrollToElement(showCommentsBtn);
        driver().findElement(showCommentsBtn).click();
    }

    //todo fix
    public void deleteComment() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteCommentBtn));
        driver().findElement(deleteCommentBtn).click();
    }

    public void editComment() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(editCommentBtn));
        driver().findElement(editCommentBtn).click();
    }

    public void editCommentSubmit() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(editCommentSubmitBtn));
        driver().findElement(editCommentSubmitBtn).click();
    }

    //todo remove if tests work without it
    /*public void scrollByPixels(int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver().getWebDriver();
        js.executeScript("window.scrollBy(0, " + px + ");");
    }*/

    public void fillTextInCommentField() {
        driver().scrollToElement(commentTextField);
        driver().findElement(commentTextField).click();
        driver().findElement(commentTextField).sendKeys(BODY_OF_THE_COMMENT);
    }

    public void submitComment() {
        driver().findElement(postCommentBtn).click();
    }

    public boolean isUsernameCorrectlyDisplayed(String username) {
        driver().scrollToElement(locatorOfCreatedComment);
        WebElement usernameField = driver().findElement(locatorOfCreatedComment);
        String field = usernameField.getText().toLowerCase();
        return field.equals(username);
    }

    public boolean isDateOfThePostCorrect() {
        WebElement dateElement = driver().findElement(locatorOfDateOfComment);
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        return dateElement.getText().contains(currentDate);
    }

    public boolean isCommentTextCorrect() {
        WebElement commentTextElement = driver().findElement(locatorOfContentOfComment);
        return commentTextElement.getText().contains(BODY_OF_THE_COMMENT);
    }

    public boolean isTextPresentOnPage() {
        String pageSource = driver().getPageSource();
        return pageSource.contains(BODY_OF_THE_COMMENT);
    }

}


