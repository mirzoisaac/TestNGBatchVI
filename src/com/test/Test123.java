package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Test123 extends CommonMethods {
	
	@BeforeMethod
	public void openBrowser() {
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");;
		//WebDriver driver= new ChromeDriver();
		setUp();
	}
	@Test
	public  void test() {
		
	}

}
