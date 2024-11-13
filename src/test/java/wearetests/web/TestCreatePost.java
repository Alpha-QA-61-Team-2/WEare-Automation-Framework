package wearetests.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static wearetests.enums.TestData.PASSWORD;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreatePost {
    public static final String OLGA = "Olga";
    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


//    @RepeatedTest(7)
    @Test

    public void createPostTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // 1 | open | / |
        driver.get("http://localhost:8081/");

        // 2 | setWindowSize | 1552x840 |
        driver.manage().window().setSize(new Dimension(1552, 840));

        // 3 | click | css=.nav-item:nth-child(2) > .nav-link |
        WebElement loginNav = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-item:nth-child(2) > .nav-link")));
        assertTrue(loginNav.isDisplayed(), "Login navigation link is not displayed");
        loginNav.click();

        // 4 | click | id=username |
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
        usernameField.click();

        // 5 | type | id=username | Olga
        usernameField.sendKeys(OLGA);
        assertEquals(OLGA, usernameField.getAttribute("value"), "Username field did not update correctly");

        // 6 | type | id=password | 123456
        WebElement passwordField = driver.findElement(By.id("password"));
        assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
        passwordField.sendKeys(PASSWORD.getValue());
        assertEquals(PASSWORD.getValue(), passwordField.getAttribute("value"), "Password field did not update correctly");

        // 7 | click | css=input:nth-child(10) |
        WebElement submitButton = driver.findElement(By.cssSelector("input:nth-child(10)"));
        assertTrue(submitButton.isDisplayed(), "Submit button is not displayed");
        submitButton.click();

        // 8 | click | css=.nav-item:nth-child(8) > .nav-link |
        WebElement postNav = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-item:nth-child(8) > .nav-link")));
        assertTrue(postNav.isDisplayed(), "Post navigation link is not displayed");
        postNav.click();

        // Scroll down:
        js.executeScript("window.scrollBy(0, 400);");

        // 9 | select | id=StringListId | label=Public post
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("StringListId")));
        assertTrue(dropdown.isDisplayed(), "Dropdown for post visibility is not displayed");
        dropdown.findElement(By.xpath("//option[. = 'Public post']")).click();
        assertEquals("true", dropdown.getAttribute("value"), "Dropdown selection did not update to 'Public post'");

        // 10 | click | id=message |
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        assertTrue(messageField.isDisplayed(), "Message field is not displayed");
        messageField.click();

        // 11 | type | id=message | this is a post test post is this is this what is this this is it!
        String messageText = "this is a post test post is this is this what is this this is it!";
        messageField.sendKeys(messageText);
        assertEquals(messageText, messageField.getAttribute("value"), "Message field did not update correctly");

        // 12 | click | css=.btn |
        WebElement postButton = driver.findElement(By.cssSelector(".btn"));
        assertTrue(postButton.isDisplayed(), "Post button is not displayed");
        postButton.click();

        // Verify post submission
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div/div[1]/div/div/div/div[2]/p[2]")));

        // Check that the confirmation message text matches the expected message content
        assertEquals(messageText, confirmationMessage.getText(), "Post confirmation message text does not match the expected message.");
    }
}