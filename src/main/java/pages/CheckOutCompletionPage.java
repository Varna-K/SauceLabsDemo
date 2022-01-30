package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckOutCompletionPage extends LoginPage{
	
	public CheckOutCompletionPage(WebDriver driver) {
		super(driver);		
	}

	
	@FindBy(xpath="//div[@class='complete-text']")
	public WebElement completionMessage;
	
	public void completionMessageDisplayed() {
		Assert.assertTrue(completionMessage.isDisplayed());
	}
	
	
	
}
