package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.OfferPageObj;
import utils.Helpers;

public class OfferPageSD {
	// public static WebDriver driver;
	// public String landingpageProductName;
	public String offerpageProductName;
	Helpers helpers;

	// depencency injection: What all variables we need in multiple step defiitions,
	// we can give those to a common class and create constructors in the respective
	// class and refer the helper class instance inside the constructor
	// also we have to add a dependency as picocontaner in pom.xml file
	public OfferPageSD(Helpers helpers) {
		this.helpers = helpers;
	}

	public void switchOffersPage() { // if already switched then give a logic to not switch the window. exit this
		// block

		if (helpers.driver.getCurrentUrl()
				.equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			System.out.println("You are already switched the window.No need to switch it again");
		} else {
			helpers.driver.findElement(By.linkText("Top Deals")).click();
			helpers.switchChildwindow();
			/*
			 * Set<String> sl = helpers.driver.getWindowHandles(); Iterator<String> il =
			 * sl.iterator(); String parentwinodw = il.next(); String childwindow =
			 * il.next(); helpers.driver.switchTo().window(childwindow);
			 */
		}
	}

	@Then("^User searched for same short name (.+) in offers page$")
	public void user_searched_for_same_short_name_something_in_offers_page_to_check_if_product_exists(String shortName)
			throws Throwable {

		switchOffersPage();
		OfferPageObj offerobj = helpers.masterobj.getOfferPageObj();
		// OfferPageObj offerobj = new OfferPageObj(helpers.driver);
		offerobj.offersearch(shortName);
		offerpageProductName = offerobj.getProductName();

	}

	@And("Vaidate product name in offer page is same as in landing page")
	public void vaidate_product_name_in_offer_page_is_same_as_in_landing_page() throws Throwable {

		System.out.println(offerpageProductName);

		Assert.assertEquals(offerpageProductName, helpers.landingpageProductName);
	}
}
