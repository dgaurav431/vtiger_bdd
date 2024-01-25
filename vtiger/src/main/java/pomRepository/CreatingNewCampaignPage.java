package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignnameTextField;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getCampaignnameTextField() {
		return campaignnameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterCampaignName(String campaignName) {
		campaignnameTextField.sendKeys(campaignName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
