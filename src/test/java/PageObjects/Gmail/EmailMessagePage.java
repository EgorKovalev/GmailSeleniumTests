package PageObjects.Gmail;

import PageObjects.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailMessagePage extends PageObjectBase {

    public WebElement DeleteMessageButton(){
        return GetElementPresent(By.xpath("(//div[@data-tooltip='Delete'])[1]"), _deafultTimeOutSec);
    }

    public Boolean isMessageDisplayed(String title){
        return IsElementPresent(By.xpath("//div[@data-message-id]//div[contains(text(),'" + title + "')]"), _deafultTimeOutSec);
    }
}