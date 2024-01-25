package opportunities_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CampaignInformationPage;
import pomRepository.CampaignsPage;
import pomRepository.CreatingNewCampaignPage;
import pomRepository.CreatingNewOpportunityPage;
import pomRepository.CreatingNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.OpportunitiesPage;
import pomRepository.OpportunityInformationPage;
import pomRepository.OrganizationInformationPage;
import pomRepository.OrganizationPage;
@Listeners(genericUtility.ListenersImplementationClass.class)
public class CreateOpportunitiesTest extends BaseClass {

	@Test(retryAnalyzer = genericUtility.RetryAnalyzerImplementationClass.class, groups = "regression")
	public void createOpportunitiesWithOrganizationNameAndCampaignNameAndVerifyTest() throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		//Test Data
		String organizationName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1, 0)+jUtils.generateRandomNo(10000);
		String campaignName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEET_NAME, 1, 0);
		String opportunityName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 0);
		String opportunityClosingDate = eUtils.fetchDateDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 1);
		String organizationLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 2);
		String campaignLookUpPageTitle = eUtils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 3);

		//Object Creation
		HomePage home = new HomePage(driver);
		OrganizationPage organization = new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver);

		CampaignsPage campaign = new CampaignsPage(driver);
		CreatingNewCampaignPage createCampaign = new CreatingNewCampaignPage(driver);
		CampaignInformationPage campaignInfo = new CampaignInformationPage(driver);

		OpportunitiesPage opportinty = new OpportunitiesPage(driver);
		CreatingNewOpportunityPage createOpportunity = new CreatingNewOpportunityPage(driver);
		OpportunityInformationPage opportunityInfo = new OpportunityInformationPage(driver);

		//Test Script
		home.clickOnOrganizationsModule();
		organization.clickOnOrganizationPlusButton();
		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		String actualOrganizationInfo = organizationInfo.verifyOrganizationInformation(organizationName);
		
		Assert.assertTrue(actualOrganizationInfo.contains(organizationName));
		System.out.println("Pass: the organization has been created");
		
		home.clickOnCampaignModule();
		campaign.clickOnCampaignPlusButton();
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		String actualCampaignInfo = campaignInfo.verifyCampaignInformation(campaignName);
		
		Assert.assertTrue(actualCampaignInfo.contains(campaignName));
		System.out.println("Pass: the campaign has been created");
		
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

}
