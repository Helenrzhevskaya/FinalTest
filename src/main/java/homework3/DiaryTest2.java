package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiaryTest2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://diary.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Cookie cookie = new Cookie("_identity_", "a2189c7ce7994221be29f809542c1190686265a7448f853c14131a5775ea7b8ea%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C900%5D%22%3B%7D");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        driver.findElement(By.id("postTitle")).sendKeys("hello, it is autotest");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")));
        driver.findElement(By.xpath("//body[@class='mce-content-body']")).sendKeys("Автотест печатает");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("atMoodBoxCheck")).click();
        driver.findElement(By.id("rewrite")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
