package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSettingsPage extends BasePage {

    private final By logoutButton = By.xpath("//a[@data-qa='logout-link']");
    private final By accountsettings = By.xpath("//*[@id=\"header-main\"]/ul/li[4]/rt-header-user-info/a[6]");
    private final By menu = By.xpath("//*[@id=\"header-main\"]/ul/li[4]/a");
    public AccountSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        clickElement(menu);
        clickElement(accountsettings);
        clickElement(logoutButton);
    }
}
