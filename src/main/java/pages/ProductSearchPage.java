package main.java.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import main.java.common.LoggerAgent;
import main.java.pages.BasePage;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.List;

public class ProductSearchPage extends BasePage<ProductSearchPage> {
	ExcelDataReader excelreader=new ExcelDataReader();
	
	@AndroidFindBy(id="rs_search_src_text")
	private MobileElement SEARCH_PRODUCT_FIELD;
	
	@AndroidFindBy(id="iss_search_dropdown_item_text_layout")
	private MobileElement SELECT_PRODUCT;
	
	@AndroidFindBy(xpath="//android.view.View[7]")
	private List<MobileElement> SELECT_SEARCHED_PRODUCT;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Sony')]")
	private MobileElement PRODUCT_NAME;
	
	@AndroidFindBy(id="ourPrice_availability")
	private MobileElement PRODUCT_PRICE;
	
	@AndroidFindBy(xpath="//*[@text='Add to Cart']")
	private MobileElement ADD_TO_CART_BTN;
	
	@AndroidFindBy(accessibility="Cart")
	private MobileElement PROCEED_TO_CHECKOUT;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Sony')]")
	private MobileElement CHECKOUT_PRODUCT_NAME;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'$')]")
	private MobileElement CHECKOUT_PRODUCT_PRICE;

	@AndroidFindBy(xpath = "orderSuccessXpath")
	private MobileElement orderSuccessMessage;
	
	//android.view.View[@content-desc="Sony X750H 65-inch 4K Ultra HD LED TV -2020 Model"]/android.widget.TextView
	public ProductSearchPage(AppiumDriver driver) {
		super(driver);
	}
	
	
	/**
	 * @author 
	 *
	 *	Search the product
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage searchProduct() throws Exception {
		SEARCH_PRODUCT_FIELD.click();
		excelreader.setExcelFile("/TestData/TestData.xlsx","Sheet1");
		excelreader.getTableArray("/TestData/TestData.xlsx","Sheet1");
		String searchProduct = excelreader.getCellData(2,4);
		SEARCH_PRODUCT_FIELD.sendKeys(searchProduct);
		return this;
	}

	
	/**
	 * @author 
	 *
	 *	Select the product
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectProduct() {
		SELECT_PRODUCT.isDisplayed();
		return this;
	}
	
	
	/**
	 * @author 
	 *
	 *
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage selectSearchedProduct() throws Exception {
		excelreader.setExcelFile("/TestData/TestData.xlsx","Sheet1");
		excelreader.getTableArray("/TestData/TestData.xlsx","Sheet1");
		String requiredProduct = excelreader.getCellData(2,5);
		for(int i=0; i<SELECT_SEARCHED_PRODUCT.size(); i++) {
		if(SELECT_SEARCHED_PRODUCT.get(i).getText().equalsIgnoreCase(requiredProduct));
		{
			SELECT_SEARCHED_PRODUCT.get(i).click();
		}
	}
		PRODUCT_NAME.isDisplayed();
		PRODUCT_PRICE.isDisplayed();
		ADD_TO_CART_BTN.click();
		return this;
	}
	
	
	/**
	 * @author 
	 *
	 *	Validate the product value vs Check out product
	 * @return ProductSearchPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public ProductSearchPage validateProductScreenValuesVsCheckout()throws Exception {
		PROCEED_TO_CHECKOUT.isDisplayed();
		CHECKOUT_PRODUCT_NAME.isDisplayed();
		CHECKOUT_PRODUCT_PRICE.isDisplayed();
		Assert.assertEquals(CHECKOUT_PRODUCT_NAME.getText(),PRODUCT_NAME.getText());
		Assert.assertEquals(CHECKOUT_PRODUCT_PRICE.getText(),PRODUCT_PRICE.getText());
		String OrderSuccessfulMessage = orderSuccessMessage.getText();
		Assert.assertEquals(OrderSuccessfulMessage, "Thank you for shopping with us.");
		LoggerAgent.LogInfo("Item purchased successfully");
		orderSuccessMessage.isDisplayed();
		return this;
	}
}
	