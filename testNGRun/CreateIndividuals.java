package testNGRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIndividuals extends Salesforcemethods {
	
	@BeforeTest
	public void testData()
	{
		FileName="CreateIndividual";
	}
	
	@Test(priority=1,dataProvider = "dynamicData")
	public  void creatingIndividual(String lastname,String sn) throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		/*
		 * WebElement drop = driver.findElement(By.
		 * xpath("(//*[name()='svg'  and @data-key='chevrondown'])[1]"));
		 * driver.executeScript("arguments[0].click()", drop);
		 */
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click()", clk);
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lastname);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		String individualname = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		// verify Individuals Name
		//System.out.println(individualname);
		if(individualname.contains(lastname))
		{
			System.out.println("Individual with correct last name is created successfully");
		}
		else
		{
			System.out.println("Individual with correct last name is not created");
		}
		
	}
}