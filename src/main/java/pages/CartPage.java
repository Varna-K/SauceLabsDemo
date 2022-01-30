package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends LoginPage{
	public Map<String,Integer> itemNames=new HashMap<String,Integer>();
	
	@FindBy(id="checkout")
	public WebElement checkoutButton;	
	
	public CartPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	public List<WebElement> itemNamesList;	
	
	@FindBy(xpath="//button[contains(@id,'remove')]")
	public List<WebElement> removeButtons;	
	 
	public void removeItemFromCart(String name) {	
		for( WebElement elem:removeButtons) {
			if(elem.getAttribute("id").contains(name.replace(" ", "-").toLowerCase())) {
				elem.click();
				break;
			}					
		}		
	} 
	
	
	
}
