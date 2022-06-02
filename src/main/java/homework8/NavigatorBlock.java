package homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class NavigatorBlock  {
    private SelenideElement newEntry = $(By.xpath("//a[@title='Новая запись']"));

@Step("Клик по кнопке Новая запись")
    public EntryPage clickToNewEntry() {
        newEntry.click();
        return page(EntryPage.class);
    }
}
