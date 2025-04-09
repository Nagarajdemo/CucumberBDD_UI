package utils;

import base.DriverInstance;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtils  {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=20;

    public String takeScreenShot(){
        return (DriverInstance.getDriverInstance().getScreenshotAs(OutputType.BASE64));
    }

    public static void waitForAWhile(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
