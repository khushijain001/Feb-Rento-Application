package testScript.StudyTable;

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
import genericLibrary.WebDriverUtility;

public class TC_Fab_05 extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@Test
	public void Verify_user_is_able_to_click_on_add_Study_Table_to_cart() throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Create a test in the report 
		test = report.createTest("Verify user is able to click on add study table to cart");
		
		// Initialize page objects and utility classes
        HomePage page = new HomePage(driver);
        WebDriverUtility driver_Utility = new WebDriverUtility();
        BedRoom studyTable = new BedRoom(driver);

        // Step 1: Verify User is on Home Page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.INFO, "Home page is displayed");

        // Step 2: Navigate to Study Table Section
        driver_Utility.actionsScrollTillElement(driver, studyTable.getStudyTablePage());
        studyTable.getStudyTablePage().click();

        // Validate navigation to Study Table page
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 4, 1));
        Reporter.log("Study Table page is displayed", true);
        test.log(Status.INFO, "Study Table page is displayed");

        // Step 3: Select Product on Study Table Page
        driver_Utility.actionsScrollTillElement(driver, studyTable.getClickOnStudyTable());
        studyTable.getClickOnStudyTable().click();

        // Validate product page is displayed
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 14, 1));
        Reporter.log("Product page is displayed", true);
        test.log(Status.INFO, "Product page is displayed");

        // Step 4: Add Product to Cart
        studyTable.getAddToCartButton().click();

        // Validate product is successfully added to cart
        Assert.assertEquals(driver.getCurrentUrl(), data_Utility.getDataFromExcel("TestData", 15, 1));
        Reporter.log("Product is added to the cart", true);
        test.log(Status.PASS, "Product is added to cart");
        
        //Capturing ScreenShot
        test.addScreenCaptureFromBase64String(driver_Utility.captureScreenshotForReport(driver));
	}

}
