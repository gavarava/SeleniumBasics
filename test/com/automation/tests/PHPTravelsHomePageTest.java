package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.junit.Ignore;
import org.testng.annotations.*;

import com.automation.tests.support.demowebsite.PHPTravelsTestHelper;

public class PHPTravelsHomePageTest {

	PHPTravelsTestHelper testHelper;

	@BeforeSuite
	public void beforeSuite() {

		testHelper = new PHPTravelsTestHelper();
		// Initialize Test Data
		// Set Configs for test results etc
	}

	@Test
	public void test_home_page_title() {
		assertEquals(testHelper.getWebDriver().getTitle(), "PHPTRAVELS | Travel Technology Partner");
	}

	@AfterTest
	public void afterTest() {
		testHelper.quitBrowser();
	}

	@AfterSuite
	public void afterSuite() {
		// Kill Data Initializations
	}

}
