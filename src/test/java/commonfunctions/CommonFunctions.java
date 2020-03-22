package commonfunctions;

import com.sun.istack.internal.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    public static WebDriver driver = null;
    public static Properties properties= null;

    Logger logger = Logger.getLogger(CommonFunctions.class);

    public Properties loadPropertyFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
       Properties properties = new Properties();
       properties.load(fileInputStream);
       return properties;
        //property file load.return
    }
    @BeforeSuite
    public void launchBrowser() throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Orange HRM Test Begins");
        logger.info("Loading the property file");
       loadPropertyFile();
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
       String driverLocation = properties.getProperty("ChromeDriverLocation");
       String driverLocation1 = properties.getProperty("FirefoxDriverLocation");
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",driverLocation);
            logger.info("Launching Chrome browser");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",driverLocation1);
            logger.info("Launching Chrome browser");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        logger.info("Navigating to Application");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @AfterSuite
    public void tearDown(){
        logger.info("Execution done. Closing th ebrowser");
        driver.quit();

    }
}
