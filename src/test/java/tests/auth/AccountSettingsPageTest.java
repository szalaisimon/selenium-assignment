package tests.auth;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountSettingsPage;
import pages.LoginPage;
import tests.DriverFactory;


public class AccountSettingsPageTest {

    private WebDriver driver;
    private AccountSettingsPage accountSettingsPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createStealthDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        accountSettingsPage = new AccountSettingsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dependsOnGroups = {"login"})
    public void successfulLogoutTest() {
        accountSettingsPage.logout();

        Assert.assertTrue(accountSettingsPage.isSignInButtonVisible());
    }

}
