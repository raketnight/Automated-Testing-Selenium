package com.qa.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
    @FindBy(name = "username")
    private WebElement usernameBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(name = "FormsButton2")
    private WebElement submit;

    @FindBy(xpath="(//*[normalize-space(text()) and normalize-space(.)='All code updated April 2014, now uses PHP/PDO for database connectivity'])[1]/following::p[1]")
    private WebElement pageTitle;

    @FindBy(xpath = "(//*[normalize-space(text()) and normalize-space(.)='All code updated April 2014, now uses PHP/PDO for database connectivity'])[1]/following::blockquote[4]")
    private WebElement currentUserPassword;

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

    public WebElement getUserPass() {
        return currentUserPassword;
    }
}
