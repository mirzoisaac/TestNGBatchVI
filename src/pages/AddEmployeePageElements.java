package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class AddEmployeePageElements {
	
	@FindBy(id="firstName") 
	public WebElement firstName;
	@FindBy(id="lastName") 
	public WebElement lastName;
	@FindBy (id="employeeId")
	public WebElement employeeId;
	@FindBy (id="photofile")
	public WebElement photofile;
	@FindBy (id="btnSave") 
	public WebElement btnSave; 
	@FindBy (id="chkLogin") 
	public WebElement checkbox;
	
	//@FindBy(id="txtUsername") public WebElement username;
	//@FindBy(name="txtPassword") public WebElement password;
	
	@FindBy(id="user_name") public WebElement  username;
	@FindBy(id="user_password") public WebElement  password;
	@FindBy(id="re_password") public WebElement  confirmpwd;
	@FindBy(id="status") public WebElement  status;
	@FindBy(xpath="//span[text()='Required']") public WebElement required;
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
