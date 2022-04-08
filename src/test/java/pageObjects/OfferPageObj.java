package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPageObj {
	public WebDriver driver;

	public OfferPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = ("tr td:nth-child(1)"))
	public WebElement OfferProductName;
	@FindBy(xpath = ("//input[@id='search-field']"))
	public WebElement Offersearch;
	// By OfferProductName = By.cssSelector("tr td:nth-child(1)");
	// By Offersearch = By.xpath("//input[@id='search-field']");

	public String getProductName() {
		String OfferItemname = OfferProductName.getText().trim();
		// String OfferItemname = driver.findElement(OfferProductName).getText().trim();
		System.out.println("Offer page product name : " + OfferItemname);

		return OfferItemname;
	}

	public void offersearch(String shortName) throws InterruptedException {
		Offersearch.sendKeys(shortName);
		// driver.findElement(Offersearch).sendKeys(shortName);
		Thread.sleep(2000);
	}
}
