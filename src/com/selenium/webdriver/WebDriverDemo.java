package com.selenium.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {

	private static SlotPicker findSlotPickerWebElements(WebDriver driver) {
		// Extract Web Elements
		List<WebElement> slotPickerClassName = driver
				.findElements(By.className("store-pickup-delivery icon-pseudo storeHeaderSlot"));

		// There are eight different ways to locate a WebElement on a web page.
		// If WebDriver doesn't find the element, it throws a runtime exception named NoSuchElementException

		List<WebElement> usingLinkText = driver.findElements(By.linkText("Se lediga tider för hämtning/hemleverans"));

		// Partial Link Text also
		//findElements() vs findElement()
		// So it is always advisable to use the findElements () method rather than the findElement() method when trying to locate elements using tag names.
		// Name, ID, TagName, Class, LinkText, PartialLinkText, XPath, and CSS.
		List<WebElement>  slotPickerByXPath = driver.findElements(By.xpath("//*[@id=\"header\"]/section/section[1]/div[1]/a[1]"));
		// One disadvantage of using XPath is it is costly in terms of time.
		// Too Much Usage will make it slow

		List<WebElement> slotPickerByCSSSelector = driver.findElements(By.cssSelector("#header > section > section.store-header.table.clearfix > div.store-header-details > a.store-pickup-delivery.icon-pseudo.storeHeaderSlot"));
		//The By.cssSelector() method is similar to the By.xpath() method in its usage
		// but the difference is that it is slightly faster than the By.xpath locating mechanism.

		return new SlotPicker(slotPickerClassName, usingLinkText, slotPickerByXPath, slotPickerByCSSSelector);
	}

	private static WebDriver getWebDriverAndGoToWAUTUrl() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ica.se/handla/maxi-ica-stormarknad-lindhagen-id_13164/");
		return driver;
	}

	public static class SlotPicker {

		public static void main() {

			WebDriver driver = getWebDriverAndGoToWAUTUrl();

			SlotPicker slotPickerElements = findSlotPickerWebElements(driver);

		}

		private List<WebElement> slotPickerByClassName;
		private List<WebElement> slotPickerByLinkText;
		private List<WebElement> slotPickerByByXPath;
		private List<WebElement> slotPickerByCssSelector;

		public SlotPicker(List<WebElement>  slotPickerByClassName, List<WebElement> slotPickerByLinkText,
				List<WebElement> slotPickerByByXPath, List<WebElement> slotPickerByCssSelector) {
			this.slotPickerByClassName = slotPickerByClassName;
			this.slotPickerByLinkText = slotPickerByLinkText;
			this.slotPickerByByXPath = slotPickerByByXPath;
			this.slotPickerByCssSelector = slotPickerByCssSelector;
		}

		public List<WebElement> getSlotPickerByClassName() {
			return slotPickerByClassName;
		}

		public List<WebElement> getSlotPickerByLinkText() {
			return slotPickerByLinkText;
		}

		public List<WebElement> getSlotPickerByByXPath() {
			return slotPickerByByXPath;
		}

		public List<WebElement> getSlotPickerByCssSelector() {
			return slotPickerByCssSelector;
		}
	}


}
