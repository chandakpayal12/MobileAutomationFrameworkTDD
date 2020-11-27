package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import java.util.concurrent.TimeUnit;

/**
 * @author 
 *
 * 09-Oct-2020
 */
/**
 * @author Payal Chandak
 *
 * 09-Oct-2020
 */
public class BasePage<T extends BasePage<T>> {
	private AppiumDriver driver;
	
	public BasePage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()),this);
	}

	public AppiumDriver getDriver() {
		return this.driver;
	}
	
	/**
	 * @author Payal Chandak
	 *This method is for click on a Element after locating it
	 *
	 * @return void
	 * @tag  @param mobileElement
	 */
	public void clickAfterFindingElement(MobileElement mobileElement) {
		mobileElement.click();
	}
	
	
	//Getting the text from a mobile element
	public String getTextAfterFindingElement(MobileElement mobileElement) {
		driver.findElements(By.xpath(""));
		return mobileElement.getText();
	}
	
	
	/**
	 * @author Payal Chandak
	 *
	 *	This method is for set the implicit wait
	 * @return void
	 * @tag  @param mobileElement
	 * @tag  @throws Exception
	 */
	public void waitForElementToBeDisplayed(MobileElement mobileElement) throws Exception {
		mobileElement.wait();
		mobileElement.isDisplayed();
	}
	
	private String getElementText(MobileElement mobileElement,int timeOutInSeconds) throws InterruptedException {
		driver.manage().wait(timeOutInSeconds);
		return mobileElement.getText();
	}
	
	//setting values on text field
	public void setvalues(MobileElement mobileElement, String value) {
		mobileElement.sendKeys(value);
	}
}
