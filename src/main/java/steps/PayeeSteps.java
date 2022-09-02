package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverUtil;

public class PayeeSteps extends DriverUtil{
	
	
	@Given("I launch bnz home page")
	public void i_launch_bnz_home_page() {
		setupDriver();
		launchHomePage();
		
	}
	@When("I click on MenuButton")
	public void i_click_on_menu_button() {
		getHomePage().menuOptions();
	}
	@When("I click on Payee option")
	public void i_click_on_payee_option() {
	    getHomePage().payees();
	}
	@Then("Payees page is loaded")
	public void payees_page_is_loaded() {
		getPayeesPage().verifyPageTitle();
	}
	@When("I click add payee")
	public void i_click_add_payee() {
		getPayeesPage().addPayee();
	}
	
	@And("I enter payee details < name > & < account >")
	public void i_enter_payee_details_name_account() {
		getPayeesPage().enterName();
		getPayeesPage().enterAccountNumber();
	}
	@When("I click on Add button")
	public void i_click_on_add_button() {
	   getPayeesPage().clickOnAdd();
	}
	@Then("I see {string} message.")
	public void i_see_message(String sucessmessage) {
	    getPayeesPage().payeeAdded();
	}
	@When("I click add button again")
	public void i_click_add_button_again() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I see the validation message")
	public void i_see_the_validation_message() {
	  getPayeesPage().assertError("A problem was found. Please correct the field highlighted below.");
	}
	
	@Then("I verify errors are gone")
	public void i_verify_errors_are_gone() {	
	}
	
	@Then("I see the list is sorted in {string} order")
	public void i_see_the_list_is_sorted_in_order(String order) {
		getPayeesPage().isPayeeSort(order);
	}
	@Then("I click on the Name header")
	public void i_click_on_the_name_header() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
//	@After
//	public void tearDown(){
//		exit();
//	}

}
