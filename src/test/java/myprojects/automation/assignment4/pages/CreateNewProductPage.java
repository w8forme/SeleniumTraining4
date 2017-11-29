package myprojects.automation.assignment4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pavel Holinko on 29.11.2017.
 */
public class CreateNewProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "form_step1_name_1")
    private WebElement productNameField;

    @FindBy(id = "form_step1_qty_0_shortcut")
    private WebElement productQuantityField;

    @FindBy(id = "form_step1_price_ttc_shortcut")
    private WebElement productPriceField;

    @FindBy(className = "switch-input")
    private WebElement switchElement;

    @FindBy(className = "growl-close")
    private WebElement closeIcon;

    @FindBy(xpath = "//*[@class = 'btn btn-primary js-btn-save']")
    private WebElement saveButton;

    public CreateNewProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 10);
    }

    public CreateNewProductPage fillProductName(String productName) {
        productNameField.sendKeys(productName);
        return this;
    }

    public CreateNewProductPage fillProductQuantity(String productQuantity) {
        productQuantityField.sendKeys(productQuantity);
        return this;
    }

    public CreateNewProductPage fillProductPrice(String productPrice) {
        productPriceField.sendKeys(productPrice);
        productPriceField.submit();
        return this;
    }

    public CreateNewProductPage clickSwitchButton() {
        switchElement.click();
        return this;
    }

    public CreateNewProductPage closeMessageWindow() {
        wait.until(ExpectedConditions.visibilityOf(closeIcon));
        closeIcon.click();
        return this;
    }

    public CreateNewProductPage clickSaveButton() {
        saveButton.click();
        return this;
    }


}
