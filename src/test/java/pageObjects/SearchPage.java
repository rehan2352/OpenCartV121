package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='product-thumb']//h4/a")
	List<WebElement> searchProducts;

	public boolean isProductExist(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getText().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	public void selectProduct(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getText().equalsIgnoreCase(productName)) {

				js.executeScript("arguments[0].scrollIntoView(true);", product);
				js.executeScript("arguments[0].click();", product);
				break;
			}
		}
	}

}
