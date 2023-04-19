package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends Preconditions {

	@BeforeTest
	public void driverInfo() {
		driverName = "Edge";
		FileName = "Campaigns";
	}

	@Test(dataProvider = "DatafromExcel")
	public void campaignCreation(String oppName, String amount) {

		// sales click
		Driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Scroll down to select key Deals
		Actions act = new Actions(Driver);
		act.moveToElement(Driver.findElement(By.xpath("//span[text()='Key Deals - Recent Opportunities']"))).perform();

		// filter sort
		WebElement sort = Driver.findElement(By.xpath("//a[@title='Key Deals Trigger']"));
		((RemoteWebDriver) Driver).executeScript("arguments[0].click()", sort);
		Driver.findElement(By.xpath("//a[@title='All Opportunities']")).click();

		// All key details click
		WebElement keys = Driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		((RemoteWebDriver) Driver).executeScript("arguments[0].click()", keys);

		// new click
		Driver.findElement(By.xpath("//div[text()='New']")).click();

		// opportunities
		// String name = "agile ";
		Driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(oppName);
		// type
		WebElement type = Driver.findElement(By.xpath("(//button[@role='combobox'])[2]"));
		((RemoteWebDriver) Driver).executeScript("arguments[0].click()", type);
		Driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='New Customer']")).click();
		// lead source
		Driver.findElement(By.xpath("(//button[@role='combobox'])[3]")).click();
		Driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		// amount
		// String amount = "70000";
		
		Driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		// close Date
		Driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		Driver.findElement(By.xpath("//span[@class='slds-day' and text()='20']")).click();
		// stage
		Driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[1]")).click();
		Driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Needs Analysis']")).click();
		// Campaign
		WebElement campaign = Driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']"));
		((RemoteWebDriver) Driver).executeScript("arguments[0].click()", campaign);
		Driver.findElement(By.xpath("//span[text()='Marathon']")).click();

		// save
		Driver.findElement(By.xpath("//button[text()='Save']")).click();

		// campaign creation verification
		String campaignname = Driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"))
				.getText();
		System.out.println(campaignname);

		if (campaignname.contains(oppName)) {
			System.out.println("Yes, campaignName is created correctly");
		}

		else {
			System.out.println("No, campaignName is not created correctly");
		}

	}

}
