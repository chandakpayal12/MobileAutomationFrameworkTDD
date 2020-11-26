package main.java.base;


import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import main.java.common.ExtendReport;
import main.java.common.LoggerAgent;
import main.java.common.MyTestListener;
import main.java.common.PropertyExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(MyTestListener.class)
public class BaseTest {

	PropertyExecutor propertyExecutor;
	private String Capabilities;
	AppiumDriver driver;
	ExtendReport extendReport;
	private String TestReport;

	/**
	 * @author 
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
	 * @author 
	 *
	 *
	 * @return void
	 * @tag  @param m
	 */
	@BeforeMethod
	public void beforeMethod(Method m)  {
		propertyExecutor.getProperty(Capabilities);
	}	
	
	

/**
 * @author 
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
	 * @author 
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
