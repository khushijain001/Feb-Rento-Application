package testScript.Wardrobe;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.BedRoom;
import elementRepository.DeliveryDetails;
import elementRepository.HomePage;
import elementRepository.Payment;
import elementRepository.ShoppingCart;
import genericLibrary.BaseTest;
import genericLibrary.WebDriverUtility;

public class TC_Fab_019 extends BaseTest {
	@Test
	public void Verify_user_is_able_to_click_on_payment() throws InterruptedException, EncryptedDocumentException, IOException {
		
		// Create a test in the report 
		test = report.createTest("Verify user is able to click on payment");
		
	    // Step 1: Login to the application
        HomePage home = new HomePage(driver);

        // Click on the login button
        home.getLoginPage().click();

        // Validate successful login
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromProperties("url"));
        test.log(Status.INFO, "Home Page displayed, user can click on login");
        Reporter.log("Login successful", true);

        // Enter login credentials and submit
        home.getEnterEmail().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 0));
        home.getEnterPassword().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 1));
        home.getClickOnSubmit().click();
        Thread.sleep(3000);

        // Step 2: Navigate to Bedroom Page
        HomePage page = new HomePage(driver);

        // Validate navigation to Home Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Initialize BedRoom object to access wardrobe elements
        BedRoom wardrobe = new BedRoom(driver);

        WebDriverUtility driverUtility = new WebDriverUtility();

        // Scroll to the wardrobe element and click
        driverUtility.actionsScrollTillElement(driver, wardrobe.getWardrobePage());
        wardrobe.getWardrobePage().click();

        // Validate that the Wardrobe page is displayed
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 3, 1));
        Reporter.log("Wardrobe page is displayed", true);
        test.log(Status.INFO, "Wardrobe page is displayed");

        // Step 3: Select Product
        driverUtility.actionsScrollTillElement(driver, wardrobe.getClickOnProductName());
        wardrobe.getClickOnProductName().click();

        // Validate navigation to Product page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("TestData", 9, 1));
        Reporter.log("Product page is displayed", true);
        test.log(Status.INFO, "Product is displayed");

        // Add product to cart
        wardrobe.getAddToCart().click();

        // Validate product is added to cart
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 1, 1));
        Reporter.log("Product is added to the cart", true);
        test.log(Status.INFO, "Product added to cart");

        // Step 4: Proceed to Shopping Cart
        ShoppingCart sCart = new ShoppingCart(driver);
        page.getClickOnShopping().click();

        // Place order from shopping cart
        sCart.getClickOnPlceOrder().click();
        Thread.sleep(3000);

        // Step 5: Enter Delivery Details
        DeliveryDetails deliveryDetails = new DeliveryDetails(driver);

        // Enter name for delivery
        deliveryDetails.getNameTextField().sendKeys(data_Utility.getDataFromExcel("TestData", 2, 1));

        // Scroll to the checkbox and click Continue
        driverUtility.actionsScrollTillElement(driver, deliveryDetails.getClickOnCheckBox());
        deliveryDetails.getClickOnContinueButton().click();
        Thread.sleep(2000);

        // Step 6: Complete Payment
        Payment paymentPage = new Payment(driver);
        paymentPage.getClickOnPayment().click();

        // Validate payment page is displayed
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 11, 1));
        Reporter.log("User is able to click on payment button", true);
        test.log(Status.PASS, "Clicked on payment");

        // Capture screenshot for report
        test.addScreenCaptureFromBase64String(driverUtility.captureScreenshotForReport(driver));
   	}

}
