package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddToCartObj;
import utils.Helpers;

public class AddToCartSD {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public AddToCartObj addtocartobj;
	Helpers helpers;

//Spring framework, EJB, 
//SRP
//
	public AddToCartSD(Helpers helpers) {
		
		this.helpers = helpers;
		this.addtocartobj = helpers.masterobj.getAddToCartObj();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo() {

		Assert.assertTrue(addtocartobj.VerifyPromoBtn());
		Assert.assertTrue(addtocartobj.VerifyPlaceOrder());

	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException {

		addtocartobj.CheckoutItems();
		// Assertion to extract name from screen and compare with name
	}

}
