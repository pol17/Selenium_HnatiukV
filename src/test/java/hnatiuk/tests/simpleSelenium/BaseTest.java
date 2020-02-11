package hnatiuk.tests.simpleSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static Logger Log = LoggerFactory.getLogger(SeleniumDemoTest.class); //для логов, ниже log.info
    protected WebDriver driver;

    @BeforeSuite
        //выносим перед тестом настройки, чтоб не дублировать каждый раз в тесте
    void setUp() {
        Log.info("Driver initialisation");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\IdeaProjects\\Selenium_HnatiukV\\src\\test\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        Log.info("Driver was initialized");

        Log.info("Configuring driver");
        this.driver.manage().window().maximize(); //manage. позволяет задать настройки при запуске браузера (напр. тут на весь экран)
        this.driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS); //каждый раз будет ждать елемент 15 сек, если его не существует, для всего теста (вместо постоянных Thread.sleep(15000))
        Log.info("Driver was configured");
    }

    //вынесли повторяющееся закрытие/выключение драйвера (выполняем после Сьюта)
    @AfterSuite
    private void tearDown() {
        if (this.driver != null) {
            Log.info("Quiting driver");
            this.driver.quit();
            Log.info("Driver was quit");
        }
    }

    //пример выноса url в отдельный метод
    void openIndexPage() {
        driver.get("http://v3.test.itpmgroup.com");
    }
}
