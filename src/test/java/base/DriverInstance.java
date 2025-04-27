package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Synchronized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
import utils.TestUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DriverInstance {
    public static final ThreadLocal<RemoteWebDriver> threadlocal=new ThreadLocal<>();
    private static final Lock lock=new ReentrantLock();
    private static WebDriverWait webDriverWait;



    private DriverInstance() {
    }

    public static RemoteWebDriver getDriverInstance(){
        if (threadlocal.get()==null){
//            lock.lock();
            try{

                if(threadlocal.get()==null){
                    RemoteWebDriver driver;
                    if ("chrome".equals(CommonUtils.getPropertyValue("browser"))) {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("disable-extensions");
                        WebDriverManager.chromedriver().setup();
                        if(CommonUtils.getPropertyValue("headless").equals("true")) {
                            chromeOptions.addArguments("headless=new");
                        }
                        driver = new ChromeDriver(chromeOptions);
                         webDriverWait=new WebDriverWait(driver,10);

                    }else if("firefox".equals(CommonUtils.getPropertyValue("browser"))) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }else {
                        throw new IllegalArgumentException("invalid browser name");
                    }
                    threadlocal.set(driver);
                    TestUtils.setWebDriverWait(webDriverWait);

                    }
                }
            finally {
//                    lock.unlock();
            }
        }
        return threadlocal.get();
    }

    public static void quitDriver(){
//        lock.lock();
        WebDriver driver=threadlocal.get();
        if(driver!=null){
            driver.quit();
//            driver=null;
//            lock.unlock();
        }
    }
}
