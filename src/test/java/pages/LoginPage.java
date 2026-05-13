package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String LOGIN_PATH = "login";
    private static final String LOGOUT_PATH = "login";
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

        typeIntoElement(emailLocator, EMAIL);
        clickElement(emailLoginButton);

        typeIntoElement(passwordLocator, PASSWORD);
        clickElement(passwordLoginButton);
    }
}