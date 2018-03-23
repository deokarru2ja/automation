package com.billing.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.billing.qa.base.TestBase;

public class ReportsPage extends TestBase{
	
	
	@FindBy(xpath="//div[@class='span5']/div/span/button")
	static WebElement reportTypeButton;
	
	@FindBy(xpath="//div[@class='span6 datepicker1']/span/button\r\n")
	static WebElement startingBillingPeriodButton;
	
	@FindBy(xpath="//div[@class='span6 datepicker2']/span/button\r\n")
	static WebElement EndingBillingPeriodButton;
	
	
	@FindBy(xpath="//button[@id='updatereport']")
	static WebElement updateReport;

	
	public static void selectReportType(int n) {
		
		reportTypeButton.click();
		
		driver.findElement(By.xpath("//*[@id='listbox1055']/ul/li["+ n +"]")).click();;
	}
}
