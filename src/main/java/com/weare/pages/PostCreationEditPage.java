package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class PostCreationEditPage extends LoggedHeader {

    protected final By visibilitySelector = By.id("StringListId");
    protected final By textField = By.id("message");
    protected final By chooseFileBtn = By.id("imagefile");
    protected final By savePostBtn = By.cssSelector("input[type='submit']");
    //protected final By likeButton =
}
