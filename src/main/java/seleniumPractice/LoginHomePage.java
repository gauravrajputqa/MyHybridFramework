package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginHomePage 
{
	WebDriver driver;
	ChromeOptions options;
	
	@Test
	public void navigate()
	{
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.get("https://www.cnn.com");	
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
	}	
}
