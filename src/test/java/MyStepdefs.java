import com.codeborne.selenide.Selenide;
import homework8.AuthorizedPage;
import homework8.EntryPage;
import homework8.MyAccountPage;
import homework8.SuccessBlock;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("User authorized")
    public void userAuthorized() {
        open("https://diary.ru");
        new AuthorizedPage().authorizationWithCookie();
    }

    @When("Click To New Entry button")
    public void clickToNewEntryButton() {
        new MyAccountPage().navigatorBlock.clickToNewEntry();
    }

    @And("Create Header {string}")
    public void createHeader(String header) {
        new EntryPage().createHeader(header);
    }

    @And("Create Message {string}")
    public void createMessage(String textMessage) throws InterruptedException {
        new EntryPage().createMessage(textMessage);
    }

    @And("Leave a smile")
    public void leaveASmile() throws InterruptedException {
        new EntryPage().leaveASmile();
    }

    @And("publish an entry")
    public void publishAnEntry() {
        new EntryPage().publish();

    }

    @Then("check content and header")
    public void checkContentAndHeader() {
        new SuccessBlock().checkContentAndHeader("Autotest");
        new SuccessBlock().checkAnHeaderInMyDiary("Autotest");
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}
