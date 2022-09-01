package steps;

import io.cucumber.java.After;
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
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@After
	public void tearDown(){
		exit();
	}

}
