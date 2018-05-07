package test;

import Core.InitDriver;
import PageObjects.Gmail.ComposeModalPage;
import PageObjects.Gmail.EmailMessagePage;
import PageObjects.Gmail.LoginPage;
import PageObjects.Gmail.MainPage;
import Services.EmailService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendEmail {

    private WebDriver _driver = InitDriver.getInstance();
    private String _username = "seleniumtest654@gmail.com";
    private String _password = "123qwerty456";

    private String _messageTitle = "(no subject)";
    private String _messageText = "Hello, World!";

    private String _baseUrl = "http://gmail.com";

    @BeforeTest
    public void openMainPage(){
        _driver.navigate().to(_baseUrl);
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

        //let's wait for the messages
        mainPage.WaitForMessageToLoad();
        mainPage.InboxButton().click();
        //get the first message in the list with appropriate subject as it is the last sent message
        mainPage.EmailMessage(_messageTitle).click();

        EmailMessagePage emailMessagePage = new EmailMessagePage();
        Assert.assertTrue(emailMessagePage.isMessageDisplayed(_messageText));

        //clean test data
        EmailService.clean(_username, _password, "INBOX");
    }

    @AfterTest
    public void stopWebDriver()
    {
        _driver.close();
    }
}