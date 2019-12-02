package com.hubspot.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPagePF;

public class LoginPFTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPagePF loginPagePF;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPagePF = new LoginPagePF(driver);
	}
	
	@Test
	public void LoginTest(){
		loginPagePF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
