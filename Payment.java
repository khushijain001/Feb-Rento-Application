package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	@FindBy(xpath="//div[@class='plan_box']//a[text()='Payment']")
	private WebElement clickOnPayment;
	
	@FindBy(xpath="(//iframe[@class='razorpay-checkout-frame'])[1]")
	private WebElement clickOnCancelPayment;
	
	@FindBy(xpath="//button[@data-testid='checkout-close']")
	private WebElement frameCross;
	
	
	@FindBy(xpath="//button[text()='Yes, exit']")
	private WebElement clickOnYesExit;
	
	@FindBy(xpath="//h3[text()='Payment Failed,']")
	private WebElement confirmMessage;
	
	//create constructor
			public Payment(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

	
	//getter
	public WebElement getClickOnPayment() {
		return clickOnPayment;
	}
	
	public WebElement getClickOnCancelPayment() {
		return clickOnCancelPayment;
	}
	
	public WebElement getClickOnYes() {
		return clickOnYesExit;
	}
	
	public WebElement getClickOnFrameCross() {
		return frameCross;
	}
	
	public WebElement getMessageDisplayed() {
		return confirmMessage;
	}
	
	

	

}
