package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.PayeesPage;
import pages.PaymentsPage;
import steps.BrowserConfig;

public class DriverUtil {
	public static WebDriver driver = BrowserConfig.driver;
	private HomePage homePage;
	private PayeesPage payeesPage;
	private PaymentsPage paymentsPage;


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
