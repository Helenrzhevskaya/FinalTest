package homework6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EntryPage extends BaseView {
    public EntryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "postTitle")
    private WebElement header;

    //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")));
    //Не знаю как в FindBy переключится на айфрейм, чтобы оставить текстовое сообщение  и потом как из него выйти??????

    @FindBy(id = "atMoodBoxCheck")
    private WebElement checkBoxSmile;

    @FindBy(id = "smile_all")
    private WebElement choiceOfEmotions;

    @FindBy(xpath = "//div[contains(@data-code,':)')]")
    private WebElement simpleSmile;

    @FindBy(id = "rewrite")
    private WebElement publishButton;

    @FindBy(xpath = "//iframe[@title='Rich Text Area']")
    private WebElement areaMessage;

    @FindBy(xpath = "//body[@data-id='message']")
    private WebElement inputMessage;

    public EntryPage createHeader(String nameHeader) {
        header.sendKeys(nameHeader);
        return this;
    }
    public EntryPage createMessage(String textMessage) throws InterruptedException {
        driver.switchTo().frame(areaMessage);
        inputMessage.sendKeys(textMessage);
        Thread.sleep(3000);
        return this;
    }

    public EntryPage leaveASmile() throws InterruptedException {
        driver.switchTo().parentFrame();
        checkBoxSmile.click();
        choiceOfEmotions.click();
        Thread.sleep(2000);
        simpleSmile.click();
        return this;
    }
    public SuccessBlock publish() {
        publishButton.click();
        return new SuccessBlock(driver);
    }

    @FindBy(xpath = "//span[.='Мой дневник']")
    public WebElement myDiary;


    @FindBy(xpath = "//span[.='URL']")
    public List<WebElement> entryList;


    public SuccessBlock openMyDiary() {
        myDiary.click();
        return new SuccessBlock(driver);
    }


}
