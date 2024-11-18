package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	@FindBy(xpath="//span[text()='+']")
	private WebElement clickOnPlusIcon;
	
	@FindBy(xpath="//a[contains(text(),' PLACE A ORDER')]")
	private WebElement placeOrder;
	
	@FindBy(xpath="//input[@class='quantityshow']")
	private WebElement valueOfTheProduct;
	
	
	
	//create constructors
		public ShoppingCart(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void getClickOnPlusIcon() throws InterruptedException {
			clickOnPlusIcon.click();
			Thread.sleep(2000);
		}
		public WebElement getClickOnPlceOrder() {
			return placeOrder;
		}
		
		public WebElement getCheckTheValue() {
			return valueOfTheProduct;
		}
		
		
}
