package com.facebook.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;

import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.Menu;
import com.facebook.qa.pages.Messenger;
import com.facebook.qa.pages.Notifications;
import com.facebook.qa.pages.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	Menu menu;
	Messenger messenger;
	Notifications notifications;
	Logger  log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("****** Starting test cases execution  *******");
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("************Login the Application**********************");
		log.info("Open Home Page");
	}

	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("******* HomePageTitleTest ******");
		log.info("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "(20+) Facebook");
		Thread.sleep(2000);
		log.info("Title Verified Successfully.....");
		log.info("****** ending test case ******");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		log.info("****** starting test case ******");
		log.info("******* verifyUserNameTest ******");
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("UserName Verified Successfully.....");
		log.info("****** ending test case ******");
	}



	@Test(priority = 3)
	public void verifyHomePage() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("******* verifyHomePage ******");
		homePage = homePage.click_home();
		Thread.sleep(3000);
		log.info("****** ending test case ******");
	}

	@Test(priority = 4)
	public void verifyClickOnLogout() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("******* verifyClickOnLogout ******");
		loginPage = homePage.checkOnLogout();
		Thread.sleep(2000);
		log.info("****** ending test case ******");
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		 log.info("browser is closed");
	}
}