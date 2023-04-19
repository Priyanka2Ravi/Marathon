package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Preconditions {

	public String driverName;
	public WebDriver Driver;
	public String FileName;
	

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void baseconditions(String url, String username, String password) {

		if (driverName.equals("Chrome")) {
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--remote-allow-origins=*");
			options1.addArguments("--disable-notifications");
			Driver = new ChromeDriver(options1);
		} else if (driverName.equals("Edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--disable-notifications");
			Driver = new EdgeDriver(option);
		}
		Driver.get(url);
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// login
		Driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		Driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Driver.findElement(By.xpath("//input[@id='Login']")).click();

		// Applauncher
		Driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
	@AfterMethod
	public void browserClose()
	{
		Driver.close();
	}
	
	@DataProvider
	public String[][] DatafromExcel() throws IOException
	{
		return ExcelData.readData(FileName);
	}
}
