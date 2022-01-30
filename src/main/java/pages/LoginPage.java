package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Setup;

public class LoginPage extends Setup{
	
private WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
}

@FindBy(id="user-name")
public WebElement userName;

@FindBy(id="password")
public WebElement passWord;

@FindBy(id="login-button")
public WebElement loginButton;

public void enterText(WebElement elem, String text) {
	elem.sendKeys(text);
}
	
}
