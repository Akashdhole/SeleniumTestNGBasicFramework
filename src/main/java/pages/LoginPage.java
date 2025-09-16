package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.SQLOutput;

public class LoginPage {

    private WebDriver driver;

    private By Ad_TitleOnLoginPage_loc = By.xpath("//h1[contains(text(),'Admin area demo')]");
    private By Ad_usernameTextBox_loc = By.id("Email");
    private By Ad_passwordTestBox_loc = By.id("Password");
    private By Ad_loginButton_loc = By.xpath("//button[contains(text(),'Log in')]");
    private By Ad_logoutButton = By.xpath("//*[contains(text(),'Logout')]");
    private By Ad_loginPageWelcomeMessage = By.xpath("//*[contains(text(),'Welcome, please sign in')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userOnAdminLoginPage(String expectedTitleOnAdLoginPage) {
        String currentTitleOnAdLoginPage = driver.findElement(Ad_TitleOnLoginPage_loc).getText();
        Assert.assertEquals(currentTitleOnAdLoginPage, expectedTitleOnAdLoginPage);
        System.out.println("Current Title On Admin Login Page is: " + currentTitleOnAdLoginPage);
        System.out.println("Expected Title On Admin Login Page is: " + expectedTitleOnAdLoginPage);
    }

    public void enterAdminUsername(String adminUsername) {
        driver.findElement(Ad_usernameTextBox_loc).clear();
        driver.findElement(Ad_usernameTextBox_loc).sendKeys(adminUsername);
    }

    public void enterAdminPassword(String adminPassword) {
        driver.findElement(Ad_passwordTestBox_loc).clear();
        driver.findElement(Ad_passwordTestBox_loc).sendKeys(adminPassword);
    }

    public void clickOnAdminLoginButton() {
        driver.findElement(Ad_loginButton_loc).click();
    }

    public void userOnAdminDashboardPage(String expectedAdminDashboardPageTitle) {
        String currenAdDashboardPagetTitle = driver.getTitle();
        Assert.assertEquals(currenAdDashboardPagetTitle, expectedAdminDashboardPageTitle);
        System.out.println("User logged in successfully!!!");
        System.out.println("Current Admin Login Page Title is: " + currenAdDashboardPagetTitle);
        System.out.println("Expected Admin Login Page Title is: " + expectedAdminDashboardPageTitle);
    }

    public void clickOnAdminLogoutButton() {
        driver.findElement(Ad_logoutButton).click();
        driver.findElement(Ad_loginPageWelcomeMessage).isDisplayed();
        String AdLoginPageWelcomeMess = driver.findElement(Ad_loginPageWelcomeMessage).getText();
        Assert.assertEquals(AdLoginPageWelcomeMess, "Welcome, please sign in!");
        System.out.println("User logged out successfully!!!");
        System.out.println("User navigated to '" + AdLoginPageWelcomeMess + "' page.");
    }
}
