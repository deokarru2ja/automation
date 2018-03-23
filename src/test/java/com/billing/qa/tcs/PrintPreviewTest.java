package com.billing.qa.tcs;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.billing.qa.base.TestBase;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.MyBillPage;
import com.billing.qa.pages.OverviewPage;
import com.billing.qa.pages.PrintPreviewPage;
import com.billing.qa.util.TestUtil;

public class PrintPreviewTest extends TestBase{
	
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
		MyBillPage.openPrintPreview();
		TestUtil.switchToNewTab(1);
		
		
	}
	
	@Test(priority=2)
	public void validatePrintPreview() {
		
		Assert.assertTrue(PrintPreviewPage.validatePrintTitle());
		Assert.assertTrue(PrintPreviewPage.validateLogo());
		Assert.assertTrue(PrintPreviewPage.validateAddress());
		Assert.assertTrue(PrintPreviewPage.validateBillDate());
		Assert.assertTrue(PrintPreviewPage.validateBillSummaryHeading());
		Assert.assertTrue(PrintPreviewPage.validateBillTotalLabel());
		Assert.assertTrue(PrintPreviewPage.validateBillTotalCharges());
		
	}
	
	@Test(priority=3)
	public void validatePrintFunctionality() {
		PrintPreviewPage.validatePrintButton();
	
		
	}
	
	
	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
}
