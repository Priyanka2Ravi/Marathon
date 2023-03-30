package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class TestCase4SalesForce {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver Driver = new ChromeDriver(options);
		Driver.get("https://login.salesforce.com/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//login
		Driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		Driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123 ");
		Driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		//learn more

		Driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		
		//new window
		Thread.sleep(3000);
		Set<String> windows = Driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windows);
		
		Driver.switchTo().window(windowlist.get(1));
		Driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Shadow root for selecting learning option
		
		Shadow shad = new Shadow(Driver);
		shad.findElementByXPath("//span[text()='Learning']").click();
		
		//Mouse hover Actions
		Thread.sleep(2000);
		Actions act = new Actions(Driver);
		WebElement wefirst = shad.findElementByXPath("//span[text()='Learning on Trailhead']");
		
		act.moveToElement(wefirst).perform();
		WebElement wesecond = shad.findElementByXPath("//a[contains(text(),'Salesforce Certification')]");
		act.scrollToElement(wesecond).perform();
		wesecond.click();
		
		//select certificates
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Administrator']")).click();
		
		System.out.println("current page Title: "  + Driver.getTitle());
		
		List<WebElement> certificates = Driver.findElements(By.xpath("(//div[contains(@class,'slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch')])[1]/div/div/div[3]"));
		
		String[] listOfcert = new String[certificates.size()];
		int i=0;
		for(WebElement e: certificates)
		{
			listOfcert[i] = e.getText();
			i++;
			
		}
		System.out.println("List of certificates:");
		for(String s:listOfcert)
		{
			System.out.println(s);
		}
		
		//ScreenShot
		
		WebElement wethird = Driver.findElement(By.xpath("(//div[@class='credentials-card_title'])[6]"));
		
		act.scrollToElement(wethird).perform();
		
		File src = Driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./marathon/salesforce_cert.png");
		
		FileUtils.copyFile(src, dest);
		
		Driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
