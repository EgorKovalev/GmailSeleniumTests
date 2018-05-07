package PageObjects.Gmail;

import PageObjects.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObjectBase {

    public WebElement UsernameTextbox() {
        return GetElement(By.id("identifierId"), _deafultTimeOutSec);
    }

    public WebElement NextButton() {
        return GetElement(By.xpath("//*[text()='Next']"), _deafultTimeOutSec);
    }

    public  WebElement PasswordTextbox(){
        return GetElement(By.xpath("//*[@name='password']"), _deafultTimeOutSec);
    }
}
