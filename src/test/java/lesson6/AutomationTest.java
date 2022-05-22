package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class AutomationTest {
    WebDriver driver;
    TShirtsPage tShirtsPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        tShirtsPage = new TShirtsPage(driver);
    }

    @Test
    void addCartTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage(driver)
                .login("spartalex93@test.test", "123456")
                //теперь после того, как мы в методе Логин возвращаем страницу Мой аккаунт, нам здесь после точки доступны все методы на этой странице/ Также сделаем метот clickTShirtsPage возвращаемым
                .navigationBlock.clickTShirtsButtonInWomenSuggest()
                .selectSize("S")
                .addTShirtToCartByText("Faded")
                        .checkCorrectSummInCart("$18.51");
        //создали экземпляр логин пейджа и этот момент: селениум смотрит, что есть в аннотации FindBy и по локатору - происходит поиск.
        //Когда он нашелся, записывается значение, затем его достаем и используем его.
        //Пейдж фэктори - нам нужен, для того, чтобы когда мы захотис обратится к какому-то полю, у нас будет заново происходит поиска элемента на веб странице. И тогда состояние - актуально. Не будет получать Эксепшионс
        //не понадобится, так как сделали методы возвращаемыми:
        //new MyAccountPage(driver).navigationBlock.clickTShirtsButtonInWomenSuggest();
        //tShirtsPage.selectSize("S").addTShirtToCartByText("Faded");

        //Объединим две проверки:
        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccesBlock(driver).succsesHeader.isDisplayed()),
                () -> assertThat(new SuccesBlock(driver).summElement, hasText("$18.51"))
        );
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
