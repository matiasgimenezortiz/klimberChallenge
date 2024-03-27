package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() {
		if (!super.is64bits()) {
			WebDriverManager.getInstance(FIREFOX).arch32().setup();
		} else {
			WebDriverManager.getInstance(FIREFOX).setup();
		}
		
		return new FirefoxDriver(getFirefoxOptions());
	}

	

	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        // Disable extensions and hide infobars
        options.addArguments("--disable-infobars");

		return options;
	}

}
