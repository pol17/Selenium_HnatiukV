package hnatiuk.tests.seleniumTests.suites;

import hnatiuk.api.components.pages.LoginPage;
import hnatiuk.tests.seleniumTests.TestService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTests extends TestService {
    private WebDriver driver;

    //@Override
    @BeforeClass
    public void setUp() {
        System.out.println("In Before Class");
        this.driver = getDriver();
    }

    @Test
    void successfullyLoginWithValidUserCredentials() {
        LoginPage loginPage = new LoginPage(driver, "http://v3.test.itpmgroup.com");
        loginPage.open()
                //.verifyTitleIs("Учет запчастей")
                .getLoginSection()
                .enterUsername("Student")
                .enterPassword("909090")
                .getSubmitButton()
                .clickSubmitButton();
    }
}
