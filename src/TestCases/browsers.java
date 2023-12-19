package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browsers {
	 public static void main(String[] args) {
	        String browser = "chrome"; // Change this value to switch between "chrome," "firefox," or "edge"

	        WebDriver driver = getDriver(browser);

	        if (driver != null) {
	            navigateAndInteract(driver, "https://www.sapnaonline.com");

	            // Close the browser
	            driver.quit();
	        } else {
	            System.out.println("Invalid browser specified.");
	        }
	    }

	    private static WebDriver getDriver(String browser) {
	        WebDriver driver = null;

	        switch (browser.toLowerCase()) {
	            case "chrome":
	               
	                driver = new ChromeDriver();
	                break;

	            case "firefox":
	                
	                driver = new FirefoxDriver();
	                break;

	            case "edge":
	                
	                driver = new EdgeDriver();
	                break;

	            // You can add more cases for other browsers if needed

	            default:
	                System.out.println("Invalid browser specified.");
	        }

	        return driver;
	    }

	    private static void navigateAndInteract(WebDriver driver, String url) {
	        // Navigate to a website
	        driver.get(url);

	        // Find an element by its ID (replace "elementId" with the actual ID of the element on the website)
	        WebElement element = driver.findElement(By.id("elementId"));

	        // Perform an action on the element (e.g., click)
	        element.click();
	    }
	

}
