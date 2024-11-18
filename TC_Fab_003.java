package testScript.Wardrobe;



import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.BedRoom;
import elementRepository.HomePage;
import genericLibrary.BaseTest;
import genericLibrary.DataUtility;
import genericLibrary.WebDriverUtility;

public class TC_Fab_003 extends BaseTest {
	@Test
	public void Verify_user_is_able_to_click_on_add_to_cart() throws InterruptedException, EncryptedDocumentException, IOException {
		
		// Create a test in the report
        test = report.createTest("Verify user is able to click on add to cart");
        
		// Initialize HomePage object to access home page elements
        HomePage page = new HomePage(driver);

        // Validate successful navigation to the Home Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Initialize BedRoom page object to access wardrobe elements
        BedRoom wardrobe = new BedRoom(driver);

        // Scroll down to the wardrobe element
        WebDriverUtility driverUtility = new WebDriverUtility();
        driverUtility.actionsScrollTillElement(driver, wardrobe.getWardrobePage());

        // Click on the wardrobe option
        wardrobe.getWardrobePage().click();

        // Validate that the Wardrobe page is displayed
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 3, 1));
        Reporter.log("Wardrobe page is displayed", true);
        test.log(Status.INFO, "Wardrobe page is displayed");

        // Scroll to the specific product element
        driverUtility.actionsScrollTillElement(driver, wardrobe.getClickOnProductName());

        // Click on the selected product
        wardrobe.getClickOnProductName().click();

        // Validate that the Product page is displayed
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("TestData", 9, 1));
        Reporter.log("Product page is displayed", true);
        test.log(Status.INFO, "Product is displayed");

        // Click on 'Add to Cart' button
        wardrobe.getAddToCart().click();

        // Validate that the product is added to the cart successfully
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 1, 1));
        Reporter.log("Product is added to the cart", true);
        test.log(Status.PASS, "Product added to cart");

        // Capture a screenshot of the cart page for the report
        test.addScreenCaptureFromBase64String(driverUtility.captureScreenshotForReport(driver));
 		
	}
	
	
	

}
