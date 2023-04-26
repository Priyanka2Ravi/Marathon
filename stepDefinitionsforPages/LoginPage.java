package stepDefinitionsforPages;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class LoginPage extends Preconditions {

	@Given("Enter the Username as {string}")
	public void enter_the_username_as(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		
		
	}
	@Given("Enter the Password as {string}")
	public void enter_the_password_as(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@Given("Login")
	public void login() {
		driver.findElement(By.id("Login")).click();
	}
}
