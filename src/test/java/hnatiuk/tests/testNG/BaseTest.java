package hnatiuk.tests.testNG;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite //аннотация
    void setUp() {
        System.out.println("I am in before suite");
    }

    @BeforeClass //аннотация
    void setUp2() {
        System.out.println("I am in before class");
    }

    @BeforeMethod //аннотация
    void setUp3() {
        System.out.println("I am in before method");
    }

    @AfterMethod //аннотация
    void tearDown() {
        System.out.println("I am in after method");
    }

    @AfterClass //аннотация
    void tearDown2() {
        System.out.println("I am in after class");
    }

    @AfterSuite //аннотация
    void tearDown3() {
        System.out.println("I am in after suite");
    }
}
