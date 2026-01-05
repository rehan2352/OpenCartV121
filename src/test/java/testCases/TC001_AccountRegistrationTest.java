package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Sanity","Master"})
	public void Verify_Account_Registration() 
	{
		
		try
		{
		logger.info("--Started TC001_Account_RegistrationTest--");
		HomePage hp=new HomePage(driver);
		
		logger.info("Clicking On MyAccount--");
		hp.clickMyAccount();
		
		logger.info("Clicking on Register--");
		hp.clickRegister();
		
		logger.info("Providing Customer Details--");
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
	    regPage.setfirstName(randomString().toUpperCase());
	    regPage.setLastName(randomString().toUpperCase());
	    regPage.setEmail(randomString()+"@gmail.com");
	    //regPage.setTelephone("9142515235");
	    
	    String pwd = randomAlphaNumeric();
	    
	    regPage.setPassword(pwd);
	    //regPage.setConfirmPwd(pwd);
	    
	    regPage.setPrivacyPolicy();
	    regPage.clickCont();
	    
	    logger.info("Validating Expected Message--");
	    String confMsg=regPage.getConfirmationMsg();
	    if(confMsg.equals("Your Account Has Been Created!"))
	    {
	    	  Assert.assertTrue(true);
	    }
	    
	    else
	    {
	       	logger.error("Test Case Failed--");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
	    }
	    //Assert.assertEquals(confMsg, "Your Account Ha Been Created!");
	    
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Test Case Finished--");
		
		
	}
		
	
	

}
