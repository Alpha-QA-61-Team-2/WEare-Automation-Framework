package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class ProfileEditorPage extends LoggedHeader {

    public ProfileEditorPage(String pageSpecificUrl) {
        super("/");
    }
    
    protected final By firstNameField = By.id("nameE");
    protected final By lastNameField = By.id("lastnameE");

    //todo finish class

}
