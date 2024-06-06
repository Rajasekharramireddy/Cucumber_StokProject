package StepDefinations;

import commonFunctions.FunctionLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSteps {
	@Given("user navigate Browser")
	public void user_navigate_browser() throws Throwable {
	    FunctionLibrary.startBrowser();
	}

	@When("user lunch Url")
	public void user_lunch_url() {
	   FunctionLibrary.openUrl();
	}

	@When("user wait for Username {string} and {string}")
	public void user_wait_for_username_and(String LocatorType,String LocatorValue) {
	    FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	}

	@Then("user enter username with {string} and {string} and {string}")
	public void user_enter_username_with_and_and(String LocatorType,String LocatorValue,String TestData) {
	    FunctionLibrary.typeAction(LocatorType,LocatorValue,TestData);
	}

	@Then("user enter  password with  {string} and {string} and {string}")
	public void user_enter_password_with_and_and(String LocatorType,String LocatorValue,String TestData) {
	    FunctionLibrary.typeAction(LocatorType, LocatorValue, TestData);
	}

	@Then("user Click on LoginButton {string} and {string}")
	public void user_click_on_login_button_and(String LocatorType,String LocatorValue) {
	    FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user should wait for Customer link with {string} and {string}")
	public void user_should_wait_for_customer_link_with_and(String LocatorType,String LocatorValue) {
		FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	    }

	@When("user  click on Customer link with {string} and {string}")
	public void user_click_on_customer_link_with_and(String LocatorType,String LocatorValue) {
	    FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user should wait for Add+ icon with {string} and {string}")
	public void user_should_wait_for_add_icon_with_and(String LocatorType,String LocatorValue) {
		FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	}

	@When("user click on Add+icon with {string} and {string}")
	public void user_click_on_add_icon_with_and(String LocatorType,String LocatorValue) {
	 FunctionLibrary.ClickAction(LocatorType, LocatorValue);  
	}

	@Then("user should wait for CustomerNumber with {string} and {string}")
	public void user_should_wait_for_customer_number_with_and(String LocatorType,String LocatorValue) {
		FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	}

	@When("user Capture CustomerNumber with {string} and {string}")
	public void user_capture_customer_number_with_and(String LocatorType,String LocatorValue) throws Throwable {
	    FunctionLibrary.Capturecus(LocatorType, LocatorValue);
	    
	}
	@When("enter in {string} with {string} and {string}")
	public void enter_in_with_and(String LocatorType,String LocatorValue,String TestData) {
		FunctionLibrary.typeAction(LocatorType, LocatorValue, TestData);
	    
	}

	@Then("user Click on AddButton with {string} and {string}")
	public void user_click_on_add_button_with_and(String LocatorType,String LocatorValue) {
	    FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user should wait for Conformok button {string} and {string}")
	public void user_should_wait_for_conformok_button_and(String LocatorType,String LocatorValue) {
		FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	}

	@Then("user Click on ConformOk  with {string} and {string}")
	public void user_click_on_conform_ok_with_and(String LocatorType,String LocatorValue) {
	    FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user should Wait for Alertok button with {string} and {string}")
	public void user_should_wait_for_alertok_button_with_and(String LocatorType,String LocatorValue) {
		FunctionLibrary.waitforElement(LocatorType, LocatorValue, "10");
	}

	@Then("user click on AlertOk button with {string} and {string}")
	public void user_click_on_alert_ok_button_with_and(String LocatorType,String LocatorValue) {
	   FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user validate Customer Table")
	public void user_validate_customer_table() throws Throwable {
	    FunctionLibrary.CustomerTable();
	}

	@When("user click on logoutlink with {string} and {string}")
	public void user_click_on_logoutlink_with_and(String LocatorType,String LocatorValue) {
	   FunctionLibrary.ClickAction(LocatorType, LocatorValue);
	}

	@Then("user close application")
	public void user_close_application() {
	   FunctionLibrary.CloseBrowser();
	}

}
