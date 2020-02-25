package hnatiuk.tests.simpleSelenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumDemoTest extends BaseTest { //наследуемся от BaseTest, в котором все основные настройки для тестов ниже

    @Test
    void test1() {
        //Dimension dimension = new Dimension(1020, 800); //dimension - указываем размер окна браузера в пикселях
        //driver.manage().window().setSize(new Dimension(1020, 800)); //а тут передаем размер (dimension) и открываем
        //driver.manage().window().setSize(dimension);
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.linkText("Popular Categories")).click();
        //Thread.sleep(15000); //аналог implicitlyWait (неявное ожидание)
    }

    @Test
    void test2() {
        driver.get("https://mvnrepository.com/");
        driver.findElement(By.linkText("Popular Tags")).click();
        driver.quit();
    }
}
