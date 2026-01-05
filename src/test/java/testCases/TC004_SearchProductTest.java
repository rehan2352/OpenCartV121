package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test(groups = {"master"})
	public void verify_pruductSearch() throws InterruptedException {

		HomePage hm = new HomePage(driver);
		hm.enterProductName("mac");

		Thread.sleep(3000);

		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.isProductExist("MacBook"));
	}
}
