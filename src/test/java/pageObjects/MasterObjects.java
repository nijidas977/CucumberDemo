package pageObjects;

import org.openqa.selenium.WebDriver;

//Factory design pattern
public class MasterObjects {

	public LandingPageObj landingpageobj;
	public OfferPageObj offerpageobj;
	public WebDriver driver;
	public AddToCartObj addtocartobj;

	public MasterObjects(WebDriver driver) {
		this.driver = driver;
		
	}

	public LandingPageObj getLandingPageObj() {
		landingpageobj = new LandingPageObj(driver);
		return landingpageobj;
	}

	public OfferPageObj getOfferPageObj() {
		offerpageobj = new OfferPageObj(driver);
		return offerpageobj;
	}
	
	public AddToCartObj getAddToCartObj() {
		addtocartobj = new AddToCartObj(driver);
		return addtocartobj;
	}

}
