package pages;



import static org.testng.Assert.assertTrue;

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
	
	}


