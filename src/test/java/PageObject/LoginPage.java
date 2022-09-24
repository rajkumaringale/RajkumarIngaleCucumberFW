package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver)
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id= "Email")
	WebElement email;
	@FindBy(id= "Password")
	WebElement password;
	@FindBy(xpath= "//button[normalize-space()='Log in']")
	WebElement loginbtn;
	@FindBy(linkText= "Logout")
	WebElement logoutt;
	
	public void enterEmail(String emailAdd)
	{   email.clear();
		email.sendKeys(emailAdd);
	}
	public void enterPassword(String pwd)
	{   password.clear();
		password.sendKeys(pwd);
	}
	public void clickOnLoginButton()
	{
		loginbtn.click();
	}
	public void clickOnLogOutButton()
	{
		logoutt.click();
	}
}
