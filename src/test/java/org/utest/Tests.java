package org.utest;

import org.testng.*;
import org.testng.annotations.*;
import org.utest.pages.GoogleSearchPage.GoogleServices;

public class Tests extends TestBase {

	@Test
	public void test_1() {
		Pages.getGoogleSearchPage().goTo();
		Assert.assertTrue(Pages.getGoogleSearchPage().isAt());
		
		Pages.getGoogleSearchPage().openPageForGoogleService(GoogleServices.Play);
		Assert.assertTrue(Pages.getGooglePlayPage().isAt());
		
		Pages.getGooglePlayPage().searchFor("Software Testing Concepts");
		Pages.getGooglePlayPage().openPageForAnApp("SoftwareTesting");
	}
}
