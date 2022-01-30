package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utility.Setup;
 

@RunWith(Cucumber.class)	
@CucumberOptions(
				features="src/main/resources/features", 
				glue="stepDefinition",
				plugin= {"pretty","html:target/cucumber-reports.html"})

public class TestRunner  {

	public static WebDriver driver;
	static Setup set=new Setup();
	@BeforeClass
	public static void setup() throws IOException {		
		driver=set.setupDriver();
		
	}
	
	@AfterClass
	public static void tearDown() {
		//set.tearDown();
	}

}
