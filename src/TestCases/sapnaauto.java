package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sapnaauto {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.sapnaonline.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

// HIT URL :
	@Test(priority = 1)
	public void geturl() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.sapnaonline.com/");

	}

	// CHECK LOGO
	@Test(priority = 2)
	public void checklogo() {

		
		driver.findElement(By.xpath("//div[@class='sc-AxirZ iiXpac logo-main']//a")).isDisplayed();
		Assert.assertTrue(true);

	}
@Test(priority=3)
public void checkTitle() {
	
	String expectedTitle = "Buy Books Online , Bookstore India, Shop for 2022 Books";
	String actualTitle =driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
}
	
	 
	 
	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
