package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstNameInput = By.xpath("//input[@id='firstname']");
	private By lastNameInput = By.xpath("//input[@id='lastname']");
	private By emailInput = By.xpath("//input[@id='email_address']");
	private By passwordInput = By.xpath("//input[@id='password']");
	private By confirmPasswordInput = By.xpath("//input[@id='password-confirmation']");
	private By createButton = By.cssSelector("button[title='Create an Account'] span");

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public MyAccountPage registerUser(String firstName, String lastName, String eMail, String password) {
		eleUtil.doSendKeys(firstNameInput, firstName);
		eleUtil.doSendKeys(lastNameInput, lastName);
		eleUtil.doSendKeys(emailInput, eMail);
		eleUtil.doSendKeys(passwordInput, password);
		eleUtil.doSendKeys(confirmPasswordInput, password);
		eleUtil.doClick(createButton);

		return new MyAccountPage(driver);
	}

}
