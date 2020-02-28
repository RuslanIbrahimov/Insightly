package com.insightly.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.insightly.qa.base.BaseClass;
import com.insightly.qa.pages.ContactsPage;
import com.insightly.qa.pages.HomePage;
import com.insightly.qa.pages.LoginPage;
import com.insightly.qa.pages.TasksPage;
import com.insightly.qa.util.Utility;

public class ContactsPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	Utility util;
	
	String xSheetName = "Sheet1";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.validateClickOnContactsLink();
	}

	@Test(priority = 1)
	public void validateContactsPageTitleTest() throws InterruptedException {
		util.waitFor(3);
		String contactsPageTitle = contactsPage.validateContactsPageTitle();
		Assert.assertEquals(contactsPageTitle, "Contacts - Insightly");
	}

	@Test(priority = 2)
	public void validateContactsText() throws InterruptedException {
		util.waitFor(1);
		Assert.assertTrue(contactsPage.validateContactsText());
		util.waitFor(2);
	}

	@DataProvider
	public Object[][] getInsightlyTestData() throws InvalidFormatException {
		Object data[][] = Utility.getTestData(xSheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getInsightlyTestData")
	public void createNewContactsTest(String firstName, String lastName, String email, String phoneNumber) throws InterruptedException {
		util.waitFor(2);
		contactsPage.validateCreateNewContactsButton();
		util.waitFor(2);
		contactsPage.createNewContacts(firstName, lastName, email, phoneNumber);
		util.waitFor(2);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
