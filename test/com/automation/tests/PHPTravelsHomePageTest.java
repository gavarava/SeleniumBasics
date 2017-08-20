package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import com.automation.tests.pages.PHPTravelsHomePage;

public class PHPTravelsHomePageTest extends TestBase {

	private PHPTravelsHomePage homePage;

	@BeforeSuite
	public void beforeSuite() {
		super.beforeSuite();
		homePage = PHPTravelsHomePage.initialize(driver);
	}

	@Test(description = "Checks the Title of the Home Page", priority = 0, alwaysRun = true)
	public void test_home_page_title() {
		homePage.navigate();
		assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
