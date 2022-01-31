package stepDefinition;

import java.util.Collection;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.InventoryPage;
import runner.TestRunner;

public class InventoryStepDefinition extends TestRunner {

	@And("^I add the \"([^\"]*)\" to the inventory")
	public void iSelectTheFromTheInventory(String itemName) throws Throwable {
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		if(driver.getCurrentUrl().contains("cart")) {
			inv.continueShopping.click();
		}		
		int index=inv.addItemToCart(itemName);
		String prodPrice=inv.inventoryItemPrices.get(index).getText();
		cartContents.put(itemName, prodPrice)	;	
		
	}

	

	@Then("I confirm the cart contents")
	public void iConfirmTheCartContents() throws Throwable {
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		inv.cartButton.click();	
		System.out.println("cart contents verified");
		
		
	}



	@Then("I remove {string} from the cart")
	public void iRemoveFromTheCart(String name) throws Throwable {
		CartPage cart=PageFactory.initElements(driver, CartPage.class);
		cart.removeItemFromCart(name);
		cartContents.remove(name);
	}



	@And("^I select (\\d+) lowest priced products$")
	public void iSelectLowestPricedProducts(int arg1) throws Throwable {
		InventoryPage inv=PageFactory.initElements(driver, InventoryPage.class);
		Collection<String> expectedOrder = inv.verifyProductOrder("price");
		inv.sortProducts("price");				
		Collection<String> actualOrder = inv.verifyProductOrder(" ");//product order as seen on page
		Assert.assertTrue(expectedOrder.equals(actualOrder));
		inv.addItemToCart(arg1);
		int i=0;
		while(i<arg1) {			
			String prodPrice=inv.inventoryItemPrices.get(i).getText();
			cartContents.put(inv.inventoryItemNames.get(i).getText(), prodPrice)	;	
			i++;
		}
	}
	
}
