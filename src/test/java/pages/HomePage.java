package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://www.tchibo.hu/";

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

}
