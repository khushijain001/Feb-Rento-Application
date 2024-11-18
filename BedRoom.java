package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BedRoom {
	
	@FindBy(xpath="//span[text()='Wardrobe']")
	private WebElement wardrobeOption;
	
	//@FindBy(xpath="//div[@class='mobile_addCart']//div[@class='plan_box']//div[@class='add_cartbut']//a[@rel='1138']")
	@FindBy(xpath="(//div[@class='add_cartbut']//a[@rel='1138'])[2]")
    private WebElement add_To_Cart;
	
	@FindBy(xpath="//div[@class='bx']//div[text()='Mello Wardrobe']")
	private WebElement clickOnProduct;
	

	@FindBy(xpath="//span[text()='Study Table']")
	private WebElement studyTable;
	
	@FindBy(xpath="//div[text()='Amber Study Table']")
	private WebElement clickOnStudytable;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div[3]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[2]/a")
	private WebElement addToCartForStudyTable;
	
	
	//create constructor
	public BedRoom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//create getter
	
	public WebElement getWardrobePage() {
		return wardrobeOption;
	}
	
	public WebElement getAddToCart() {
		return add_To_Cart;
	}
	
	public WebElement getClickOnProductName() {
		return clickOnProduct;
	}
	
	public WebElement getStudyTablePage() {
		return studyTable;
	}
	
	public WebElement getClickOnStudyTable() {
		return clickOnStudytable;
	}
	
	public WebElement getAddToCartButton() {
		return addToCartForStudyTable;
	}
	
	
	
	

}
