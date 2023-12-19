package updateAddress;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fullname {
	WebDriver driver;
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.sapnaonline.com/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//click on my ac
		driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
		//click on existing user
		driver.findElement(By.xpath("//a[@class='item']")).click();
		//click on email or username and send user credintials
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testingwala335@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("admin@123");
		//click on loggin button
		driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		//click on my account
		driver.findElement(By.xpath("//div[@class='sc-Axmtr MainHeader__CustomText-yzc09z-12 yDPBL']")).click();
		//click on my address
		driver.findElement(By.xpath("//div[contains(text(),'My Addresses')]")).click();
		
		//click on edit button 
		driver.findElement(By.xpath("//div[contains(text(),'Edit')]")).click();
		
		//clear namefield
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
	
	}
	
	@Test(priority=1) // checking if its allowed numbers in name fields
	public void Numbers_Fullname() {
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("123123");
		driver.findElement(By.xpath("//div[@class='active item']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Save']")).click();
		//check if the name field contains any numbers
		
		String actual_error = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		String expected_error = "Enter valid name";
		Assert.assertEquals(actual_error, expected_error);
		
		//Assert.assertTrue(actual_error.contains("Enter valid name"));
		
	}
	
	@Test(priority=2)
	public void BlankSpaces_fullname() {
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("   ");
		
		driver.findElement(By.xpath("//div[normalize-space()='Save']")).click();
		String actual_error=driver.findElement(By.xpath("//div[@role='alert']")).getText();
		String expected_error = "Enter Valid Name";
		Assert.assertEquals(actual_error, expected_error);
		
		
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		
		
		Thread.sleep(15000);
	      driver.quit();
	}
}
