package hnatiuk.tests.seleniumTests.listeners;

import hnatiuk.tests.seleniumTests.TestService;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;

public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult testResult) {
        String methodName = testResult.getMethod().getMethodName();
        Allure.addAttachment(methodName, new ByteArrayInputStream(((TakesScreenshot) TestService.getDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }
}
