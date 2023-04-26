package stepDefinitionsforPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class DeleteIndividualPage extends Preconditions {

	@And("Click delete from dropdown")
	public void deleteFromDropdown() throws InterruptedException
	{
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
	}
	
	@And("Select Delete option")
	public void deletingImdividual() {
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
	}
}
