package org.utest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import org.utest.pages.ApplicationPage;

public class TestBase extends TestListenerAdapter {

	protected static Logger logger = null;
	
	@BeforeClass
	public void setUp() {
		Browser.initialize();
		logger = LogManager
				.getLogger(TestBase.class);
	}

	@AfterClass
	public void tearDown() {
		Browser.quit();
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger.error("[Test Failed]: "+ tr.getMethod());
		logger.error(tr.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger.error("[Test Skipped]: "+ tr.getMethod());
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger.error("[Test Passed]: "+ tr.getMethod());
	}
}
