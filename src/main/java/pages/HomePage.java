package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utilities;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='Button Button--transparent js-main-menu-btn MenuButton']")
	private WebElement bnzMenuButton;

	@FindBy(xpath = "//span[text()='Payees']")
	private WebElement payeeOption;

	@FindBy(xpath = "//span[text()='Pay or transfer']")
	private WebElement paymentOption;
	
	@FindBy(xpath = "//div[@id='account-ACC-1']/div[2]/span[3]")
	private WebElement everyDayAccountBalance;
	
	@FindBy(xpath = "//div[@id='account-ACC-5']/div[2]/span[3]")
	private WebElement billsAccountBalance;

	public void menuOptions() {
		bnzMenuButton.click();
	}

	public void payees() {
		payeeOption.click();
	}

	public void payments() {
		paymentOption.click();
	}
	
	public String getEveryDayAccountCurrentValue() {
		String value = everyDayAccountBalance.getText();
		value = value.replace(",", "");
		return value;
	}
	
	public String getBillsAccountCurrentValue() {
		String value = billsAccountBalance.getText();
		value = value.replace(",", "");
		return value;
	}
	
	public void launchHomePage() {
		driver.get(Utilities.getConfigValue("bnzappUrl"));
	}
}
