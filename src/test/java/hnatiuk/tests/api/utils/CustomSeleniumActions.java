package hnatiuk.tests.api.utils;

import hnatiuk.tests.seleniumTests.TestService;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@UtilityClass
public class CustomSeleniumActions {
    private WebDriver driver = TestService.getDriver();

    public static WebElement dofind(By selector) {
        return driver.findElement(selector);
    }

    public static void doSendKeys(By selector, String text) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(text);
    }
}
