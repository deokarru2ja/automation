package com.billing.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.billing.qa.pages.InterstitialPage;
import com.billing.qa.pages.LoginPage;
import com.billing.qa.pages.MyBillPage;
import com.billing.qa.pages.OverviewPage;
import com.billing.qa.pages.PrintPreviewPage;
import com.billing.qa.pages.ReportsPage;
import com.billing.qa.util.TestUtil;
import com.billing.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		prop=new Properties();
		String dir=System.getProperty("user.dir");
		String file=dir + "/src/main/java/com/billing/qa/config/config.properties";
		
		try {
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialize(String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "A:/Jar/chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			  System.setProperty("webdriver.gecko.driver","A:/New folder/geckodriver.exe");
			  driver=new FirefoxDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(TestUtil.URL);
		
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, InterstitialPage.class);
		PageFactory.initElements(driver, OverviewPage.class);
		PageFactory.initElements(driver, MyBillPage.class);
		PageFactory.initElements(driver, PrintPreviewPage.class);
		PageFactory.initElements(driver, ReportsPage.class);
	}
	
	
}
