package seleniumutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.function.Function;

public class Waits {
	
	private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
                .ignoring(WebDriverException.class)
                .until(condition);
	}

	public void waitForElementToBeVisible(WebDriver driver, final WebElement element, int seconds) {
		waitForCondition(driver, seconds, d -> element.isDisplayed());
	}

	public void waitForElementToDisappear(WebDriver driver, final WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.ignoring(WebDriverException.class)
				.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementToBeClickable(WebDriver driver, final WebElement element, int seconds) {
		waitForCondition(driver, seconds, d -> ExpectedConditions.elementToBeClickable(element));
	}



}
