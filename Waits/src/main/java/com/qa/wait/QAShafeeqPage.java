package com.qa.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAShafeeqPage {
	
	@FindBy(id = "quote")
	private WebElement parent;
	
	public WebElement getElement(WebDriver driver) {
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("shafeeq")));
		return element;
	}
	
}
