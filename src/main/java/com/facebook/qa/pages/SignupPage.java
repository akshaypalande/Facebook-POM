package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.BaseClass;
import io.qameta.allure.Step;

public class SignupPage extends BaseClass {

	@FindBy(linkText = "Create New Account")
	WebElement signUp;

	@FindBy(xpath = "//input[@placeholder='First name']")
	WebElement firstname;

	@FindBy(name = "lastname")
	WebElement lastname;

	@FindBy(name = "reg_email__")
	WebElement reg_email__;

	@FindBy(name = "reg_email_confirmation__")
	WebElement reg_email_confirmation__;

	@FindBy(id = "password_step_input")
	WebElement reg_passwd__;

	@FindBy(name = "birthday_day")
	WebElement birthday_day;

	@FindBy(name = "birthday_month")
	WebElement birthday_month;

	@FindBy(name = "birthday_year")
	WebElement birthday_year;

	@FindBy(name = "sex")
	WebElement gender;

	@FindBy(name = "websubmit")
	WebElement signUpBtn;

	public SignupPage() {
		PageFactory.initElements(driver, this);
		signUp.click();
	}

	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}

	public LoginPage signUp(String fn, String ln, String em, String vem, String pwd, String bd, String bm, String by,
			String g) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		reg_email__.sendKeys(em);
		reg_email_confirmation__.sendKeys(vem);
		reg_passwd__.sendKeys(pwd);
		birthday_day.sendKeys(bd);
		birthday_month.sendKeys(bm);
		birthday_year.sendKeys(by);
		gender.sendKeys(g);
		signUpBtn.click();
		return new LoginPage();
	}

}
