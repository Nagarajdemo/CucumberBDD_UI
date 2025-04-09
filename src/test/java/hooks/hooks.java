package hooks;

import base.DriverInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.CommonUtils;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class hooks {

   public  RemoteWebDriver driver;
   public TestUtils utils=new TestUtils();
    @Before(order = 1)
    public void beforeScenario(){
        driver=DriverInstance.getDriverInstance();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(CommonUtils.getPropertyValue("url"));
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        boolean failed = scenario.isFailed();
        System.out.println("is Failed? "+failed);
        if(failed) {
//            byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshotAs, "image/png");
            utils.takeScreenShot();
            DriverInstance.getDriverInstance().getScreenshotAs(OutputType.BASE64);
        }
        DriverInstance.getDriverInstance();
        DriverInstance.quitDriver();
    }
}
