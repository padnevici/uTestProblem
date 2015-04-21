package org.utest.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.utest.Browser;
import org.utest.Configs;

public class GoogleSearchPage {
	private static final Logger logger = LogManager
			.getLogger(GoogleSearchPage.class);

	public enum GoogleServices {
		Play, Drive, YouTube, Gmail, Maps, Calendar, News
	}

	@FindBy(how = How.XPATH, using = "//*[@id='gbwa']/div[contains(@class,'gb_6a')]/a[contains(@href,'/options/')]")
	private WebElement appsBtn;

	@FindBy(how = How.XPATH, using = "//ul//li/a[contains(@href,'play.google')]")
	private WebElement googlePlayLnk;

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

	public void goTo() {
		logger.info(String.format("Navigating to [%s] page", this.getClass().getName()));
		Browser.navigate(Configs.getInstance().getUrl());
	}

	public boolean isAt() {
		boolean result = Browser.getTitle().trim().toLowerCase()
				.equals("google");
		if (result) {
			logger.info(String.format("Title for [%s] is correct", this.getClass().getName()));
			return result;
		}

		logger.info(String.format("Title for [%s] page is not correct", this.getClass().getName()));
		return false;
	}
}
