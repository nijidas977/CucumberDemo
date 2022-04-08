package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.MasterObjects;
//This is a kind of factory class from where we will get all the shared varaibles/methods to our step definitions
public class Helpers extends BaseClass{
	public WebDriver driver;
	public String landingpageProductName;
	public MasterObjects masterobj;
	public BaseClass baseclass;
	
	public Helpers() throws IOException{
		//baseclass= new BaseClass();
		//driver = baseclass.WebdriverManager();
		driver = WebdriverManager();
		masterobj = new MasterObjects(driver);
	}
	
}
