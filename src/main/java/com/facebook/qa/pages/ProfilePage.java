package com.facebook.qa.pages;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

import com.facebook.qa.base.BaseClass;

public class ProfilePage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'Akshay Palande')]")
	WebElement profilePage;

	@FindBy(xpath = "//div[@aria-label='Update profile picture']")
	WebElement profilePhoto;

	@FindBy(xpath = "//span[contains(text(),'Upload Photo')]")
	WebElement photoUpload;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveButton;

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickProfilePage() {
		profilePage.click();
	}

	public boolean verifyProfilePage() {
		return profilePage.isDisplayed();
	}

	public String verifyProfilePagePageTitle() {
		return driver.getTitle();
	}

	public ProfilePage click_photoUpload() throws InterruptedException, IOException, AWTException {
		// click profile page
		profilePage.click();
		Thread.sleep(1000);

		// click profile photo
		profilePhoto.click();
		Thread.sleep(1000);

		// click upload photo
		photoUpload.click();
		Thread.sleep(1000);

		Runtime.getRuntime().exec("C:\\Users\\HP\\eclipse-workspace\\Facebook.POM\\Photo\\teddy.exe");

		// click save button
		saveButton.click();
		Thread.sleep(3000);

		return new ProfilePage();

	}
}
		