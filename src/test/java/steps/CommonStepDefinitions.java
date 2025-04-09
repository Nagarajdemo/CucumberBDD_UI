package steps;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import cucumber.api.java.en.Then;
import utils.CommonUtils;
import utils.TestUtils;

public class CommonStepDefinitions {
    TestUtils utils;

    public CommonStepDefinitions(TestUtils utils) {
        this.utils = utils;
    }


    @Then("user takes snapshot")
    public void userTakesSnapshot() {
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(utils.takeScreenShot()).build());

    }
}
