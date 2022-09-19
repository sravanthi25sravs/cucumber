package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons {

	// WebElements

	@FindBy(xpath = "//img[@title='ParaBank']")
	private WebElement logo;

	@FindBy(xpath = "//p[@class='caption']")
	private WebElement caption;

	@FindBy(xpath = "//h2")
	private WebElement loginHeader;

	@FindBy(name = "username")
	private WebElement usernameTxtb;

	@FindBy(name = "password")
	private WebElement passwordTxtb;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement loginBtn;

	@FindBy(linkText = "Forgot login info?")
	private WebElement forgotPassLink;

	@FindBy(linkText = "Register")
	private WebElement regLink;

	// Actions

	public void launchApplication(String url) {
		driver.get(url);
	}

	public void verifyLogo() {
		if (logo.isDisplayed());
	
	}

	public void verifyAppTitle(String title) {
		if (driver.getTitle().equals(title));
	
	}

	public void verifyApplicationCaption(String url) {
		if (getElementText(caption).equals(url));
		

	}

	public void verifyApplicationLogin(String username, String password) {
		enterText(usernameTxtb, username);
		enterText(passwordTxtb, password);
	}
	
	public void clickOnLoginButton() {
		click(loginBtn);
	}
	
	public void getRegistrationPage() {
		click(regLink);

	}
	
	public void getForgotLoginInfoPage() {
		click(forgotPassLink);
	}

	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}

}
