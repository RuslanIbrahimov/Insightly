package com.insightly.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.insightly.qa.util.Utility;

import com.insightly.qa.util.WebEventListener;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;

	public BaseClass() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/ruslan/eclipse-workspace/Insightly/src/main/java/com/"
					+ "insightly/qa/config/configuration.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ruslan/eclipse-workspace/Insightly/Drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ruslan/eclipse-workspace/Insightly/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		//e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		//eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		//driver = e_driver;
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
