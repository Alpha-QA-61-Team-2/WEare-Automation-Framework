package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class ProfileEditorPage extends LoggedHeader {

    protected final By firstNameField = By.id("nameE");
    protected final By lastNameField = By.id("lastnameE");
    protected final By birthDateField = By.id("birthDayE");
    protected final By genderSelect = By.id("selectE");
    protected final By introField = By.id("publicinfoE");
    protected final By citySelect = By.id("selectC");
    protected final By updateBtn = By.xpath("//button[contains(text(),'Profile')]");

    //todo finish class
    public void submitUpdateForm() {

    }
}
