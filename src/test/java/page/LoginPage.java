package page;

import base.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c508571215-1']/child::input")
    WebElement userName;

    @FindBy(xpath = "//div[@class='mat-mdc-form-field-infix ng-tns-c508571215-2']/child::input")
    WebElement password;

    @FindBy(xpath ="//span[@class='mdc-button__label' and text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()=' All Categories ']")
    WebElement bookCartHomePage;

    public LoginPage() {
        PageFactory.initElements(DriverInstance.getDriverInstance(), this);
    }

    public void loginToBookcart(String un, String pwd){
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
    }

    public String returnBookCartHomePage(){
        return bookCartHomePage.getText();
    }
}
