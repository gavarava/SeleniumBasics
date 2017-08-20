package com.automation.tests.support.demowebsite;

import java.io.File;
import java.net.Proxy;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PHPTravelsTestHelper {

	private static String CHROME_DRIVER_PATH = "Drivers/chromeDriver.exe";

	// TODO Använd driver factory för att få en WebDriver så man kan använder vad som helst är kräv
	private WebDriver webDriver;

	// Drivers need to be initialized at startup, it uses the JSON Wire Protocol.
	public PHPTravelsTestHelper() {
		initializeDriver();
	}

	private void initializeDriver() {
		validatePath(CHROME_DRIVER_PATH);
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		ChromeOptions options = setupChromeOptions();
		setDesiredCapabilitiesForTesting(options);
		this.webDriver = new ChromeDriver(options);
	}

	private void validatePath(String chromeDriverPath) {
		File file = new File(CHROME_DRIVER_PATH);
		file.exists();
	}

	private ChromeOptions setupChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		return options;
	}

	private void setDesiredCapabilitiesForTesting(ChromeOptions options) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		desiredCapabilities.setJavascriptEnabled(true);
		desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
		desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, false);
		desiredCapabilities.setCapability(CapabilityType.PROXY, Proxy.NO_PROXY);
		desiredCapabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}

	public void navigateTo(String url) {
		webDriver.get(url);
	}

	public void quitBrowser() {
		webDriver.quit();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
}
