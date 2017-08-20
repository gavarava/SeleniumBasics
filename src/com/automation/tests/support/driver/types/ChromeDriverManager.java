package com.automation.tests.support.driver.types;

import java.io.File;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.tests.support.driver.DriverManager;

public class ChromeDriverManager extends DriverManager {

	private static String CHROME_DRIVER_PATH = "Drivers/chromeDriver.exe";
	private ChromeDriverService chromeDriverService;

	@Override
	public void startService() {
		//doStartsService();
	}

	// TODO Use the Builder to set the Driver Capabilities
	private void doStartsService() {
		if (null == chromeDriverService) {
			try {
				chromeDriverService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File(CHROME_DRIVER_PATH))
						.usingAnyFreePort()
						.build();
				chromeDriverService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != chromeDriverService && chromeDriverService.isRunning())
			chromeDriverService.stop();
	}

	@Override
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = setupChromeOptions();
		setupDesiredCapabilities(capabilities, options);
		driver = new ChromeDriver(capabilities);
	}

	private ChromeOptions setupChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		return options;
	}

	private void setupDesiredCapabilities(DesiredCapabilities capabilities, ChromeOptions options) {
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
		capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, false);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}

}
