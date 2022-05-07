package cl.equifax.prueba.Page;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import java.time.Duration;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected static WebDriver driver;
	protected WebDriverWait wait;

	private static final int WAIT_TIMEOUT = 30;
	private static final int POLLING = 1;

	static {
		// Ingresar direccion de ChromeDriver en Enviroment Ejemplo:
		// Variable, Valor
		// WEB_DRIVER_CHRO C://oliver//etc
		System.setProperty("webdriver.chrome.driver", System.getenv("WEB_DRIVER_CHRO"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
	}

	protected Base(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofSeconds(POLLING));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT), this);
	}

	protected Base(WebDriver driver, int timeOutSec) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec), Duration.ofSeconds(POLLING));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT), this);
	}

	protected Base(WebDriver driver, int timeOutSec, int pollingSec) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec), Duration.ofSeconds(pollingSec));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT), this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public void waitUntilElementIsElementClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			throw new ConditionTimeoutException(
					String.format("No se encuentra el elemento despues de 30 segundos\nElemento: %s", element));
		}
	}

	protected boolean isVisible(WebElement webElement) {
		try {
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isVisible(By element) {
		try {
			return getDriver().findElement(element).isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitUntilElementIsVisible(WebElement element) {
		try {
			await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
		} catch (ConditionTimeoutException e) {
			throw new ConditionTimeoutException(String.format(
					"No se encuentra el elemento despues de " + WAIT_TIMEOUT + " segundos\nElemento: %s", element));
		}
	}

	public void waitUntilElementIsVisible(By element) {
		try {
			await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
		} catch (ConditionTimeoutException e) {
			throw new ConditionTimeoutException(String.format(
					"No se encuentra el elemento despues de " + WAIT_TIMEOUT + " segundos\nElemento: %s", element));
		}
	}

}
