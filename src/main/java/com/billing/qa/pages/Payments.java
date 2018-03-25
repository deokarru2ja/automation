package com.billing.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.billing.qa.base.TestBase;

public class Payments extends TestBase{
	
	@FindBy(linkText="See your bill")
	static WebElement seeYourBill;
	
	public static void validatePageTitle() {
		System.out.println(driver.getTitle());
		seeYourBill.click();
		System.out.println(driver.findElement(By.tagName("title")).getText());
	}
	
}
