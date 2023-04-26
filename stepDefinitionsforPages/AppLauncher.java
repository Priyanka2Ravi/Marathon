package stepDefinitionsforPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class AppLauncher extends Preconditions {

	
	@Given("Select Individiaul from App Launcher")
	public void select_individiaul_from_app_launcher() {

		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].scrollIntoView();", individual);
		driver.executeScript("arguments[0].click();", individual);
	}
}
