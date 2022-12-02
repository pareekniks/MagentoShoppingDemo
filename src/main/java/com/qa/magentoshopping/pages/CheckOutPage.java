package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.magentoshopping.util.ElementUtil;

public class CheckOutPage {

	private ElementUtil eleUtil;
	private WebDriver driver;

	private By streetInput = By.name("street[0]");
	private By cityInput = By.name("city");
	private By stateList = By.name("region_id");
	private By postalCodeinput = By.name("postcode");
	private By countryList = By.name("country_id");
	private By telephoneInput = By.name("telephone");
	private By radioButton = By.name("ko_unique_2");
	
	private By nextButton = By.xpath("//span[normalize-space()='Next']");
	private By placeOrderButton = By.xpath("//span[text()='Place Order']");

	private By orderNumberText = By.className("order-number");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String performCheckout(String streetAddress, String city, String State, String postalCode, String Country,
			String phone)  {
		eleUtil.waitForElementPresense(streetInput, 20);
		eleUtil.doSendKeys(streetInput, streetAddress);
		eleUtil.doSendKeys(cityInput, city);
		eleUtil.waitForElementClickable(countryList, 20);
		eleUtil.doSelectByVisibletext(countryList, Country);
		eleUtil.waitForElementClickable(stateList, 20);
		eleUtil.doSendKeys(postalCodeinput, postalCode);
		eleUtil.doSelectByVisibletext(stateList, State);
		eleUtil.waitForElementClickable(telephoneInput, 20);
		eleUtil.doSendKeys(telephoneInput, phone);
		eleUtil.waitForElementClickable(radioButton, 20);
		eleUtil.doClick(radioButton);
		eleUtil.waitForElementVisiblity(nextButton, 20);
		eleUtil.waitForElementClickable(nextButton, 20);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doClick(nextButton);
		eleUtil.waitForElementVisiblity(placeOrderButton, 20);
		eleUtil.waitForElementClickable(placeOrderButton, 20);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doClick(placeOrderButton);
		eleUtil.waitForElementVisiblity(orderNumberText, 20);
		return eleUtil.doGetText(orderNumberText);

	}

	public MyOrdersPage verifyPurchase() {
		eleUtil.waitForElementVisiblity(orderNumberText, 20);
		eleUtil.doClick(orderNumberText);
		return new MyOrdersPage(driver);

	}

}
