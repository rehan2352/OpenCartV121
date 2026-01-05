package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	
	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_login;
	
	public void setEmail(String email)
	{
	   txtemail.sendKeys(email);
	}
	
	public void setPass(String pass)
	{
		pwd.sendKeys(pass);
	}
	
	public void clklogin()
	{
		btn_login.click();
	}

}
