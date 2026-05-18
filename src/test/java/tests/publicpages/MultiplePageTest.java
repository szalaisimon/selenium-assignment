package tests.publicpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MoviePage;
import tests.DriverFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class MultiplePageTest {

    private WebDriver driver;
    private MoviePage moviePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createStealthDriver();
        moviePage = new MoviePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldVerifyMovieTitlesAcrossMultiplePages() {
        Map<String, String> pagesToExpectedTitles = new LinkedHashMap<>();
        pagesToExpectedTitles.put("https://www.rottentomatoes.com/m/matrix", "The Matrix");
        pagesToExpectedTitles.put("https://www.rottentomatoes.com/m/titanic", "Titanic");
        pagesToExpectedTitles.put("https://www.rottentomatoes.com/m/avatar", "Avatar");
        pagesToExpectedTitles.put("https://www.rottentomatoes.com/m/king_kong", "King Kong");
        pagesToExpectedTitles.put("https://www.rottentomatoes.com/m/jurassic_park", "Jurassic Park");

        for (Map.Entry<String, String> entry : pagesToExpectedTitles.entrySet()) {
            String pageUrl = entry.getKey();
            String expectedTitle = entry.getValue();

            driver.get(pageUrl);
            String actualTitle = moviePage.getMovieTitleText();

            Assert.assertEquals(actualTitle, expectedTitle, "Unexpected title: " + pageUrl);
        }
    }
}

