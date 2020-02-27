package hnatiuk.tests.seleniumTests;

import hnatiuk.tests.seleniumTests.driver.WebDriverThread;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TestService {
    // A list to store all instances of WebDriverThread
    // A thread won't be able to modify the list while another thread is currently running a method from this list.
    // The object is locked while processing method.
    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<WebDriverThread> driverThread;

    //used in tests page objects' variables to not instantiate them in the tests
    /*private final FrameworkProperties CONFIGURATION = FrameworkProperties.getInstance();
    protected final String baseURL = CONFIGURATION.getBaseURL();*/

    /**
     * Instantiates WebDriverThreads objects,
     * to isolate each instance of WebDriver during parallel tests running
     */
    @BeforeSuite
    public static void instantiateDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            WebDriverThread webDriverThread = new WebDriverThread();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    public static WebDriver getDriver() {
        log.info("Requesting driver");
        return driverThread.get().getDriver();
    }

    @AfterMethod
    public static void clearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public static void closeDriverObjects() {
        log.info("Closing threads within webDriverThreadPool");
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
            log.info("Thread closed");
        }
    }
}
