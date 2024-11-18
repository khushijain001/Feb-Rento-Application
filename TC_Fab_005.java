package testScript.Wardrobe;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.BedRoom;
import elementRepository.HomePage;
import elementRepository.ShoppingCart;
import genericLibrary.BaseTest;
import genericLibrary.WebDriverUtility;

public class TC_Fab_005 extends BaseTest{
	@Test
	public void Verify_user_is_able_to_increase_the_quantity_of_Wardrobe() throws InterruptedException, EncryptedDocumentException, IOException {
		
		// Create a test in the report 
		test = report.createTest("Verify user is able to increase product quantity in cart");
		
		// Initialize HomePage object to access home page elements
        HomePage page = new HomePage(driver);
        
        // Log test for navigating to the home page
        test = report.createTest("Verify user is able to click on bedroom option");
        
        // Validate successful navigation to the Home Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Initialize BedRoom page object to access wardrobe elements
        BedRoom wardrobe = new BedRoom(driver);
        test = report.createTest("Verify user is able to click on wardrobe option");

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
        Reporter.log("Product is displayed", true);
        test.log(Status.INFO, "Product is displayed");

        // Click on 'Add to Cart' button
        wardrobe.getAddToCart().click();

        // Validate that the product is added to the cart successfully
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 1, 1));
        Reporter.log("Product is added to the cart", true);
        test.log(Status.INFO, "Product added to cart");

        // Brief pause to ensure page update
        Thread.sleep(3000);

        // Navigate to the shopping cart
        page.getClickOnShopping().click();

        // Initialize ShoppingCart object
        ShoppingCart sCart = new ShoppingCart(driver);

        // Click on the "+" icon to increase product quantity
        sCart.getClickOnPlusIcon();
        Thread.sleep(3000);
        driverUtility.acceptAlert(driver);

        // Validate navigation to the shopping cart page
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 10, 1));
        Reporter.log("Navigated to shopping cart successfully", true);
        test.log(Status.INFO, "Accessed shopping cart");

        // Validate that the quantity of the product has increased
        String quantityValue = sCart.getCheckTheValue().getAttribute("value");
        Assert.assertEquals(quantityValue, data_Utility.getDataFromExcel("TestData", 12, 1));
        Reporter.log("Quantity increased successfully", true);
        test.log(Status.PASS, "Product quantity increased successfully");

        // Capture a screenshot of the updated cart for the report
        test.addScreenCaptureFromBase64String(driverUtility.captureScreenshotForReport(driver));	}

}
