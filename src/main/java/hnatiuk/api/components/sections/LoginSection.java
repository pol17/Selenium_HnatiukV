package hnatiuk.api.components.sections;

import hnatiuk.api.components.buttons.SubmitButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSection {
    private static final By USERNAME_INPUT_SELECTOR = By.name("_username");
    private static final By PASSWORD_INPUT_SELECTOR = By.id("password");

    private WebDriver driver;

    public LoginSection(WebDriver driver) {
        this.driver = driver;
    }

    public SubmitButton getSubmitButton() {
        return new SubmitButton(this.driver);
    }

    public LoginSection enterUsername(String Username) {
        this.driver.findElement(USERNAME_INPUT_SELECTOR).clear();
        this.driver.findElement(USERNAME_INPUT_SELECTOR).sendKeys(Username);
        return this;
    }

    public LoginSection enterPassword(String Password) {
        this.driver.findElement(PASSWORD_INPUT_SELECTOR).clear();
        this.driver.findElement(PASSWORD_INPUT_SELECTOR).sendKeys(Password);
        return this;
    }
}
