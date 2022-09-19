package com.app.test;

import com.app.pages.AccountOverviewPage;
import com.app.pages.ForgotPasswordPage;
import com.app.pages.LoginPage;
import com.app.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {


	@Given("Launch the parabank application with {string}")
	public void launch_the_parabank_application_with(String url) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchApplication(url);
		
	}

	@Then("Application title should be {string}")
	public void application_title_should_be(String title) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyAppTitle(title);
	}

	@Then("Application caption should be {string}")
	public void application_caption_should_be(String caption) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyApplicationCaption(caption);		
	}

	@When("^I Eneter (.*) and (.*)$")
	public void enterUsernameAndPassword(String username, String Password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyApplicationLogin(username, Password);
	}

	@When("I Clicked on Login button")
	public void i_clicked_on_login_button() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.clickOnLoginButton();
		
	}

	@Then("Account overview page should be displayed")
	public void account_overview_page_should_be_displayed() {
		AccountOverviewPage aopage =AccountOverviewPage.getAccountOverviewPage();
		aopage.verifySuccessfulLogin();
	}

	@When("I clicked on Registration link in the loginpage")
	public void i_clicked_on_registration_link_in_the_loginpage() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.getRegistrationPage();
		
	}

	@Then("Registration page should be launched")
	public void registration_page_should_be_launched() {
		RegistrationPage regpage = RegistrationPage.getRegistrationPage();
		regpage.verifyRegPage();
	}

	@When("I clicked on Forgot password link in the loginpage")
	public void i_clicked_on_forgot_password_link_in_the_loginpage() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.getForgotLoginInfoPage();
		
	}

	@Then("Forgot Password page should be launched")
	public void forgot_password_page_should_be_launched() {
		ForgotPasswordPage fgpage = ForgotPasswordPage.getForgotPassPage();
		fgpage.getForgotPassPage();
	}

}
