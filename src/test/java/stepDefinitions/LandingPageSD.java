package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPageObj;
import pageObjects.MasterObjects;
import utils.Helpers;

//Classes must follow Single responsibility principle : which means one class should handle responsibility for single ui
//Classesshould be loosly coupled : means we should be able to inject dependencies to other classesas well
public class LandingPageSD {

	Helpers helpers;
	public LandingPageObj landobj;

	public LandingPageSD(Helpers helpers) {
		this.helpers = helpers;
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws Throwable {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\NJ15032022\\Git\\Git_Workspace\\Demo\\Drivers\\chromedriver.exe");
		 * helpers.driver = new ChromeDriver();
		 * helpers.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		//helpers.baseclass.WebdriverManager();
		helpers.WebdriverManager();
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void usemr_search_for_a_product_with_short_name_something_and_extract_actual_name(String shortName)
			throws Throwable {

		// MasterObjects masterobj = new MasterObjects(helpers.driver);
		landobj = helpers.masterobj.getLandingPageObj();
		// LandingPageObj landobj = new LandingPageObj(helpers.driver);
		landobj.SearchItem(shortName);
		helpers.landingpageProductName = landobj.getProductName();

	}

	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity) {

		landobj.incrementQuantity(Integer.parseInt(quantity));
		landobj.addToCart();

	}

}
