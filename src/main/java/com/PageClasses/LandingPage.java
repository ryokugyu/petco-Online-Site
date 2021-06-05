package com.PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import com.PageBaseClass.PageBaseClass;
import com.PageObjects.ConversionPageObjects;
import com.utilities.TakeScreenshots;

public class LandingPage extends PageBaseClass {
	
	ConversionPageObjects conversionPageObject;
	
	public LandingPage(WebDriver driver) {
		this.driver= driver;
		
		conversionPageObject = new ConversionPageObjects(driver);
		PageFactory.initElements(driver, conversionPageObject);
	}
	
	public void clickContinueShopping() throws InterruptedException {
		try{
			Thread.sleep(10000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void clickHamburgerButton() {
		TakeScreenshots.takeScreenShot(driver);
		conversionPageObject.hamburger.click();
	}
	
	public void clickFishOption() throws InterruptedException {
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"topcontent\\\"]/div[3]/div/div/ul/li[3]/button")));
		Actions action = new Actions(driver);
		action.moveToElement(conversionPageObject.FishButton).build().perform();
		TakeScreenshots.takeScreenShot(driver);
		/*List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"topcontent\"]/div[3]/div/div/ul/li/button/span"));
		System.out.println("**********");
		int size = elements.size();
		System.out.println("**********" + size);
		for(int i=0;i<size;i++) {
			String data = elements.get(i).getText();
			if(data.equals("Fish")) {
				System.out.println("**********");
				elements.get(i).click();
				break;
			}
		}*/
	}
	
	public productPage clickFrozenFood() throws InterruptedException {
		Thread.sleep(2000);
		conversionPageObject.FrozenFood.click();
		TakeScreenshots.takeScreenShot(driver);
		
		productPage p = new productPage(driver);
		PageFactory.initElements(driver, p);
		
		return p;
		
		
	}

}
