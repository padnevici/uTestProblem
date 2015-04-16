package org.utest;

import org.testng.*;
import org.testng.annotations.*;

public class Tests extends TestBase {

	@Test
	public void test_1() {
		System.out.println(Browser.getTitle());
	}
}
