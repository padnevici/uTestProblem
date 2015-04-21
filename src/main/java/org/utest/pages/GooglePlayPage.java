package org.utest.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.utest.Browser;
import org.utest.Configs;
import org.utest.Pages;
import org.utest.pages.GoogleSearchPage.GoogleServices;

public class GooglePlayPage {

	private static final Logger logger = LogManager
			.getLogger(GooglePlayPage.class);

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//*[@id='gbwa']/div[contains(@class,'gb_6a')]/a[contains(@href,'/options/')]")
	private WebElement appsBtn;

	@FindBy(how = How.XPATH, using = "//ul//li/a[contains(@href,'play.google')]")
	private WebElement googlePlayLnk;

	public void searchFor(String text) {
		logger.info(String.format("Searching for: '%s'", text));
		searchBox.sendKeys(text);
		searchBox.submit();
	}

	public void openPageForAnApp(String pageName) {
		logger.info(String.format("Opening page for: '%s'", pageName));
		String xpath = String.format("//a[@title='%s']", pageName);

		// get all elements fir same name and click on first match
		WebElement element = Browser.getWebDriver()
				.findElement(By.xpath(xpath));
		Browser.clickOnWebElement(element);
	}

	public void goTo() {
		if (Browser.checkIfElementExists(appsBtn) == false)
			Pages.getGoogleSearchPage().goTo();

		logger.info(String.format("Navigating to [%s] page", this.getClass()
				.getName()));
		Pages.getGoogleSearchPage().openPageForGoogleService(
				GoogleServices.Play);
	}

	public boolean isAt() {
		boolean result = Browser.getTitle().trim().toLowerCase()
				.equals("google play");
		if (result) {
			logger.info(String.format("Title for [%s] is correct", this
					.getClass().getName()));
			return result;
		}

		logger.info(String.format("Title for [%s] page is not correct", this
				.getClass().getName()));
		return false;
	}
}
