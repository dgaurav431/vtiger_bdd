package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.FileUtility;
import genericUtility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinition",
    plugin = {"pretty", "html:target/htmlReport/cucumber-HTML-Report", "json:target/jsonReport/cucumber-Json-report.json", "junit:target/xmlReport/cucumber-xml-report.xml"})
public class TestRunner {
    
    public static WebDriver driver;
    
    @BeforeClass
    public static void setUp() throws IOException {
        String browser = FileUtility.fetchDataFromPropertyFile("browser");
        String url = FileUtility.fetchDataFromPropertyFile("url");
        
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        System.out.println("The browser is launched");
        WebDriverUtility.maximizeTheWindow(driver);
        WebDriverUtility.waitForElementsToLoaded(driver);
        driver.get(url);
        System.out.println("The URL is navigated");
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
        System.out.println("The Browser is closed");
    }
}
