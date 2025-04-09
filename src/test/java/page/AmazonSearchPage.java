package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchPage {
    private WebDriver driver;
    private static By searchField=By.xpath("//div[@class='_ZGFyZ_container_yQKU1 sbx-desktop']//descendant::img[@class='_ZGFyZ_logo_2NXq6']");
    private static By validateText=By.xpath("//h2[contains(@class, 'a-size-base a-spacing-small a-spacing-top')]//child::span/following-sibling::span[2]");


    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchField(String searchValue){
        driver.findElement(searchField).sendKeys(searchValue);
        driver.findElement(validateText).getText();
    }
}
