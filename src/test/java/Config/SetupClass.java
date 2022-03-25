package Config;

import Pages.Page;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SetupClass extends Page {


    public void startClass( Boolean interfase ) {
        com.codeborne.selenide.Configuration.browser = "chrome";      //браузер для тестов
        ChromeOptions options = null;  //создать обьект для установки опций браузера хром
//        System.setProperty("webdriver.chrome.driver", "chromedriver\\win\\chromedriver.exe");
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver\\win\\chromedriver.exe");
            if (interfase == true){options = new ChromeOptions();}
            if (interfase == false){options = new ChromeOptions().setHeadless(true);}
        } else {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            options = new ChromeOptions().setHeadless(true); //браузер без вебинтерфейса
        }
        com.codeborne.selenide.Configuration.timeout = 15000;   //максимальный интервал ожидания вебэлементов в милисекундах
//  /   ChromeOptions options = new ChromeOptions();  //создать обьект для установки опций браузера хром
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // вспливающие окна
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});    // Отключить расширения режима разработчика , отключить панель автоматизации
        options.addArguments("--no-sandbox");   // для докера
        options.addArguments("--disable-dev-shm-usage"); // для докера
        WebDriver myWebDriver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(myWebDriver);
        myWebDriver.manage().window().maximize();
        myWebDriver.manage().window().setSize(new Dimension(1920, 1080));
        openHomePage();
    }

    public void finishClass() {
        closeWebDriver();
    }
}
