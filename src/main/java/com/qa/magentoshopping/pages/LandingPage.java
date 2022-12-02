package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class LandingPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By CreateAnAccountLink = By.linkText("Create an Account");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public boolean checkregisterLink() {
		return eleUtil.doIsdisplayed(CreateAnAccountLink);
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(CreateAnAccountLink);
		return new RegisterPage(driver);
		
	}

}
