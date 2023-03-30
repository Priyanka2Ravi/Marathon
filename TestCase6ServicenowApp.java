package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class TestCase6ServicenowApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver Driver = new ChromeDriver(options);
		Driver.get("https://dev57553.service-now.com/ ");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//login
		Driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		Driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("2oaD6KN$q$vN");
		
		Driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Shadow shade = new Shadow(Driver);
		shade.setImplicitWait(20);
		
		shade.findElementByXPath("//div[@id='all']").click();
		
		shade.findElementByXPath("//span[text()='Service Catalog']").click();
		
		Thread.sleep(2000);
		
		WebElement frame1 = shade.findElementByXPath("//iframe[@title='Main Content']");
		
		Driver.switchTo().frame(frame1);
		
		Driver.findElement(By.xpath("//span/h2[contains(text(),'Mobiles')]")).click();
		
		Driver.findElement(By.xpath("//a[@class='service_catalog']/strong")).click();
		
		//Select class
		
		WebElement selectclass = Driver.findElement(By.xpath("//select[contains(@class,'form-control cat_item_option')]"));
		
		Select opt = new Select(selectclass);
		
		opt.selectByVisibleText("Gold");
		
		
		
		WebElement selectclass2 = Driver.findElement(By.xpath("(//select[contains(@class,'form-control cat_item_option')])[2]"));
				
		Select opts = new Select(selectclass2);
				
		opts.selectByVisibleText("128");	
		
		
		Driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		String title = Driver.getTitle();
		
		System.out.println(title);
		
		if(title.contains("Order Status"))
		{
			System.out.println("Yes, order has been placed");
		}
		else
		{
			System.out.println("No order has been placed");
		}
		
		System.out.println("Request number is : "+ Driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText() );
		
		
		File source = Driver.getScreenshotAs(OutputType.FILE);
		File Destination = new File("./marathon/Order_Placed.png");
		
		FileUtils.copyFile(source, Destination);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
