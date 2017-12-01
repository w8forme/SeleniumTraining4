package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductDAO;
import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.pages.*;
import myprojects.automation.assignment4.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CreateNewProductPage createNewProductPage;
    private MainPage mainPage;
    private AllProductsPage allProductsPage;
    private ProductDetailsPage productDetailsPage;
    private ProductDAO productDAO;


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        CustomReporter.logAction("Login in admin panel");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = loginPage.openLoginPage()
                .fillEmailInput(login)
                .fillPassInput(password)
                .clickLoginBtn();

    }

    public void createProduct(ProductData newProduct) {
        // TODO implement product creation scenario
        CustomReporter.logAction("Select 'products' tab from side menu");
        createNewProductPage = dashboardPage.selectCatalogProducts().clickCreateNewProductButton();
        CustomReporter.logAction("Create new product with random parameters");
        createNewProductPage.fillProductName(newProduct.getName())
                .fillProductQuantity(newProduct.getQty())
                .fillProductPrice(newProduct.getPrice())
                .clickSwitchButton()
                .closeMessageWindow()
                .clickSaveButton()
                .closeMessageWindow();
    }

    public ProductDAO getTestProduct(ProductData newProduct) {
        CustomReporter.logAction("Open main page");
        mainPage = PageFactory.initElements(driver, MainPage.class);
        CustomReporter.logAction("Click on all products link");
        allProductsPage = mainPage.openMainPage()
                .scrollToAllProductsLink()
                .clickAllProductsLink();
        CustomReporter.logAction("Check if test product present in catalog");
        boolean hasTestProduct = allProductsPage.isProductPresent(newProduct.getName());
        productDetailsPage = allProductsPage.clickOnProduct();
        CustomReporter.logAction("Extract product details to further compare");
        productDAO = productDetailsPage.getProductDetails();
        productDAO.setDisplayed(hasTestProduct);
        return productDAO;
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_running")));
    }
}
