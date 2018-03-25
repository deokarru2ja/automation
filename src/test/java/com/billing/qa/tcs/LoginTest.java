package com.billing.qa.tcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.billing.qa.base.TestBase;
import com.billing.qa.pages.InterstitialPage;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.MyBillPage;
import com.billing.qa.pages.OverviewPage;
import com.billing.qa.pages.Payments;
import com.billing.qa.util.TestUtil;

public class LoginTest extends TestBase {

	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(ITestContext context, String browser) {
		
		
		initialize(browser);
		TestUtil.setContext(context);
		
	}
	
	@Parameters({"userName","password"})
	@Test(priority=1)
	public void checkLogin(String userName, String password) {
		
		LoginPage.login(userName, password);
		OverviewPage.navigateToBilling();
		MyBillPage.navigateToPayments();
		Payments.validatePageTitle();
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.close();
	}
	
	
}
