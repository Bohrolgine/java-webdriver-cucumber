package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getPosition;

public class RestStepsDefs {
    RestClient careersClient = new RestClient();

    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        new RestClient().login(getData(role));

        //careersClient.login(getData(role));
//        Map<String, String> user = getData(role);
//        new RestClient().login(user);
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String type) {
        new RestClient().createPosition(getPosition(type));

        //careersClient.createPosition(getData(type));
    }

    @Then("I verify via REST new position is in the list")
    public void iVerifyViaRESTNewPositionIsInTheList() {
        System.out.println();

    }
}
