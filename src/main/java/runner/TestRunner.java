package runner;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 

@RunWith(Cucumber.class)	
@CucumberOptions(
				features="src/main/resources/features", 
				glue="stepDefinition",
				plugin= {"pretty","html:target/cucumber-reports.html"}
				//,tags="@RemoveAndCheckout"
				)

public class TestRunner  {
	public static WebDriver driver;
	public static HashMap<String, String> cartContents=new HashMap<String, String>();
}
