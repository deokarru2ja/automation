package com.billing.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.billing.qa.base.TestBase;
import com.billing.qa.util.TestUtil;

public class MyBillPage extends TestBase {

	@FindBy(xpath="//*[@id=\'selectbill_dropDwn\']/span/button")
	static WebElement billHistoryDropDown;
	
	@FindBy(xpath="//div[@id=\'selectbill_dropDwn\']/span/button/span[1]")
	static WebElement currentBillLabelBHD;
	
	@FindBy(xpath="//div[@id=\'selectbill_dropDwn\']/span/button/span[3]")
	static WebElement totalBillChargesBillHistoryDropdown;
	
	@FindBy(xpath="//*[@id=\'selectbill_dropDwn\']/span/button/span[2]")
	static WebElement notAvailableLabel;
	
	@FindBy(xpath="//*[@id=\'wrapper\']/div[2]/div/div/div/div/div/div[3]/div/section[2]/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[2]/h3")
	static WebElement billNotReadyNote;
	
	@FindBy(xpath="//*[@id='wrapper']/div[2]/div/div/div/div/div/div[3]/div/section[2]/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[2]/p/a")
	static WebElement viewRecentPaymentLink;
	
	@FindBy(xpath="//a/span[contains(text(),'Print')]")
	static WebElement print;
	
	@FindBy(xpath="//*[@id=\"overview\"]/div/div/div[3]/a")
	static WebElement reportsLink;
	
	@FindBy(xpath="//*[@id=\'overview\']/div/div/div[2]/a")
	static WebElement paymentsLink;
	
	
	
	
	
	
	
	public static void selectHistoricalBill(int n) {
		
		billHistoryDropDown.click();
		driver.findElement(By.xpath("//div[@id=\'listbox489\']/ul/li["+n+"]")).click();;
		
	}
	public static boolean valTotalChrgsBillHistoryDropdown() {
		
		try {
		 
			return totalBillChargesBillHistoryDropdown.isDisplayed();
			
		}
			catch(NoSuchElementException e)
		{
				return false;
		}
		
	}
	
	public static boolean valCurrentBillLabel() {
		
		return currentBillLabelBHD.isDisplayed();
	}
	
    public static boolean notAvailableLabel() {
		
		if(notAvailableLabel.getText().equalsIgnoreCase("Not Available")) {
			return true ;
		}
		
		return false;
	}
    
    public static boolean validateBillUnavailableNote() {
    	
    	try {
   		 
			return billNotReadyNote.isDisplayed();
			
		}
			catch(NoSuchElementException e)
		{
				return false;
		}
		
    }
    
    public static boolean validateViewRecentPaymentLink() {
    	
    
      		 
			viewRecentPaymentLink.click();
			
			TestUtil.waitUntilNavigation(TestUtil.paymentURL);
			
			if(driver.getCurrentUrl().equals(TestUtil.paymentURL)) 
				return true ;	
			
			else return false ;
			
		
		
    	
    	
    }
    
    public static boolean validateNoOfBillsInBHD() {
    	
    	billHistoryDropDown.click();
    	WebElement z = driver.findElement(By.xpath("//*[@class=\"awd-select-list in ddh-collapse\"]/ul"));
    	List<WebElement> list=z.findElements(By.tagName("li"));
    	
    	if(list.size()>17)
    		return false ;
    	
    	else
    		return true;
    	
    }
    
    public static boolean validateSectionsUnderBHD() {
    	
    	billHistoryDropDown.click();
    	
    	WebElement z = driver.findElement(By.xpath("//*[@class=\"awd-select-list in ddh-collapse\"]/ul"));
    	List<WebElement> list=z.findElements(By.tagName("div"));
    	
    	
    	if(list.size()==2 && list.get(0).getText().equalsIgnoreCase("current bill") && list.get(1).getText().equalsIgnoreCase("previous bill"))
    		return true ;
    	
    	else if(list.size()==1 && list.get(0).getText().equalsIgnoreCase("current bill"))
    		return true ;
    	
    	else if (list.size()==3 && list.get(0).getText().equalsIgnoreCase("current bill") & list.get(1).getText().equalsIgnoreCase("previous bill") && list.get(2).getText().equalsIgnoreCase("previous wireless"))
    		return true;
    	
    	
    	return false;
    	
    }
    
    public static void openPrintPreview() {
    	
    	
    	print.click();
    	System.out.println(driver.getTitle());
    	
    }
    
    public static void navigateToReports() {
    	
    	reportsLink.click();
    }
    
    public static void navigateToPayments() {
    	
    	paymentsLink.click();
    	System.out.println(driver.getTitle());
    	
    }

}
