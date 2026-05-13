package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void successfulLoginTest() {
        loginPage.login();
        String bodyText = loginPage.getBodyText().toLowerCase();
        Assert.assertTrue(bodyText.contains("simon"));
        Assert.assertTrue(bodyText.contains("szalai"));
        Assert.assertTrue(bodyText.contains("profile"));
        Assert.assertTrue(bodyText.contains("account"));
        Assert.assertTrue(bodyText.contains("log out"));
    }
}
