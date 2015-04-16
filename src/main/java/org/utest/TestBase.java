package org.utest;

import org.testng.annotations.*;


public class TestBase {

	@BeforeClass
	public void setUp(){
		Browser.initialize();
	}
	
	@AfterClass
	public void tearDown(){
		Browser.quit();
	}
}
