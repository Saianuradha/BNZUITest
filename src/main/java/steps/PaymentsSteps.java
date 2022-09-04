package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverUtil;

public class PaymentsSteps extends DriverUtil {
	private Double amountTransfering;
	private Double previousFromValue;
	private Double previousToValue;
	

	@Given("I launch bnz home page second")
	public void i_launch_bnz_home_page_second() {
		setupDriver();
		launchHomePage();

	}

	@When("I click on MenuButton second")
	public void i_click_on_menu_button_second() {
		getHomePage().menuOptions();
	}

	@When("I Navigate to PaymentsPage")
	public void navigate_to_payments_page() {
		getHomePage().payments();
	}
	
	@When("I click on Everyday")
	public void i_click_on_everyday() {
		getPaymentsPage().selectFromAccount(getDriver());
	}

	@When("I click on Bills")
	public void i_click_on_bills() {
		getPaymentsPage().selectToAccount(getDriver());
	}
	
	@When("I enter amount {string}")
	public void i_enter_amount_value(String value) {
		amountTransfering = Double.parseDouble(value);
		getPaymentsPage().enterTransferAmount(value);
	}

	@When("I click on Transer button")
	public void i_click_on_transer_button() {
		previousFromValue = Double.parseDouble(getPaymentsPage().getFromAccountValue());
		previousToValue = Double.parseDouble(getPaymentsPage().getToAccountValue());
		getPaymentsPage().clickTransferButton();
	}

	@When("I see Success message")
	public void i_see_success_message() {
		getPaymentsPage().transferSuccessMessageDisplayed();
	}

	@Then("I verify Transaction")
	public void i_verify_transaction() {
		Double currentFromAccountValue = Double.parseDouble(getHomePage().getEveryDayAccountCurrentValue());
		Double currentToAccountValue = Double.parseDouble(getHomePage().getBillsAccountCurrentValue());
	
		assertTrue(((currentFromAccountValue + amountTransfering) == previousFromValue), "Assertion Failed: Mismatch in From Account");
		assertTrue(((currentToAccountValue - amountTransfering) == previousToValue), "Assertion Failed: Mismatch in To Account");
		
	}

}
