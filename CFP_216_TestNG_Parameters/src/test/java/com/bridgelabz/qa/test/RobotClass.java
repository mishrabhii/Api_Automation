package com.bridgelabz.qa.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RobotClass extends BaseClass {
	@Test
	
  public void mouseAndKeyBordOperationTest() throws AWTException {
	  
	  driver.get("https://bldev.bridgelabz.com/webinar");
	  driver.findElement(By.id("deftphnumber")).sendKeys("9651094335");
	
	  Robot robot = new Robot();
	  robot.delay(4000);
//	  robot.keyPress(KeyEvent.);
//	  robot.keyRelease(KeyEvent.VK_HOME);
	  robot.delay(5000);
	  robot.mouseMove(400, 400);
	  robot.delay(500);
	  robot.mouseWheel(6000);
	  robot.delay(500);
	  
	  
  }
}
