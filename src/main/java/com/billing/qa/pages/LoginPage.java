package com.billing.qa.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import com.billing.qa.base.TestBase;
import com.billing.qa.util.TestUtil;
import com.google.common.base.Function;
import com.google.common.base.Predicate;


public class LoginPage extends TestBase {

	
	@FindBy(xpath="//*[@id=\"userName\"]")
	static WebElement userName;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	static WebElement password;
	
	
	@FindBy(xpath="//*[@id=\"loginButton\"]")
	static WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\'save-user-id\']")
	static WebElement saveuidchk;
	
	
	@FindBy(xpath="//*[@id=\"z1-profile-open\"]")
	 static WebElement icon;
	
	@FindBy(xpath="//*[@id=\"profile-signout-mobile\"]")
	 static WebElement logout;
	
	
	
	
	//actions
	public static void login(String unm, String pwd)  {
		
		userName.sendKeys(unm);
		password.sendKeys(pwd);
		saveuidchk.click();
		loginButton.click();
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);	
		
		Function<WebDriver,Boolean> function = new Function<WebDriver, Boolean>(){

			public Boolean apply(WebDriver driver) {
				
				String url=driver.getCurrentUrl();
				
				if(url.equals(TestUtil.interstitialURL)) {
					
					System.out.println(TestUtil.interstitialURL);
					InterstitialPage.navigateToOverview(url);
					return true;
				}
				else if(url.equals(TestUtil.overviewURL)) {
					return true ;
				}
								
				return false;
			}
			
		};
		
		wait.until(function);
	
		
		/****Predicate<WebDriver> predicate =new Predicate<WebDriver>() {

			@Override
			public boolean apply(WebDriver arg0) {
				String url=driver.getCurrentUrl();
				
				if(url.equals(prop.getProperty("interstitialURL"))) {
					InterstitialPage.navigateToOverview(url);
					return true;
				}
								
				return false;
			}
			
			
		};  ****/
		
	}
}
