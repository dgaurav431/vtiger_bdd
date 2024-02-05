package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	public LeadsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Lead...\"]")
	private WebElement addLeadsPlusButton;

	public WebElement getAddLeadsPlusButton() {
		return addLeadsPlusButton;
	}
	
	public void clickOnLeadsPlusButton() {
		addLeadsPlusButton.click();
	}
}
