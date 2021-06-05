package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.PageBaseClass.PageBaseClass;

public class ConversionPageObjects extends PageBaseClass {
	public ConversionPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id=\"bx-close-inside-1369773\"]")
	public WebElement continueShopping;
	
	@FindBy(xpath="//*[@id=\"topcontent\"]/div[3]/button")
	public WebElement hamburger;
	
	@FindBy(xpath="//*[@id=\"topcontent\"]/div[3]/div/div/ul/li[3]") 
	public WebElement FishButton;
	
	@FindBy(xpath="//*[@id=\"product-listing-sort-by_4_3074457345618259661_4099276460824482093\"]")
	public WebElement sortByAtoZ;

	
	@FindBy(linkText="Frozen Food")
	public WebElement FrozenFood;
		
	@FindBy(xpath="//*[@id=\"prod-tile-8\"]/div[2]/div[1]/a")
	public WebElement productName;
	
	@FindBy(xpath="//*[@id=\"prod-tile-8\"]/div[2]/div[3]/span")
	public WebElement productPrice;

	@FindBy(xpath="//*[@id=\"section_button_0_3_3074457345618259659_4099276460824482099\"]/p/a")
	public WebElement priceIcon;
	
	@FindBy(xpath="//*[@id=\"facetDiv12095115111114116951121141059910195801011169911183116111114101958583685840123505332534812532534841\"]/label/i")
	public WebElement price25to50;
	
	@FindBy(xpath="//*[@id=\"prod-tile-0\"]/div[2]/div[1]/a")
	public WebElement price25to50FirstItem;
	
	@FindBy(xpath="//*[@id=\"petco-header-render-node\"]/header/div[2]/div/a")
	public WebElement navigateHome;
	
	
	


}
