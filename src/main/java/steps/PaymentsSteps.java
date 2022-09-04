package steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PaymentsPage;

public class PaymentsSteps {
	private Double amountTransfering;
	private Double previousFromValue;
	private Double previousToValue;
	
	public static WebDriver driver = BrowserConfig.driver;
	public PaymentsPage paymentsPage;
	public HomePage homePage;
	
	public PaymentsSteps() {
		paymentsPage = new PaymentsPage(driver);
		homePage = new HomePage(driver);
	}
	

//	@Given("I launch bnz home page second")
//	public void i_launch_bnz_home_page_second() {
//		launchHomePage();
//
//	}
//
//	@When("I click on MenuButton second")
//	public void i_click_on_menu_button_second() {
//		homePage.menuOptions();
//	}

	@When("I Navigate to PaymentsPage")
	public void navigate_to_payments_page() {
		homePage.payments();
	}
	
	@When("I click on Everyday")
	public void i_click_on_everyday() {
		paymentsPage.selectFromAccount();
	}

	@When("I click on Bills")
	public void i_click_on_bills() {
		paymentsPage.selectToAccount();
	}
	
	@When("I enter amount {string}")
	public void i_enter_amount_value(String value) {
		amountTransfering = Double.parseDouble(value);
		paymentsPage.enterTransferAmount(value);
	}

	@When("I click on Transer button")
	public void i_click_on_transer_button() {
		previousFromValue = Double.parseDouble(paymentsPage.getFromAccountValue());
		previousToValue = Double.parseDouble(paymentsPage.getToAccountValue());
		paymentsPage.clickTransferButton();
	}

	@When("I see Success message")
	public void i_see_success_message() {
		paymentsPage.transferSuccessMessageDisplayed();
	}

	@Then("I verify Transaction")
	public void i_verify_transaction() {
		Double currentFromAccountValue = Double.parseDouble(homePage.getEveryDayAccountCurrentValue());
		Double currentToAccountValue = Double.parseDouble(homePage.getBillsAccountCurrentValue());
	
		assertTrue(((currentFromAccountValue + amountTransfering) == previousFromValue), "Assertion Failed: Mismatch in From Account");
		assertTrue(((currentToAccountValue - amountTransfering) == previousToValue), "Assertion Failed: Mismatch in To Account");
		
	}
}
