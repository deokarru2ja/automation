package com.billing.qa.tcs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.billing.qa.base.TestBase;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.MyBillPage;
import com.billing.qa.pages.OverviewPage;

public class OverviewPageTest extends TestBase {
	
	
	public OverviewPageTest() {
		super();
	}
	
	@Parameters({"browser","userName","password"})
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {
		initialize(browser);
		LoginPage.login(prop.getProperty("unm"), prop.getProperty("pwd"));		 
		
	}
	
	@Test
	public void checkNavigation() {
	
		
		OverviewPage.navigateToBilling();
		MyBillPage.navigateToPayments();
	}
	
	@AfterMethod
	public void tearDown() {
		// driver.close();
	}
}
