package com.testng.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashBoardPageElements;
import pages.LoginPageElements;
import utils.CommonMethods;
import utils.ConfigsReader;

public class Task extends CommonMethods {

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void validLogin() {
		
		LoginPageElements login = new LoginPageElements();

		boolean displayed = login.logo.isDisplayed();
		
		Assert.assertTrue(displayed);

		sendKeys(login.username, ConfigsReader.getProperty("username"));

		sendKeys(login.password, ConfigsReader.getProperty("password"));

		click(login.loginBtn);

		DashBoardPageElements dashBoard= new DashBoardPageElements();
		String expectedWelcome= "Welcome Admin";
		String actualWelcome=dashBoard.welcome.getText();
		
		Assert.assertEquals(actualWelcome, expectedWelcome);
		

		wait(1);
	}

}
