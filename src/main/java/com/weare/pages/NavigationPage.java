package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testframework.Driver;

import static testframework.DriverManager.driver;

public class NavigationPage {

    private final By postSectionLink = By.xpath("//a[contains(text(),'Add')]");

    public void goToLatestPosts() {
        driver.findElement(By.xpath("//*[text()='Latest Posts']")).click();
    }

    public void goToPostSection() {
        driver.findElement(postSectionLink).click();
    }
}
