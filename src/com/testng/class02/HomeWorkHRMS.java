package com.testng.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddEmployeePageElements;
import pages.DashBoardPageElements;
import pages.LoginPageElements;
import pages.PersonalDetailsPageElements;
import utils.CommonMethods;
import utils.ConfigsReader;

public class HomeWorkHRMS extends CommonMethods {
	// HRMS Add Employee
	// 1.Open Chrome Browser
	/*
	 * 2.Go to http://human.... 3.Login into the application 4.Click on Add employee
	 * 5.Verify labels:Full Name, Employee ID, Photograph are displayed
	 *  6.ProvideEmployee first name and last name 
	 *  7.Add picture to the profile 
	 *  8.VerifyEmployee has been added successfully 
	 *  9.Close the browser
	 * 
	 */
	@BeforeMethod
	public static void openBrowser() {
		// SystemSystem.setProperty("webdriver.chrome.driver",
		// Constants.CHROME_DRIVER_PATH);//ChromePath
		// WebDriver driver= new ChromeDriver();
		// driver.get(url);
		setUp();
	}

	// TestCase1
	//@Test
	public static void logIn() {
		LoginPageElements login = new LoginPageElements();
		// login.username.sendKeys(ConfigsReader.getProperty("username"));
		// driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		sendKeys(login.username, ConfigsReader.getProperty("username"));
		login.password.sendKeys(ConfigsReader.getProperty("password"));
		login.loginBtn.click();
		wait(4);
	}

	// TestCase2
	@Test
	public static void addEmployee() {
		logIn();
		DashBoardPageElements dashBoard = new DashBoardPageElements();
		click(dashBoard.pim);
		wait(3);
		click(dashBoard.addEmployee);
		wait(3);

		// WebElement
		// fullnameLabel=driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
		AddEmployeePageElements addEmployee = new AddEmployeePageElements(); 
		PersonalDetailsPageElements pdetails= new PersonalDetailsPageElements();

		String expectedText = "Full Name";
		String actualText = pdetails.fullNameLabel.getText();
//         if(addEmployee.fullNameLabel.isDisplayed()) {
//        	 if(actualText.equals(expectedText)) {
//        		 System.out.println("Full Name Text Label is displayed and Written correctly");
//        	 }else{
//        		 System.out.println("The label text is incorrect");
//        	 }
//         }else {
//        	 System.out.println("Full Name Label is not displayed");
//         }
         
		// hard Assert
		Assert.assertEquals(actualText, expectedText, "Full Name Text Label is Written incorrectly");
		Assert.assertTrue(pdetails.fullNameLabel.isDisplayed(), "Full Name Label is not Displayed");
		
		Assert.assertTrue(pdetails.employeeIdLabel.isDisplayed());
		Assert.assertTrue(pdetails.photofileLabel.isDisplayed()," Photo label is not Displayed");
	
		// addEmployee.firstName.sendKeys("Alex");
		sendKeys(addEmployee.firstName, "Alex");
		sendKeys(addEmployee.lastName, "Jackson");
		sendKeys(addEmployee.employeeId, "70701");
		//addEmployee.photofile.sendKeys("C:\\Users\\mirzo\\Desktop/test case.txt");
		
		addEmployee.photofile.sendKeys("C:\\Users\\mirzo\\Downloads/download.jpeg");
		

	}

	@AfterMethod
	public static void quitBrowser() {
		wait(5);
		tearDown();

	}

}
