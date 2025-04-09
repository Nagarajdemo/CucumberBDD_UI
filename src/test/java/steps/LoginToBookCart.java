package steps;

import base.DriverInstance;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import page.BookcartLandingPage;
import page.LoginPage;
import utils.TestUtils;

import static org.apache.commons.lang3.StringUtils.trim;

public class LoginToBookCart {

    public RemoteWebDriver driver= DriverInstance.getDriverInstance();
    BookcartLandingPage bookcartLandingPage;
    LoginPage loginPage;

    public LoginToBookCart(BookcartLandingPage bookcartLandingPage,LoginPage loginPage) {
        this.bookcartLandingPage = bookcartLandingPage;
        this.loginPage=loginPage;
    }

    @Given("load to book cart main page")
    public void loadToBookCartMainPage() {
        bookcartLandingPage.clickLoginButton();
        TestUtils.waitForAWhile();
    }

    @When("user click on login button, login page should be displayed")
    public void userClickOnLoginButtonLoginPageShouldBeDisplayed() {
        Assert.assertEquals("Login",bookcartLandingPage.returnLoginText());
        TestUtils.waitForAWhile();
    }

    @Then("user log into the application with with {string} and {string}")
    public void userLogIntoTheApplicationWithWithAnd(String un, String pwd) {
        loginPage.loginToBookcart(un, pwd);
        Assert.assertEquals("All Categories",trim(loginPage.returnBookCartHomePage()));
    }
}
