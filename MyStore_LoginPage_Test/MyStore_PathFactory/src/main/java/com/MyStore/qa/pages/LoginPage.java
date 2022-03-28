package com.MyStore.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.MyStore.qa.base.MyStoreBase;

public class LoginPage extends MyStoreBase {
	
	@FindBy(xpath= "//h1[@class='page-heading']")
	WebElement page_heading;
	
	@FindBy(xpath= "//h3[contains(text(),'Already registered?')]")
	WebElement loginpage_subheading;
	
	@FindBy(xpath ="//label[@for='email']")
	WebElement Email_Label;
	
	@FindBy(id= "email")
	WebElement email_dom;
	
	@FindBy(xpath= "//label[contains(text(),'Password')]")
	WebElement Password_Label;
	
	@FindBy(id= "passwd")
	WebElement passwd_dom;
	
	@FindBy(id= "SubmitLogin")
	WebElement signin_btn;
	
	@FindBy(xpath= "//a[contains(text(),'Forgot your password?')]")
	WebElement link_frgtpasswd;
	
	@FindBy(xpath= "//div[@class='alert alert-danger']/ol")
	WebElement signin_error;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePageHeading() {
		return page_heading.isDisplayed();
	}
	
	public boolean validateSubHeading() {
		return loginpage_subheading.isDisplayed();
	}
	
	public boolean validateEmailLabel() {
		return Email_Label.isDisplayed();
	}
	
	public boolean validatePasswordLabel() {
		return Password_Label.isDisplayed();
	}
	
	public boolean signin_btn_enabled() {
		return signin_btn.isEnabled();
	}
	public MyAccountPage loginwithValidCredential(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
		return new MyAccountPage();
	}
	
	public MyAccountPage LoginWith_Enterbtn(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.sendKeys(Keys.ENTER);
		return new MyAccountPage();
	}
	
	public void InvalidEmail_ValidPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void ValidEmail_InvalidPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void InvalidEmail_InvalidPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void EmptyEmail_ValidPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void EmptyEmail_InvalidPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void ValidEmail_EmptyPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void InvalidEmail_EmptyPasswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void EmptyEmai_EmptyPassswd(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public void ValidCredentialinCAPS(String email, String passwd) {
		email_dom.sendKeys(email);
		passwd_dom.sendKeys(passwd);
		signin_btn.click();
	}
	
	public String Validate_ErrorMsg() {
		return signin_error.getText();
	}
	
	public boolean Validate_link_forgotpasswd() {
		return link_frgtpasswd.isDisplayed();
	}
	
	public ForgotPasswordPage Link_forgotpasswd() {
		link_frgtpasswd.click();
		return new ForgotPasswordPage();
	}
	
	
	
	
}
