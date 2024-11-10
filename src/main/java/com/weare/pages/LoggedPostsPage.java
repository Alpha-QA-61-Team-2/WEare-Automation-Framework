package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class LoggedPostsPage extends AnonPostsPage{

    private LoggedHeader loggedHeader;

    public LoggedPostsPage() {
        this.loggedHeader = new LoggedHeader();
    }

    protected final By likeBtn = By.cssSelector("input[value='Like']");
    protected final By browsePublicBtn = By.xpath("(//input[@value='Browse'])[1]");
    protected final By browseCategoryBtn = By.xpath("(//input[@value='Browse'])[2]");


}
