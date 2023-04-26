package testNGRun;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteIndividuals extends Salesforcemethods {

	@BeforeTest
	public void testData()
	{
		FileName="CreateIndividual";
	}
	
	@Test(priority=3,dataProvider = "dynamicData")
	public  void deletingIndividual(String lastname,String sn) throws InterruptedException {
		
		
		/*
		 * WebElement clk =
		 * driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		 * driver.executeScript("arguments[0].click();", clk); Thread.sleep(2000);
		 */
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lastname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);////div[@class='uiPopupTrigger']
		//Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		driver.findElement(By.xpath("//input[@class='slds-input']")).clear();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(lastname,Keys.ENTER);
		Thread.sleep(3000);
		String individualdelete = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		//Verify Whether Individual is Deleted using Individual last name"
		System.out.println(individualdelete);
		if(individualdelete.contentEquals("No items to display."))
		{
			System.out.println("Individual  is deleted successfully");
		}
		else
		{
			System.out.println("Individual is not deleted");
		}
		
	}

}

