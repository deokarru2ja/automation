package com.billing.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.billing.qa.base.TestBase;
import com.billing.qa.util.TestUtil;

public class PrintPreviewPage extends TestBase {
	
	
	@FindBy(xpath="//*[@id=\'ge5p_z2-nav-bar\']/div[2]/a/h1")
	static WebElement printTitle;
	
	@FindBy(xpath="//*[@id=\'ge5p_z2-nav-bar\']/div[1]/a/span/i")
	static WebElement logo;
	
	@FindBy(xpath="//div[@class='margin-top20']")
	static WebElement address;
	
	@FindBy(xpath="//div[@class='bill-date margin-top30 ng-binding']")
	static WebElement billDate;
	
	@FindBy(xpath="//*[@id=\'printf\']/div[1]/div[1]/h2")
	static WebElement billSummaryHeading;
	
	@FindBy(xpath="//*[@id=\'printf\']/div[2]/div/div[1]/h3")
	static WebElement billTotalLabel;
	
	@FindBy(xpath="//*[@id='printf']/div[2]/div/div[2]/h3")
	static WebElement billTotalCharges;
	
	@FindBy(xpath="//button[contains(text(),'Print')]")
	static WebElement printButton;
	
	
	@FindBy(xpath="*[@id='print-header']/div/button[1]")
	static WebElement finalPrint;
	
	public static boolean validatePrintTitle() {
		
		return 	TestUtil.isDisplayed(printTitle);
				
				
	}
	
	public static boolean validateLogo() {
		
		return 	TestUtil.isDisplayed(logo);
				
				
	}
	
	public static boolean validateAddress() {
		
		return 	TestUtil.isDisplayed(address);
				
				
	}
	
	public static boolean validateBillDate() {
		
		return 	TestUtil.isDisplayed(billDate);
				
				
	}
	
   public static boolean validateBillSummaryHeading() {
		
		return 	TestUtil.isDisplayed(billSummaryHeading);
				
				
	}
   
   public static boolean validateBillTotalLabel() {
		
		return 	TestUtil.isDisplayed(billTotalLabel);
				
				
	}
   
   public static boolean validateBillTotalCharges() {
		
		return 	TestUtil.isDisplayed(billTotalCharges);
				
				
	}
	
	
	
	public static void validatePrintButton() {
		
		Actions actions = new Actions(driver);

		actions.moveToElement(printButton).click().perform();
		finalPrint.click();
		
		
		
	}
	
	
	
}
