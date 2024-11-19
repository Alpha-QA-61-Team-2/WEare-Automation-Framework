package com.weare.pages.header;

import com.weare.pages.BasePage;
import org.openqa.selenium.By;

public class BaseHeader extends BasePage {

    public BaseHeader() {
        super("/");
    }

    protected final By homeBtn = By.linkText("Home");
    protected final By latestPostsBtn = By.linkText("Latest Posts");
    protected final By aboutUsBtn = By.linkText("About us");

    public void viewLatestPosts() {
        driver().findElement(latestPostsBtn).click();
    }
}
