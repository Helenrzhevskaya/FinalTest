package examination_autotest;

import examination.AuthorizationPage;
import examination.Success_Block;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;

import lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

@Epic("Test stand GB")
public class Post_request_handle {
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
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)");
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver(chromeOptions));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();

    }

    @Test
    void positiveAuthorization() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        new AuthorizationPage(driver)
                .enterUsername("GB202301271f49")
                .enterPassword("b71e07f1ca")
                .enterButton().
                success_Block.checkCorrectAuthorization("Hello, GB202301271f49");


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new Success_Block(driver).successHeader.isDisplayed()),
                () -> {
                    assertThat(new Success_Block(driver).nameField, hasText("Hello, GB202301271f49"));
                }
        );
        Thread.sleep(5000);

    }

    @Test
    void check2BlockDisplay() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        new AuthorizationPage(driver)
                .enterUsername("GB202301271f49")
                .enterPassword("b71e07f1ca")
                .enterButton().
                success_Block.checkCorrectAuthorization("Hello, GB202301271f49");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new Success_Block(driver).successHeader.isDisplayed()),
                () -> {
                    assertThat(new Success_Block(driver).nameField, hasText("Hello, GB202301271f49"));
                }
        );
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
