package homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.LoginPage;
import lesson6.SuccesBlock;
import lesson6.TShirtsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class DiaryAutomationTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    EntryPage entryPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");//передаем настройки для блокирования нотификаций
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();

        entryPage = new EntryPage(driver);

    }

    @Test
    void theFirstCreateAnEntry() throws InterruptedException {
        driver.get("https://diary.ru");
        new AuthorizedPage(driver).
                authorizationWithCookie()
                .navigatorBlock.clickToNewEntry()
                .createHeader("222")
                .createMessage("Hello, it's me")
                .leaveASmile()
                .publish()
                        .checkContentAndHeader("222");

        new EntryPage(driver).openMyDiary().checkAnHeaderInMyDiary("222");


        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccessBlock(driver).checkContent.isDisplayed()),
                () -> {
                    assertThat(new SuccessBlock(driver).checkHeader, hasText("222"));
                }
        );
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
