package com.MyStore.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.qa.base.MyStoreBase;

public class HomePage extends MyStoreBase{
	
	@FindBy(xpath= "//img[@class='logo img-responsive']")
	WebElement logo_image;
	
	@FindBy(xpath= "//a[contains(text(),'Sign in')]")
	WebElement SignIn;
	
	 public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
	
	
	public boolean validate_logo() {
		return logo_image.isDisplayed();
	}
	
	public boolean validate_signinbtn() {
		return SignIn.isDisplayed();
	}
	
	public LoginPage navigating_to_loginpage() throws IOException{
		SignIn.click();
		
		return new LoginPage();
	}

}
