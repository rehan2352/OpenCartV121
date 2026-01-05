package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
    public void Verify_LoginDDT(String email, String pwd, String exp) {

        logger.info("Starting TC003_LoginDDT--");

        // Home Page
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        // Login Page
        loginPage lp = new loginPage(driver);
        lp.setEmail(email);
        lp.setPass(pwd);
        lp.clklogin();

        // My Account
        MyAccountPage macc = new MyAccountPage(driver);
        boolean visible = macc.isMyAccountExist();

        /*
         Data is valid   - login success - test pass - logout
                           login failed  - test fail

         Data is invalid - login success - test fail - logout
                           login failed  - test pass
        */

        if (exp.equalsIgnoreCase("Valid")) {
            if (visible) {
                try { macc.clkLogout(); } catch (Exception e) {}
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
        else if (exp.equalsIgnoreCase("Invalid")) {
            if (visible) {
                try { macc.clkLogout(); } catch (Exception e) {}
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }

        logger.info("TC003_LoginDDT Test Finished--");
    }
}
