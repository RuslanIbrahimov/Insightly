package com.insightly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insightly.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory/Object Repository
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"login-button\"]")
	WebElement loginBttn;

	@FindBy(id = "newuser")
	WebElement signinBttn;

	@FindBy(id = "svg2")
	WebElement insightlyLogo;

	@FindBy(id = "newuser")
	WebElement signinBtt;

	// Initialization WebElements/Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateInsightlyLogo() {
		return insightlyLogo.isDisplayed();
	}

	public HomePage login(String usrnm, String psswrd) {
		username.sendKeys(usrnm);
		password.sendKeys(psswrd);
		loginBttn.click();
		return new HomePage();

	}

}
