package hnatiuk.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitButton {
    private static final By SUBMIT_BUTTON_SELECTOR = By.cssSelector("button[type=\"submit\"]");

    private WebDriver driver;

    public SubmitButton(WebDriver driver) {
        this.driver = driver;
    }

    public SubmitButton clickSubmitButton() {
        this.driver.findElement(SUBMIT_BUTTON_SELECTOR).click();
        return this;
    }
}
