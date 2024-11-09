package com.weare.pages;

import com.weare.pages.header.LoggedHeader;
import org.openqa.selenium.By;

public class ExplorePostPage extends LoggedHeader {

    public ExplorePostPage(String pageSpecificUrl) {
        super("/");
    }

    protected final By allPostsByUserBtn = By.cssSelector("input[value*='All']");
    protected final By editPostBtn = By.linkText("Edit post");
    protected final By deletePostBtn = By.linkText("Delete post");

    protected final By seeProfileBtn = By.linkText("See profile");

    protected final By showCommentsBtn = By.xpath("//button[contains(text(),'Comments')]");
    protected final By likeCommentBtn = By.cssSelector("input[value='Like']");
    protected final By editCommentBtn = By.linkText("Edit comment");
    protected final By deleteCommentBtn = By.linkText("Delete comment");
    protected final By commentTextField = By.id("message");
    protected final By postCommentBtn = By.cssSelector("input[value*='Post']");
}
