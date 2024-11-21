package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IndividualPostPage extends AnonPostsPage {

    protected final By commentField = By.id("message");
    protected final By postComment = By.cssSelector("#leaveComment > form > div:nth-child(2) > input");
    protected final By showCommentsSelector = By.xpath("//*[text()='Show Comments']");
    protected final By locatorOfCreatedComment = By.xpath("//*[@id=\"comments\"]/div[2]/h3");
    protected final By locatorOfContentOfComment = By.cssSelector("#comments > div.comment-body > p:nth-child(3)");
    protected final By locatorOfDateOfComment = By.className("meta");
    protected static final String BODY_OF_THE_COMMENT = "this is a test comment to test the comment send functionality";
    public static final int PIXELS_UP = -400;
    public static final int PIXELS_DOWN_400 = 400;
    public static final int PIXELS_DOWN_2500 = 2500;
    protected static final String DATE_FORMAT = "dd/MM/yyyy";

    public void scrollByPixels(int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver().getWebDriver();
        js.executeScript("window.scrollBy(0, " + px + ");");
    }

    public void fillTextInCommentField() {
        scrollByPixels(PIXELS_UP);
        driver().findElement(commentField).click();
        driver().findElement(commentField).sendKeys(BODY_OF_THE_COMMENT);
    }

    public void submitComment() {
        driver().findElement(postComment).click();
    }

    public void showCommentsButton() {
        scrollByPixels(PIXELS_UP);
        driver().findElement(showCommentsSelector).click();
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
