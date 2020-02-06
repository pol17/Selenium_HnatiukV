package hnatiuk.tests.simpleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumDemoTest {

    @Test
    void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\IdeaProjects\\Selenium_HnatiukV\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.linkText("Concord SDK")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
