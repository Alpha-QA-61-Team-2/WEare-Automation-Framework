package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProfileEditorPage extends LoggedHeader {

    protected final By firstNameField = By.id("nameE");
    protected final By lastNameField = By.id("lastnameE");
    protected final By birthDateField = By.id("birthDayE");
    protected final By genderSelect = By.id("selectE");
    protected final By emailField = By.id("emailE");
    protected final By introField = By.id("publicinfoE");
    protected final By citySelect = By.id("selectC");
    protected final By updateBtn = By.xpath("//button[contains(text(),'Profile')]");

    public void submitUpdateForm(String firstName, String lastName) {
        if (!driver().findElement(firstNameField).getAttribute("value").isEmpty() ||
                !driver().findElement(lastNameField).getAttribute("value").isEmpty()) {
            driver().findElement(firstNameField).clear();
            driver().findElement(lastNameField).clear();
        }
        driver().findElement(firstNameField).sendKeys(firstName);
        driver().findElement(lastNameField).sendKeys(lastName);
        driver().findElement(birthDateField).sendKeys("01/01/1999");
        driver().findElement(emailField).clear();
        driver().findElement(emailField).sendKeys("some@mail.com");
        Select city = new Select(driver().findElement(citySelect));
        city.selectByVisibleText("Dospat");
        driver().findElement(updateBtn).click();
    }

    public boolean updatedDetailsAreSaved(String lastName) {
        return driver().findElement(lastNameField).getAttribute("value").contains(lastName);
    }

    public boolean isEmailChanged(String prevEmail) {
        return !driver().findElement(emailField).getAttribute("value").equals(prevEmail);
    }

}
