package org.utest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.utest.Browser;

public class HeaderPage {

	private static final Logger logger = LogManager.getLogger(HeaderPage.class);

	public enum GoogleServices {
		Play, Drive, YouTube, Gmail, Maps, Calendar, News
	}

	@FindBy(how = How.XPATH, using = "//*[@id='gbwa']/div[contains(@class,'gb_6a')]/a[contains(@href,'/options/')]")
	protected WebElement appsBtn;

	@FindBy(how = How.XPATH, using = "//ul//li/a[contains(@href,'play.google')]")
	protected WebElement googlePlayLnk;
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchBox;

	public void searchFor(String text) {
		logger.info(String.format("Searching for: '%s'", text));
		searchBox.sendKeys(text);
		searchBox.submit();
	}

	public void openPageForGoogleService(GoogleServices app) {
		switch (app) {
		case Play:
			logger.info(String.format("Opening [%s] google service page", app));
			Browser.clickOnWebElement(appsBtn);
			Browser.clickOnWebElement(googlePlayLnk);
			break;
		default:
			logger.info("Is not supported yet");
		}
	}
}
