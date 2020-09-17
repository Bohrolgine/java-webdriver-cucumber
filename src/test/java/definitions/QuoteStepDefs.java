package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @Given("I open {string} page")
    public void iOpenPage(String page) {

        switch (page) {
            case "quote":

                form.open();

                break;

            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        QuoteForm form = new QuoteForm();
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.agreeWithPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        QuoteForm form = new QuoteForm();
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat("actualValue").isEqualTo("expectedValue");

        assertThat(true).isTrue();

    }
}