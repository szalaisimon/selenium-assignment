package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void homePageStaticContentTest() {
        String title = homePage.getPageTitle();
        Assert.assertTrue(title.contains("Tchibo"));

        // menu items
        String bodyText = homePage.getBodyText();
        Assert.assertTrue(bodyText.contains("Heti ajánlat"));
        Assert.assertTrue(bodyText.contains("Kávé"));
        Assert.assertTrue(bodyText.contains("Női"));
        Assert.assertTrue(bodyText.contains("Férfi"));
        Assert.assertTrue(bodyText.contains("Gyerek"));
        Assert.assertTrue(bodyText.contains("Otthon"));
        Assert.assertTrue(bodyText.contains("Sport"));
        Assert.assertTrue(bodyText.contains("Outlet"));

        // home page titles
        Assert.assertTrue(bodyText.contains("Kategóriáink"));
        Assert.assertTrue(bodyText.contains("Kávé kiválasztása és megrendelése"));
        Assert.assertTrue(bodyText.contains("Legújabb kínálataink"));
    }
}