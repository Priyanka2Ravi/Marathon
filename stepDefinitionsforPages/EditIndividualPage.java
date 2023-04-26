package stepDefinitionsforPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class EditIndividualPage  extends Preconditions{

	@When("Search with lastname as (.*)$")
	public void search_with_lastname(String lastname) throws InterruptedException {
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lastname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	@When("Click edit from dropdown")
	public void click_edit_from_dropdown() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
	}
	@When("Enter MR as salutation")
	public void enter_mr_as_salutation() {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
	}
	@When("Provide Firstname as (.*)$")
	public void provide_firstname(String firstname) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(firstname);
		
	}
	
	@And("Click Save button on edit page")
	public void editSave() throws InterruptedException {
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	Thread.sleep(2000);
	}
}
