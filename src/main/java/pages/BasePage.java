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
 * @author 
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
	 * @author 
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
	 * @author 
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
	
	// Clicking on a particular element
	private void fastClick(MobileElement mobileElement,int timeOutInSeconds) throws InterruptedException {
		driver.manage().wait(timeOutInSeconds);
		mobileElement.click();
	}
	
	
	/**
	 * @author 
	 *
	 * Method for Scrolling 
	 * @return void
	 * @tag  @param times
	 */
	public void scrollDown(int times) {
		for(int i=0;i< times;i++) {
			org.openqa.selenium.Dimension dim= getDriver().manage().window().getSize();
			int height=dim.getHeight();
			int width=dim.getWidth();
			int x=width/2;
			int starty=(int)(height*0.85);
			int endy=(int)(height*0.5);
			TouchAction action= new TouchAction(getDriver());
			action.press(PointOption.point(x,starty));
			action.moveTo(PointOption.point(x, endy));
			action.release().perform();
	}
	}

	
	/**
	 * @author 
	 *
	 * Rotation methods 1. Rotating Landscape 2. Rotating Portrait
	 * @return void
	 * @tag  @param times
	 */
	
	public T rotateToLandscape() {
		
		return (T)this;
	}
	
	
	public T rotateToPortrait() {
		
		return (T)this;
	}
}
