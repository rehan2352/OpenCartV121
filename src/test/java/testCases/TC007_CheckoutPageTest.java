package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC007_CheckoutPageTest extends BaseClass {

	@Test(groups = {"master"})
	public void verify_checkout_process() throws InterruptedException {

		// ---------- SEARCH & ADD PRODUCT ----------
		HomePage hp = new HomePage(driver);
		hp.enterProductName(p.getProperty("searchProductName"));
		Thread.sleep(3000);

		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.isProductExist(p.getProperty("searchProductName")));

		sp.selectProduct(p.getProperty("searchProductName"));

		ProductPage pp = new ProductPage(driver);
		pp.setQuantity("2");
		pp.addToCart();
		Assert.assertTrue(pp.isSuccessMsgDisplayed());

		// ---------- CART ----------
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.clickItemsToNavigateToCart();
		sc.clickViewCart();
		Thread.sleep(3000);
		sc.clickOnCheckout();

		// ---------- CHECKOUT ----------
		CheckoutPage ch = new CheckoutPage(driver);

		ch.setfirstName("Test");
		ch.setlastName("User");
		ch.setaddress1("Address Line 1");
		ch.setaddress2("Address Line 2");
		ch.setcity("Delhi");
		ch.setpin("110001");
		ch.setCountry("India");
		ch.setState("Delhi");

		ch.clickOnContinueAfterBillingAddress();
		Thread.sleep(2000);

		ch.clickOnContinueAfterDeliveryAddress();
		Thread.sleep(2000);

		ch.setDeliveryMethodComment("Checkout page test");
		ch.clickOnContinueAfterDeliveryMethod();
		Thread.sleep(2000);

		ch.selectTermsAndConditions();
		ch.clickOnContinueAfterPaymentMethod();
		Thread.sleep(3000);

		// ---------- VALIDATION ----------
		String totalPrice = ch.getTotalPriceBeforeConfOrder();
		Assert.assertNotNull(totalPrice);
	}
}
