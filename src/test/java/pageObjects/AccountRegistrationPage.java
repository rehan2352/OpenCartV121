package pageObjects;

//import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
//	@FindBy(xpath="//input[@id='input-telephone']")
//	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	
//	@FindBy(xpath="//input[@id='input-confirm']")
//	WebElement txtConPass;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btn_Agree;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setfirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	public void setLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
//	public void setTelephone(String conNo)
//	{
//		txtTelephone.sendKeys(conNo);
//	}
//	
	public void setPassword(String pass)
	{
		pwd.sendKeys(pass);
	}
	
//	public void setConfirmPwd(String pass)
//	{
//		txtConPass.sendKeys(pass);
//	}
	
	public void setPrivacyPolicy()
	{
		//btn_Agree.click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // 1. Scroll page to bottom (IMPORTANT)
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	    // 2. Small wait for layout settle
	    try { Thread.sleep(500); } catch (Exception e) {}

	    // 3. JS click (bypasses overlay)
	    js.executeScript("arguments[0].click();", btn_Agree);

	}
	
	public void clickCont() 
	{
		//sol1
		//btn_Continue.click();
		
		//sol2
		//btn_Continue.submit();
		
		//sol3
//		Actions act=new Actions(driver);
//		act.moveToElement(btn_Continue).click().perform();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll Continue button into view
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn_Continue);

	    // Small wait for UI stability
	    try { Thread.sleep(500); } catch (Exception e) {}

	    // JS click (bypasses overlay)
	    js.executeScript("arguments[0].click();", btn_Continue);
		
		
		
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	

}
