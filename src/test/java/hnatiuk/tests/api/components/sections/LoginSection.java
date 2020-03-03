package hnatiuk.tests.api.components.sections;

import hnatiuk.tests.api.components.buttons.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSection {
    private final By rootSelector = By.className("login-box-body");
    private static final By USERNAME_INPUT_SELECTOR = By.name("_username");
    private static final By PASSWORD_INPUT_SELECTOR = By.id("password");

    private WebDriver driver;

    public LoginSection(WebDriver driver) {
        this.driver = driver;
    }

    /*public SubmitButton getSubmitButton() {
        return new SubmitButton(this.driver);
    }*/

    public Button getSubmitButton() {
        return new Button(this.driver, this.rootSelector);
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
