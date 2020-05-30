package com.testng.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.CommonMethods;
import utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods{
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	// @Test
	public void titleValidation() throws Exception {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		} else {
			System.out.println("titleValidation failed");
			throw new Exception();
		}
		Thread.sleep(2000);
	}

	// @Test
	public void logoValidation() throws Exception {
		String logoPath = "//div[@id='divLogo']/img";
		WebElement logo = driver.findElement(By.xpath(logoPath));
		boolean isDisplayed = logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("logoValidation passed");
		} else {
			System.out.println("logoValidation failed");
			throw new Exception();
		}
		Thread.sleep(2000);
	}
	

	@Test
	public void validLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
//		sendText(username, "Admin");
		sendKeys(username, ConfigsReader.getProperty("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendKeys(password, ConfigsReader.getProperty("password"));

		click(driver.findElement(By.id("btnLogin")));
		
		String expectedWelcome= "Welcome Admin";
		WebElement welcome=driver.findElement(By.xpath("//a[@id='welcome']"));
		String actualWelcome= welcome.getText();
		if(expectedWelcome.equals(actualWelcome)) {
			System.out.println("Welcome admin is displayed "+welcome.isDisplayed());
		}else {
			System.out.println("Welcome admin is not displayed");
		}

		// HW
		// Validate that Welcome Admin is displayed
		// Check the reports in test-output folder
		Thread.sleep(2000);

	}

}
