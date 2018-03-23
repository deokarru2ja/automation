package com.billing.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.billing.qa.base.TestBase;
import com.billing.qa.util.TestUtil;

public class OverviewPage extends TestBase{

	@FindBy(xpath="//*[@id=\'z1-pullMenu-open\']/i[1]")
	static WebElement menu;
	
	@FindBy(xpath="//ul[@id=\'tab-desktop-menu\']/li[2]/a")
	static WebElement bnplink;
	
	@FindBy(xpath="//ul[@id='tab-desktop-menu']/li[2]/ul/li[3]/a[3]")
	static WebElement viewMyBill;
	
	@FindBy(xpath="//*[@id=\'myBilling\']/div[2]/a")
	static WebElement seeMyBill;
	
	
	
	
	
	public static void navigateToBilling() {
		
		TestUtil.waitUntilElementIsVisible(seeMyBill);
		
		seeMyBill.click();
		
		
	}
	
	

}
