package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryDetails {
	@FindBy(xpath="//input[@id='billing_name'][1]")
	private WebElement nameTextField;
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_address']")
	private WebElement addressTextField;
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_gst']")
	private WebElement gstTextField;
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_landmark']")
	private WebElement landMarkTextField;
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_email']")
	private WebElement emailTextField;
	
	
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_postcode']")
	private WebElement postCodeTextField;
	
	
	
	@FindBy(xpath="//div[@class='DeliveryDetails']//input[@id='billing_phone']")
	private WebElement phoneTextField;
	
	@FindBy(xpath="//div[@class='checkout checkout_biling']/input[@id='radio_btn']")
	private WebElement checkBox;
	
	@FindBy(xpath="//a[@class='plain-div ']")
	private WebElement clickOnContinue;
	
	@FindBy(xpath="//select[@id='mySelect']")
	private WebElement selectDropDown;
	
	@FindBy(xpath="//select[@id='select_city']")
	private WebElement selectCityDropDown;
	
	
	
	//create constructor
		public DeliveryDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//create getter
		
		
		public WebElement getNameTextField() {
			return nameTextField;
		}

		public WebElement getAddressTextField() {
			return addressTextField;
		}

		public WebElement getGstTextField() {
			return gstTextField;
		}

		public WebElement getLandMarkTextField() {
			return landMarkTextField;
		}

		public WebElement getEmailTextField() {
			return emailTextField;
		}

		public WebElement getPostCodeTextField() {
			return postCodeTextField;
		}

		public WebElement getPhoneTextField() {
			return phoneTextField;
		}
		
		public WebElement getClickOnCheckBox() {
			return checkBox;
		}
		
		public WebElement getClickOnContinueButton() {
			return clickOnContinue;
		}
		
		public WebElement getSelectDropDownOption() {
			return selectDropDown;
		}
		
		public WebElement getSelectCityDropDownOption() {
			return selectCityDropDown;
		}


	

}
