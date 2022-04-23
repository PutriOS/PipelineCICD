package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.User;

public class UserStepDefinitions {

    @Steps
    User user;

    @Given("I set Api endpoints")
    public void iSetApiEndpoints() {
        user.setApiEndpoint();
    }

    @When("I send GET HTTP request")
    public void iSendGETHTTPRequest() {
        user.sendGetHttpRequest();
    }

    @And("I receive valid data for detail user")
    public void iReceiveValidDataForDetailUser() {
        user.validateDataDetailUser();
    }

    @When("I send POST HTTP request")
    public void iSendPOSTHTTPRequest() {
        user.sendPostHttpRequest();
    }

    @And("I receive valid data for new user")
    public void iReceiveValidDataForNewUser() {
        user.validateDatanewUser();
    }

    @Then("I receive valid HTTP response code {int}")
    public void iReceiveValidHTTPResponseCode(int arg0) {
        user.iReceiveValidHTTPResponseCode(arg0);
    }

    @When("I send PUT HTTP request")
    public void iSendPUTHTTPRequest() {
        user.iSendPUTHTTPRequest();
    }

    @And("I receive valid data for updated user")
    public void iReceiveValidDataForUpdatedUser() {
        user.iReceiveValidDataForUpdatedUser();
    }

    @When("I send DELETE HTTP request")
    public void iSendDELETEHTTPRequest() {
        user.iSendDELETEHTTPRequest();
    }

}


