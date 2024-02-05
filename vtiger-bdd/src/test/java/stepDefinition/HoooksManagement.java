package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import genericUtility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import runner.TestRunner;

public class HoooksManagement {
	
	
	@After
	public void getScreenShot(Scenario scenario) throws WebDriverException, IOException {
		String name = scenario.getName();
		
		if(scenario.isFailed()) {
			WebDriverUtility.takeAScreenShot(TestRunner.driver, "./src/test/resources/screenshots/"+name+".png");
		}
		
	}

}
