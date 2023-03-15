package firstMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestCase1RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
options.addArguments("--disable-notifications");
ChromeDriver Drive = new ChromeDriver(options);
Drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
Drive.get("https://www.redbus.in/");
Drive.manage().window().maximize();
Drive.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("Chennai");
Drive.findElement(By.xpath("//li[@class='selected'][1]")).click();
Drive.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Bangalore");
Drive.findElement(By.xpath("//li[@class='selected'][1]")).click();
Drive.findElement(By.xpath("//input[@id='onward_cal']")).click();
Drive.findElement(By.xpath("//td[@class='wd day'][1]")).click();
Drive.findElement(By.id("search_btn")).click();
Thread.sleep(3000);
String buscount = Drive.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
System.out.println(buscount);
Thread.sleep(3000);
WebElement selectSleeper = Drive.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
Drive.executeScript("arguments[0].click();",selectSleeper);
Thread.sleep(2000);
System.out.println(Drive.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText());
Thread.sleep(2000);
System.out.println(Drive.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText());
System.out.println(Drive.getTitle());
	}

}
