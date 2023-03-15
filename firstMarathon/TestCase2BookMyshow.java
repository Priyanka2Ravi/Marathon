package firstMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2BookMyshow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver Drive = new ChromeDriver(options);
		Drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Drive.get("https://in.bookmyshow.com/");
		Drive.manage().window().maximize();
		Drive.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("Hyderabad");
		Drive.findElement(By.xpath("//span[@class='sc-dBaXSw gYlrLO']/strong")).click();
		String currentURL = Drive.getCurrentUrl();
		System.out.println(currentURL);
		if( currentURL.contains("hyderabad"))
		{
			System.out.println("yes, Hyderabad is present in the current URL");
		}
		else
		{
			System.out.println("No, Hyderabad is not present in the current URL");
		}
		Drive.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
		Drive.findElement(By.xpath("//span[text()='English']")).click();
		Drive.findElement(By.xpath("//span[@class='sc-dPNhBE kOdloY']/a[contains(text(),'Shazam!')]")).click();
		System.out.println(Drive.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText());
		Drive.findElement(By.xpath("(//div[@class='info-section']/div)[1]")).click();		
		String s = Drive.findElement(By.xpath("//div[@class='venue-facilities']")).getText();
				if ( s.contains("Parking Facility"))
				{
			System.out.println("yes there is Parking Facility ");
				}
				else
				{
					System.out.println("There is no Parking Facility");
				}
				Thread.sleep(3000);
		Drive.findElement(By.xpath("//div[@class='cross-container']")).click();
		Drive.findElement(By.xpath("(//div[@class='showtime-pill-container _available'])[1]//div[@class='__details']")).click();
		Drive.findElement(By.id("btnPopupAccept")).click();
		Drive.findElement(By.id("pop_1")).click();
		Thread.sleep(2000);
		Drive.findElement(By.id("proceed-Qty")).click();
		Thread.sleep(2000);
		Drive.findElement(By.xpath("//a[@class='_available']")).click();
		Drive.findElement(By.xpath("//a[@id='btmcntbook' and @class='bar-btn _primary']/span")).click();
		Thread.sleep(2000);
		System.out.println(Drive.findElement(By.xpath("//span[@id='subTT' and @class='__sub-total']")).getText());
		
		
		
	}

}
