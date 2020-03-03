package hnatiuk.tests.api.components.buttons;

import hnatiuk.tests.api.components.Clickable;
import hnatiuk.tests.api.components.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class Button implements Visible, Clickable {
    private WebDriver driver;
    private final By rootSelector;
    private WebElement element;

    public Button(WebDriver driver, By parentSelector) {
        this.driver = driver;
        this.rootSelector = new ByChained(parentSelector, By.tagName("button"));
    }

    @Override
    public WebElement getRootElement() {
        return this.rootSelector != null
                ? this.driver.findElement(rootSelector)
                : this.element;
    }

    public boolean elementIsVisible() {
        return this.driver.findElement(rootSelector).isDisplayed();
    }

    public boolean elementIsNotVisible() {
        //logic that returns false
        return false;
    }
}
