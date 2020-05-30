package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class PersonalDetailsPageElements {
	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;
	@FindBy(css="input#btnLogin") public WebElement loginBtn;
	@FindBy(id="menu_pim_addEmployee") public WebElement addEmployee;
	@FindBy(id="menu_pim_viewPimModule") public WebElement pimBtn;
	@FindBy(id="personal_txtLicExpDate") public WebElement licExpDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']") public WebElement licExpMonth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']") public WebElement licExpYear;
	@FindBy(xpath="//input[@name='personal[optGender]']") public List<WebElement> gender;
	
	@FindBy(xpath="//label[@class='hasTopFieldHelp']")
	public WebElement fullNameLabel;
	
	@FindBy(xpath="//label[@for='employeeId']") public WebElement employeeIdLabel;

	@FindBy(xpath="//label[@for='photofile']") public WebElement photofileLabel;
	
	@FindBy(xpath="//div[@id='pdMainContainer']/div/h1") public WebElement personalDetailsLabel;
	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
