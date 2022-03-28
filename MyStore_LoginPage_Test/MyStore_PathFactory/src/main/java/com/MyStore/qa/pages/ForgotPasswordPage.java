package com.MyStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.qa.base.MyStoreBase;

public class ForgotPasswordPage extends MyStoreBase {
	
	@FindBy(xpath="//h1[@class='page-subheading']")
	WebElement sub_heading;
	
	@FindBy(id="email")
	WebElement email_dom;
	
	@FindBy(xpath="//span[contains(text(),'Retrieve Password')]")
	WebElement Retrive_Password_btn;
	
    public ForgotPasswordPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validate_SubHeading() {
		return sub_heading.getText();
	}
	
	public boolean validate_EmailDom() {
		return email_dom.isDisplayed();
	}
	
	public boolean RetrivePasswdBtn() {
		return Retrive_Password_btn.isDisplayed();
	}
}
