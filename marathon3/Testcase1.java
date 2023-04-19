package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 extends Preconditions{

	@BeforeTest
	public void driverInfo()
	{
		 driverName = "Chrome";
		 FileName ="Questions";
	}
	
	@Test(dataProvider = "DatafromExcel")
	public void questionValidate(String question,String Detail) throws InterruptedException 
	{
				
		//serach context
		Driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Content");
		Driver.findElement(By.xpath("//mark[text()='Content']")).click();
		
		
		//Chatter
		WebElement chatter = Driver.findElement(By.xpath("//span[text()='Chatter']"));
		((RemoteWebDriver) Driver).executeScript("arguments[0].click()",chatter);
		
		//page title verification
		Thread.sleep(3000);
		String pageTitle = Driver.getTitle();
		
		if(pageTitle.contains("Chatter Home"))
		{
		System.out.println("Current Page Title is verified successfully");
		}
		else
		{
			System.out.println("Current Page Title is not verified successfully");
		}
		
		//question tab
		Driver.findElement(By.xpath("//span[text()='Question']/ancestor::a")).click();
		
		//data from excel
		String data = question;
		Driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(data);
		Driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(Detail);
		
		//click ask
		Driver.findElement(By.xpath("//button[text()='Ask']")).click();
		
		//verify the question
		Thread.sleep(3000);
		String question1 = Driver.findElement(By.xpath("//div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer']/span")).getText();
		System.out.println(question1);
		
		
		if(question1.contains(data))
		{
			System.out.println("Yes, typed question is displayed correctly");
		}
		
		else
		{
			System.out.println("No, typed question is not displayed correctly");
		}
	}

}
