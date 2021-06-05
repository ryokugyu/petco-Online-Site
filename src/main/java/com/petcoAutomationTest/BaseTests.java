package com.petcoAutomationTest;

//import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.Test;

import com.PageBaseClass.PageBaseClass;
//import com.PageClasses.HomePage;
import com.PageClasses.LandingPage;
import com.PageClasses.productPage;
//import com.PageClasses.ProfilePage;
import com.utilities.ReadPropertiesFile;

public class BaseTests {
	
	Properties prop = ReadPropertiesFile.readConfiguration();
	LandingPage landingPage;
	productPage pp;
	
	@Test
	public void petcoTest() throws InterruptedException {
		PageBaseClass pagebaseclass = new PageBaseClass();
		pagebaseclass.invokeBrowser(prop.getProperty("browserName"));
		landingPage = pagebaseclass.openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickContinueShopping();
		landingPage.clickHamburgerButton();
		landingPage.clickFishOption();
		pp = landingPage.clickFrozenFood();
		pp.sortByAtoZ();
		pp.getproductNameAndPrice();
		pp.selectPrice();
		pp.writeToExcelPrice25to50();
		pp.navigateToHome();
		pagebaseclass.closeBrowser();
	}
	
}
