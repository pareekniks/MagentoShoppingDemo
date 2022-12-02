package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class ProductDetails {

	private ElementUtil eleUtil;
	private WebDriver driver;

	private By addToCartButton = By.xpath("(//span[contains(text(),'Add to Cart')])[1]");
	private By checkOutButton = By.xpath("//button[@id='top-cart-btn-checkout']");

	private By counterNumberIcon = By.xpath("//a[@class='action showcart']");
	private By succMsg = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void addToCart() {
		eleUtil.waitForElementVisiblity(addToCartButton, 20);
		eleUtil.doClick(addToCartButton);
	}

	public CheckOutPage navigateToCheckOut() {
		eleUtil.waitForElementVisiblity(succMsg, 20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.waitForElementVisiblity(counterNumberIcon, 20);
		eleUtil.waitForElementClickable(counterNumberIcon, 20);
		eleUtil.doClick(counterNumberIcon);
		eleUtil.waitForElementClickable(checkOutButton, 20);
		eleUtil.doClick(checkOutButton);
		return new CheckOutPage(driver);

	}

}
