package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Campaign...\"]")
	private WebElement addCampaignPlusButton;

	
	
	public WebElement getAddCampaignPlusButton() {
		return addCampaignPlusButton;
	}



	public void clickOnCampaignPlusButton() {
		addCampaignPlusButton.click();
	}

}
