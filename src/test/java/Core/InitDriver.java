package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {
    private static WebDriver _driver;

    public static WebDriver getInstance(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        if(_driver == null){
            _driver = new ChromeDriver();
            _driver.manage().window().maximize();
        }
        return _driver;
    }
}