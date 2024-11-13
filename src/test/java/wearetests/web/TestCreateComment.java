package wearetests.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.cssSelector;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static wearetests.enums.TestData.PASSWORD;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCreateComment {
    public static final String OLGA = "Olga";
    public static final String BODY_OF_THE_COMMENT = "this is a test comment to test the comment send functionality";
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

    //@Test
    @RepeatedTest(8)
    public void createComment() {
        // Test name: createComment
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("http://localhost:8081/");
        // 2 | setWindowSize | 1552x840 |
        driver.manage().window().setSize(new Dimension(1552, 840));
        // 3 | click | css=.nav-item:nth-child(2) > .nav-link |
        driver.findElement(cssSelector(".nav-item:nth-child(2) > .nav-link")).click();
        // 4 | click | id=username |
        driver.findElement(By.id("username")).click();
        // 5 | type | id=username | Olga
        driver.findElement(By.id("username")).sendKeys(OLGA);
        // 6 | type | id=password | 123456
        driver.findElement(By.id("password")).sendKeys(PASSWORD.getValue());
        // 7 | click | css=input:nth-child(10) |
        driver.findElement(cssSelector("input:nth-child(10)")).click();
        // 8 | click | linkText=Latest Posts |
        driver.findElement(By.linkText("Latest Posts")).click();
        // 9 | click | css=.btn:nth-child(1) |
        driver.findElement(cssSelector(".btn:nth-child(1)")).click();


        // 10 | wait until element is clickable and click | id=message |
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        messageField.click();

        // 11 | type | id=message | this is a test comment to test the comment send functionality
        messageField.sendKeys(BODY_OF_THE_COMMENT);

        // 12 | click | css=.form-group > .btn |
        driver.findElement(cssSelector(".form-group > .btn")).click();

        // **Wait for an element that confirms the page is fully loaded**
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".form-group > .btn")));

        // Scroll up after wait
        js.executeScript("window.scrollBy(0, -400);");

        // **Wait for the "Show Comments" button to be clickable after scroll**
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
