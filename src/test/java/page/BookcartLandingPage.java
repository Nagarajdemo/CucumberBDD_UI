package page;

import base.DriverInstance;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class BookcartLandingPage {
    @FindBy(xpath = "//div[@class='d-flex align-items-center']/descendant::button/following-sibling::button")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='mat-mdc-card-header-text']/child::mat-card-title")
    WebElement loginPage;

    public BookcartLandingPage() {
        PageFactory.initElements(DriverInstance.getDriverInstance(), this);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String returnLoginText(){
        return  loginPage.getText();
    }
}
