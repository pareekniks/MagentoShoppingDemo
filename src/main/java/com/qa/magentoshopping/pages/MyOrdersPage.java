package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class MyOrdersPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By orderNumberText = By.xpath("//span[@class='base']");

	public MyOrdersPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public boolean verifyOrderNumber(String orderNumber) {
		eleUtil.waitForElementPresense(orderNumberText, 20);
		if (eleUtil.doGetText(orderNumberText).contains(orderNumber)) {
			return true;
		} else {
			return false;
		}
	}

}
