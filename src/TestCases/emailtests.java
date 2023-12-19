package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class emailtests {
	
	WebDriver driver;
	
	@BeforeMethod
	public void sapna() {
		
		driver=new ChromeDriver(); // invoking chrome driver
		driver.get("https://www.sapnaonline.com/"); // navigating to sapnaonline site
		driver.manage().window().maximize();
		
		//click on my account
		driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
		
		// click on existing user
		driver.findElement(By.xpath("//a[@class='item']")).click();
		
		
		
		
	}
	
	@Test
	public void validDetails() //enter valid details
	{
		//click on email and send keys
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testingwala335@gmail.com");
		
		String TestEmail0 = "testingwala335@gmail.com";
				Assert.assertEquals(TestEmail0, "testingwala335@gmail.com");
		
		
	}
	
	
	
		@Test(priority=1) 
		public void wrongemail() //entering wrong email
		{
			//click on email and send keys
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("testingwala@gmail.com");
			
			String TestEmail = "testingwala@gmail.com";
					Assert.assertEquals(TestEmail, "testingwala335@gmail.com");
					
				
					
					}
		@Test(priority=2)// 
		public void space()//enter spaces in Email box
		{
			//click on email and send keys
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("       ");
			
			String TestEmail1 = "        ";
			Assert.assertEquals(TestEmail1, "testingwala335@gmail.com");
			{
				System.out.println("Enter Valid Email");
			}
			
			
		}
		@Test(priority=3)
		public void spclchar()//enter special characters in email
		{
			//click on email and send keys
			driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("!@#$%^&*@hmail.com");
			
			String actualEmail = "!@#$%^&*@hmail.com"; //
			WebElement expectedEmail = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
			Assert.assertEquals(actualEmail, expectedEmail);
			if(actualEmail.equals(expectedEmail))
			{
				System.out.println("you have entered valid email address");
			}else {
				System.out.println("Enter Valid Email");
			}
		}
		
		
		
		
		
		
		
		@AfterMethod
		public void entPW() throws InterruptedException {
			
			//click on password and send password
			driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("StudyStudy");
			
			//click on submit button
			
			driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).click();
			
			Thread.sleep(5000);
			driver.quit();
			
			
			
		}
	
	}
	
	


