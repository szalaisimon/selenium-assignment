package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String LOGIN_PATH = "login";
    private static final String EMAIL = "szalai.simon@gmail.com";
    private static final String PASSWORD = "password123";
    private final By emailLocator = By.id("login-email-input");
    private final By passwordLocator = By.id("pass");
    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private final By emailLoginButton = By.cssSelector("rt-button[slot='email-login-button']");
    private final By passwordLoginButton = By.cssSelector("rt-button[slot='continue-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL + LOGIN_PATH);
    }

    public void login() {
        clickElement(acceptCookiesButton);
        pause(500);

        typeIntoElement(emailLocator, EMAIL);
        pause(800);
        clickElement(emailLoginButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLoginButton));

        typeIntoElement(passwordLocator, PASSWORD);
        pause(500);
        clickElement(passwordLoginButton);
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}