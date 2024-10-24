package StepDefinations;

import org.openqa.selenium.WebDriver;

import CommonFunctions.FunctionLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ERPSteps
{

	WebDriver driver;
	
	@Given("launch Browser")
	public void launch_browser() throws Throwable
	{
	   driver = FunctionLibrary.startBrowser();
	}
	
	@Given("launch url")
	public void launch_url() 
	{
	    FunctionLibrary.openUrl();
	}
	
	@When("wait for username with {string} and {string} and {string}")
	public void wait_for_username_with_and_and(String Ltype, String Lvalue, String Mywait) 
	{
	   FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("enter user name with {string} and {string} and {string}")
	public void enter_user_name_with_and_and(String Ltype, String Lvalue, String TestData) 
	{
		FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
	}
	
	@When("enter password with {string} and {string} and {string}")
	public void enter_password_with_and_and(String Ltype, String Lvalue, String TestData) 
	{
	   FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
	}
	
	@When("click submit button with {string} and {string}")
	public void click_submit_button_with_and(String Ltype, String Lvalue) throws Throwable 
	{
	   FunctionLibrary.clickAction(Ltype, Lvalue);
	}
	
	@When("wait for supplier link with {string} and {string} and {string}")
	public void wait_for_supplier_link_with_and_and(String Ltype, String Lvalue, String Mywait)
	{
	    FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("click on supplier link with {string} and {string}")
	public void click_on_supplier_link_with_and(String Ltype, String Lvalue) throws Throwable
	{
		FunctionLibrary.clickAction(Ltype, Lvalue);

	}
	
	@When("wait for addIcon link with {string} and {string} and {string}")
	public void wait_for_add_icon_link_with_and_and(String Ltype, String Lvalue, String Mywait)
	{
	   FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("click on addicon link with {string} and {string}")
	public void click_on_addicon_link_with_and(String Ltype, String Lvalue) throws Throwable
	{
	   FunctionLibrary.clickAction(Ltype, Lvalue);
	}
	
	@When("wait for supplier number with {string} and {string} and {string}")
	public void wait_for_supplier_number_with_and_and(String Ltype, String Lvalue, String Mywait)
	{
	   FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("capture supplier number with {string} and {string}")
	public void capture_supplier_number_with_and(String Ltype, String Lvalue) throws Throwable
	{
		
		FunctionLibrary.capturesupp(Ltype, Lvalue);
	}
	
	@When("enter in {string} with {string} and {string}")
	public void enter_in_with_and(String testdata, String Ltype, String Lvalue)
	{
		FunctionLibrary.typeAction(Ltype, Lvalue, testdata);
		
	   
	}
	
	@When("enter in {string} wih {string} and {string}")
	public void enter_in_wih_and(String testdata, String Ltype, String Lvalue)
	{
		FunctionLibrary.typeAction(Ltype, Lvalue, testdata);
	}
	
	@When("click add button with {string} and {string}")
	public void click_add_button_with_and(String Ltype, String Lvalue) throws Throwable
	{
	   FunctionLibrary.clickAction(Ltype, Lvalue);
	   
	}
	
	@When("wait for confirm ok button with {string} and {string} and {string}")
	public void wait_for_confirm_ok_button_with_and_and(String Ltype, String Lvalue, String Mywait) 
	{
		FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("click on confirm ok button with {string} and {string}")
	public void click_on_confirm_ok_button_with_and(String Ltype, String Lvalue) throws Throwable
	{
	   FunctionLibrary.clickAction(Ltype, Lvalue);
	}
	
	@When("wait for alert ok button with {string} and {string} and {string}")
	public void wait_for_alert_ok_button_with_and_and(String Ltype, String Lvalue, String Mywait)
	{
		FunctionLibrary.waitForElement(Ltype, Lvalue, Mywait);
	}
	
	@When("click on alert ok button with {string} and {string}")
	public void click_on_alert_ok_button_with_and(String Ltype, String Lvalue) throws Throwable 
	{
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}
	
	@When("verify supplier number")
	public void verify_supplier_number() throws Throwable 
	{

		FunctionLibrary.supplierTable();
	}
	
	@Then("click logout link with {string} and {string}")
	public void click_logout_link_with_and(String Ltype, String Lvalue) throws Throwable 
	{
		FunctionLibrary.clickAction(Ltype, Lvalue);

	}
	@Then("close Browser")
	public void close_browser()
	{
		FunctionLibrary.closeBrowser();
	}
}
