package pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PayeesPage {
	@FindBy(xpath = "//span[text()='Payees']")
	private WebElement payeeOption;

	@FindBy(xpath = "//button[@class='Button Button--sub Button--translucid js-add-payee']")
	private WebElement addPayee;

	@FindBy(id = "ComboboxInput-apm-name")
	private WebElement enterPayeename;

	@FindBy(id = "apm-bank")
	private WebElement enterBank;

	@FindBy(id = "apm-branch")
	private WebElement enterBranch;

	@FindBy(id = "apm-account")
	private WebElement enterAccount;

	@FindBy(id = "apm-suffix")
	private WebElement enterSuffix;

	@FindBy(xpath = "//button[@class='js-submit Button Button--primary']")
	private WebElement addbutton;

	@FindBy(xpath = "//*[@id='loginHandler']/label")
	private WebElement payeeadded;

	@FindBy(xpath = "//*[@id=\"modal-form-manager\"]/div/div[1]/div")
	private WebElement errorMessage;

	@FindBy(xpath = "//h3[@class='js-payee-name-column CustomSection-headingSpread u-textStyle-bold']")
	private WebElement nameHeader;

	@FindBy(xpath = "//ul[@class='List List--border']")
	private WebElement ulWebElement;
	
	@FindBy(xpath = "//span[text()='Payee added']")
	private WebElement payeeAddedSuccessMessage;

	public void verifyPageTitle(WebDriver driver) {
		 JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("return document.readyState")
	      .toString().equals("complete");
	      String currentUrl = driver.getCurrentUrl();
	      String payeeUrlExpected = "https://www.demo.bnz.co.nz/client/payees";
	     
	      assertTrue(currentUrl.equals(payeeUrlExpected), "Payee page did not load");
	}
	
	public void payeeAdded() {
		try {
			// TODO remove thread.sleep
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(payeeAddedSuccessMessage.isDisplayed() == true, "Payee added success message is not displayed");
	}
	
	public void addPayee() {
		addPayee.click();
	}

	public void enterName() {
		enterPayeename.sendKeys("AnuRadha" + Keys.ENTER);
	}

	public void enterAccountNumber() {
		enterBank.sendKeys("02");
		enterBranch.sendKeys("0830");
		enterAccount.sendKeys("1234567");
		enterSuffix.sendKeys("000" + Keys.ENTER);
	}

	public void clickOnAdd() {
		addbutton.click();

	}

	public void assertError(String errorMessageExpected) {
		assertTrue(errorMessageExpected.equals(errorMessage.getText()),
				"Payee Name is mandatory:" + errorMessage.getText().toString());
	}

	public void assertErrorMessageGone() {
		Assert.assertEquals(false, errorMessage.isDisplayed());
	}

	public void clickNameHeader() {
		nameHeader.click();
	}

	public void isPayeeSort(String order) {
		ArrayList<String> obtainedList = new ArrayList<>();

		List<WebElement> elementList = ulWebElement.findElements(By.xpath("//span[@class='js-payee-name']"));
		for (WebElement ele : elementList) {
			obtainedList.add(ele.getText().toString());
		}

		if (order.equals("ascending")) {
			ArrayList<String> tempList = new ArrayList<String>(obtainedList);
			Collections.sort(tempList);

			boolean isSortedInAscending = tempList.equals(obtainedList);
			assertTrue((isSortedInAscending == true), "Payee List is not Sorted in Ascending Order");
		} else {
			ArrayList<String> tempList = new ArrayList<String>(obtainedList);
			Collections.sort(tempList, Collections.reverseOrder());

			boolean isSortedInDescending = tempList.equals(obtainedList);
			assertTrue((isSortedInDescending == true), "Payee List is not Sorted in Descending Order");
		}
	}

}
