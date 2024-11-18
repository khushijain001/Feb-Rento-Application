package testScript.StudyTable;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import elementRepository.HomePage;
import genericLibrary.BaseTest;

public class SearchTestCase extends BaseTest {
	
	@Test(dataProvider="SearchTestData")
	public void Verify_user_is_able_to_search_product(String productNumber,String productName) throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Create a test in the report
		test = report.createTest("Verify user is able to search product");
		
		// Start test and log initial search details
        test.log(Status.INFO, productNumber + " : " + productName + " : is being searched");
        Reporter.log("Search icon clicked", true);
        test.log(Status.PASS, "Clicked on search icon");

        // Validate that Home Page is displayed
        Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("PageTitle", 1, 1));
        Reporter.log("Home page is displayed", true);
        test.log(Status.PASS, "Home page is displayed");

        // Initialize HomePage elements and perform the search
        HomePage home = new HomePage(driver);
        home.getClickOnSearchIcon().click();
        home.getSearchTextField().sendKeys(productName);
        home.getValueSearch().click();

        // Validate if the searched product is displayed on the page
        String displayedProduct = driver.findElement(By.xpath("//div[text()='" + productName + "']")).getText();
        Assert.assertTrue(displayedProduct.contains(productName), "Product name not found in search results");
        Reporter.log("Product displayed in search results", true);
        test.log(Status.PASS, productNumber + " : " + productName + " : Search Test Case passed");

        // Navigate back to the home page
        home.getClickOnBackOption().click();
        Thread.sleep(2000);
    }

    // Data Provider for search test data
    @DataProvider(name = "SearchTestData")
    public Object[][] search_Test_Data() throws EncryptedDocumentException, IOException {
        return data_Utility.getMultipleDataFromExcel("SearchTestData");

	}

}
