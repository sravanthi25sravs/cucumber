package com.framework.webdriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.framework.utilities.ReadProp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass {

	// This class will have all the methods related to browser

	WebDriver driver;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	//Method to launch browser window
	@Before
	public void setupBrowser() {
		String browser =ReadProp.readData("Config.properties").getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			Assert.fail("Invalid browser value");
		}
		setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get(ReadProp.readData("Config.properties").getProperty("URL"));
	}

	//Method to close browser windows
	@After
	public void closeBrowser() {
		driver.quit();
	}

	//Method to store browser session in thread local
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}

	//Method to share driver details with other class
	public static synchronized WebDriver getDriver() {
		return thread.get();
	}

}
