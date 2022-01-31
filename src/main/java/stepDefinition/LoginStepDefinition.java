package stepDefinition;

import org.junit.After;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utility.ConfigReader;
import utility.Setup;

public class LoginStepDefinition extends Setup  {
	
	@Given("I visit SauceLabs page")	
	public void navigateUrl() {		
		Setup set=new Setup();
		set.navigateToUrl();		
		System.out.println("Navigated to SauceLabs");
		cartContents.clear();
	}
	

	@When("I login as a registered user")
	public void login() {
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		ConfigReader cr=new ConfigReader();
		login.enterText(login.userName, cr.getProperty("username"));
		login.enterText(login.passWord, cr.getProperty("password"));
		login.loginButton.click();
		System.out.println("Logged in as registered user on SauceLabs");
	}

	@After
	public static void aftermethod() {
		System.out.println("in after");
	}
	
}
