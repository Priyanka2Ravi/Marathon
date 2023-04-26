package stepDefinitionsforPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class NewIndividualPage extends Preconditions {

	/*
	 * When Click new Individual And Give Lastname as <lastname> And Select Save
	 * button
	 * 
	 * Then Validate New individual Creation
	 */
	@When("Click new Individual")
	public void clickNew()
	{
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click()", clk);
		
	}
	@And("Enter lastname for individual (.*)$")
	public void giveLastName(String lastname)
	{
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lastname);
	
	}
	
	@And("Select Save button")
	public void selectSavebutton() throws InterruptedException
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		
	}
	
	
}
