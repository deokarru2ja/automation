package com.billing.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;

import com.billing.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIMEOUT=120;
	public static final long IMPLICIT_WAIT=120;
	public static final long EXPLICIT_WAIT=120;
	public static final long TIMEOUT=120;
	public static final String interstitialURL="https://dssqa8-m.stage.att.com/my/#/adWorksInterceptorsGlobal";
	public static final String paymentURL="https://dssqa8-m.stage.att.com/my/#/Payments";
	public static final String overviewURL="https://dssqa8-m.stage.att.com/my/#/accountOverview";
	public static final String URL="https://dssqa8-m.stage.att.com/my/#/login";
	public static final String PRINT_URL="https://dssqa8-m.stage.att.com/my/#/printBill";
	
	static ITestContext context;
	
	public static void setContext(ITestContext tcContext) {
		context=tcContext;
	}
	
	public static String getSS() {
		
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotName=context.getName();
		//waitForLoad();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" +"/"+ screenshotName +"/" + timestamp
				+ ".png";
		File finalDestination=new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
	}
	
	 public static void waitForLoad() {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(pageLoadCondition);
	    }
	 
	 public static void switchToNewTab(int n) {
		 
		 ArrayList<String> handles =new ArrayList<String>(driver.getWindowHandles());
		 
		 driver.switchTo().window(handles.get(n));
		
		 
	 }
	 
	 public static void waitUntilElementIsVisible(WebElement element) {
		
		 FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		 wait.ignoring(StaleElementReferenceException.class, ElementNotFoundException.class);
		 wait.pollingEvery(5, TimeUnit.SECONDS);
		 wait.withTimeout(TIMEOUT, TimeUnit.SECONDS);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(element));
			
			
			
	 }
	 
	 public static void waitUntilNavigation(String url) {
		 
		 WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
			wait.until(ExpectedConditions.urlToBe(url));
	 }
	 
	 public static boolean isDisplayed(WebElement element) {
		 
		 try {
				return element.isDisplayed();
				
				}
				catch(Exception e) {
				return false;
				}
	 }
}
