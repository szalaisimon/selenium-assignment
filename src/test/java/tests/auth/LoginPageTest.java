package tests.auth;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.DriverFactory;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createStealthDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(groups = {"login"})
    public void successfulLoginTest() {
        loginPage.login();
        String bodyText = loginPage.getBodyText().toLowerCase();
        Assert.assertTrue(bodyText.contains("simon"));
        Assert.assertTrue(bodyText.contains("szalai"));
        Assert.assertTrue(bodyText.contains("log out"));
    }
}
