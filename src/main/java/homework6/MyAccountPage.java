package homework6;


import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BaseView {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        navigatorBlock = new NavigatorBlock(driver);
    }
    public NavigatorBlock navigatorBlock;

}


