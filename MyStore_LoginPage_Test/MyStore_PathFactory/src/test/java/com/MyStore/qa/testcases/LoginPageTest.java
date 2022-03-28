package com.MyStore.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.qa.base.MyStoreBase;
import com.MyStore.qa.pages.ForgotPasswordPage;
import com.MyStore.qa.pages.HomePage;
import com.MyStore.qa.pages.LoginPage;
import com.MyStore.qa.pages.MyAccountPage;



public class LoginPageTest extends MyStoreBase {
	
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	ForgotPasswordPage fp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod 
	public void setup() throws IOException {
		initialization();
		lp = new LoginPage();
		mp = new MyAccountPage();
		fp = new ForgotPasswordPage();
		hp = new HomePage();
		lp = hp.navigating_to_loginpage();
		
	}
	
	@Test (priority=1)
	public void PageheadingTest() throws IOException{

		Assert.assertEquals(lp.validatePageHeading(), true);
	}
	
	@Test 
	public void SubheadingTest() {
		Assert.assertEquals(lp.validateSubHeading(), true);
	}
	
	@Test 
	public void EmailLabelTest() {
		Assert.assertEquals(lp.validateEmailLabel(), true);
	}
	
	@Test 
	public void PasswdLabelTest() {
		Assert.assertEquals(lp.validatePasswordLabel(), true);
	}
	
	@Test 
	public void signinbtn_enabled_test() {
		Assert.assertEquals(lp.signin_btn_enabled(), true);
	}
	@Test 
	public void LoginWithValidCredentialTest() throws IOException{
		mp = lp.loginwithValidCredential(prop.getProperty("email01"), prop.getProperty("passwd01"));
		Assert.assertEquals(mp.validate_username(), "Dhruvesh Patel");
	}
	
	@Test
	public void LoginWith_Enterbtn_test() {
		mp = lp.LoginWith_Enterbtn(prop.getProperty("email01"), prop.getProperty("passwd01"));
		Assert.assertEquals(mp.validate_username(), "Dhruvesh Patel");
	}
	
	@Test
	public void LoginWith_InvalidEmail_ValidPasswd() {
		lp.InvalidEmail_ValidPasswd(prop.getProperty("email02"), prop.getProperty("passwd02"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Authentication failed.");
	}
	
	@Test
	public void LoginWith_ValidEmail_InvalidPasswd() {
		lp.ValidEmail_InvalidPasswd(prop.getProperty("email03"), prop.getProperty("passwd03"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Authentication failed.");
	}
	
	@Test
	public void LoginWith_InvalidEmail_InvalidPasswd() {
		lp.InvalidEmail_InvalidPasswd(prop.getProperty("email04"), prop.getProperty("passwd04"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Authentication failed.");
	}
	
	@Test 
	public void LoginWith_EmptyEmail_ValidPasswd() {
		lp.EmptyEmail_ValidPasswd(prop.getProperty("email05"), prop.getProperty("passwd05"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "An email address required.");
	}
	
	@Test
	public void LoginWith_EmptyEmail_InvalidPasswd() {
		lp.EmptyEmail_InvalidPasswd(prop.getProperty("email06"), prop.getProperty("passwd06"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "An email address required.");
	}
	
	@Test 
	public void LoginWIth_ValidEmail_EmptyPasswd() {
		lp.ValidEmail_EmptyPasswd(prop.getProperty("email07"), prop.getProperty("passwd07"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Password is required.");
	}
	
	@Test 
	public void LoginWith_InvalidEmail_EmptyPasswd() {
		lp.InvalidEmail_EmptyPasswd(prop.getProperty("email08"), prop.getProperty("passwd08"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Password is required.");
	}
	
	@Test 
	public void LoginWith_EmptyEmail_EmptyPassswd() {
		lp.EmptyEmai_EmptyPassswd(prop.getProperty("email09"), prop.getProperty("passwd09"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "An email address required.");
	}
	
	@Test 
	public void LoginWith_ValidCredentialinCAPS() {
		lp.ValidCredentialinCAPS(prop.getProperty("email10"), prop.getProperty("passwd10"));
		Assert.assertEquals(lp.Validate_ErrorMsg(), "Authentication failed.");
	}
	
	@Test 
	public void Link_forgotpasswd_test() {
		fp = lp.Link_forgotpasswd();
		Assert.assertEquals(fp.validate_SubHeading(), "FORGOT YOUR PASSWORD?");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
