package stepDefinitionsforPages;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Preconditions extends AbstractTestNGCucumberTests {

	public ChromeOptions option;
	public static ChromeDriver driver;

	@BeforeMethod
	public void commonActions() {
		option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	
	@AfterMethod
	public void browserClose()
	{
		driver.close();
	}

}
