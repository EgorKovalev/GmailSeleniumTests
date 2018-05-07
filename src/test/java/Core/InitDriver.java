package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {

    private static WebDriver _driver;

    public static WebDriver getInstance(){
        //in case using cross-browsers testing, we can move the parameter to .xml
        //to simplify code I just add a name as a string here
        String browser = "chrome";

        if(_driver == null){
            if (browser.toLowerCase().equals("chrome")){
                _driver = getChromeInstance();
            }
            /*if (browser.toLowerCase().equals("firefox")){
                _driver = getFFInstance();
            }
            if (browser.toLowerCase().equals("safari")){
                _driver = getSafariInstance();
            }
            if (browser.toLowerCase().equals("opera")){
                _driver = getOperaInstance();
            }*/

            _driver.manage().window().maximize();
        }

        return _driver;
    }

    private static ChromeDriver getChromeInstance() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        return new ChromeDriver();
    }

    // All other driver instances can be created from here

    /*private static FirefoxDriver getFFInstance() {
        return new FirefoxDriver();
    }

    private static ChromeDriver getChromeInstance() {
        return new ChromeDriver();
    }

    private static SafariDriver getSafariInstance() {
        return new SafariDriver();
    }

    private static OperaDriver getOperaInstance() {
        return new OperaDriver();
    }
    ...

    */
}