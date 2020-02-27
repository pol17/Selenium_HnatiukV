package hnatiuk.api.components.buttons;

import hnatiuk.api.components.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class Button implements Visible {
    private WebDriver driver;
    private final By rootSelector;

    public Button(WebDriver driver, By parentSelector) {
        this.driver = driver;
        this.rootSelector = new ByChained(parentSelector, By.tagName("button"));
    }

    public boolean elementIsVisible() {
        return this.driver.findElement(rootSelector).isDisplayed();
    }

    public boolean elementIsNotVisible() {
        //logic that returns false
        return false;
    }
}
