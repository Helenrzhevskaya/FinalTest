package homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatorBlock extends BaseView {

    public NavigatorBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Новая запись']")
    private WebElement newEntry;


    public EntryPage clickToNewEntry() {
        newEntry.click();
        //header.sendKeys("hello, it is autotest from Test");
        return new EntryPage(driver);
    }
}
