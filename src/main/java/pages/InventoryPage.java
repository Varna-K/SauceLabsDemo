package pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends LoginPage{
	public Map<String,Integer> itemNames=new HashMap<String,Integer>();
	public HashMap<String,Double> sortPricesMap=new HashMap<String,Double>();
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
	
	@FindBy(xpath="//div[@class='pricebar']/button")
	public List<WebElement> addRemoveButtons;
	
	public InventoryPage(WebDriver driver) {
		super(driver);		
	}
	
	public int addItemToCart(String name) {	
		int i=0;
		for( WebElement elem:addRemoveButtons) {
			if(elem.getAttribute("id").contains(name.replace(" ", "-").toLowerCase())) {
				i=addRemoveButtons.indexOf(elem);
				elem.click();				
				break;
			}					
		}
		return i;
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
			addRemoveButtons.get(i).click();
			i++;
			
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
				sortPricesMap.put( elem.getText(),price);
				i++;
			}
			
			HashMap<String, Double> temp
            = sortPricesMap.entrySet()
                  .stream()
			.sorted(Map.Entry.<String, Double>comparingByValue()
                  //  .reversed()
            .thenComparing(Map.Entry.comparingByKey()))
			.collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));
						
			sortList= temp.keySet();
			break;
		}
		default:{
			for(WebElement elem:inventoryItemNames) {
				sortList.add(elem.getText());				
			}
			break;
		}
		}
		return sortList;
		
	}
	
	
		
	
	
	
	
	
}
