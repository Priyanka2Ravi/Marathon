package firstMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase3Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver Drive = new ChromeDriver(options);
		Drive.get("https://www.amazon.in/");
		Drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Drive.manage().window().maximize();
		Drive.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		Drive.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		Drive.findElement(By.xpath("//span[text()=' for boys']")).click();
		Thread.sleep(2000);
		System.out.println(Drive.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
		Drive.findElement(By.xpath("//li[@aria-label='American Tourister']//a//label/i")).click();
		Drive.findElement(By.xpath("//li[@aria-label='Skybags']//a//label/i")).click();
		Thread.sleep(3000);
		Drive.findElement(By.xpath("//span[@aria-label='Sort by:']/span")).click();
		Thread.sleep(2000);
		Drive.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		Thread.sleep(1000);
		
		System.out.println(Drive.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText());
		String s = Drive.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(s);
		System.out.println(Drive.getTitle());
		Drive.close();
	}

}
