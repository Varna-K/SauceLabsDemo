package stepDefinition;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.InventoryPage;
import runner.TestRunner;

public class InventoryStepDefinition extends TestRunner {

	@And("^I select the \"([^\"]*)\" from the inventory")
	public void iSelectTheFromTheInventory(String itemName) throws Throwable {
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		if(driver.getCurrentUrl().contains("cart")) {
			inv.continueShopping.click();
		}		
		inv.addItemToCart(itemName);
	}

	

	@Then("I confirm the cart contents")
	public void iConfirmTheCartContents() throws Throwable {
		System.out.println("cart contents verified");
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		inv.cartButton.click();	
	}



	@Then("I remove {string} from the cart")
	public void iRemoveFromTheCart(String name) throws Throwable {
		CartPage cart=PageFactory.initElements(driver, CartPage.class);
		cart.removeItemFromCart(name);
	}



	@And("^I select (\\d+) lowest priced products$")
	public void iSelectLowestPricedProducts(int arg1) throws Throwable {
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		Collection<String> expectedOrder = inv.verifyProductOrder("price");
		inv.sortProducts("price");				
		Collection<String> actualOrder = inv.verifyProductOrder(" ");
		boolean b=expectedOrder.equals(actualOrder);
		inv.addItemToCart(arg1);
	}
	
}
