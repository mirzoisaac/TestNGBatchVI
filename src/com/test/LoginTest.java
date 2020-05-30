package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//	
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test
	public void validAdminLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.username, ConfigsReader.getProperty("username"));
		sendKeys(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//DashboardPageElements dashboard = new DashboardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		//Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	@Test
	public void invalidPasswordLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.username, ConfigsReader.getProperty("username"));
		sendKeys(login.password, "uiuguig");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test(enabled=true)
	public void emptyUsernameLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	

}
