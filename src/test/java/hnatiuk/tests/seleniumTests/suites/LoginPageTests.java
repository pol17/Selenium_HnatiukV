package hnatiuk.tests.seleniumTests.suites;

import hnatiuk.tests.api.components.buttons.Button;
import hnatiuk.tests.api.components.pages.LoginPage;
import hnatiuk.tests.api.components.sections.LoginSection;
import hnatiuk.tests.seleniumTests.TestService;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Login") //allure annotation
@Issue("Project-1234") //allure annotation
public class LoginPageTests extends TestService {
    private static final String USERNAME = "Student";
    private static final String PASSWORD = "909090";

    private WebDriver driver;

    @Override
    @BeforeClass
    public void setUp() {
        System.out.println("In Before Class");
        this.driver = getDriver();
    }

    @Test
    @Description("I usually describe test scenario") //allure annotation
    @Severity(BLOCKER) //allure annotation
    void successfullyLoginWithValidUserCredentials() {
        LoginPage loginPage = new LoginPage(driver, "http://v3.test.itpmgroup.com");
        loginPage.open()
                .verifyTitleIs("Учет запчастей")
                .getLoginSection()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .getSubmitButton();
                //.clickSubmitButton();
    }

    @Test(dataProvider = "invalidUserCredentials")
    void failWhenLoginWithInvalidUserCredentials(String username, String userpassword) {
        LoginPage loginPage = new LoginPage(driver, "http://v3.test.itpmgroup.com");
        loginPage.open()
                .verifyTitleIs("Учет запчастей");
        LoginSection loginSection = loginPage.getLoginSection();
        loginSection
                .enterUsername(username)
                .enterPassword(userpassword);
        Button submitButton = loginSection.getSubmitButton();
        submitButton.elementIsVisible();
        submitButton.verifyEnabled();
        submitButton.click();
                /*.clickSubmitButton()
                .verifySubmitButtonIsNotVisible()
                .verifyNumbersOfSubmitButtonsIs(2);*/
    }

    @DataProvider
    private Object[][] invalidUserCredentials() {
        return new Object[][]{
                {"asdf", PASSWORD},
                {"", PASSWORD},
                {"as", PASSWORD},
                {USERNAME, "1234"},
                {USERNAME, ""},
                {USERNAME, "12*)"}
        };
    }
}
