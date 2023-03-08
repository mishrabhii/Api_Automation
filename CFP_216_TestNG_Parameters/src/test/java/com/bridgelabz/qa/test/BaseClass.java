package com.bridgelabz.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver = null;
	

	@BeforeTest
	@Parameters("browser")
	public void setup (@Optional("chrome")String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("safari")) {
		
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		}
		else {
			System.out.println("Not selected any Browser!!!");
		}
		
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

@AfterTest

	public void tearDown(){
	driver.close();
	}
}
