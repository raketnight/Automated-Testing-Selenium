package com.qa.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username")
    private WebElement usernameBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(name = "FormsButton2")
    private WebElement submit;

    @FindBy(xpath="(//*[normalize-space(text()) and normalize-space(.)='All code updated April 2014, now uses PHP/PDO for database connectivity'])[1]/following::p[1]")
    private WebElement pageTitle;

    @FindBy(xpath="(//*[normalize-space(text()) and normalize-space(.)='The status was:'])[1]/following::center[1]")
    private WebElement loginSuccess;

    public void enterName(String text) {
        usernameBox.sendKeys(text);
    }

    public void enterPassword(String text) {
        passwordBox.sendKeys(text);
        submit.click();
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getLoginResult() {
        return loginSuccess;
    }
}
