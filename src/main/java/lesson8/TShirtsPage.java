package lesson8;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TShirtsPage {
    private ElementsCollection sizeList = $$(By.xpath("//ul[@id='ul_layered_id_attribute_group_1']//a"));

    @Step("Выбор размера")
    public TShirtsPage selectSize(String size) {
        sizeList.findBy(text(size)).click();
        return this;
    }

    private ElementsCollection tShirtsList = $$(By.xpath("//ul[@class='product_list grid row']//li"));

    private SelenideElement addToCartButton = $(By.xpath("//a[@title='Add to cart']"));

    @Step("Добавить рубашку в корзину")
    public SuccesBlock addTShirtToCartByText(String productName) {

        tShirtsList.findBy(text(productName)).hover();
        addToCartButton.click();
        return page(SuccesBlock.class);
    }
}
