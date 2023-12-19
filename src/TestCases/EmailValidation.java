package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailValidation {
	    public static void main(String[] args) {
	        // Set the path to your chromedriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	    	
	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Launch the website
	        driver.get("https://www.sapnaonline.com");

	        // Locate the email input field and enter a sample email address
	        WebElement emailInput = driver.findElement(By.id("email"));
	        emailInput.sendKeys("example@email.com");

	        // Locate the subscribe button and click it
	        WebElement subscribeButton = driver.findElement(By.id("subscribe"));
	        subscribeButton.click();

	        // Wait for the response message to be displayed
	        try {
	            Thread.sleep(2000); // Adjust the wait time as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Check if the response message contains the success notification
	        WebElement messageElement = driver.findElement(By.id("response-message"));
	        String messageText = messageElement.getText();
	        boolean isValidEmail = messageText.contains("You have successfully subscribed.");

	        // Print the result of email validation
	        if (isValidEmail) {
	            System.out.println("Email address is valid!");
	        } else {
	            System.out.println("Email address is not valid.");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}


