package selenium;

import PageObjects.Gmail.ComposeModalPage;
import PageObjects.Gmail.EmailMessagePage;
import PageObjects.Gmail.LoginPage;
import PageObjects.Gmail.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestEmail {
    private WebDriver _driver = InitDriver.getInstance();
    private String _username = "seleniumtest654@gmail.com";
    private String _password = "123qwerty456";
    private String _messageText = "Hello, World!";

    @BeforeTest
    public void openMainPage(){
        _driver.navigate().to("http://gmail.com");
    }

    @Test
    public void sendEmailTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.UsernameTextbox().sendKeys(_username);
        loginPage.NextButton().click();
        loginPage.PasswordTextbox().sendKeys(_password);
        loginPage.NextButton().click();

        MainPage mainPage = new MainPage();
        mainPage.ComposeButton().click();

        ComposeModalPage composeModalPage = new ComposeModalPage();
        composeModalPage.ToTextbox().sendKeys(_username);
        composeModalPage.MessageTextBox().sendKeys(_messageText);
        composeModalPage.SendButton().click();

        //let's wait for messages
        mainPage.WaitForMessageToLoad();
        mainPage.InboxButton().click();
        //get the first message in the list with appropriate subject as it is the last sent message
        mainPage.EmailMessage("(no subject)").click();

        EmailMessagePage emailMessagePage = new EmailMessagePage();
        Assert.assertTrue(emailMessagePage.isMessageDisplayed(_messageText));

        //clean test data using API request

    }

    @AfterTest
    public void stopWebDriver()
    {
        _driver.close();
    }
}