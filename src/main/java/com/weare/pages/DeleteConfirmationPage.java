package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class DeleteConfirmationPage extends LoggedHeader {

    protected final By actionSelect = By.id("StringListId");
    protected final By submitBtn = By.cssSelector("input[type='submit']");
}
