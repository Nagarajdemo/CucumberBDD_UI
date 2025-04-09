package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Synchronized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverInstance {
    public static final ThreadLocal<RemoteWebDriver> threadlocal=new ThreadLocal<>();
    private static final Lock lock=new ReentrantLock();



    private DriverInstance() {
    }

    public static RemoteWebDriver getDriverInstance(){
        if (threadlocal.get()==null){
//            lock.lock();
            try{

                if(threadlocal.get()==null){
                    RemoteWebDriver driver;
                    if ("chrome".equals(CommonUtils.getPropertyValue("browser"))) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();

                    }else if("firefox".equals(CommonUtils.getPropertyValue("browser"))) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }else {
                        throw new IllegalArgumentException("invalid browser name");
                    }
                    threadlocal.set(driver);

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
