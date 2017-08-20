package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.tests.support.driver.DriverManager;
import com.automation.tests.support.driver.DriverType;
import com.automation.tests.support.driver.factory.DriverManagerFactory;

public class TestBase {

	private   DriverManager webDriverManager;
	protected WebDriver     driver;

	@BeforeSuite
	public void beforeSuite() {
		webDriverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = webDriverManager.getDriver();
	}

	@AfterSuite
	public void afterSuite() {
		webDriverManager.quitDriver();
	}
}
