package com.billing.qa.util;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.billing.qa.base.TestBase;



	
	/*************************************** PURPOSE **********************************
	 - This class implements the WebDriverEventListener, which is included under events.
	 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
	 which would be displayed/logged as the application under test is being run.
	 Do not call any of these methods, instead these methods will be invoked automatically
	 as an when the action done (click, findBy etc). 
	 */

	public class WebEventListener extends TestBase implements WebDriverEventListener {
		
		
	
		public void beforeNavigateTo(String url, WebDriver driver) {
			System.out.println("Before navigating to: '" + url + "'");
	
		}

		public void afterNavigateTo(String url, WebDriver driver) {
			System.out.println("Navigated to:'" + url + "'");
			
			
		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver) {
			System.out.println("Value of the:" + element.toString() + " before any changes made");
		}

		public void afterChangeValueOf(WebElement element, WebDriver driver) {
			System.out.println("Element value changed to: " + element.toString());
		}

		public void beforeClickOn(WebElement element, WebDriver driver) {
			System.out.println("Trying to click on: " + element.toString());
		}

		public void afterClickOn(WebElement element, WebDriver driver) {
			System.out.println("Clicked on: " + element.toString());
			String screenshotPath = TestUtil.getSS();
			
			
			String path = "<img src=\"file://" + screenshotPath + "\" alt=\"\"/>" ;
			Reporter.log(path);
			
		}

		public void beforeNavigateBack(WebDriver driver) {
			System.out.println("Navigating back to previous page");
		}

		public void afterNavigateBack(WebDriver driver) {
			System.out.println("Navigated back to previous page");
		}

		public void beforeNavigateForward(WebDriver driver) {
			System.out.println("Navigating forward to next page");
		}

		public void afterNavigateForward(WebDriver driver) {
			System.out.println("Navigated forward to next page");
		}

		public void onException(Throwable error, WebDriver driver) {
			System.out.println("Exception occured: " + error);
			
		}

		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Trying to find Element By : " + by.toString());
			
		}

		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Found Element By : " + by.toString());
			String screenshotPath = TestUtil.getSS();
			
			
			String path = "<img src=\"file://" + screenshotPath + "\" alt=\"\"/>" ;
			Reporter.log(path);
		
		}

		/*
		 * non overridden methods of WebListener class
		 */
		public void beforeScript(String script, WebDriver driver) {
			
			System.out.println("Before script");
		}

		public void afterScript(String script, WebDriver driver) {
			System.out.println("After Script");
		}

		public void beforeAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void afterAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void afterAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void beforeAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void beforeNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void afterNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub

		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub

		}

		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub

		}
		
		

		private Date getTime(long startMillis) {
			
			
			Calendar calender = Calendar.getInstance();
			calender.setTimeInMillis(startMillis);
			
			return calender.getTime();
		}


	}

