package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

	@FindBy(id = "input-payment-firstname")
	WebElement txtfirstName;

	@FindBy(id = "input-payment-lastname")
	WebElement txtlastName;

	@FindBy(id = "input-payment-address-1")
	WebElement txtaddress1;

	@FindBy(id = "input-payment-address-2")
	WebElement txtaddress2;

	@FindBy(id = "input-payment-city")
	WebElement txtcity;

	@FindBy(id = "input-payment-postcode")
	WebElement txtpin;

	@FindBy(id = "input-payment-country")
	WebElement drpCountry;

	@FindBy(id = "input-payment-zone")
	WebElement drpState;

	@FindBy(id = "button-payment-address")
	WebElement btncontinueBillingAddress;

	@FindBy(id = "button-shipping-address")
	WebElement btncontinueDeliveryAddress;

	@FindBy(name = "comment")
	WebElement txtDeliveryMethod;

	@FindBy(id = "button-shipping-method")
	WebElement btncontinueShippingAddress;

	@FindBy(name = "agree")
	WebElement chkboxTerms;

	@FindBy(id = "button-payment-method")
	WebElement btncontinuePaymentMethod;

	@FindBy(xpath = "//tfoot//strong[text()='Total:']/following::td[1]")
	WebElement lblTotalPrice;

	@FindBy(id = "button-confirm")
	WebElement btnConfOrder;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement lblOrderConMsg;

	public void setfirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(txtfirstName)).sendKeys(firstName);
	}

	public void setlastName(String lastName) {
		txtlastName.sendKeys(lastName);
	}

	public void setaddress1(String address1) {
		txtaddress1.sendKeys(address1);
	}

	public void setaddress2(String address2) {
		txtaddress2.sendKeys(address2);
	}

	public void setcity(String city) {
		txtcity.sendKeys(city);
	}

	public void setpin(String pin) {
		txtpin.sendKeys(pin);
	}

	public void setCountry(String country) {
		new Select(drpCountry).selectByVisibleText(country);
		wait.until(ExpectedConditions.elementToBeClickable(drpState));
	}

	public void setState(String state) {
		new Select(drpState).selectByVisibleText(state);
	}

	public void clickOnContinueAfterBillingAddress() {
		btncontinueBillingAddress.click();
	}

	public void clickOnContinueAfterDeliveryAddress() {
		btncontinueDeliveryAddress.click();
	}

	public void setDeliveryMethodComment(String deliverymsg) {
		txtDeliveryMethod.sendKeys(deliverymsg);
	}

	public void clickOnContinueAfterDeliveryMethod() {
		btncontinueShippingAddress.click();
	}

	public void selectTermsAndConditions() {
		if (!chkboxTerms.isSelected()) chkboxTerms.click();
	}

	public void clickOnContinueAfterPaymentMethod() {
		btncontinuePaymentMethod.click();
	}

	public String getTotalPriceBeforeConfOrder() {
		return wait.until(ExpectedConditions.visibilityOf(lblTotalPrice)).getText();
	}

	public void clickOnConfirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(btnConfOrder)).click();
	}

	public boolean isOrderPlaced() {
		try {
			wait.until(ExpectedConditions.visibilityOf(lblOrderConMsg));
			return lblOrderConMsg.getText().equalsIgnoreCase("Your order has been placed!");
		} catch (Exception e) {
			return false;
		}
	}
}
