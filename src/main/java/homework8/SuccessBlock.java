package homework8;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessBlock {

    private SelenideElement checkContent = $(By.xpath("//div[@class='content']"));

    private SelenideElement checkHeader = $(By.xpath("//a[.='Autotest']"));

    private SelenideElement checkMessage = $(By.xpath("//a[.='Hello, it is me']"));


@Step("Проверяем отображение контента и заголовка")
    public void checkContentAndHeader(String header) {

        Assertions.assertAll(
                () -> checkContent.shouldBe(visible),
                () -> {checkHeader.shouldHave(text(header));
                }
        );
    }

    @Step("Проверяем заголовок в Мой дневник")
    public SuccessBlock checkAnHeaderInMyDiary(String headerInDiary) {
        Assertions.assertAll(
                () ->  checkContent.shouldBe(visible),
                () -> {checkHeader.shouldHave(text(headerInDiary));}
        );
        return this;
    }
}
