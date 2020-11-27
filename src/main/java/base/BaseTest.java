package main.java.base;


import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import main.java.common.ExtendReport;
import main.java.common.LoggerAgent;
import main.java.common.PropertyExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

public class BaseTest {

	PropertyExecutor propertyExecutor;
	private String Capabilities;
	AppiumDriver driver;
	ExtendReport extendReport;
	private String TestReport;

	/**
	 * @author Payal Chandak
	 *
	 *
	 * @return void
	 * @tag  @throws MalformedURLException
	 * @tag  @throws Exception
	 */
	@BeforeClass
	public void setup() throws MalformedURLException, Exception {
		LoggerAgent.LogError("Executed before every class");
	}
	

	
	/**
	 * @author Payal Chandak
	 *
	 *
	 * @return void
	 * @tag  @param m
	 */
	@BeforeMethod
	public void beforeMethod(Method m)  {
		// Set desired capabilities.
	   DesiredCapabilities capabilities = new DesiredCapabilities();
	   capabilities.setCapability("PLATFORM_NAME", propertyExecutor.getProperty("platformName"));
	   capabilities.setCapability("PLATFORM_VERSION", propertyExecutor.getProperty("platformVersion"));
	   capabilities.setCapability("AUTOMATION_NAME",propertyExecutor.getProperty("automationName"));
	   capabilities.setCapability("DEVICE_NAME",propertyExecutor.getProperty("deviceName"));
	   capabilities.setCapability("APP",propertyExecutor.getProperty("app"));
		//Instantiate Appium Driver
		try {
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL(propertyExecutor.getProperty("URL")), capabilities);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	

/**
 * @author Payal Chandak
 *
 *
 * @return void
 * @tag  @param result
 * @tag  @throws FileNotFoundException
 */
@AfterMethod
public void afterMethod(ITestResult result) throws FileNotFoundException {
	extendReport.getReporter(TestReport);
	extendReport.closeReporter();
	}
	
	
	/**
	 * @author Payal Chandak
	 * @return void
	 * @tag  
	 */
	@AfterClass
	public void tearDown() {
		try {
			this.driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
