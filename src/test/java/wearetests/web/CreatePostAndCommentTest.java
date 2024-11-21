package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreatePostAndCommentTest extends WEareBaseWebTest {

    public static final String ERROR_MESSAGE_IF_POST_IS_NOT_CREATED = "There is no post, containing the input text!";

    @Test
    @Order(1)
    public void createPostTest() {
        //1 login
        authenticateWithUser(TestData.USER_1.getValue());
        // 2 find element post in navigation bar and click it:
        homePage.clickAddNewPost();
        // 3 Scroll down:
        postCreationEditPage.scrollDown();
        // 4 select public post and fill body of the post:
        postCreationEditPage.selectFromDropdownAndClickInBodyOfThePost();
        // 5 find element post button and click on it:
        postCreationEditPage.submitPost();
        // 6 Check that the confirmation message text matches the expected message content:
        assertTrue(postCreationEditPage.isSuccessMessageVisible(), ERROR_MESSAGE_IF_POST_IS_NOT_CREATED);
    }

//
//    @Test
//    @Order(2)
//    public void createCommentTest() {
//        loginWithUsernameAndPassword(OLGA, PASSWORD);
//
//        // 8 find latest posts
//        driver.findElement(By.linkText("Latest Posts")).click();
//        // 9 | click on one of the latest posts
//        driver.findElement(cssSelector(".btn:nth-child(1)")).click();
//
//        // 10 | wait until element message field is clickable and click
//        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
//        messageField.click();
//
//        // 11 fill the message in the message field:
//        messageField.sendKeys(BODY_OF_THE_COMMENT);
//
//        // 12 click send comment button:
//        driver.findElement(cssSelector(".form-group > .btn")).click();
//
//        // 13 Wait for an element that confirms the page is fully loaded**
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".form-group > .btn")));
//
//        // 14 Scroll up after wait
//        js.executeScript("window.scrollBy(0, -400);");
//
//        // 15 Wait for the "Show Comments" button to be clickable after scroll**
//        WebElement showCommentField = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[text()='Show Comments']")));
//        showCommentField.click();
//
//        // **Assertion Steps**
//        // 1. Locate the comment container
//        WebElement commentBody = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector(".comment-body")));
//
//        // 2. Assert that the username is displayed correctly
//        WebElement usernameElement = commentBody.findElement(By.tagName("h3"));
//        assertEquals(OLGA, usernameElement.getText(), "Username is incorrect in the comment.");
//
//        // 3. Assert that the date in the meta element contains today’s date
//        WebElement dateElement = commentBody.findElement(By.className("meta"));
//        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        assertTrue(dateElement.getText().contains(currentDate), "Date is incorrect or not today's date.");
//
//        // 4. Assert that the comment text matches what was entered
//        WebElement commentTextElement = commentBody.findElement(By.tagName("p"));
//        assertEquals(BODY_OF_THE_COMMENT,
//                commentTextElement.getText(), "Comment text does not match.");
//    }
}
