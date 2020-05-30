package com.testng.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.CommonMethods;
import utils.ConfigsReader;

public class TC01HrmsLogin extends CommonMethods{
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test
	public void avalidLogin() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendKeys(username, ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendKeys(password, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));
		
		WebElement logo=xpath("//div[@id='branding']//img");
		
		if(logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Logo is not displayed");
		}
		
	}
	
	@Test
	public void  negativeLogin() throws Exception {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendKeys(username, ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendKeys(password, "");
		click(driver.findElement(By.id("btnLogin")));
		
		WebElement passEmpty=xpath("//span[@id='spanMessage']");
		String expected="Password cannot be empty";
		String actual=passEmpty.getText();
		if(expected.equals(actual)) {
			System.out.println("Pasword cannot be empty is displayed "+passEmpty.isDisplayed());
		}else {
			System.out.println("It is not diplayed");
			throw new Exception();
		}
		
	}
	
	

}
