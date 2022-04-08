package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public WebDriver driver;
	public String Browser, URL;
	public String ProjectFolder = System.getProperty("user.dir");

	public WebDriver WebdriverManager() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				ProjectFolder + "\\src\\test\\resources\\globalproperties.properties");
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String URL = prop.getProperty("URL");
		System.out.println(Browser + " || " + URL);
		if (driver == null) {

			// driver = new ChromeDriver();
			// driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			if (Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ProjectFolder + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (Browser.equals("firefox")) {
				System.out.println("Firefox code activated");
			} else if (Browser.equals("edge")) {
				System.out.println("Firefox code activated");
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
			driver.navigate().to(URL);
			driver.manage().window().maximize();

		}
		return driver;
	}

	public void switchChildwindow() { // if already switched then give a logic to not switch the window. exit this
		// block

		Set<String> sl = driver.getWindowHandles();
		Iterator<String> il = sl.iterator();
		String parentwinodw = il.next();
		String childwindow = il.next();
		driver.switchTo().window(childwindow);

	}

}
