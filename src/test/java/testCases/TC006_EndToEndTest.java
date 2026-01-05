package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC006_EndToEndTest extends BaseClass {

	@Test(groups = { "master" })
	public void endToendTest() throws InterruptedException {

		SoftAssert myassert = new SoftAssert();

		HomePage hp = new HomePage(driver);

		// -------- REGISTRATION --------
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setfirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());

		String email = randomString() + "@gmail.com";
		regpage.setEmail(email);
		regpage.setPassword("test123");
		regpage.setPrivacyPolicy();
		regpage.clickCont();

		Thread.sleep(3000);
		myassert.assertEquals(
				regpage.getConfirmationMsg(),
				"Your Account Has Been Created!"
		);

		// -------- LOGOUT --------
		MyAccountPage mc = new MyAccountPage(driver);
		mc.clkLogout();
		Thread.sleep(2000);

		// -------- LOGIN --------
		hp.clickMyAccount();
		hp.clickLogin();

		loginPage lp = new loginPage(driver);
		lp.setEmail(email);
		lp.setPass("test123");
		lp.clklogin();

		mc = new MyAccountPage(driver);
		myassert.assertTrue(mc.isMyAccountExist());

		// -------- SEARCH --------
		hp.enterProductName(p.getProperty("searchProductName"));
		Thread.sleep(3000);

		SearchPage sp = new SearchPage(driver);
		myassert.assertTrue(
				sp.isProductExist(p.getProperty("searchProductName"))
		);

		sp.selectProduct(p.getProperty("searchProductName"));

		// -------- ADD TO CART --------
		ProductPage pp = new ProductPage(driver);
		pp.setQuantity("2");
		pp.addToCart();

		myassert.assertTrue(pp.isSuccessMsgDisplayed());

		// -------- CART (NO CHECKOUT) --------
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.clickItemsToNavigateToCart();
		sc.clickViewCart();
		Thread.sleep(3000);

		// Validate cart page loaded (total price exists)
		myassert.assertNotNull(sc.getTotalPrice());

		myassert.assertAll();
	}
}
