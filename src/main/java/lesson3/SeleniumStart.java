package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      //  WebDriver driver = new ChromeDriver();
      //  driver.get("https://google.com");

        // WebDriverManager.firefoxdriver().setup();//вызывается библиотека менеджера, которая проверить версию firefox  в нашей системе и сама скачает версию драйвера и пропишет нужный путь
       // WebDriver firefoxDriver = new FirefoxDriver();
       // firefoxDriver.get("https://yandex.ru");

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com");

        Thread.sleep(5000);//остановка выполнения сценария на 5сек
        //firefoxDriver.quit();
        chromeDriver.quit(); //для закрытия браузера
    }
}
