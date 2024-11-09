package com.weare.pages.header;

import org.openqa.selenium.By;

public class AnonHeader extends BaseHeader{

    public AnonHeader(String pageSpecificUrl) {
        super("/");
    }

    protected final By registerBtn = By.linkText("REGISTER");
    protected final By signInBtn = By.xpath("//a[contains(text(),'SIGN')]");

}
