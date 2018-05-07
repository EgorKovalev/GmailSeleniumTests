package PageObjects.Gmail;

import PageObjects.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends PageObjectBase {

    private int _emailMessageWaiterSec = 60;

    public WebElement ComposeButton(){
        return GetElement(By.xpath("//div[text()='COMPOSE']"), _deafultTimeOutSec);
    }

    public WebElement InboxButton(){
        return GetElement(By.xpath("//a[contains(text(),'Inbox')]"), _deafultTimeOutSec);
    }

    public void WaitForMessageToLoad(){
        GetElement(By.xpath("//a[contains(@aria-label,'unread')]"), _emailMessageWaiterSec);
    }

    public WebElement EmailMessage(String title){
        return GetElement(By.xpath("//div/span/b[.='" + title + "']"), _deafultTimeOutSec);
    }
}