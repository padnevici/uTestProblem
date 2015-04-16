package org.utest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;

public class Browser {
	private static WebDriver webDriver = null;

	public static void initialize() {
		String browserType = Configs.getInstance().getBrowser().toLowerCase();
		if (browserType.toLowerCase().trim() == "chrome")
			initChrome();
		else if (browserType.toLowerCase().trim() == "firefox")
			initFirefox();
		else
			initFirefox();
	}

	private static void initChrome() {
		webDriver = new ChromeDriver();
		init();
	}

	private static void initFirefox() {
		webDriver = new FirefoxDriver();
		init();
	}

	private static void init() {
		navigate(Configs.getInstance().getUrl());
		webDriver.manage().window().setPosition(new Point(0, 0));
		webDriver.manage().window().maximize();
		webDriver
				.manage()
				.timeouts()
				.implicitlyWait(
						Configs.getInstance().getImplicitSeleniumWaitTime(),
						TimeUnit.SECONDS);
	}

	public static void navigate(String url) {
		webDriver.navigate().to(url);
		implicitWait();
	}

	public static void quit() {
		webDriver.quit();
	}
	
	public static void implicitWait() {
		implicitWait(Configs.getInstance().getImplicitWaitTime());
	}

	public static void implicitWait(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getTitle() {
		return webDriver.getTitle();
	}

	public static SearchContext getSearchContextDriver() {
		return webDriver;
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}
}
