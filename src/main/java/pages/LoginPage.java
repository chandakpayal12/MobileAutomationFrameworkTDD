package main.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import main.java.pages.ExcelDataReader;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage<LoginPage> {
	
	ExcelDataReader excelreader=new ExcelDataReader();
	@AndroidFindBy(id="sign_in_button")
	private MobileElement ALLOW_SIGNIN;

	@AndroidFindBy(id = "usernameId")
	private WebElement username;

	@AndroidFindBy(id = "enterUsernameId")
	private WebElement enterUsernameField;

	@AndroidFindBy(xpath = "continueButtonXpath")
	private WebElement continueButton;

	@AndroidFindBy(id = "passwordId")
	private WebElement password;

	@AndroidFindBy(id = "loginButtonId")
	private WebElement loginButton;

	@AndroidFindBy(id = "amazonHomeId")
	private WebElement amazonHome;


	public LoginPage(AppiumDriver driver) {
		super(driver);
	}


	/**
	 * @author 
	 *
	 *  login 
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectSigninButton() {
		ALLOW_SIGNIN.click();
		return this;
	}
	
	/**
	 * @author 
	 *
	 *	Set Email Address
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setEmailAddress() throws Exception {
		username.click();
		excelreader.setExcelFile("/TestData/TestData.xlsx","Sheet1");
		excelreader.getTableArray("/TestData/TestData.xlsx","Sheet1");
		String userId = excelreader.getCellData(2,1);
		username.sendKeys(userId);
		return this;
	}
	
	/**
	 * @author 
	 *
	 *	Click on Continue button
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectContinue() {
		loginButton.click();
		return this;
	}
	
	/**
	 * @author 
	 *
	 *	Enter the password
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setPassword() throws Exception {
		excelreader.setExcelFile("/TestData/TestData.xlsx","Sheet1");
		excelreader.getTableArray("/TestData/TestData.xlsx","Sheet1");
		String pwd = excelreader.getCellData(2,2);
		password.sendKeys(pwd);
		return this;
	}
	
	
	/**
	 * @author 
	 *
	 * Click on Sign in button
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectSignIn() {
		amazonHome.isDisplayed();
		return new ProductSearchPage(getDriver());
	}
}
