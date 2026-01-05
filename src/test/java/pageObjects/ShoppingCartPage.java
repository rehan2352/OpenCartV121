package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//div[@id='content']//table//tr[last()]/td[2]")
	WebElement totalPrice; //$246.40
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigateToCart()
	{
		btnItems.click();
	}
	
	public void clickViewCart()
	{
		lnkViewCart.click();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}

	
	public void clickOnCheckout() {
	    js.executeScript("arguments[0].scrollIntoView(true);", btnCheckout);
	    js.executeScript("arguments[0].click();", btnCheckout);
	}

}