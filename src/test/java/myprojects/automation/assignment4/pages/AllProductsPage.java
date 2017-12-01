package myprojects.automation.assignment4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pavel Holinko on 29.11.2017.
 */
public class AllProductsPage {

    private WebDriver driver;

    @FindBy(css = "a.next")
    private WebElement nextButton;
    private WebElement testProduct;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductPresent(String productName) {
        while (!(existsElement(productName))) {
            String url = driver.getCurrentUrl();
            scrollToElement(nextButton);
            nextButton.click();
            if (url.equals(driver.getCurrentUrl())) {
                return false;
            }
        }
        return true;
    }

    public ProductDetailsPage clickOnProduct() {
        scrollToElement(testProduct);
        testProduct.click();
        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private boolean existsElement(String elementLinkName) {
        try {
            testProduct = driver.findElement(By.partialLinkText(elementLinkName));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
