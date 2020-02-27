package hnatiuk.api.components.buttons;

import jdk.internal.loader.AbstractClassLoaderValue;
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

    public SubmitButton verifySubmitButtonIsNotVisible() {
        this.driver.findElement(SUBMIT_BUTTON_SELECTOR).isDisplayed();
        return this;
    }

    public SubmitButton verifyNumbersOfSubmitButtonsIs (int expectedResult) {
        int actualResult = this.driver.findElements(SUBMIT_BUTTON_SELECTOR).size();
        assertThat(actualResult)
                .withFailMessage("Number of '%s' is not '%d'", 2)
                .isEqualTo(2);
        return this;
    }
}
