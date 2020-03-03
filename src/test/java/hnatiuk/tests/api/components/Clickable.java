package hnatiuk.tests.api.components;

public interface Clickable extends RootElement {
    default boolean verifyEnabled() {
        getRootElement().isEnabled();
        System.out.println("I am enabled");
        return true;
    }

    default void click() {
        getRootElement().click();
        System.out.println("I was clicked");
    }
}
