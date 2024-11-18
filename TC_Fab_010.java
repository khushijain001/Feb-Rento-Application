package testScript.StudyTable;

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

public class TC_Fab_010 extends BaseTest {
	@Test
	public void Verify_user_is_able_to_click_on_payment() throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Create a test in the report
		test = report.createTest("Verify user is able to click on payment");
		
		// Initialize page objects and utility classes
        HomePage page = new HomePage(driver);
        WebDriverUtility driver_Utility = new WebDriverUtility();
        BedRoom studyTable = new BedRoom(driver);

        // Step 1: User Login
        page.getLoginPage().click();
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromProperties("url"));
        test.log(Status.INFO, "Home Page displayed and can click on login");
        Reporter.log("Clicked Login done", true);

        // Enter login credentials and submit
        page.getEnterEmail().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 0));
        page.getEnterPassword().sendKeys(data_Utility.getDataFromExcel("LoginTestData", 1, 1));
        page.getClickOnSubmit().click();
        Thread.sleep(3000);

        // Step 2: Verify Home Page Displayed after Login
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Step 3: Navigate to Study Table Section
        driver_Utility.actionsScrollTillElement(driver, studyTable.getStudyTablePage());
        studyTable.getStudyTablePage().click();

        // Validate navigation to Study Table page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 4, 1));
        Reporter.log("Study Table page is displayed", true);
        test.log(Status.INFO, "Study Table page is displayed");

        // Step 4: Select Product on Study Table Page
        driver_Utility.actionsScrollTillElement(driver, studyTable.getClickOnStudyTable());
        studyTable.getClickOnStudyTable().click();

        // Validate product page is displayed
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 14, 1));
        Reporter.log("Product is displayed", true);
        test.log(Status.INFO, "Product is displayed");

        // Step 5: Add Product to Cart
        driver_Utility.actionsScrollTillElement(driver, studyTable.getAddToCartButton());
        studyTable.getAddToCartButton().click();

        // Validate product is added to cart
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 15, 1));
        Reporter.log("Product is added to the cart", true);
        test.log(Status.INFO, "Product is added");

        // Step 6: Proceed to Shopping Cart
        page.getClickOnShopping().click();
        ShoppingCart sCart = new ShoppingCart(driver);
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 10, 1));
        Reporter.log("User is able to click on shopping cart", true);
        test.log(Status.INFO, "Click on shopping cart");

        // Step 7: Place Order
        sCart.getClickOnPlceOrder().click();

        // Step 8: Enter Delivery Details
        DeliveryDetails delivery_Details = new DeliveryDetails(driver);
        delivery_Details.getNameTextField().sendKeys(data_Utility.getDataFromExcel("TestData", 2, 1));
        driver_Utility.actionsScrollTillElement(driver, delivery_Details.getClickOnCheckBox());
        Thread.sleep(2000);
        delivery_Details.getClickOnContinueButton().click();
        Thread.sleep(2000);

        // Step 9: Click on Payment
        Payment payment_page = new Payment(driver);
        payment_page.getClickOnPayment().click();

        // Validate user is able to click on payment
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 11, 1));
        Reporter.log("User is able to click on payment button", true);
        test.log(Status.PASS, "Click on payment");	
        
        //Capturing ScreenShot
        test.addScreenCaptureFromBase64String(driver_Utility.captureScreenshotForReport(driver));
        
      }
}
