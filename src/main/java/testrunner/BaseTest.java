package testrunner;

import asserts.Validate;
import driver.DriverFactory;
import driver.DriverManager;
import listeners.TestMethodListener;
import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Constants;

@Listeners(TestMethodListener.class)
public abstract class BaseTest implements Logging {
	
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected Validate validate;
	
	@BeforeMethod
	@Parameters({"driverName"})
	protected void setup(@Optional("CHROME") String driverName) {
		getLogger().info("Starting a Selenium WebDriver instance.");
		
		initializeDriverManager(driverName);
		
		driver = this.getDriver();
		validate = new Validate(this.getDriver());
		
		driver.navigate().to(Constants.getContextUrl());
	}
	
	private synchronized void initializeDriverManager(String driverName) {
		if (null == driverManager) {
			driverManager = DriverFactory.valueOf(driverName).getDriverManager();
		} else {
			driverManager.getDriver();
		}
	}
	
	public Validate getValidator() {
		return validate;
	}
	
	@AfterMethod
	protected void afterMethod() {
		getLogger().info("Closing Selenium WebDriver instance.");
		driverManager.quitDriver();
	}
	
	@AfterClass
	protected void cleanUp() {
				
	}
	
	protected WebDriver getDriver() {
		return driverManager.getDriver();
	}
}
