package myprojects.automation.assignment4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pavel Holinko on 12.11.2017.
 */
public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "page-header-desc-configuration-add")
    private WebElement createNewProductButton;

    @FindBy(id = "subtab-AdminCatalog")
    private WebElement catalogTabElement;

    @FindBy(id = "subtab-AdminProducts")
    private WebElement productsTabElement;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 10);
    }

    public DashboardPage selectCatalogProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogTabElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogTabElement).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(productsTabElement));
        productsTabElement.click();
        return this;
    }

    public CreateNewProductPage clickCreateNewProductButton() {
        createNewProductButton.click();
        return PageFactory.initElements(driver, CreateNewProductPage.class);
    }
}
