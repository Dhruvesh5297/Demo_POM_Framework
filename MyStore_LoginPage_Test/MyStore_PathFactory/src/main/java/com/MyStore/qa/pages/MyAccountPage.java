  package com.MyStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.qa.base.MyStoreBase;

public class MyAccountPage extends MyStoreBase {
	
	@FindBy(xpath= "//span[contains(text(),'My account')]")
	WebElement page_name;
	
	@FindBy(xpath= "//span[contains(text(),'Dhruvesh Patel')]")
	WebElement user_name;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement logout_btn;
	
	 public MyAccountPage() {
			
			PageFactory.initElements(driver, this);
		}
	
	public boolean validate_PageName() {
		return page_name.isDisplayed();
	}
	
	public String validate_username() {
		return user_name.getText();
	}
	
	public boolean validate_LogoutBtn() {
		return logout_btn.isDisplayed();
	}
	
}
