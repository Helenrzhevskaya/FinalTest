package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");
        /*
        //без подклада куки    driver.findElement(By.id("loginform-username")).sendKeys("spartalex");
        driver.findElement(By.id("loginform-password")).sendKeys("123456");
        //для авторизации чаще всего на сайте используются капчи. Но в селениуме эту капчу не пройти, так как вод капчи находится внутри айфрейма (iframe)- это вствка кусочка веб стрницы с другого сайта
        //и чтобы работать с элементами внутри афрейма, нужно на наего переключится

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        //После работы внутри айфрейма, нам нужно для продолжения работы вернуться обратно в родительский фрейм
        driver.switchTo().parentFrame();

        driver.findElement(By.id("login_btn")).click(); //так как есть после капчи - доп проверка, тест упадет. Поэтому нужно подкладывать куки

*/
        driver.get("https://diary.ru");
        //перед тем как повесить куку, создадим ее. (В конструктор передаем имя и значение куки из вкладки application-cookies
        Cookie cookie = new Cookie("_identity_", "a2189c7ce7994221be29f809542c1190686265a7448f853c14131a5775ea7b8ea%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C900%5D%22%3B%7D");
        //теперь добавляем в наш драйвер
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();//для перезагрузки страницы
        Thread.sleep(5000);

        driver.quit();


    }
}
