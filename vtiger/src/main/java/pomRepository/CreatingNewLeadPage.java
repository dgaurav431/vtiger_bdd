package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {

	public CreatingNewLeadPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "salutationtype")
	private WebElement leadsSalutationDropdown;
	
	@FindBy(name = "firstname")
	private WebElement leadFirstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement leadLastNameTextField;
	
	@FindBy(name = "company")
	private WebElement leadCompanyNameTextField;
	
	@FindBy(xpath = "//input[@value=\"T\"]")
	private WebElement leadsAssignToGroupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement leadAssignToDropDown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement leadSaveButton;

	public WebElement getLeadsSalutationDropdown() {
		return leadsSalutationDropdown;
	}

	public WebElement getLeadFirstNameTextField() {
		return leadFirstNameTextField;
	}

	public WebElement getLeadLastNameTextField() {
		return leadLastNameTextField;
	}

	public WebElement getLeadCompanyNameTextField() {
		return leadCompanyNameTextField;
	}

	public WebElement getLeadsAssignToGroupRadioButton() {
		return leadsAssignToGroupRadioButton;
	}

	public WebElement getLeadAssignToDropDown() {
		return leadAssignToDropDown;
	}

	public WebElement getLeadSaveButton() {
		return leadSaveButton;
	}
	
	public void selectLeadSalutation(String option) {
		
		Select select = new Select(leadsSalutationDropdown);
		select.selectByVisibleText(option);
	}
	
	public void enterLeadsFirstName(String firstName) {
		leadFirstNameTextField.sendKeys(firstName);
	}
	
	public void enterLeadsLastName(String lastName) {
		leadLastNameTextField.sendKeys(lastName);
	}
	
	public void enterLeadsCompanyName(String companyName) {
		leadCompanyNameTextField.sendKeys(companyName);
	}
	
	public void clickOnAssignedToGroupsRadioButton() {
		leadsAssignToGroupRadioButton.click();
	}
	
	public void selectFromAssignToGroupDropDown(String option) {
		
		Select select = new Select(leadAssignToDropDown);
		select.selectByVisibleText(option);
	}
	
	public void clickOnSaveButton(){
		leadSaveButton.click();
		
	}
	
}
