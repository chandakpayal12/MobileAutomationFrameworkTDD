package test.java.tests;


import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import main.java.pages.LoginPage;
import org.testng.annotations.Test;
import utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;
import main.java.base.BaseTest;

import static org.jsoup.nodes.Entities.EscapeMode.base;

public class AmazonShoppingTest extends BaseTest{

	private String screenShotPath;

	/*Test for login,
	 * adding product and 
	 * validation
	 * @author : Payal Chandak
	*/
	@Test(priority=1,enabled=true)
	public void validateAmazonProductAdded(AppiumDriver driver) throws Exception {
		new LoginPage(driver)
		.selectSigninButton()
		.setEmailAddress()
		.selectContinue()
		.setPassword()
		.selectSignIn()
		.searchProduct()
		.selectProduct()
		.selectSearchedProduct()
		.validateProductScreenValuesVsCheckout();
		ExtentTest testReporter = null;
		testReporter.log(LogStatus.PASS, "Product Shipped Successfully...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));

	}
}
