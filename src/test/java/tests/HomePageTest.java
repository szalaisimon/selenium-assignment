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
        Assert.assertTrue(title.contains("Rotten Tomatoes"));

        String bodyText = homePage.getBodyText().toLowerCase();

        // menu items
        Assert.assertTrue(bodyText.contains("movies"));
        Assert.assertTrue(bodyText.contains("tv shows"));
        Assert.assertTrue(bodyText.contains("rt app"));
        Assert.assertTrue(bodyText.contains("news"));
        Assert.assertTrue(bodyText.contains("showtimes"));

        // home page titles
        Assert.assertTrue(bodyText.contains("movies in theaters"));
        Assert.assertTrue(bodyText.contains("watch at home"));
        Assert.assertTrue(bodyText.contains("new to rent/buy at home"));
        Assert.assertTrue(bodyText.contains("coming soon to theaters"));
    }
}