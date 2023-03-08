package com.bridgelabz.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass_Mouse_And_Keyboard_Operations extends BaseClass {

	@Test
	public void mouse_Operation () throws InterruptedException {

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
	//  actions.dragAndDrop(drag, drop).perform();
		Thread.sleep(1000);

		actions.clickAndHold(drag).perform();
		actions.moveToElement(drop).release().perform();
		Thread.sleep(1000);

	}

	@Test

	public void mouse_Operations_On_FB() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement element1 = driver.findElement(By.id("pass"));
		Actions actions = new Actions(driver);
		element1.click();
		actions.moveToElement(element1).sendKeys("Abhishek@123").perform();
		Thread.sleep(1000);
		WebElement element2 = driver.findElement(By.id("email"));
		element2.click();
		actions.moveToElement(element2).sendKeys("Abhishek@gmail.com").perform();
		Thread.sleep(1000);
	}

	@Test
	public void keyBoard_Operations () throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("email"));
		actions.keyDown(Keys.SHIFT).perform();
		actions.sendKeys("abhishek@gmail.com");
		Thread.sleep(2000);
		actions.keyUp(Keys.SHIFT).perform();
		Thread.sleep(2000);

	}
	@Test
	
	public void change_whatsapp_profile () throws InterruptedException {
		driver.get("https://www.instagram.com/accounts/onetap/?next=%2F");
driver.findElement(By.name("username")).sendKeys("9219446890");
driver.findElement(By.name("password")).sendKeys("sanjaymishra44");
driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
Thread.sleep(5000);
		//driver.
	//	driver.findElement(By.xpath("//body/div[@id='mount_0_0_nV']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[8]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/span[1]/img[1]")).click();
	//	driver.switchTo().frame(0);
	}
}
