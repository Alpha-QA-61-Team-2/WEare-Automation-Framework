package wearetests.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.enums.TestData.PASSWORD;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAddAndApproveFriendRequest extends BaseTestClassOlga {


    @Test
    @Order(1)
    public void testAddFriend() {
        loginWithUsernameAndPassword(OLGA, PASSWORD);

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
        loginWithUsernameAndPassword(MARTIN, PASSWORD);

        // Step # | name | target | value
        driver.get("http://localhost:8081/auth/users/41/profile");
        String currentUrl = driver.getCurrentUrl();

        driver.findElement(By.xpath("/html/body/section[1]/div[2]/form/input")).click();

        // wait for element to be clickable
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

