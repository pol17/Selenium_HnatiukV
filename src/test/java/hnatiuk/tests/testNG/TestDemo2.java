package hnatiuk.tests.testNG;

import org.testng.annotations.Test;

public class TestDemo2 extends BaseTest { //наследуемся для аннотаций
    @Test
    void myTest() {
        System.out.println("My testDemo5");
        System.out.println("After compilation5");
    }
}
