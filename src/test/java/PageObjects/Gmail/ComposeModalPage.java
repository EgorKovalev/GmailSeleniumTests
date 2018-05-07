package PageObjects.Gmail;

import PageObjects.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComposeModalPage extends PageObjectBase {

    public WebElement ToTextbox(){
        return GetElement(By.xpath("//*[@name='to']"), _deafultTimeOutSec);
    }

    public WebElement MessageTextBox(){
        return  GetElement(By.xpath("//div[@aria-label='Message Body']"), _deafultTimeOutSec);
    }

    public WebElement SendButton(){
        return  GetElement(By.xpath("//*[text()='Send']"), _deafultTimeOutSec);
    }
}