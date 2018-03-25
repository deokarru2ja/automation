package com.billing.qa.tcs;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.billing.qa.base.TestBase;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.MyBillPage;
import com.billing.qa.pages.OverviewPage;
import com.billing.qa.util.PDFReport;
import com.billing.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BillHistoryDropdownTest extends TestBase {
	
	
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
		
	}
	
	@Test(priority = 2)
	public void goToBillingPage() {
		
		OverviewPage.navigateToBilling();
	}
	
	@Test(priority = 3)
	public void validateTotalChargesForCurrentBill() {
		Assert.assertFalse(MyBillPage.valTotalChrgsBillHistoryDropdown(), "Total Chrges is not displayed in Bill history dropdown when current bill is selected");
	}
	
	@Test(priority = 4)
	public void validateSelectPreviousBill(){
		MyBillPage.selectHistoricalBill(2);
	}
	
	@Test(priority = 5)
	public void validateTotalChargesForPreviousBill() {
		
		Assert.assertTrue(MyBillPage.valTotalChrgsBillHistoryDropdown(), "Total Chrges is displayed in Bill history dropdown when previous bill is selected");
		
	}
	
	@Test(priority=6)
	public void validateNumberOfBillInBHD() {
		
		Assert.assertTrue(MyBillPage.validateNoOfBillsInBHD());
		
		MyBillPage.navigateToPayments();
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
