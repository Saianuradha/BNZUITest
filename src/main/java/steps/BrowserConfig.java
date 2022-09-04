package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Utilities;

public class BrowserConfig {

	public static WebDriver driver=null;

	@Before
	public void beforeScenario(Scenario scenario) {
		if(driver==null) {
		initSystemProperty();
		initDriver(Utilities.getConfigValue("browser"));

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(Utilities.getConfigValue("loadingTime"))));
		}
	}

	private void initDriver(String browserType) {
			switch (browserType) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			default:
				driver = new ChromeDriver();
			}
	}

	private void initSystemProperty() {
		if (System.getProperty("os.name").contains("Win")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		} else if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver");
		}
	}

//	public WebDriver getDriver() {
//		return driver;
//	}

}
