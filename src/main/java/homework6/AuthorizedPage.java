package homework6;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizedPage extends BaseView {
    public AuthorizedPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage authorizationWithCookie() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "a2189c7ce7994221be29f809542c1190686265a7448f853c14131a5775ea7b8ea%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C900%5D%22%3B%7D");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        return new MyAccountPage(driver);
    }
}
