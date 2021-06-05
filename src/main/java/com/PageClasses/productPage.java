package com.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PageBaseClass.PageBaseClass;
import com.PageObjects.ConversionPageObjects;

import com.utilities.WriteResultsToExcel;
import com.utilities.TakeScreenshots;

public class productPage extends PageBaseClass {
	
ConversionPageObjects conversionPageObject;
	
	public productPage(WebDriver driver) {
		this.driver= driver;
		
		conversionPageObject = new ConversionPageObjects(driver);
		PageFactory.initElements(driver, conversionPageObject);
	}
	
	public void sortByAtoZ() {
		try {
			Select s = new Select(conversionPageObject.sortByAtoZ);
			s.selectByVisibleText("Name A-Z");
			Thread.sleep(15000);
			TakeScreenshots.takeScreenShot(driver);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getproductNameAndPrice() {
		try {
		TakeScreenshots.takeScreenShot(driver);
		String productName= conversionPageObject.productName.getAttribute("title");
		System.out.println("Product Name: "+ productName);
		

		String productPrice= conversionPageObject.productPrice.getText();
		System.out.println("Product Price: " + productPrice);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void selectPrice() {
		try {
			conversionPageObject.priceIcon.click();
			conversionPageObject.price25to50.click();
			Thread.sleep(10000);
			TakeScreenshots.takeScreenShot(driver);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void writeToExcelPrice25to50() {
		try {
			TakeScreenshots.takeScreenShot(driver);
			String productName= conversionPageObject.price25to50FirstItem.getAttribute("title");
			System.out.println("Product Name: "+ productName);
			String fileName = WriteResultsToExcel.writeData(productName);
			System.out.println("Results stored in: "+ fileName);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void navigateToHome() {
		try {
			conversionPageObject.navigateHome.click();
			Thread.sleep(3000);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
