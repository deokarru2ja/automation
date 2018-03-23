package com.billing.qa.tcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.billing.qa.base.TestBase;
import com.billing.qa.pages.InterstitialPage;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.OverviewPage;
import com.billing.qa.util.TestUtil;

public class LoginTest extends TestBase {

	
	public LoginTest() {
		super();
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
		initialize(browser);
		
	}
	@Parameters({"userName","password"})
	@Test
	public void doLogin(String userName, String password) throws InterruptedException {
		
		LoginPage.login(userName, password);
		
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.close();
	}
	
	
}
