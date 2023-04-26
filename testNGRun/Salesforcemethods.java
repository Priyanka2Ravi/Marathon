package testNGRun;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Salesforcemethods {
	
	public ChromeOptions option;
	public ChromeDriver driver;
	public static String FileName;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void commonaction(String url, String username, String password)
	{
		
		option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].scrollIntoView();", individual);
		driver.executeScript("arguments[0].click();", individual);
	}
	
	
	  @AfterMethod public void browserclose()
	  { driver.close(); }
	 
	
	
	@DataProvider
	public String[][] dynamicData() throws IOException
	{
		return ExcelData.readData(FileName);
	}
}
