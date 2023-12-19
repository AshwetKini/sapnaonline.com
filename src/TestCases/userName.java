package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userName {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.sapnaonline.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
		

	}
		@Test(priority=1)
		public void testName() {
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("@#$%%^^"); // enter special characters
		driver.findElement(By.xpath("//input[@placeholder='Enter 10 Digit Mobile Number']")).sendKeys("9699116214"); // enter correct mobile no
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ashwetkini@gmail.com"); // enter correct email 
		driver.findElement(By.xpath("//input[@placeholder='Set a Password']")).sendKeys("admin@123");//enter valid password
		driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).click(); // click on submit button
		
		/* String actual = driver.findElement(By.xpath("//span[normalize-space()='Please enter a valid Full Name']")).getText();
		 boolean expected = driver.findElement(By.xpath("//span[normalize-space()='Please enter a valid Full Name']")).isDisplayed();
		
	Assert.assertEquals(actual, expected);*/
	if(driver.findElement(By.xpath("//span[normalize-space()='Please enter a valid Full Name']")).isDisplayed())
	{
		System.out.println("test case is passed");
			}
	else {
		System.out.println("test case is Failed");
	}
	
		}
		
		@Test(priority=2)
		public void blankspace () {
			driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(" "); // send blank spaces
			driver.findElement(By.xpath("//input[@placeholder='Enter 10 Digit Mobile Number']")).sendKeys("9699116214");
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ashwetkini@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Set a Password']")).sendKeys("admin@123");
			driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).click();
			
			boolean flag = driver.findElement(By.xpath("sc-Axmtr InputOtp__LoginHeadingText-sc-17qyfe3-0 esBbye")).isDisplayed();
			Assert.assertTrue(flag, "first name field is accepting blankspaces");
			
			
		}
			
			
				
			
		



@AfterMethod
public void closeBrowser() throws InterruptedException {
	Thread.sleep(15000);
      driver.quit();
}

}
