package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PostCreationEditPage extends LoggedHeader {

    protected final By visibilitySelector = By.id("StringListId");
    protected final By textField = By.id("message");
    protected final By chooseFileBtn = By.id("imagefile");
    protected final By savePostBtn = By.cssSelector("input[type='submit']");
    //protected final By likeButton =
    protected final By dropdownButton = By.xpath("//option[. = 'Public post']");

    protected static final String BODY_OF_THE_POST = "this is a post test post is this is this what is this this is it!";


    public void selectFromDropdownAndClickInBodyOfThePost() {
        //driver().scrollToElement(dropdownButton);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(dropdownButton)).click();
        driver().findElement(textField).click();
        driver().findElement(textField).sendKeys(BODY_OF_THE_POST);
    }

    public void submitPost() {
        driver().findElement(savePostBtn).click();
    }

    public boolean isSuccessMessageVisible() {
        WebElement webElement = driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div/div/div[2]/p[2]"));
        return webElement.getText().contains(BODY_OF_THE_POST);
    }
}
