package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class ProductSearchPage {
	
	private ElementUtil eleUtil;
	private WebDriver driver;
	
	private By userProduct =By.xpath("(//div[@class='product-item-info'])[1]");

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public ProductDetails navigateToProductDetails() {
		eleUtil.waitForElementVisiblity(userProduct, 10);
		eleUtil.doClick(userProduct);
		return new ProductDetails(driver);
	}

}
