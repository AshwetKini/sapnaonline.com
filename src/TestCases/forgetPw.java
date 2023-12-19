package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class forgetPw {
WebDriver driver;

@BeforeMethod
public void frgtpW() {
	
	
	driver=new ChromeDriver(); // invoking chrome driver
	driver.get("https://www.sapnaonline.com/"); // navigating to sapnaonline site
	driver.manage().window().maximize();
	
	//click on my account
	driver.findElement(By.xpath("//div[@class='sc-Axmtr cTkVAB']")).click();
	
	//click on existing user
	driver.findElement(By.xpath("//a[@class='item']")).click();
	
	//click on FORGET PASSWORD
	driver.findElement(By.xpath("//div[@class='sc-Axmtr kSYKgZ ButtonText']")).click();
	
	//click on Emailbox
	driver.findElement(By.xpath("//input[@placeholder='Email Address*']")).sendKeys("testingwala335@gmail.com");
	
	//click on submit button
	driver.findElement(By.xpath("//button[@class='ui fluid button PasswordContainer__BigBtnYellow-sc-1ux7nv5-2 kFJphi']")).click();
	
}	
	@Test(priority=1)
	public void validEmail() {
		
		String validEmail = "testingwala335@gmail.com";
	 String actualEmail= "testingwala335@gmail.com";
		
	 
	if(validEmail.equals(actualEmail))	 
	 {
			 System.out.println(" login successfull");
		 }else {
			 System.out.println(" enter valid email ");
		 }
		
		
		
		
	}
	
	@Test(priority=2)
	public void invalidEmail() {
		
		String expectedEmail = "testingwala335@gmail.co";
		WebElement actualEmail =driver.findElement(By.xpath("//input[@placeholder='Email Address*']"));
		Assert.assertEquals(actualEmail, expectedEmail);
		//Assert.assertEquals(invalidemail, "testingwala335@gmail.com")); 
			if(actualEmail.equals(expectedEmail)) {
				System.out.println("valid email");
			}else {
				System.out.println("invalid EEmail");
				
			}
		
		
		
	}
	@Test(priority=3)
	public void emptyspc() {
		String spaces = "     ";
		Assert.assertEquals(spaces, "testingwala335@gmail.com");
		
	}
	
	@Test(priority=4)
	public void spclchar() {
		
		String spclchar= "!#$@$%^&*";
		Assert.assertEquals(spclchar, "testingwala335@gmail.com");
	}
	
	
	
	
@AfterMethod
public void clickContinue() {
	//click on continue button after filling email
	driver.findElement(By.xpath("//button[@class='ui fluid button PasswordContainer__BigBtnYellow-sc-1ux7nv5-2 kFJphi']")).click();
	driver.quit();
}


@AfterTest
public void tearDown() throws InterruptedException {
	
	/*
	//navigating to login page after reseting password
		driver.findElement(By.cssSelector(".ui.button.PasswordContainer__BigBtnYellow-sc-1ux7nv5-2.kFJphi")).click();

	*/
	Thread.sleep(10000);
	

}}
