package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductDAO;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateProductTest extends BaseTest {

    private ProductData testProduct;
    private ProductDAO productForCompare;

    @Test(dataProvider = "credentials")
    public void createNewProduct(String login, String password) {
        // TODO implement test for product creation
        testProduct = ProductData.generate();
        actions.login(login, password);
        actions.waitForContentLoad();
        actions.createProduct(testProduct);
    }

    // TODO implement logic to check product visibility on website
    @Test(dependsOnMethods = "createNewProduct")
    public void checkProductVisibility() {

        productForCompare = actions.getTestProduct(testProduct);
        assertTrue(productForCompare.isDisplayed(), "The given product is not found.");
        assertEquals(productForCompare.getName().toLowerCase(), testProduct.getName().toLowerCase());
        assertEquals(productForCompare.getQty(), testProduct.getQty());
        assertEquals(productForCompare.getPrice(), testProduct.getPrice());
    }
}
