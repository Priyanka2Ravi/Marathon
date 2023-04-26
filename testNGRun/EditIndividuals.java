package testNGRun;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditIndividuals extends Salesforcemethods{

	
	@BeforeTest
	public void testData()
	{
		FileName ="EditIndividual";
	}
	
	@Test(priority=2,dataProvider = "dynamicData")
	public  void editingIndividual(String lastname, String firstname) throws InterruptedException {
		
		/*
		 * WebElement clk =
		 * driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		 * driver.executeScript("arguments[0].click();", clk);
		 */
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lastname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// .sendKeys("Kumars",Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(firstname);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		String firstname1 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		// Verify the first name as 'Ganesh'
		System.out.println(firstname1);
		if(firstname1.contains(firstname))
		{
			System.out.println("Individual with correct first name is created successfully");
		}
		else
		{
			System.out.println("Individual with correct first name is not created");
		}
		
	}

}
