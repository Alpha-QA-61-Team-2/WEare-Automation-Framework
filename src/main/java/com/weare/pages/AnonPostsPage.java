package com.weare.pages;

import com.weare.pages.header.AnonHeader;
import org.openqa.selenium.By;

public class AnonPostsPage extends AnonHeader {

    public AnonPostsPage(String pageSpecificUrl) {
        super("/posts");
    }

    protected final By explorePostBtn = By.xpath("//a[contains(text(),'Explore')]");
    protected final By seeProfileBtn = By.xpath("//a[contains(text(),'profile')]");
    protected final By categorySelect = By.id("name");
    protected final By browseCategoryBtn = By.xpath("(//input[@value='Browse'])");
}
