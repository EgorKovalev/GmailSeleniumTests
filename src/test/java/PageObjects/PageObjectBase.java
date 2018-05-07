package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.InitDriver;

public abstract class PageObjectBase {
    private WebDriver _driver = InitDriver.getInstance();
    protected int _deafultTimeOutSec = 30;

    protected WebElement GetElement(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(_driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return _driver.findElement(locator);
    }

    protected WebElement GetElementPresent(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(_driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return _driver.findElement(locator);
    }

    protected Boolean IsElementPresent(By locator, int timeout)
    {
        try {
            WebDriverWait wait = new WebDriverWait(_driver, timeout);
            WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            return element.isDisplayed();
        }
        catch (WebDriverException ex){
            return false;
        }
    }
}