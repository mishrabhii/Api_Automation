package com.bridgelabz.qa.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launch_WebinarScreen extends BaseClass {
	@Test
	public void webinarScreen() throws InterruptedException, AWTException {
		
		driver.get("https://bldev.bridgelabz.com/webinar");

		boolean flag =driver.findElement(By.id("deftphnumber")).isDisplayed();
		if(flag)
		{
			driver.findElement(By.id("deftphnumber")).sendKeys("9651094335");
		}
		driver.findElement(By.id("deftemail")).sendKeys("abhi.mishra509@gmail.com");
		driver.findElement(By.id("deftusername")).sendKeys("Abhishek Mishra");

		List<WebElement> elements = driver.findElements(By.xpath("//div"));
		System.out.println("No of elements = " +elements.size());
		for (int i=0;i<elements.size();i++) {
			System.out.println("Element Text =" +elements.get(i).getAttribute("value"));
		}

		Thread.sleep(500);
		WebElement element = driver.findElement(By.id("deftyear"));
		element.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(500);
		element.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"passoutYears\"]/div[6]")).click();

		Thread.sleep(500);
		driver.findElement(By.id("deftdegree")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"degreeStreamOptions\"]/div[1]")).click();

		driver.findElement(By.id("deftsbtn")).click();

		String title  =driver.getTitle();
		System.out.println("current page title is = "+ title);
		AssertJUnit.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job", title);

		String pgsrc =driver.getPageSource();
		System.out.println("current page source is = "+ pgsrc);

		String url = driver.getCurrentUrl();
		System.out.println("current page url is = "+ url);


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deftdegree")));
		element1.click();

		Thread.sleep(500);
		System.out.println("Text : " +element1.getText());

		Thread.sleep(500);
		
		WebElement txt = driver.findElement(By.xpath("//*[@id=\"main-webinar-section\"]/section[1]/div/div[3]"));
		System.out.println("getting text =" +txt.getText());
		
		
	}
	

}
