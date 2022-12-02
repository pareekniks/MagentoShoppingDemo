package api.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest extends BaseTest {
	Response response;
	User userInfo = new User();

	@Test(priority = 1)
	public void testGetUser() {
		logger.info("Generating one random user test started");
		response = UserEndPoints.generateUser("in");
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);

		logger.info("Saving all the user information");
		userInfo.setFirstName(response.then().extract().path(Constants.FIRST_NAME_PATH).toString());
		userInfo.setLastName(response.then().extract().path(Constants.LAST_NAME_PATH).toString());
		userInfo.setPhone(response.then().extract().path(Constants.PHONE).toString());
		userInfo.setCity(response.then().extract().path(Constants.CITY).toString());
		userInfo.setState(response.then().extract().path(Constants.STATE).toString());
		userInfo.setStreetAddress(response.then().extract().path(Constants.STREETADDRESS).toString());
		userInfo.setPostalCode(response.then().extract().path(Constants.POSTALCODE).toString());
		userInfo.setEmail(response.then().extract().path(Constants.EMAIL).toString());

	}

	@Test(priority = 2)
	public void verifyLandingPage() {
		logger.info("Checking registration link");
		Assert.assertTrue(landingPage.checkregisterLink());
	}

	@Test(priority = 3)
	public void regiserUser() {
		logger.info("navigating to  registration link");
		regPage = landingPage.navigateToRegisterPage();
		logger.info("registering the user");
		myaccPage = regPage.registerUser(userInfo.getFirstName(), userInfo.getLastName(), userInfo.getEmail(),
				"Test@1234");
		logger.info("Asserting user information");
		Assert.assertTrue(myaccPage.getUserInformation());
	}

	@Test(priority = 4)
	public void buyProductandValidate() {
		logger.info("Searching for product");
		prodSearchPage = myaccPage.searchProduct("watch");
		logger.info("navigating to  product details page");
		prodDetailsPage = prodSearchPage.navigateToProductDetails();
		logger.info("adding to cart the product");
		prodDetailsPage.addToCart();
		logger.info("performing the checkout");
		checkOutPage = prodDetailsPage.navigateToCheckOut();
		String orderNumber = checkOutPage.performCheckout(userInfo.getStreetAddress(), userInfo.getCity(),
				userInfo.getState(), userInfo.getPostalCode(), "India", userInfo.getPhone());
		logger.info("After purchase verifying the product");
		myOrdPage = checkOutPage.verifyPurchase();
		Assert.assertTrue(myOrdPage.verifyOrderNumber(orderNumber));
	}

}
