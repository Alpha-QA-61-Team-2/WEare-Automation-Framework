package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import testframework.DriverManager;

import static testframework.DriverManager.driver;
import static testframework.core.BaseWebTest.driver;

import java.time.Duration;

public class DeletePostPage extends DriverManager {


    public void navigateToLatestPosts() {
        driver.findElement(By.linkText("Latest Posts")).click();
    }

    // Open a post and edit it
    public void openAndEditPost() {
        driver.findElement(By.cssSelector(".col-md-12:nth-child(2) .btn:nth-child(1)")).click();
        try {
            Thread.sleep(3000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Show comments section
    public void showComments() {
        driver.findElement(By.cssSelector(".show-comments")).click();
    }

    public void deletePost() {
        driver.findElement(By.xpath("//a[text()='Delete post']")).click();

        // Select "Delete comment" option from dropdown
        WebElement dropdownElement = driver.findElement(By.id("StringListId"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Delete post");

        // Confirm delete action
        driver.findElement(By.cssSelector(".btn")).click();
    }

    // Delete a comment
    public void deleteComment() {
        driver.findElement(By.xpath("//a[contains(text(),'Delete comment')]")).click();

        // Select "Delete comment" option from dropdown
        WebElement dropdownElement = driver.findElement(By.id("StringListId"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Delete comment");

        // Confirm delete action
        driver.findElement(By.cssSelector(".btn")).click();
    }

    /*public boolean isPostDeletedSuccessfullyVisible() {
        try {
            return driver().findElement(By.xpath("//*[contains(text(),'Post deleted successfully')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCommentDeletedSuccessfullyVisible() {
        try {
            return driver().findElement(By.xpath("//*[contains(text(),'Comment deleted successfully')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }*/
}
