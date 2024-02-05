package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement addOrganizationPlusButton;

	public WebElement getAddOrganizationPlusButton() {
		return addOrganizationPlusButton;
	}
	
	public void clickOnOrganizationPlusButton() {
		addOrganizationPlusButton.click();
	}

}
