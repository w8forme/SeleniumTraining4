package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductDAO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Pavel Holinko on 01.12.2017.
 */
public class ProductDetailsPage {

    private WebDriver driver;
    private ProductDAO productDAO;

    @FindBy(css = "h1[itemprop=name]")
    private WebElement productNameElement;
    @FindBy(css = "span[itemprop=price]")
    private WebElement productPriceElement;
    @FindBy(css = "div.product-quantities > span")
    private WebElement productQtyElement;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDAO getProductDetails() {
        String productName = productNameElement.getText();
        float productPrice = Float.parseFloat(productPriceElement.getAttribute("content"));
        int productQty = Integer.parseInt(productQtyElement.getText()
                .replaceAll("\\D+", "")
                .trim());
        return new ProductDAO(productName, productQty, productPrice);
    }
}
