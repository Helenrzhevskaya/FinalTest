package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class SuccesBlock extends BaseView {
    public SuccesBlock(WebDriver driver) {
        super(driver);
    }

    private final static String SUCCESS_XPATH_LOCATOR = "//div[contains(@class, 'layer_cart_product ')]//h2";

    //@FindBy(xpath = "//div[contains(@class, 'layer_cart_product ')]//h2")   //затем эту константу можем здесь хранить
    @FindBy(xpath = SUCCESS_XPATH_LOCATOR)
    public WebElement succsesHeader;

    @FindBy(xpath = "//span[@class='ajax_block_cart_total']")
    public WebElement summElement;

@Step("Проверка корректности суммы товаров в корзине")
    public void checkCorrectSummInCart(String expectedSumm) {
        //webDriverWait.until(ExpectedConditions.visibilityOf(succsesHeader)); //либо испрользовать visibilityOfElelementLocated и по xpath  искать локатор - тогда ее запишем в переменную константу
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_XPATH_LOCATOR)));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccesBlock(driver).succsesHeader.isDisplayed()),
                () -> {
                    assertThat(new SuccesBlock(driver).summElement, hasText(expectedSumm));
                }
        );
    }
}
