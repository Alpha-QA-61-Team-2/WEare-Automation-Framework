package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class PersonalProfilePage extends LoggedHeader {

    public PersonalProfilePage(String pageSpecificUrl) {
        super("/");
    }

    protected final By friendRequestsBtn = By.cssSelector("input[type='submit']");
    protected final By editProfileBtn = By.xpath("//a[contains(text(),'edit')]");
}
