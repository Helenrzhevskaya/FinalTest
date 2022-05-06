package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        // как запретить уведомлениям на сайте показываться
        WebDriverManager.chromedriver().setup();

        //создадим экземляр класса хром опшинс:для добавления настроек
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");//передаем настройки для блокирования нотификаций
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)"); //настройка для браузера, когда заходит гугл бот(для снятия всяких стилей)
        //chromeOptions.addArguments("--headless");//для запуска автотеста без интерфейса, чтобы тестер мышкой случайно не сбил фокус селениума
        WebDriver driver = new ChromeDriver(chromeOptions);//передаем в конструктор
        driver.get("https://google.com");
        //для открытия в определенном разрешении:
        driver.manage().window().setSize(new Dimension(300, 700));
        Thread.sleep(5000);
        driver.manage().window().maximize();


        //для открытия новой вкладки хрома:
        driver.switchTo().newWindow(WindowType.TAB);//для переключения между вкладками, окнами, Аймфреймами. (Откроется новая вкладка) TAB -открытие вкладки
        //также есть на сайте различные нативные окошки, которые спрашивают согласия или подтверждения . Вызывается alert(); в консоле девтулз. Эта плашка затрудняет что-то делать на сайте, если не закрыть ее
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());//нам нужно получить список дискрипторов и с помощью селениума передать дискриптор той вкладки , на которую зотим переключится
        driver.switchTo().window(tabs.get(1)); //внуть передаем дискриптор той вкладки, куда хотим пойти
        driver.get("https://ya.ru");
        Thread.sleep(5000);
        driver.close();//закроет тек вкладку
        Thread.sleep(5000);

        driver.switchTo().window(tabs.get(0));//после закрытия предыдущей вкладки, подсказываем, что мы хотим октрыть из нулевой вкладки следующие вкладки
        ((JavascriptExecutor)driver).executeScript(" window.open(\"https://ya.ru\", '_blank').focus();"); //Для начала нудно привести драйвер к джава скрипту. джава скрипт для открытия новой вкладки(можно вначале тестировать в консоле разработчика)
        Thread.sleep(5000);
        driver.quit();//закроет все вкладки бразуреа

    }
}
