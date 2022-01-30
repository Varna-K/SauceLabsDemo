package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Information extends LoginPage{
	
	public Information(WebDriver driver) {
		super(driver);		
	}

	@FindBy(id="first-name")
	public WebElement firstName;	
	
	@FindBy(id="last-name")
	public WebElement lastName;	
	
	@FindBy(id="postal-code")
	public WebElement postalCode;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	public void typeText(WebElement elem, String text) {
		elem.sendKeys(text);	
	}
	
	 
	
	
	
}
