package homework6;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class SuccessBlock extends BaseView {
    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    private final static String SUCCESS_XPATH_LOCATOR = "//div[@class='content']";
    private final static String SUCCESS_HEADER = "//span[.='URL']";

    @FindBy(xpath = SUCCESS_XPATH_LOCATOR)
    public WebElement checkContent;

    @FindBy(xpath = "//a[.='222']")
    public WebElement checkHeader;

    @FindBy(xpath = "//a[.='Hello, it's me']")
    public WebElement checkMessage;

    public void checkContentAndHeader(String header) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_XPATH_LOCATOR)));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccessBlock(driver).checkContent.isDisplayed()),
                () -> {
                    assertThat(new SuccessBlock(driver).checkHeader, hasText(header));
                }
        );
    }
    public SuccessBlock checkAnHeaderInMyDiary(String headerInDiary) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_HEADER)));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccessBlock(driver).checkContent.isDisplayed()),
                () -> {
                    assertThat(new SuccessBlock(driver).checkHeader, hasText(headerInDiary));

                }

        );
        return this;
    }

}
