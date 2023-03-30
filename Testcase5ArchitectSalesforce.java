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

public class Testcase5ArchitectSalesforce {

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
		
		//select architect certificates
		Thread.sleep(2000);
		
		WebElement archi = Driver.findElement(By.xpath("//h1[text()='Administrator Credentials']"));
		act.scrollToElement(archi).perform();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
		
		//summary
		String summary = Driver.findElement(By.xpath("//div[contains(@class,'slds-container--center slds-container--medium slds-p-vertical--large')]/div")).getText();
		
		System.out.println("Summary of Salesforce Architect : "+ summary);
		
		//Certificate list
		WebElement certi = Driver.findElement(By.xpath("//a[text()='Heroku Architect']"));
		act.scrollToElement(certi).perform();
		
		List<WebElement> certificatelist = Driver.findElements(By.xpath("(//div[contains(@class,'slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch')])[1]/div/div/div[3]"));
		
		String[] cert = new String[certificatelist.size()];
		int i=0;
		
		System.out.println("List of Salesforce Architect Certificates are : ");
		for(WebElement e:certificatelist)
		{
			cert[i]= e.getText();
			System.out.println(cert[i]);
			i++;
			
		}
		
		Driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> certificatelist2 = Driver.findElements(By.xpath("//div[contains(@class,'slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch')]/div/div/div[3]"));
		
		
		String[] certs = new  String[certificatelist2.size()];
		int j=0;
		System.out.println("List of Application Architect Certificates are : ");
		for(WebElement f:certificatelist2)
		{
			certs[j]= f.getText();
			System.out.println(certs[j]);
			j++;
			
		}
		
		//System.out.println("Additional Certificates are :");
		
		
		
		
		//screenshot
		WebElement dd = Driver.findElement(By.xpath("//a[text()='Platform App Builder']"));
		act.scrollToElement(dd).perform();
		

		File src1 = Driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./marathon/Application_cert.png");
		
		FileUtils.copyFile(src1, dest1);
		
		
		WebElement ddd = Driver.findElement(By.xpath("//a[text()='Integration Architect']"));
		act.scrollToElement(ddd).perform();
		

		File src2 = Driver.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("./marathon/Additional_Application_cert.png");
		
		FileUtils.copyFile(src2, dest2);
		
		
		Driver.quit();
		
	}

}
