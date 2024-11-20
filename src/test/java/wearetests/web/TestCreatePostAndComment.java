package wearetests.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.cssSelector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.enums.TestData.PASSWORD;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCreatePostAndComment extends BaseTestClassOlga {

    //@RepeatedTest(4)
    @Test
    @Order(1)
    public void createPostTest() {
        //1 login
        loginWithUsernameAndPassword(OLGA, PASSWORD);

        // 2 find element post in navigation bar and click it:
        WebElement postNav = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-item:nth-child(8) > .nav-link")));
        assertTrue(postNav.isDisplayed(), "Post navigation link is not displayed");
        postNav.click();

        // 3 Scroll down:
        js.executeScript("window.scrollBy(0, 400);");

        // 4 select from the dropdown that the post to be public post; and click it:
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("StringListId")));
        assertTrue(dropdown.isDisplayed(), "Dropdown for post visibility is not displayed");
        dropdown.findElement(By.xpath("//option[. = 'Public post']")).click();
        assertEquals("true", dropdown.getAttribute("value"), "Dropdown selection did not update to 'Public post'");

        // 5 find field for the body(message) of the post and click on it:
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        assertTrue(messageField.isDisplayed(), "Message field is not displayed");
        messageField.click();

        // 6 fill the body(message) of the post with the message text:
        String messageText = BODY_OF_THE_POST;
        messageField.sendKeys(messageText);
        assertEquals(messageText, messageField.getAttribute("value"), "Message field did not update correctly");

        // 7 find element post button and click on it:
        WebElement postButton = driver.findElement(By.cssSelector(".btn"));
        assertTrue(postButton.isDisplayed(), "Post button is not displayed");
        postButton.click();

        // 8 Verify post submission
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div/div[1]/div/div/div/div[2]/p[2]")));

        // 9 Check that the confirmation message text matches the expected message content
        assertEquals(messageText, confirmationMessage.getText(), "Post confirmation message text does not match the expected message.");
    }


    //@RepeatedTest(4)
    @Test
    @Order(2)
    public void createCommentTest() {
        loginWithUsernameAndPassword(OLGA, PASSWORD);

        // 8 find latest posts
        driver.findElement(By.linkText("Latest Posts")).click();
        // 9 | click on one of the latest posts
        driver.findElement(cssSelector(".btn:nth-child(1)")).click();

        // 10 | wait until element message field is clickable and click
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        messageField.click();

        // 11 fill the message in the message field:
        messageField.sendKeys(BODY_OF_THE_COMMENT);

        // 12 click send comment button:
        driver.findElement(cssSelector(".form-group > .btn")).click();

        // 13 Wait for an element that confirms the page is fully loaded**
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".form-group > .btn")));

        // 14 Scroll up after wait
        js.executeScript("window.scrollBy(0, -400);");

        // 15 Wait for the "Show Comments" button to be clickable after scroll**
        WebElement showCommentField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='Show Comments']")));
        showCommentField.click();

        // **Assertion Steps**
        // 1. Locate the comment container
        WebElement commentBody = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".comment-body")));

        // 2. Assert that the username is displayed correctly
        WebElement usernameElement = commentBody.findElement(By.tagName("h3"));
        assertEquals(OLGA, usernameElement.getText(), "Username is incorrect in the comment.");

        // 3. Assert that the date in the meta element contains today’s date
        WebElement dateElement = commentBody.findElement(By.className("meta"));
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertTrue(dateElement.getText().contains(currentDate), "Date is incorrect or not today's date.");

        // 4. Assert that the comment text matches what was entered
        WebElement commentTextElement = commentBody.findElement(By.tagName("p"));
        assertEquals(BODY_OF_THE_COMMENT,
                commentTextElement.getText(), "Comment text does not match.");
    }
}
