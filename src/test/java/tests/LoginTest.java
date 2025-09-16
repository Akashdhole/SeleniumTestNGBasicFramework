package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //Page Object
    // LoginPage loginPage = new LoginPage(driver);

    @Test
    public void testValidAdminLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userOnAdminLoginPage("Admin area demo");
        loginPage.enterAdminUsername("admin@yourstore.com");
        loginPage.enterAdminPassword("admin");
        loginPage.clickOnAdminLoginButton();
        loginPage.userOnAdminDashboardPage("Dashboard / nopCommerce administration");
        loginPage.clickOnAdminLogoutButton();
    }
}