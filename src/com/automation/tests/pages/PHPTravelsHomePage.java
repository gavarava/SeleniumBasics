package com.automation.tests.pages;

import org.openqa.selenium.WebDriver;

public class PHPTravelsHomePage {

	// man måste Aldrig assert vid Page Objs

	private static String PHP_TRAVELS_HOMEPAGE = "http://www.phptravels.net/";

	private WebDriver webDriver;

	public PHPTravelsHomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		// Verify if we are on this page --- else throw custom exception
	}

	public void navigateToThisPage() {
		webDriver.get(PHP_TRAVELS_HOMEPAGE);
	}

}
