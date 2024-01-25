package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewOpportunityPage {
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "potentialname")
	private WebElement opportunitiesNameTextField;

	@FindBy(xpath = "//select[@id=\"related_to_type\"]/../..//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement organizationLookUpButton;

	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[2]")
	private WebElement campaignSourceLookUpButton;
	
	@FindBy(name = "closingdate")
	private WebElement closingDateCalenderTextField;
	
	@FindBy(name = "search_text")
	private WebElement organizationLookPageSearchTextField;
	
	@FindBy(name = "search")
	private WebElement organizationLookUpPageSearchButton;
	
	@FindBy(name = "search_text")
	private WebElement campaignLookPageSearchTextField;
	
	@FindBy(name = "search")
	private WebElement campaignLookUpPageSearchButton;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement organizationSaveButton;

	public WebElement getOpportunitiesNameTextField() {
		return opportunitiesNameTextField;
	}

	public WebElement getOrganizationLookUpButton() {
		return organizationLookUpButton;
	}

	public WebElement getCampaignSourceLookUpButton() {
		return campaignSourceLookUpButton;
	}

	public WebElement getClosingDateCalenderTextField() {
		return closingDateCalenderTextField;
	}
	
	public void enterOpportunitiesName(String opportunityName) {
		opportunitiesNameTextField.sendKeys(opportunityName);
	}
	
	
	public WebElement getOrganizationLookPageSearchTextField() {
		return organizationLookPageSearchTextField;
	}

	public WebElement getOrganizationLookUpPageSearchButton() {
		return organizationLookUpPageSearchButton;
	}

	public WebElement getCampaignLookPageSearchTextField() {
		return campaignLookPageSearchTextField;
	}

	public WebElement getCampaignLookUpPageSearchButton() {
		return campaignLookUpPageSearchButton;
	}

	public WebElement getOrganizationSaveButton() {
		return organizationSaveButton;
	}

	public void enterOpportunityName(String opportunityName) {
		opportunitiesNameTextField.sendKeys(opportunityName);
	}
	public void enterOrganizationDetailsinOrganizationLookUpPage(String titleOfPageToSwitch, String organizationName) {
		
		String parentWindowTitle = driver.getTitle();
		organizationLookUpButton.click();
		
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(driver, titleOfPageToSwitch);
		organizationLookPageSearchTextField.sendKeys(organizationName);
		organizationLookUpPageSearchButton.click();
		
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		
		wUtils.switchToChildBorwser(driver, parentWindowTitle);
		
	}
	
	public void enterCampaignDetailsinCampaignSourceLookUpPage(String titleOfPageToSwitch, String campaignName) {
		
		String parentWindowTitle = driver.getTitle();
		campaignSourceLookUpButton.click();
		
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBorwser(driver, titleOfPageToSwitch);
		campaignLookPageSearchTextField.sendKeys(campaignName);
		campaignLookUpPageSearchButton.click();
		
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		
		wUtils.switchToChildBorwser(driver, parentWindowTitle);
		
	}
	
	
	public void enterClosingDate(String dateInYYYY_MM_DD_Format) {
		
		closingDateCalenderTextField.sendKeys(dateInYYYY_MM_DD_Format);
	}
	
	
	public void clickOnSaveButton(){
		organizationSaveButton.click();
		
	}
}
