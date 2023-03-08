package com.bridgelabz.qa.test;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class CheckForDataProvider extends BaseClass {
//	@Test(description="Webinar screen Automation",priority = 0, dataProvider="dataProvider")
//
//	public void webinar_Screen(String phone_Number, String Name) throws InterruptedException {
//
//		driver.get("https://bldev.bridgelabz.com/webinar");
//
//		Thread.sleep(400);
//		driver.findElement(By.id("deftphnumber")).sendKeys(phone_Number);
//		Thread.sleep(400);
//		driver.findElement(By.id("deftusername")).sendKeys(Name);
//	} 
//	@DataProvider(name="dataProvider")
//	public Object[][] getDataTestExecution() {
//
//		return new Object[][] {
//			{"7265638738","abhishek"},
//			{"12833993","sanjay"},
//			{"938372673","rajeev"},
//		};
//	}

	@Test(dataProvider="dataProvider")
	public void phoneNumber(String phone_Number) throws InterruptedException {
		driver.get("https://bldev.bridgelabz.com/webinar");
		Thread.sleep(400);
		driver.findElement(By.id("deftphnumber")).sendKeys(phone_Number);

	}
	@DataProvider(name="dataProvider")
	public  Object[][] getDataTestExecution(Method m) {
		if(m.getName().equalsIgnoreCase("webinar_Screen"))
		{return new Object[][] {
			{"9651093849","abhishek"},
			{"7237698472","sanjay"},
			{"938372673","rajeev"},
		};
		}
		else {
			return new Object[][] {
				{"9651093849"},
				{"7237698472"},
				{"9383726739"},
			};
		}
	}
}
