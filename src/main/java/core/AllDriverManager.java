package core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllDriverManager {
	private static final Logger logger = LogManager.getLogger(AllDriverManager.class);
    public static WebDriver driver=null;
    @SuppressWarnings("deprecation")
	public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
        switch(browser.toLowerCase()){
            case "chrome":
            	 WebDriverManager.chromedriver().setup();
                 ChromeOptions chromeOptions = new ChromeOptions();
                 chromeOptions.addArguments("--headless", "--window-size=1644,868");
                 driver = new ChromeDriver(chromeOptions);
                 logger.info("Chrome Browser invoked");
                break;
                
            case "firefox":
            	WebDriverManager.firefoxdriver().setup();
            	 FirefoxOptions firefoxOptions = new FirefoxOptions();
                 firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver();
                logger.info("Firefox Browser invoked");
                break;
                
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("Edge Browser invoked");
                break;
                
            case "safari":
                driver = new SafariDriver();
                logger.info("Safari Browser invoked");
                break;
                
            case "headless":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
                driver = new ChromeDriver(options);
                logger.info("Headless Chrome Browser invoked");
                break;
                
            default:
                logger.fatal("No such browser is implemented.Browser name sent: " + browser);
                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static void navigateToTheUrl(String url){
        driver.get(url);
        logger.info("Browser navigated to the url: " + url);
    }

    public static void quitDriver(){
        driver.quit();
      //  logger.info("Driver closed");
    }
    public static void switchBrowserToTab(){
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //As product description click will open new tab, we need to switch the driver to the new tab. If you do not switch, you can not access the new tab
        Set<String> handles = driver.getWindowHandles(); 	// get all the open windows
        logger.info("List of windows found: "+handles.size());
        logger.info("Windows handles: " + handles.toString());
        Iterator<String> it = handles.iterator(); 		// get the iterator to iterate the elements in set
        String nextTab = it.next();		//gives the child window id
        driver.switchTo().window(nextTab); 		// switch to product Descp
        logger.info("Switched to the new window/tab");
    }

    public static void switchToOriginalTab(){
        Set<String> handles = driver.getWindowHandles(); // get all the open windows
        logger.info("List of windows found: "+handles.size());
        logger.info("Windows handles: " + handles.toString());
        Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
        String original = it.next();//gives the parent window id
        driver.switchTo().window(original);
        logger.info("Switched to the original window/tab");

    }

    public static String getBrowserName(){
        String browserDefault = "chrome"; //Set by default
        String browserSentFromCmd = System.getProperty("browser");

        if (browserSentFromCmd==null){
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }
    
    public static void log(String Messgae){
    	System.out.println(Messgae);	
    	logger.info(Messgae);
	}

}
