package com.bridgelabz.qa.test;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class JavaScriptExecutor extends BaseClass {

	@Test(description="retriving data from guru99 web related to api testing")

	public void getNoOfFrames() throws InterruptedException {

		driver.get("https://www.guru99.com/api-testing.html");
		JavascriptExecutor executer = (JavascriptExecutor)driver;

		int  NoOfFrames = Integer.parseInt(executer.executeScript("return window.length").toString());
		System.out.println("NoOfFrames ="+NoOfFrames);
				
		executer.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
	}
}
