package PageObjects.Gmail;

import PageObjects.PageObjectBase;
import org.openqa.selenium.By;

public class EmailMessagePage extends PageObjectBase {

    public Boolean isMessageDisplayed(String title){
        return IsElementPresent(By.xpath("//div[@data-message-id]//div[contains(text(),'" + title + "')]"), _deafultTimeOutSec);
    }
}