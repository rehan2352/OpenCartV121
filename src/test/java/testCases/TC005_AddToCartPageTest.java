package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {

	@Test(groups = {"master"})
	public void verify_addToCart() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.enterProductName("iPhone");

		Thread.sleep(3000);

		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.isProductExist("iPhone"));

		sp.selectProduct("iPhone");

		ProductPage pp = new ProductPage(driver);
		pp.setQuantity("2");
		pp.addToCart();

		Assert.assertTrue(pp.isSuccessMsgDisplayed());
	}
}
