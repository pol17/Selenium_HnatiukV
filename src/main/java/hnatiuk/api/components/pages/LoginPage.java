package hnatiuk.api.components.pages;

import hnatiuk.api.components.sections.LoginSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return  this;
    }

    /*public LoginPage verifyTitleIs(String title) {
        String actualTitle = this.driver.findElement(TITLE_SELECTOR).getText();
        //assertThat(actualTitle)
    }*/
}
