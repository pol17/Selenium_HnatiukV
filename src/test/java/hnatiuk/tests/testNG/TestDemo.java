package hnatiuk.tests.testNG;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
public class TestDemo extends BaseTest { //наследуемся для аннотаций
    //Logger log = Logger.getLogger(TestDemo.class.getName());

    @Test(testName = "Description about this test") //testName называет тест заданым именем
    void demoTest1() {
        //log.info("msg text here");
        System.out.println("My testDemo1");
        System.out.println("After compilation1");
    }

    @Test(dependsOnMethods = "demoTest1") //dependsOnMethods говорит, что тест будет запущен только после теста demoTest1
    void demoTest2() {
        System.out.println("My testDemo2");
        System.out.println("After compilation2");
    }

    @Test(priority = 1) //priority задает приоритет выполнения (очередность). Приоритет выше, если без него!
    void demoTest3() {
        System.out.println("My testDemo3");
        System.out.println("After compilation3");
    }

    @Test(dataProvider = "invalidCredentials") //не дублируя код, вызываем тест несколько раз с разными параметрами
    void demoTest4(String userName, int userID) {
        System.out.println("My testDemo4");
        System.out.println(userName + " " + userID);
    }

    @DataProvider //не дублируя код, вызываем тест несколько раз с разными параметрами
    Object[][] invalidCredentials() {
        //my uniq logic
        return new Object[][] {
                {"Martin", 17},
                {"Alex", 123},
                {"Sem", 987}
        };
    }
}
