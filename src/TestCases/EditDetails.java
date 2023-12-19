package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditDetails {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.sapnaonline.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		
		
		
		//click on myAccont
	
		driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
		
		//click on existing user
		driver.findElement(By.xpath("//a[@class='item']")).click();
		
		//enter email address and password
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testingwala335@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("admin@123");
		//click on continue button
		driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		
		//click on my account
		driver.findElement(By.xpath("//div[@class='sc-AxhCb ghXQuW']")).click();
		//click on my address
		driver.findElement(By.xpath("//div[contains(text(),'My Addresses')]")).click();
		
		//click on edit 
		driver.findElement(By.xpath("//div[@class='sc-AxirZ Addresses__CursorBox-sc-1noqkxg-5 bCCjDK ripple']//div[@class='sc-AxhCb iJFzik']")).click();
		
		//click on name field
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
	}
		@Test
		public void validnamecheck() {
	driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("ash kini");
	 boolean	actual = driver.findElement(By.xpath("//input[@placeholder='Full Name']")).isDisplayed();
		String expected = "ash kini";
		Assert.assertEquals(actual, expected);
		
		}
		
		
		
		
		
	
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[normalize-space()='Save']")).click(); //click on save button
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
	
	

}
