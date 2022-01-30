import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkoutFlow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			WebDriverManager .edgedriver().setup();
			WebDriver driver=new EdgeDriver();

			//Navigate to Saucelabs url
			String url="https://www.saucedemo.com/";
			driver.get(url);

			//Login with username and password
			WebElement username = driver.findElement(By.id("user-name"));
			username.sendKeys("standard_user");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("secret_sauce");
			WebElement loginButton = driver.findElement(By.id("login-button"));
			loginButton.click();

			//Wait for successful login		 
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			try{
				wait.until(ExpectedConditions.urlContains("inventory"));
			}
			catch(Exception e) {
				throw new Exception("Login not successful");
			}

			System.out.println("Reached inventory");
			
			//Add2 items and click on shopping cart
			List<WebElement> addToCartButtons=driver.findElements(By.xpath("//button[contains(@name,'add-to-cart')]"));
			addToCartButtons.get(1).click();
			addToCartButtons.get(4).click();
			WebElement shoppingCart = driver.findElement(By.className("shopping_cart_badge"));
			shoppingCart.click();
			
			driver.findElements(By.xpath("//button[contains(@name,'remove')]")).get(1).click();
			
			driver.findElement(By.name("checkout")).click();
			
			WebElement firstName = driver.findElement(By.id("first-name"));
			firstName.sendKeys("FName");
			WebElement lastName = driver.findElement(By.id("last-name"));
			lastName.sendKeys("LName");
			WebElement postalCode = driver.findElement(By.id("postal-code"));
			postalCode.sendKeys("123123");
			WebElement continueButton = driver.findElement(By.id("continue"));
			continueButton.click();
			
			
			
			

			driver.close();
			//driver.quit();

		}
		catch(Exception e1) {
			throw new Exception("Exception is" + e1);
		}
		}

	}
