package stepDefinitionsforPages;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class HomePage extends Preconditions {

	@Given("Select view All from toggle option")
	public void select_view_all_from_toggle_option() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
}
}