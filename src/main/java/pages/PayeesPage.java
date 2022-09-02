package pages;



import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PayeesPage {
	@FindBy(xpath = "//span[text()='Payees']")
	private WebElement payeeOption;
	
	public void verifyPageTitle() {		
	}
	@FindBy(xpath = "//button[@class='Button Button--sub Button--translucid js-add-payee']")
	private WebElement addPayee;
	public void addPayee() {
	addPayee.click();
	}
	@FindBy(id = "ComboboxInput-apm-name")
	private WebElement enterPayeename;
	public void enterName() {
		enterPayeename.sendKeys("AnuRadha"+Keys.ENTER);
	}
	@FindBy(id = "apm-bank")
	private WebElement enterBank;
	@FindBy(id = "apm-branch")
	private WebElement enterBranch;
	@FindBy(id = "apm-account")
	private WebElement enterAccount;
	@FindBy(id = "apm-suffix")
	private WebElement enterSuffix;
	public void enterAccountNumber() {
		enterBank.sendKeys("02");
		enterBranch.sendKeys("0830");
		enterAccount.sendKeys("1234567");
		enterSuffix.sendKeys("000"+Keys.ENTER);
	}
	@FindBy(xpath = "//button[@class='js-submit Button Button--primary']")
	private WebElement addbutton;
	public void clickOnAdd() {
	addbutton.click();
		
	}
	@FindBy(xpath = "//*[@id='loginHandler']/label")
	private WebElement payeeadded;
	public void payeeAdded() {
			
	}
	
	@FindBy(xpath = "//*[@id=\"modal-form-manager\"]/div/div[1]/div")
	private WebElement errorMessage;
	public void assertError(String errorMessageExpected){
		assertTrue(errorMessageExpected.equals(errorMessage.getText()),"Payee Name is mandatory:"+errorMessage.getText().toString());
	}
	public void assertErrorMessageGone() {
		Assert.assertEquals(false, errorMessage.isDisplayed());
	}
	
	@FindBy(xpath = "//h3[@class='js-payee-name-column CustomSection-headingSpread u-textStyle-bold']")
	private WebElement nameHeader;
	public void clickNameHeader() {
		nameHeader.click();
	}
	
	@FindBy(xpath = "//ul[@class='List List--border']")
	private WebElement ulWebElement;
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


