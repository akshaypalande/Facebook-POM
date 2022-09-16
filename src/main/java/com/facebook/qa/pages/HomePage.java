package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.BaseClass;
import io.qameta.allure.Step;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(), 'Akshay Palande')]")

	WebElement userNameLabel;

	@FindBy(xpath = "//div[@class ='j83agx80 l9j0dhe7']")
	WebElement dropDownLink;

	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement logout;

	@FindBy(xpath = "//span[contains(text(), 'Groups')]")
	WebElement groupsLink;

	@FindBy(xpath = "(//span[@class='tojvnm2t a6sixzi8 abs2jz4q a8s20v7p t1p8iaqh k5wvi7nf q3lfd5jv pk4s997a bipmatt0 cebpdrjk qowsmv63 owwhemhu dp1hu0rb dhp61c6y iyyx5f41'])[7]")
	WebElement yourProfile;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friends;

	@FindBy(xpath = "//a[contains(@aria-label,'Home')]")
	WebElement home;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
//Action
	
	@Step("check the hompepage Title")
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	@Step("check that correct username")
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	@Step("check the home paget")
	public HomePage click_home() {
		home.click();
		return new HomePage();
	}

	@Step("check the login page")
	public LoginPage checkOnLogout() {
		yourProfile.click();
		logout.click();
		return new LoginPage();
	}

}