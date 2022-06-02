package homework8;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EntryPage  {

    private SelenideElement header = $(By.id("postTitle"));

    private SelenideElement checkBoxSmile = $(By.id("atMoodBoxCheck"));

    private SelenideElement choiceOfEmotions = $(By.id("smile_all"));

    private SelenideElement simpleSmile = $(By.xpath("//div[contains(@data-code,':)')]"));

    private SelenideElement  publishButton = $(By.id("rewrite"));

    private SelenideElement areaMessage = $(By.xpath("//iframe[@title='Rich Text Area']"));

    private SelenideElement inputMessage = $(By.xpath("//body[@data-id='message']"));

    @Step("Пишем заголовок")
    public EntryPage createHeader(String nameHeader) {
        header.sendKeys(nameHeader);
        return this;
    }

    @Step("Пишем текст")
    public EntryPage createMessage(String textMessage) throws InterruptedException {
        WebDriverRunner.getWebDriver().switchTo().frame(areaMessage);
        //driver.switchTo().frame(areaMessage);
        inputMessage.sendKeys(textMessage);
        Thread.sleep(3000);
        return this;
    }

    @Step("Оставляем смайлик")
    public EntryPage leaveASmile() throws InterruptedException {
        WebDriverRunner.getWebDriver().switchTo().parentFrame();
        checkBoxSmile.click();
        choiceOfEmotions.click();
        Thread.sleep(2000);
        simpleSmile.click();
        return this;
    }

    @Step("Публикуем запись")
    public SuccessBlock publish() {
        publishButton.click();
        return page(SuccessBlock.class);
    }

    @FindBy(xpath = "//span[.='Мой дневник']")
    public WebElement myDiary;


    @FindBy(xpath = "//span[.='URL']")
    public List<WebElement> entryList;

    @Step("Открываем Мой дневник")
    public SuccessBlock openMyDiary() {
        myDiary.click();
        return page(SuccessBlock.class);
    }
}
