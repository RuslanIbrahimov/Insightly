package com.insightly.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insightly.qa.base.BaseClass;
import com.insightly.qa.pages.ContactsPage;
import com.insightly.qa.pages.HomePage;
import com.insightly.qa.pages.LoginPage;
import com.insightly.qa.pages.TasksPage;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	TasksPage tasksPage;
	ContactsPage contactsPage;

	HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Insightly", "Home page title doesn't match");
	}

	@Test(priority = 2)
	public void validateUserMenuTest() {
		Assert.assertTrue(homePage.validateUserMenu());
	}

	@Test(priority = 3)
	public void validateClickOnTasksLinkTest() {
		tasksPage = homePage.validateClickOnTasksLink();
	}

	@Test(priority = 4)
	public void validateClickOnContactsLinkTest() {
		contactsPage = homePage.validateClickOnContactsLink();
	}

	@Test(priority = 5)
	public void validateTotalSalesRepsTest() {
		Assert.assertTrue(homePage.validateTotalSalesReps());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
