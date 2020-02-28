package com.insightly.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.insightly.qa.base.BaseClass;

public class HomePage extends BaseClass {

	// Page Factory/Object Repository
	@FindBy(id = "userMenu")
	WebElement userMenu;

	@FindBy(xpath = "//*[@id=\"navlink_task\"]")
	WebElement tasksLink;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//*[@id=\"card-LOOKUPCARD1\"]")
	WebElement totalSalesReps;

	// Initialization WebElements/Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUserMenu() {
		return userMenu.isDisplayed();
	}

	public TasksPage validateClickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public ContactsPage validateClickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public boolean validateTotalSalesReps() {
		return totalSalesReps.isDisplayed();
	}

}
