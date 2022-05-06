package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//вместо обычного ожидания. Общий  для всех.
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category#/");

        //создадим экземпляр класса вебдрайвер вейт для создания опредленных условий
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement casualDressesCheckbox = driver.findElement(By.id("layered_category_9"));
        casualDressesCheckbox.click();

        //Thread.sleep(5000);//так как в прошлый раз тест упал перед кликом на крестик, ставим время на поспать
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));//здесь мы прописываем условие видимости опредленного эелмента, когда в html  он появляется вследствии опрд действмя. Этот метод лучше. Перехватывается меньше исключений

        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Cancel']"))));//отличается от другого тем, что этот меод применяется, когда элемент всегда присутствует на сайте
        driver.findElement(By.xpath("//a[@title='Cancel']")).click(); //сокращенный вариант, чтобы не писать переменную.

        Thread.sleep(5000);
        driver.quit();
    }
}
