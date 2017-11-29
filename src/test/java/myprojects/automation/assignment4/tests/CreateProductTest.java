package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    @Test(dataProvider = "credentials")
    public void createNewProduct(String login, String password) {
        // TODO implement test for product creation

        actions.login(login, password);
        actions.waitForContentLoad();
        actions.createProduct(ProductData.generate());
    }

    @Test(dependsOnMethods = "createNewProduct")
    public void checkProductVisibility() {
//        actions.openMainPage();
//        actions.waitForContentLoad();
//        actions.viewAllProducts();
//        actions.findProduct(testProduct.getName());
//        assertTrue(actions.hasProduct(testProduct.getName()), "The given product is not found.");
//        ProductData resultProduct = actions.getProductDetails(testProduct.getName());
//        assertEquals(testProduct.getName().toUpperCase(), resultProduct.getName());
//        assertEquals(testProduct.getQty(), resultProduct.getQty());
//        assertEquals(testProduct.getPrice(), resultProduct.getPrice());
    }

    // TODO implement logic to check product visibility on website
}
