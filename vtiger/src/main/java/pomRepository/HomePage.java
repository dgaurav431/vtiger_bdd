package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a obejct repository to store elements belonging to Home Page of Vtiger Application
 * @author Akash Deb
 *
 */
public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Leads")
	private WebElement leadsModule;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;

	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;

	@FindBy(linkText = "Products")
	private WebElement productsModule;

	@FindBy(linkText = "More")
	private WebElement MoreDropdown;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMoreDropdown() {
		return MoreDropdown;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	public void clickOnLeadsModule() {
		leadsModule.click();
	}

	public void clickOnOrganizationsModule() {
		organizationsModule.click();
	}

	public void clickOnContactsModule() {
		contactsModule.click();
	}

	public void clickOnOpportunityModule() {
		opportunitiesModule.click();
	}

	public void clickOnProductModule() {
		productsModule.click();
	}

	public void clickOnCampaignModule() {

		Actions action = new Actions(driver);
		action.moveToElement(MoreDropdown).perform();
		action.click(campaignsModule).perform();
	}

	public void clickOnVendorModule() {

		Actions action = new Actions(driver);
		action.moveToElement(MoreDropdown).perform();
		action.click(vendorsModule).perform();
	}
	
	public void signOutAction() {
		Actions action = new Actions(driver);
		action.moveToElement(administratorIcon).perform();
		action.click(signOutOption).perform();
	}

}
