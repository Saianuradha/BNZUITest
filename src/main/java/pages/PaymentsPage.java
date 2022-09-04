package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentsPage {
	
private WebDriver driver;
	
	public PaymentsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
	

	public void selectFromAccount() {
		fromChooseAccount.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fromAccountType);
	}

	public void selectToAccount() {
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Transfer successful']")));
		
		assertTrue(transferSuccessMessage.isDisplayed() == true, "Success message is not displayed");	
	}
	
	public String getFromAccountValue() {
		String fullText = fromChooseAccount.findElement(By.xpath("(//p[contains(@class,'balance')])[1]")).getText();
		fullText = fullText.substring(1);
		int index = fullText.indexOf(" Avl.");
		fullText = fullText.substring(0, index);
		return fullText.replace(",", "");
	}
	
	public String getToAccountValue() {
		String fullText = toChooseAccount.findElement(By.xpath("(//p[contains(@class,'balance')])[2]")).getText();
		fullText = fullText.substring(1);
		int index = fullText.indexOf(" Avl.");
		fullText = fullText.substring(0, index);
		return fullText.replace(",", "");
	}

}
