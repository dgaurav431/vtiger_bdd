package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.DataBaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IPathConstant;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pomRepository.CreatingNewLeadPage;
import pomRepository.HomePage;
import pomRepository.LeadsInformationPage;
import pomRepository.LeadsPage;
import pomRepository.LoginPage;
import runner.TestRunner;

public class ToCreateLeadTest {

	public WebDriver driver;
	
	public ToCreateLeadTest() {
		
		this.driver=TestRunner.driver;
	}
	
	
	
	

	@Given("The user logs in and is on the Home Page")
	public void the_user_logs_in_and_is_on_the_home_page() throws IOException {
		String username = FileUtility.fetchDataFromPropertyFile("username");
		String password = FileUtility.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login in to Application");
		System.out.println("The User has logged in and is on the Home Page");
	}

	@When("The user creates a Lead")
	public void the_user_creates_a_lead() throws EncryptedDocumentException, FileNotFoundException, IOException {
		// Test Data
		String leadSalutation = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignedToGroupOption = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);

		// Obejct creation statement of all POM Classes
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		CreatingNewLeadPage createLeads = new CreatingNewLeadPage(driver);
		// Actual Test Script
		home.clickOnLeadsModule();
		leads.clickOnLeadsPlusButton();
		createLeads.selectLeadSalutation(leadSalutation);
		createLeads.enterLeadsFirstName(leadFirstName);
		createLeads.enterLeadsLastName(leadLastName);
		createLeads.enterLeadsCompanyName(leadCompanyName);
		createLeads.clickOnAssignedToGroupsRadioButton();
		createLeads.selectFromAssignToGroupDropDown(leadAssignedToGroupOption);
		createLeads.clickOnSaveButton();
		System.out.println("The user has created a Lead");

	}

	@Then("The user verifies the Lead Information and Loggs Out")
	public void the_user_verifies_the_lead_information_and_loggs_out() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String leadFirstName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = ExcelUtility.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		LeadsInformationPage leadInfo = new LeadsInformationPage(driver);
		
		String actualLeadInfo = leadInfo.verifyLeadInformation(leadFirstName, leadLastName);
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("Pass: the Lead has been created");
		System.out.println("The Lead is verified");
		
		HomePage home = new HomePage(driver);
		home.signOutAction();
		System.out.println("The user has logged out");
		

	}

}
