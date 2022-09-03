package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage {
	@FindBy(xpath = "//button[@data-monitoring-label='Transfer Form From Chooser']")
	private WebElement fromChooseAccount;
	@FindBy(xpath = "//button[@data-monitoring-label='Transfer Form To Chooser']")
	private WebElement toChooseAccount;

	@FindBy(xpath = "(//button[contains(@class,'button')])[4]")
	private WebElement fromAccountType;

	@FindBy(xpath = "(//div[contains(@class,'content')])[10]")
	private WebElement toAccountType;

	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement accountTab;

	@FindBy(xpath = "//button[@data-monitoring-label='Transfer Form Submit']")
	private WebElement transferButton;

	@FindBy(xpath = "(//input[contains(@id,'field-bnz-web-ui-toolkit')])[1]")
	private WebElement amountEditText;

	@FindBy(xpath = "//span[text()='Transfer successful']")
	private WebElement transferSuccessMessage;

	public void selectFromAccount(WebDriver driver) {
		fromChooseAccount.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fromAccountType);
	}

	public void selectToAccount(WebDriver driver) {
		toChooseAccount.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountTab);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toAccountType);
	}

	public void enterTransferAmount(String value) {
		amountEditText.sendKeys(value);
	}

	public void clickTransferButton() {
		transferButton.click();
	}

	public void transferSuccessMessageDisplayed() {
		try {
			// TODO remove thread.sleep
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(transferSuccessMessage.isDisplayed() == true, "Success message is not displayed");
	}

}
