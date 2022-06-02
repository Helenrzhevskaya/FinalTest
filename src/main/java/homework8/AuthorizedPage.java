package homework8;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizedPage {

    @Step("Логинимся")
    public MyAccountPage authorizationWithCookie() {
        open("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "a2189c7ce7994221be29f809542c1190686265a7448f853c14131a5775ea7b8ea%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C900%5D%22%3B%7D");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        WebDriverRunner.getWebDriver().navigate().refresh();
        return page(MyAccountPage.class);
    }
}
