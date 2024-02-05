package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	public OpportunitiesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Opportunity...\"]")
	private WebElement addOpportunitiesPlusButton;

	public WebElement getAddOpportunitiesPlusButton() {
		return addOpportunitiesPlusButton;
	}
	
	public void clickOnOpportunitiesPlusButton() {
		addOpportunitiesPlusButton.click();
	}
}
