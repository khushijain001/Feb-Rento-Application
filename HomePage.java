package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[@class='nav-link']")
	private WebElement bedroomOption;
	
	@FindBy(xpath="//li[@class='si']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='txtEmail']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement passwordTextField;
	
	
	@FindBy(xpath="//button[@id='btnSignIn']")
	private WebElement submitButton;

	@FindBy(xpath="//li[@class='cart_icon']")
	private WebElement shoppingCartButton;
	
	@FindBy(xpath="//a[@class='search-trigger']")
	private WebElement clickOnSearchIcon;
	
	@FindBy(xpath="//div[@class='logo logo_destop']")
	private WebElement clickOnBackOption;
	
	@FindBy(xpath="//input[@name='key']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement valueSearch;
	
	

	

	//create constructors
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//create getters()
	public WebElement getBedroomPage() {
		return bedroomOption;
	}
	
	public WebElement getLoginPage() {
		return loginButton;
	}
	
	public WebElement getEnterEmail() {
		return emailTextField;
	}
	
	public WebElement getEnterPassword() {
		return passwordTextField;
	}
	
	public WebElement getClickOnSubmit() {
		return submitButton;
	}
	
	public WebElement getClickOnShopping() {
		return shoppingCartButton;
	}
	public WebElement getClickOnSearchIcon() {
		return clickOnSearchIcon;
	}

	public WebElement getClickOnBackOption() {
		return clickOnBackOption;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	public WebElement getBedroomOption() {
		return bedroomOption;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getShoppingCartButton() {
		return shoppingCartButton;
	}
	
	public WebElement getValueSearch() {
		return valueSearch;
	}

	


	
	
	

}
