package com.weare.pages.header;

import org.openqa.selenium.By;

public class AdminHeader extends LoggedHeader {

    protected final By adminZoneBtn = By.xpath("//a[contains(text(),'admin')]");
}
