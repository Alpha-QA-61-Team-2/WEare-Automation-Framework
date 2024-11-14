package wearetests.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestClassOlga {

    protected static final String BODY_OF_THE_POST = "this is a post test post is this is this what is this this is it!";
    protected static final String BODY_OF_THE_COMMENT = "this is a test comment to test the comment send functionality";
    protected static final String OLGA = "Olga";
    protected static final String MARTIN = "Martin";
    protected static WebDriver driver;
    protected static JavascriptExecutor js;
    protected static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    static void loginWithUsernameAndPassword(String username, Enum<?> password) {

        // 1 | open | / |
        driver.get("http://localhost:8081/");

        // 3 | click | css=.nav-item:nth-child(2) > .nav-link |
        WebElement loginNav = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-item:nth-child(2) > .nav-link")));
        assertTrue(loginNav.isDisplayed(), "Login navigation link is not displayed");
        loginNav.click();

        // 4 | click | id=username |
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
        usernameField.click();

        // 5 | type | id=username | Olga
        usernameField.sendKeys(username);
        assertEquals(username, usernameField.getAttribute("value"), "Username field did not update correctly");

        // 6 | type | id=password | 123456
        WebElement passwordField = driver.findElement(By.id("password"));
        assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
        passwordField.sendKeys(password.toString());
        assertEquals(password.toString(), passwordField.getAttribute("value"), "Password field did not update correctly");

        // 7 | click | css=input:nth-child(10) |
        WebElement submitButton = driver.findElement(By.cssSelector("input:nth-child(10)"));
        assertTrue(submitButton.isDisplayed(), "Submit button is not displayed");
        submitButton.click();
    }

    /**
     * if we need to resize the window after login;
     */
    static void resizeWindow() {
        driver.manage().window().setSize(new Dimension(1552, 840));
    }
}