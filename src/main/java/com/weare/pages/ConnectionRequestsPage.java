package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class ConnectionRequestsPage extends LoggedHeader {

    protected final By approveBtn = By.cssSelector("input[value*='Approve']");
}
