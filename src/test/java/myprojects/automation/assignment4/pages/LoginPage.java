package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pavel Holinko on 12.11.2017.
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "passwd")
    private WebElement passField;

    @FindBy(name = "submitLogin")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.get(Properties.getBaseAdminUrl());
        return this;
    }

    public LoginPage fillEmailInput(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassInput(String password) {
        passField.sendKeys(password);
        return this;
    }

    public DashboardPage clickLoginBtn() {
        submitButton.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }
}
