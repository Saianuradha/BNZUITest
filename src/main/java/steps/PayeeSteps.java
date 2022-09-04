package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PayeesPage;

public class PayeeSteps {
	
	public static WebDriver driver = BrowserConfig.driver;
	public PayeesPage payeePage;
	public HomePage homePage;
	
	public PayeeSteps() {
		payeePage = new PayeesPage(driver);
		homePage = new HomePage(driver);
	}
	

	@Given("I launch bnz home page")
	public void i_launch_bnz_home_page() {
		homePage.launchHomePage();
	}

	@When("I click on MenuButton")
	public void i_click_on_menu_button() {
		homePage.menuOptions();
	}

	@When("I click on Payee option")
	public void i_click_on_payee_option() {
		homePage.payees();
	}

	@Then("Payees page is loaded")
	public void payees_page_is_loaded() {
		payeePage.verifyPageTitle();
	}

	@When("I click add payee")
	public void i_click_add_payee() {
		payeePage.addPayee();
	}

	@And("I enter payee details < name > & < account >")
	public void i_enter_payee_details_name_account() {
		payeePage.enterName();
		payeePage.enterAccountNumber();
	}

	@When("I click on Add button")
	public void i_click_on_add_button() {
		payeePage.clickOnAdd();
	}
	
	@Then("I see {string} message")
	public void i_see_message(String string) {
		payeePage.payeeAdded();
	}

	@When("I see the validation message")
	public void i_see_the_validation_message() {
		payeePage.assertError("A problem was found. Please correct the field highlighted below.");
	}

	@Then("I verify errors are gone")
	public void i_verify_errors_are_gone() {
	}

	@Then("I see the list is sorted in {string} order")
	public void i_see_the_list_is_sorted_in_order(String order) {
		payeePage.isPayeeSort(order);
	}

	@Then("I click on the Name header")
	public void i_click_on_the_name_header() {
		payeePage.clickNameHeader();
	}

}
