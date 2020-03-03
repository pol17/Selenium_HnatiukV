package hnatiuk.tests.api.components.pages;

import hnatiuk.tests.api.components.sections.LoginSection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class LoginPage {
    private static final By TITLE_SELECTOR = By.className("login-logo");

    private WebDriver driver;
    private String url;

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public LoginSection getLoginSection() {
        return new LoginSection(this.driver);
    }

    public LoginPage open() {
        this.driver.get(this.url);
        return this;
    }

    @Step("Verify title is {0}") //allure annotation | {0} подтягивает title

    public LoginPage verifyTitleIs(String title) {
        String actualTitle = this.driver.findElement(TITLE_SELECTOR).getText();
        assertThat(actualTitle).isEqualTo(title);
        return this;
    }
}
