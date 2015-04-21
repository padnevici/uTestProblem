package org.utest.pages;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.utest.Browser;
import org.utest.Pages;

public class GooglePlayPage extends HeaderPage {

	private static final Logger logger = LogManager
			.getLogger(GooglePlayPage.class);

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'see-more') and contains(@class,'apps') and contains(@href,'store')]")
	private WebElement seeMoreAppsLnk;

	public void openPageForAnApp(String appName) {
		logger.info(String
				.format("Opening page for: '%s' application", appName));

		// discover more apps if case
		Browser.implicitWait();
		if (Browser.checkIfElementExists(seeMoreAppsLnk)) {
			Browser.clickOnWebElement(seeMoreAppsLnk);

			for (int i = 0; i < 3; i++) {
				Actions builder = new Actions(Browser.getWebDriver());
				Browser.executeJavaScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
				builder.moveToElement(appsBtn).perform();
				Browser.executeJavaScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
				Browser.implicitWait(3000);
			}
		}

		String xpath = String.format("//a[@title='%s']", appName);

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
		Pages.getHeaderPage().openPageForGoogleService(GoogleServices.Play);
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
