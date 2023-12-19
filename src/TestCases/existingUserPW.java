package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class existingUserPW {

	
	WebDriver driver;

	@BeforeMethod
	public void prof() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.sapnaonline.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// click on my account
		driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
		
		//click on existing user
		driver.findElement(By.xpath("//a[@class='item']")).click();
		//click on email and send keys
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testingwala335@gmail.com");
		
		//click on password and send password
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("StudyStudy");
		
		
		
	}
		@Test(priority=1)
		public void email()
		{
			boolean emailverify= 
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).isDisplayed();
			
			Assert.assertTrue(emailverify);
		}
		/*@Test(priority=2)
		public void password() {
			
			//String Password= driver.get.Password();
			boolean passwordverify=driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).isDisplayed();
			
		
			Assert.assertEquals(passwordverify, "StudyStudy");
	}
		*/
	
		@Test (priority=3)
		public void testpw()
		{
			
			String testpassword = "Testpw123";
			Assert.assertEquals(testpassword, "StudyStudy");
		}
		
		@Test(priority=4) //password is less than 6 characters 
		public void smallpw()
		{
			
			String expectedpassword = "12345";
			 String actualPassword=driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).getText();			
			System.out.println("as asasas"+actualPassword);
			Assert.assertEquals(expectedpassword, actualPassword);
		}


		
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
