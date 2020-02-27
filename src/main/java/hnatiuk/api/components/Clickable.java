package hnatiuk.api.components;

import org.openqa.selenium.WebElement;

public interface Clickable {
    default boolean verifyEnabled() {
        //my logic
        System.out.println("I am enabled");
        return true;
    }

    default WebElement click() {
        return null;
    }
}
