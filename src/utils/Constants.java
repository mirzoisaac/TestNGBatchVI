package utils;

public class Constants {
	
	public static final String CHROME_DRIVER_PATH = "C:\\Users\\mirzo\\eclipse-workspace\\TestNGBatchVI/drivers/chromedriver.exe";

	//public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
	public static final String CONFIGS_FILEPATH = System.getProperty("user.dir") + "/configurations/configs.properties";
	public static final int EXPLICIT_WAIT_TIME = 20;
	public static final int IMPLICIT_WAIT_TIME = 10;

	public static void main(String[] args) {
		System.out.println(CHROME_DRIVER_PATH);

	}

}
