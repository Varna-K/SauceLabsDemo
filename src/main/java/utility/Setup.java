package utility;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import runner.TestRunner;

public class Setup extends TestRunner{
	
	
	String url,browser;
	public HashMap<String, String> cartContents=new HashMap<String, String>();
	ConfigReader cr=new ConfigReader();
	
	public Setup()  {
		super();
		url=cr.getProperty("url");
		browser=cr.getProperty("browser");
	}

	
	public WebDriver setupDriver() {
		switch(browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public void navigateToUrl() {
		driver.get(url);
	}

	
	
	
}
