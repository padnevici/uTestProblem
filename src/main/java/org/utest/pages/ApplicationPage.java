package org.utest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.utest.Browser;
import org.utest.Pages;

public class ApplicationPage extends HeaderPage {

	private static final Logger logger = LogManager
			.getLogger(ApplicationPage.class);

	@FindBy(how = How.XPATH, using = "//*[@id='body-content']//div[@class='document-title']/div")
	private WebElement titleLbl;

	@FindBy(how = How.XPATH, using = "//*[@id='body-content']//div[@class='rating-box']//meta[@itemprop='ratingValue']")
	private WebElement ratingLbl;

	@FindBy(how = How.XPATH, using = "//*[@id='body-content']//div[@class='rating-box']//meta[@itemprop='ratingCount']")
	private WebElement reviewsLbl;

	public Application getApplicationObject() {
		logger.debug(String
				.format("Getting object for current Application page"));
		Application app = new Application();
		app.setName(getName());
		app.setRating(getRating());
		app.setReviews(getReviewsCount());
		return app;
	}

	public String getName() {
		return titleLbl.getText().trim();
	}

	public double getRating() {
		return Double.parseDouble(ratingLbl.getAttribute("content").trim());
	}

	public long getReviewsCount() {
		return Long.parseLong(reviewsLbl.getAttribute("content").trim());
	}

	public void goTo(String appName) {
		logger.info(String.format("Navigating to [%s] application page",
				appName));
		Pages.getGooglePlayPage().goTo();
		Pages.getGooglePlayPage().searchFor(appName);
		Pages.getGooglePlayPage().openPageForAnApp(appName);
	}

	public boolean isAt(String appName) {
		boolean result = Browser.getTitle().trim().toLowerCase()
				.contains(appName.toLowerCase());
		if (result) {
			logger.info(String.format("Title for [%s] is correct", appName));
			return result;
		}

		logger.info(String
				.format("Title for [%s] page is not correct", appName));
		return false;
	}
}
