package pages;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends LoginPage{
	public Map<String,Integer> itemNames=new HashMap<String,Integer>();
	public TreeMap<Double,String> sortPricesMap=new TreeMap<Double,String>();
	public TreeSet<String> sortSet=new TreeSet<String>();
	
	
	@FindBy(xpath="//button[contains(@name,'add-to-cart')]")
	public List<WebElement> addToCartButtons;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	public List<WebElement> inventoryItemNames;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement cartButton;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	public  WebElement dropdownSelect;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	public List<WebElement> inventoryItemPrices;
	
	@FindBy(id="continue-shopping")
	public WebElement continueShopping;
	
	public InventoryPage(WebDriver driver) {
		super(driver);		
	}
	
	public void addItemToCart(String name) {	
		for( WebElement elem:addToCartButtons) {
			if(elem.getAttribute("id").contains(name.replace(" ", "-").toLowerCase())) {
				elem.click();
				break;
			}					
		}		
	}

	public void sortProducts(String sortValue) {
		Select sel=new Select(dropdownSelect);
		if (sortValue.equalsIgnoreCase("price")) {
		 sel.selectByValue("lohi");
		}
		else {
			sel.selectByValue("az");
		}
		
	}
	
	public void addItemToCart(int arg1) {
		int i=0;
		while( i<arg1) {
			addToCartButtons.get(i).click();		
			}					
		}

	
	public Collection<String> verifyProductOrder(String factor) {	
		Collection<String> sortList=new LinkedHashSet <String>();
		switch (factor) {
		case "name":{
			for(WebElement elem:inventoryItemNames) {
				sortSet.add(elem.getText());
			}
			sortList.addAll(sortList);
			break;
		}
		case "price":{
			int i=0;		
			for(WebElement elem:inventoryItemNames) {
				Double price=Double.parseDouble(inventoryItemPrices.get(i).getText().replace("$", ""));
				sortPricesMap.put(price, elem.getText());
				i++;
			}
			System.out.println(sortPricesMap);
			sortList= sortPricesMap.values();
			break;
		}
		default:{
			for(WebElement elem:inventoryItemNames) {
				sortList.add(elem.getText());
				System.out.println(sortList);
			}
			//System.out.println(sortList);
			break;
		}
		}
		return sortList;
		
	}
	
	
		
	
	
	
	
	
}
