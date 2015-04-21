package org.utest;

import org.openqa.selenium.support.PageFactory;
import org.utest.pages.*;

public class Pages {
	public static HeaderPage getHeaderPage() {
		HeaderPage page = new HeaderPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static GoogleSearchPage getGoogleSearchPage() {
		GoogleSearchPage page = new GoogleSearchPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static GooglePlayPage getGooglePlayPage() {
		GooglePlayPage page = new GooglePlayPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
	
	public static ApplicationPage getApplicationPage() {
		ApplicationPage page = new ApplicationPage();
		PageFactory.initElements(Browser.getWebDriver(), page);
		return page;
	}
}
