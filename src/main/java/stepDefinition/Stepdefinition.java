package stepDefinition;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import runner.TestRunner;
import utility.Setup;

public class Stepdefinition extends TestRunner{

	
	static Setup set=new Setup();
	
	
	@Before
	public void startTest() {
		driver=set.setupDriver();	
		cartContents.clear();
	}
	
	@After
	public void endTest(Scenario scenario) {

		if (scenario.isFailed()) {
			Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
		}
		driver.quit();
	}
}
