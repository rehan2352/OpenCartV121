package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_loginTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void Verify_Login()
	{
		logger.info("Starting TC002_loginTest");
		
		try
		{
		
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		loginPage lp=new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.clklogin();
		
		//My Account
		MyAccountPage macc=new MyAccountPage(driver);
		boolean visible=macc.isMyAccountExist();
		
		Assert.assertTrue(visible);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC002_loginTest");
	}
}
