package com.billing.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.billing.qa.base.TestBase;
import com.billing.qa.util.TestUtil;

public class InterstitialPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\'wrapper\']/div[2]/div/div/section/div/div/div[2]/div/div/div[2]/div/div[2]/button")
	static WebElement remindMeLater;
	
	@FindBy(xpath="//*[@id=\'wrapper\']/div[2]/div/div/section/div/div/div[2]/div/div/div[2]/div/div[1]/button[1]")
	static WebElement iAgree;
	
	
	public static void navigateToOverview(String url) {
		
		if(url.equals(TestUtil.interstitialURL)) {
		remindMeLater.click();
		}
			
		
	}
}
