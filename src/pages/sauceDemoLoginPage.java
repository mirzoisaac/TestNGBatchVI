package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class sauceDemoLoginPage extends CommonMethods{
	
	@FindBy (id="user-name")
	public WebElement userNameTextBox;
	
	@FindBy (id="password")
	public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@class='btn_action']")
	public WebElement loginButton;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface')]")
	public WebElement errorMsg;
	
	public sauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	public void login() {
//		sendKeys(userNameTextBox, "standard_user");
//		sendKeys(passwordTextBox, "secret_sauce");
//		click(loginButton);
//		
//	}
	

}
