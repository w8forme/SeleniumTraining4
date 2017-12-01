package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pavel Holinko on 29.11.2017.
 */
public class MainPage {

    private WebDriver driver;

    @CacheLookup
    @FindBy(css = "a.all-product-link.pull-xs-left.pull-md-right.h4")
    private WebElement allProductsLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(Properties.getBaseUrl());
        return this;
    }

    public MainPage scrollToAllProductsLink() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", allProductsLink);
        return this;
    }

    public AllProductsPage clickAllProductsLink() {
        allProductsLink.click();
        return PageFactory.initElements(driver, AllProductsPage.class);
    }


}
