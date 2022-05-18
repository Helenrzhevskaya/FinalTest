package homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class DiaryTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");//передаем настройки для блокирования нотификаций
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)"); //настройка для браузера, когда заходит гугл бот(для снятия всяких стилей)
        driver = new ChromeDriver(chromeOptions);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "a2189c7ce7994221be29f809542c1190686265a7448f853c14131a5775ea7b8ea%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C900%5D%22%3B%7D");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }

    @Test
    void theFirstCreateAnEntry() throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        driver.findElement(By.id("postTitle")).sendKeys("hello, it is autotest from Test");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")));
        driver.findElement(By.xpath("//body[@data-id='message']")).sendKeys("Автотест печатает");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("atMoodBoxCheck")).click();
        driver.findElement(By.id("smile_all")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-code=':)']")).click();
        driver.findElement(By.id("add_picture_box")).click();
        driver.findElement(By.id("file_uploader")).sendKeys("C:\\Users\\Глиномялки\\IdeaProjects\\testLena\\src\\test\\resources\\отчет.png");
        driver.findElement(By.id("rewrite")).click();

        driver.findElement(By.xpath("//span[.='Мой дневник']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//a[.='hello, it is autotest from Test']")).isDisplayed(), true);

    }
    @Test
    void theSecondDeleteAnEntry() throws InterruptedException {
        driver.findElement(By.xpath("//span[.='Мой дневник']")).click();
        List<WebElement> entryList = driver.findElements(By.xpath("//div[@class='post-header']/a"));
        Assertions.assertEquals(driver.findElement(By.xpath("//a[.='hello, it is autotest from Test']")).isDisplayed(),true);
        Thread.sleep(2000);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entryList.stream().filter(f -> f.getText().contains("hello")).findFirst().get());
        entryList.stream().filter(f -> f.getText().contains("hello")).findFirst().get().click();
        driver.findElement(By.xpath("//a[@title='Удалить']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//h2[.='Подтверждение']")));
        assertThat(driver.findElement(By.xpath("//div[@class='modal-content']//h2[.='Подтверждение']")), isDisplayed());
        driver.findElement(By.xpath("//button[.='Да']")).click();

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
//bordered post-list pager_target
////a[.='hello, it is autotest from Test']//div[@class='post-header']//a[@title='Удалить']
//a[.='hello, it is autotest from Test']//div[@class='post-header'//a[@title='Удалить']

//div[@class='post-header']//a[.='hello, it is autotest from Test']//  /ancestor::div[@]/..    или ancestor::div[@]/following-sibling::div//h2[