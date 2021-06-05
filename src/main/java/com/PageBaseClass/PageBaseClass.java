package com.PageBaseClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageClasses.LandingPage;
import com.utilities.ReadPropertiesFile;
import com.utilities.TakeScreenshots;

public class PageBaseClass {
	public WebDriver driver;
	Properties prop = ReadPropertiesFile.readConfiguration();

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {

			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + prop.getProperty("chromeSrc"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + prop.getProperty("geckoSrc"));
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + prop.getProperty("operaSrc"));
				driver = new OperaDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + prop.getProperty("ieDriverSrc"));
				driver = new InternetExplorerDriver();
			} else {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/******Close WebDriver******/
	public void closeBrowser() {
		driver.close();
	}

	/*****************************
	 * Open Application
	 ********************************/

	public LandingPage openApplication(String URL) {

		driver.get(URL);
		
		System.out.println("Opening Website");
		TakeScreenshots.takeScreenShot(driver);
		
		LandingPage landingPage = new LandingPage(driver);
		PageFactory.initElements(driver, landingPage);
		
		return landingPage;
	}


}
