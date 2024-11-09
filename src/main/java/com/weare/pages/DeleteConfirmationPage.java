package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class DeleteConfirmationPage extends LoggedHeader {

    public DeleteConfirmationPage(String pageSpecificUrl) {
        super("/");
    }

    protected final By actionSelect = By.id("StringListId");
    protected final By submitBtn = By.cssSelector("input[type='submit']");
}
