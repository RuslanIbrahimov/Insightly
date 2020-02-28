package com.insightly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insightly.qa.base.BaseClass;

public class ContactsPage extends BaseClass {

	// Page Factory/Object Repository
	@FindBy(id = "objType")
	WebElement contactsText;

	@FindBy(id = "AddNewButton")
	WebElement newContactBttn;

	@FindBy(id = "//h1[contains(text(),'Add New Contact')]")
	WebElement addNewContactText;

	@FindBy(xpath = "//*[@id=\"Contact_FIRST_NAME\"]")
	WebElement firstName;

	@FindBy(xpath = "//*[@id=\"Contact_LAST_NAME\"]")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"Contact_EMAIL_ADDRESS\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"Contact_PHONE\"]")
	WebElement phoneNumber;
	
	@FindBy(id = "btn-save")
	WebElement saveBttn;

	//Initialization WebElements/Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateContactsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateContactsText() {
		return contactsText.isDisplayed();
	}
	
	public void validateCreateNewContactsButton() {
		newContactBttn.click();
	}
	
	public void createNewContacts(String ftName, String ltName, String eml, String phoneNum) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		email.sendKeys(eml);
		phoneNumber.sendKeys(phoneNum);
		saveBttn.click();
	}
}