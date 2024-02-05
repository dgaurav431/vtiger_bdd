package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pomRepository.CampaignInformationPage;
import pomRepository.CampaignsPage;
import pomRepository.CreatingNewCampaignPage;
import pomRepository.CreatingNewOpportunityPage;
import pomRepository.CreatingNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OpportunitiesPage;
import pomRepository.OpportunityInformationPage;
import pomRepository.OrganizationInformationPage;
import pomRepository.OrganizationPage;
import runner.TestRunner;

public class ToCreateAnOpportunityTest {
	
	public WebDriver driver;
	
	int random;

	public ToCreateAnOpportunityTest() {
		
		this.driver=TestRunner.driver;
	}
	

	
	
	@Given("Admin loggs in and is on the Home Page")
	public void admin_loggs_in_and_is_on_the_home_page() throws IOException {
		String username = FileUtility.fetchDataFromPropertyFile("username");
		String password = FileUtility.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login in to Application");
		System.out.println("The User has logged in and is on the Home Page"); 
	}

	@When("Admin creates an Organization")
	public void admin_creates_an_organization() throws EncryptedDocumentException, FileNotFoundException, IOException {
		random = JavaUtility.generateRandomNo(10000);
		String organizationName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1, 0)+random;

		HomePage home = new HomePage(driver);
		OrganizationPage organization = new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver);
		
		home.clickOnOrganizationsModule();
		organization.clickOnOrganizationPlusButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		String actualOrganizationInfo = organizationInfo.verifyOrganizationInformation(organizationName);
		
		Assert.assertTrue(actualOrganizationInfo.contains(organizationName));
		System.out.println("Pass: the organization has been created");
		  
	}

	@And("Admin creates a Campaign")
	public void admin_creates_a_campaign() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String campaignName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEET_NAME, 1, 0);
		
		HomePage home = new HomePage(driver);
		CampaignsPage campaign = new CampaignsPage(driver);
		CreatingNewCampaignPage createCampaign = new CreatingNewCampaignPage(driver);
		CampaignInformationPage campaignInfo = new CampaignInformationPage(driver);

		home.clickOnCampaignModule();
		campaign.clickOnCampaignPlusButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		
		String actualCampaignInfo = campaignInfo.verifyCampaignInformation(campaignName);
		
		Assert.assertTrue(actualCampaignInfo.contains(campaignName));
		System.out.println("Pass: the campaign has been created");
		

	}

	@And("Admin creates an Opportunity")
	public void admin_creates_an_opportunity() throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		String opportunityName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 0);
		String opportunityClosingDate = ExcelUtility.fetchDateDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 1);
		String organizationLookUpPageTitle = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 2);
		String campaignLookUpPageTitle = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 3);
		String campaignName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEET_NAME, 1, 0);
		String organizationName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1, 0)+random;

		
		HomePage home = new HomePage(driver);
		OpportunitiesPage opportinty = new OpportunitiesPage(driver);
		CreatingNewOpportunityPage createOpportunity = new CreatingNewOpportunityPage(driver);
		OpportunityInformationPage opportunityInfo = new OpportunityInformationPage(driver);
		
		home.clickOnOpportunityModule();
		opportinty.clickOnOpportunitiesPlusButton();
		createOpportunity.enterOpportunityName(opportunityName);
		createOpportunity.enterOrganizationDetailsinOrganizationLookUpPage(organizationLookUpPageTitle, organizationName);
		
		createOpportunity.enterCampaignDetailsinCampaignSourceLookUpPage(campaignLookUpPageTitle, campaignName);
		createOpportunity.enterClosingDate(opportunityClosingDate);
		createOpportunity.clickOnSaveButton();
		
		String actualOpportunityName = opportunityInfo.verifyOpportunityInformation(opportunityName);
		Assert.assertTrue(actualOpportunityName.contains(opportunityName));
		System.out.println("Pass: the opportunity has been created");
	}

	@Then("Admin verifies the Opportunity")
	public void admin_verifies_the_opportunity() throws EncryptedDocumentException, FileNotFoundException, IOException {
		OpportunityInformationPage opportunityInfo = new OpportunityInformationPage(driver);
		String opportunityName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 0);

		String actualOpportunityName = opportunityInfo.verifyOpportunityInformation(opportunityName);
		Assert.assertTrue(actualOpportunityName.contains(opportunityName));
		System.out.println("Pass: the opportunity has been created");
	}

}
