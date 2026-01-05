package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-quantity")
	WebElement txtQuantity;

	@FindBy(id = "button-cart")
	WebElement btnAddToCart;

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successMsg;

	public void setQuantity(String qty) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(txtQuantity));
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
	}

	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		btnAddToCart.click();
	}

	public boolean isSuccessMsgDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(successMsg));
			return successMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
