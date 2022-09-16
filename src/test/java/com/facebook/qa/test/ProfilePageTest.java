package com.facebook.qa.test;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ProfilePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	Logger log = Logger.getLogger(ProfilePageTest.class);


	public ProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void click_profilePage() {
		profilePage.clickProfilePage();
		log.info("Clicked on profile Page..");
	}

	@Test(priority = 2)
	public void verifyProfile() {
		profilePage.verifyProfilePage();
		log.info("Verify Profile Page");
	}

	@Test(priority = 3)
	public void click_uploadPhoto() throws AWTException, InterruptedException, IOException {
		profilePage.click_photoUpload();
		log.info("Click on Upload Photo");
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser....");
	}

}