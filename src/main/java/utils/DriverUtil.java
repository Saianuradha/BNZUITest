package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.PayeesPage;
import pages.PaymentsPage;

public class DriverUtil {
	private WebDriver driver;
	private HomePage homePage;
	private PayeesPage payeesPage;
	private PaymentsPage paymentsPage;

	public WebDriver setupDriver() {
		initSystemProperty();
		initDriver(Utilities.getConfigValue("browser"));

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(Utilities.getConfigValue("loadingTime"))));

		homePage = PageFactory.initElements(driver, HomePage.class);
		payeesPage = PageFactory.initElements(driver, PayeesPage.class);
		paymentsPage = PageFactory.initElements(driver, PaymentsPage.class);
		return driver;
	}

	private void initDriver(String browserType) {
		if (driver == null) {
			switch (browserType) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			default:
				driver = new ChromeDriver();
			}
		}
	}

	private void initSystemProperty() {
		if (System.getProperty("os.name").contains("Win")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		} else if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver");
		}
	}

	public void exit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void launchHomePage() {
		driver.get(Utilities.getConfigValue("bnzappUrl"));
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public PayeesPage getPayeesPage() {
		return payeesPage;
	}

	public void verifyPageTitle() {
		driver.getTitle();
	}

	public PaymentsPage getPaymentsPage() {
		return paymentsPage;
	}

}
