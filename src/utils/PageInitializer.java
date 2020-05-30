package utils;

import pages.AddEmployeePageElements;
import pages.DashBoardPageElements;
import pages.LoginPageElements;
import pages.PersonalDetailsPageElements;
import pages.sauceDemoLoginPage;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashBoardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static sauceDemoLoginPage sauceDemoPage;
	
	public static void initialize() {
		
		login=new LoginPageElements();
		dashboard=new DashBoardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
		sauceDemoPage=new sauceDemoLoginPage();
	}

}
