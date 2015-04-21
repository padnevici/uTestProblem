package org.utest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import org.testng.annotations.*;
import org.utest.pages.Application;
import org.utest.pages.GooglePlayPage;
import org.utest.pages.HeaderPage.GoogleServices;

public class Tests extends TestBase {
	private static final Logger logger = LogManager.getLogger(Tests.class);

	@Test
	public void test_1() {
		try {
			Pages.getGoogleSearchPage().goTo();
			Assert.assertTrue(Pages.getGoogleSearchPage().isAt());

			Pages.getHeaderPage().openPageForGoogleService(GoogleServices.Play);
			Assert.assertTrue(Pages.getGooglePlayPage().isAt());

			Pages.getGooglePlayPage().searchFor("Software Testing Concepts");
			Pages.getGooglePlayPage().openPageForAnApp("SoftwareTesting");

			Pages.getApplicationPage().isAt("SoftwareTesting");
			Application app = Pages.getApplicationPage().getApplicationObject();
			Assert.fail("arteficial fail");
			Assert.assertNotEquals(app.getName(), "");
			Assert.assertNotEquals(app.getRating(), 0);
			Assert.assertNotEquals(app.getReviews(), 0);

			logger.info(String.format(
					"Application name: '%s'\tRating: %.1f\tReviews count: %d",
					app.getName(), app.getRating(), app.getReviews()));
		} catch (Exception e) {
			logger.error(e);
			logger.error(e.getStackTrace());
			Assert.fail("", e);
		}
	}
}
