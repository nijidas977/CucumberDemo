package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObj {
	public WebDriver driver;

	public LandingPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ("//input[@type='search']"))
	public WebElement Search;
	@FindBy(css = ("h4.product-name"))
	public WebElement LandingpageProductname;
	@FindBy(css = ("a.increment"))
	public WebElement increment;
	@FindBy(css = (".product-action button"))
	public WebElement addToCart;

	public void SearchItem(String shortName) throws InterruptedException {
		Search.sendKeys(shortName);
		System.out.println("Short name from feature file : " + shortName);
		Thread.sleep(2000);

	}

	public String getProductName() {
		String ProductNameLP = LandingpageProductname.getText().split("-")[0].trim();
		return ProductNameLP;
	}
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			increment.click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
}
