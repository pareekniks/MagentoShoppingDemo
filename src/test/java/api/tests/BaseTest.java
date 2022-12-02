package api.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.magentoshopping.factory.DriverFactory;
import com.qa.magentoshopping.pages.CheckOutPage;
import com.qa.magentoshopping.pages.LandingPage;
import com.qa.magentoshopping.pages.MyAccountPage;
import com.qa.magentoshopping.pages.MyOrdersPage;
import com.qa.magentoshopping.pages.ProductDetails;
import com.qa.magentoshopping.pages.ProductSearchPage;
import com.qa.magentoshopping.pages.RegisterPage;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	Properties prop;

	LandingPage landingPage;
	RegisterPage regPage;
	MyAccountPage myaccPage;
	ProductSearchPage prodSearchPage;
	ProductDetails prodDetailsPage;
	CheckOutPage checkOutPage;
	MyOrdersPage myOrdPage;
	SoftAssert softAssert;
	public Logger logger;
	

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_Driver(prop);
		landingPage = new LandingPage(driver);
		softAssert = new SoftAssert();
		logger = LogManager.getLogger(this.getClass());
		
		

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
