package wearetests.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.enums.TestData.PASSWORD;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAddAndApproveFriendRequest {

    public static final String OLGA = "Olga";
    public static final String MARTIN = "Martin";
    private static WebDriver driver;
    static JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
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
        usernameField.sendKeys(OLGA);

        // Step 4: Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        assertThat("Password field is not displayed", passwordField.isDisplayed(), is(true));
        passwordField.sendKeys(PASSWORD.getValue());

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

        assertTrue(successMessageForConnecting.getText().contains("Good job! You have send friend request!"));
    }

    @Test
    @Order(2)
    public void testApproveFriendRequest() {
        // Step # | name | target | value

        // 1 | open | / |
        driver.get("http://localhost:8081/");
        // 2 | setWindowSize | 1552x840 |
        driver.manage().window().setSize(new Dimension(1552, 840));
        // 3 | click | css=.nav-item:nth-child(2) > .nav-link |
        driver.findElement(By.cssSelector(".nav-item:nth-child(2) > .nav-link")).click();
        // 4 | click | id=username |
        driver.findElement(By.id("username")).click();
        // 5 | type | id=username | Martin
        driver.findElement(By.id("username")).sendKeys(MARTIN);
        // 6 | type | id=password | 123456
        driver.findElement(By.id("password")).sendKeys(PASSWORD.toString());
        // 7 | click | css=input:nth-child(10) |
        driver.findElement(By.cssSelector("input:nth-child(10)")).click();
        // 8 | click | css=.nav-item:nth-child(5) > .nav-link |
        driver.findElement(By.cssSelector(".nav-item:nth-child(5) > .nav-link")).click();
        // 9 | click | css=.btn |
        driver.findElement(By.cssSelector(".btn")).click();

        // wait for element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn.btn-primary.py-2[value='Approve Request']")));
        approveButton.click();

        // assertion: check that element with `value="Approve Request"` is not present in the page:
        List<WebElement> approveRequestButtons = driver.findElements(By.cssSelector("input.btn.btn-primary.py-2[value='Approve Request']"));
        assertTrue(approveRequestButtons.isEmpty());

        // wait for element h3 containing „There are no requests“ to be visible:
        boolean isTextPresent = wait.until(driver -> {
            List<WebElement> h3Elements = driver.findElements(By.tagName("h3"));
            return h3Elements.stream().anyMatch(element -> element.getText().contains("There are no requests"));
        });

        //assertion that there is at least one h3 element containing this text
        assertTrue(isTextPresent);
    }

}

