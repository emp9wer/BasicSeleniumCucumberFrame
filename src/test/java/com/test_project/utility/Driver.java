package com.test_project.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
//encapsulation
    //create a private constructor to remove access to this object
    private Driver() {

    }

    /*
    We make the Webdriver private because we want to close access from outside the class.
    We making it static because we will use it in the static method.
     */
    private static WebDriver driver; //default value = null

    /*
    create re-usable utility method which will return the same driver instance once we call it
    -if an instance doesn't exist it will create first and then it will always return same instance
     */
    public static WebDriver getDriver(){

        if (driver==null){
            /*
            we will read browser type from configuration.properties file
            this way we control which browser is opened from outside our code
             */
            String browseType = ConfigurationReader.getProperty("browser");

            /*
              we will read browser type from configuration.properties file
              and depending on it - switch statement will determine the case and open matching browser
             */
            switch (browseType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            //this line will terminate currently existing driver completely - it will be not existent going forward
            driver.quit();
            //we assign value back to null so that my singleton can create a newer one if needed
            driver=null;
        }
    }



}
