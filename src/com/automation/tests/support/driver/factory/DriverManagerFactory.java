package com.automation.tests.support.driver.factory;

import com.automation.tests.support.driver.DriverManager;
import com.automation.tests.support.driver.DriverType;
import com.automation.tests.support.driver.types.ChromeDriverManager;
import com.automation.tests.support.driver.types.FirefoxDriverManager;
import com.automation.tests.support.driver.types.SafariDriverManager;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new SafariDriverManager();
			break;
		}
		return driverManager;

	}
}
