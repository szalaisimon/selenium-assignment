package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage extends BasePage {

    private final By movieTitle = By.cssSelector("rt-text[slot='title']");

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getMovieTitleText() {
        return waitVisibilityAndFindElement(movieTitle).getText().trim();
    }
}

