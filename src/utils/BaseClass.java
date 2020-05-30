package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static void main(String[] args) {
		ConfigsReader.readProperties(Constants.CONFIGS_FILEPATH);
		
			System.out.println(ConfigsReader.getProperty("browser"));

		

	}
	
	public static WebDriver driver;
	
	@BeforeMethod (alwaysRun= true)
	public static void setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGS_FILEPATH);
		
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver= new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH);
			driver= new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize();
	}
	
	@AfterMethod (alwaysRun= true) 
	public static void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}

}
