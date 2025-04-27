package utils;

import base.DriverInstance;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Data
public class TestUtils  {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=20;
    private static WebDriverWait webDriverWait;


    public static void setWebDriverWait(WebDriverWait webDriverWait) {
        TestUtils.webDriverWait = webDriverWait;
    }


    public String takeScreenShot(){
        return (DriverInstance.getDriverInstance().getScreenshotAs(OutputType.BASE64));
    }

    public static void waitForAWhile(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  waitUntilvisibility(By by){
        Wait<RemoteWebDriver> wait
                = new FluentWait<>(DriverInstance.getDriverInstance())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(TimeoutException.class);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch(TimeoutException e){
            System.out.println(
                    "Timed out waiting for element to be visible..");
        }

    }



}
