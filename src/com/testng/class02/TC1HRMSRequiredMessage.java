package com.testng.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashBoardPageElements;
import pages.LoginPageElements;
import utils.CommonMethods;
import utils.ConfigsReader;

public class TC1HRMSRequiredMessage extends CommonMethods {
	
//	@BeforeMethod
//	public static void openBrowser() {//method1-->> method2
//		setUp();
//	}
	
	//US 67789 As an Admin while adding employee  
	//if I leave required fields empty I should see “Required” message
	
	@Test
	public void requiredMessage() {
		//LoginPageElements login= new LoginPageElements();
//		AddEmployeePageElements addEmp=new AddEmployeePageElements();
//		login.username.sendKeys("a");
//		addEmp.username.sendKeys("o");
		//login.login("Admin", "Hum@an123");
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		sendKeys(addEmp.firstName, "Ilhom");
		sendKeys(addEmp.lastName, " ");
		sendKeys(addEmp.employeeId, "1990");
		addEmp.photofile.sendKeys("C:\\Users\\mirzo\\Desktop/us_passport.jpg");
		addEmp.checkbox.click();
		sendKeys(addEmp.username, "ilhom123");
		sendKeys(addEmp.password, "ilhom1234");
		sendKeys(addEmp.confirmpwd, "ilhom1234");
		selectDdValue(addEmp.status, "Disabled");
		
		//driver.findElement(By.xpath("//span[text()='Required']")).getText();
		
//		if(addEmp.required.isDisplayed()) {
//			if(addEmp.required.getText().equals("Required")) {
//				System.out.println("Required is displayed and written correctly");
//			}else {
//				System.out.println("Not Displayed");
//			}
//		}
		//Assert.assertTrue(addEmp.required.isDisplayed(),"It is not displayed");
		//Assert.assertEquals(addEmp.required.getText(), "Required","Required is displayed and written correctly");
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(addEmp.required.isDisplayed(),"It is not displayed");
		soft.assertEquals(addEmp.required.getText(), "Required","Required is displayed and written correctly");
		
		System.out.println("After first assert Error");
	
		
		soft.assertAll();
		
		
		wait(2);
		
		
	}
	

}
