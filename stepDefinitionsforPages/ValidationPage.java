package stepDefinitionsforPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Then;

public class ValidationPage extends Preconditions {

	@Then("Validate New individual Creation (.*)$")
	public void validateIndividualCreation(String lastname)
	{
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
	
	@Then("Validate the firstname of edited individual (.*)$")
	public void validate_the_firstname(String firstname) {
	 
		String firstname1 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		if(firstname1.contains(firstname))
		{
			System.out.println("Individual with correct first name is created successfully");
		}
		else
		{
			System.out.println("Individual with correct first name is not created");
		}
	}
	
	@Then("Validate Deletion of individual (.*)$")
	public void validateDeletion(String lastname) throws InterruptedException {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		driver.findElement(By.xpath("//input[@class='slds-input']")).clear();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(lastname ,Keys.ENTER);
		Thread.sleep(3000);
		String individualdelete = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		//Verify Whether Individual is Deleted using Individual last name"
		System.out.println(individualdelete);
		if(individualdelete.contentEquals("No items to display."))
		{
			System.out.println("Individuals  is deleted successfully");
		}
		else
		{
			System.out.println("Individual is not deleted");
		}
	}
}
