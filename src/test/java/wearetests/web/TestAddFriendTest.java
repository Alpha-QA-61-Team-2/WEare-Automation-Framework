package wearetests.web;


import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class TestAddFriendTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

     @After
     public void tearDown() {
         driver.quit();
     }

    @Test
    public void testAddFriend() {
        // Step 1: Open main page
        driver.get("http://localhost:8081/");
        driver.manage().window().setSize(new Dimension(1552, 840));

        // Step 2: Navigate to login page and verify navigation
        WebElement loginNavLink = driver.findElement(By.cssSelector(".nav-item:nth-child(2) > .nav-link"));
        assertThat("Login link is not displayed", loginNavLink.isDisplayed(), is(true));
        loginNavLink.click();

        // Step 3: Enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        assertThat("Username field is not displayed", usernameField.isDisplayed(), is(true));
        usernameField.sendKeys("Olga");

        // Step 4: Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        assertThat("Password field is not displayed", passwordField.isDisplayed(), is(true));
        passwordField.sendKeys("123456");

        // Step 5: Submit login form
        passwordField.sendKeys(Keys.ENTER);

        // Step 6: Verify successful login by checking redirection to profile page
        driver.get("http://localhost:8081/auth/users/41/profile");
        String currentUrl = driver.getCurrentUrl();
        assertThat("Did not navigate to the correct profile URL", currentUrl, is("http://localhost:8081/auth/users/41/profile"));

        // Step 7: Check profile page elements
        WebElement profileHeader = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[1]/form/input"));
        assertThat("Profile friend request input is not displayed", profileHeader.isDisplayed(), is(true));

        // Step 8: Send friend request (Click on friend request button)
        profileHeader.click();

        // Optional: Verify friend request submission
        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
        assertThat("Submit button is not displayed", submitButton.isDisplayed(), is(true));
        // submitButton.click();

        //assert that page contains text: Good job! You have send friend request!
        WebElement successMessageForConnecting = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[2]"));

        assertTrue("Success message not displayed as expected!",
                successMessageForConnecting.getText().contains("Good job! You have send friend request!"));

    }
}
