package com.testng.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.ConfigsReader;
import utils.ExcelUtility;

public class HW extends CommonMethods{
	
	@Test(dataProvider = "userDataFromExcel", groups = { "homework", "addEmp", "regression" })
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		wait(1);

		// add employee information
		sendKeys(addEmp.firstName, firstName);
		sendKeys(addEmp.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = addEmp.employeeId.getAttribute("value");

		// click on Create Login Details
		click(addEmp.checkbox);
		wait(1);
		sendKeys(addEmp.username, username);
		sendKeys(addEmp.password, password);
		sendKeys(addEmp.confirmpwd, password);
		wait(1);
		jsClick(addEmp.btnSave);
		wait(1);

		// validation
		waitForVisibility(pdetails.personalDetailsLabel);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");

		// take screeshot
		takeScreenshot(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Raj", "Capoor", "raj123", "AmirKhan_@123" },
				{ "John", "Smith", "john123", "AmirKhan_@123" }, { "Mary", "Ann", "mary123", "AmirKhan_@123" },
				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testdata/Excel.xlsx", "Employee");
	}


}
