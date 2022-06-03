package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccesBlock  {

    private SelenideElement succsesHeader = $(By.xpath("//div[contains(@class, 'layer_cart_product ')]//h2"));

    private SelenideElement summElement = $(By.id("//span[@class='ajax_block_cart_total']"));

@Step("Проверка корректности суммы товаров в корзине")
    public void checkCorrectSummInCart(String expectedSumm) {
   // succsesHeader.getWrappedElement(). для написания кода на голом селениуме

        Assertions.assertAll(
                () -> succsesHeader.shouldBe(visible),
                () -> summElement.shouldHave(text(expectedSumm))

        );
    }
}
