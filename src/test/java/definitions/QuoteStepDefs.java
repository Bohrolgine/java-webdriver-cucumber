package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QUOTE.QuoteForm;
import pages.QUOTE.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

//    @Given("I open {string} page")
//    public void iOpenPage(String page) {
//
//        switch (page) {
//            case "quote":
//                form.open();
//                break;
//
//            //case "ups":
//                //upsPg.open();
//                //break;
//
//            default:
//                throw new RuntimeException("Unknown page: " + page);
//        }
//    }

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
        assertThat(result.getResultText()).contains(user.get("username"));
        assertThat(result.getResultText()).contains(user.get("email"));
        assertThat(result.getResultText()).contains(user.get("firstName"));
        assertThat(result.getResultText()).contains(user.get("lastName"));

        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
        assertThat(result.getPasswordText()).doesNotContain(user.get("password"));
        assertThat(result.getPasswordText()).isEqualTo("[entered]");

        //assertThat("actualValue").isEqualTo("expectedValue");
        //assertThat(true).isTrue();
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillContactInfo(user.get("contactPersonName"), user.get("contactPersonPhone"));
    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(result.getResultText().contains(user.get("contactPersonName")));
        assertThat(result.getResultText().contains(user.get("contactPersonPhone")));
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String errorField, String errorMessage) {

        switch (errorField) {
            case "username":
                assertThat(form.getUsernameErrorText()).isEqualTo(errorMessage);
                break;
            case "email":
                assertThat(form.getEmailErrorText()).isEqualTo(errorMessage);
                break;
            case "password":
                assertThat(form.getPasswordErrorText()).isEqualTo(errorMessage);
                break;
            case "confirmPassword":
                assertThat(form.getConfirmPasswordErrorText()).isEqualTo(errorMessage);
                break;
            case "name":
                assertThat(form.getNameErrorText()).isEqualTo(errorMessage);
                break;
            case "agreedToPrivacyPolicy":
                assertThat(form.getagreedToPrivacyPolicyErrorText()).isEqualTo(errorMessage);
                break;
            default:
                throw new RuntimeException("Unrecognized field: " + errorField);
        }
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String inputValue) {

        switch (field) {
            case "username":
                form.fillUsername(inputValue);
                break;
            case "email":
                form.fillEmail(inputValue);
                break;
            case "password":
                form.fillPassword(inputValue);
                break;
            case "confirmPassword":
                form.fillPasswordConfirm(inputValue);
                break;
            default:
                throw new RuntimeException("Unknown field: " + field + " for expected input: " + inputValue);
        }
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorText) {
        switch (errorText) {
            case "password":
                assertThat(form.getPasswordErrorText()).isEqualTo("");
                break;
            case "confirmPassword":
                assertThat(form.getConfirmPasswordErrorText()).isEqualTo("");
                break;
            case "username":
                assertThat(form.getUsernameErrorText()).isEqualTo("");
                break;
            case "email":
                assertThat(form.getEmailErrorText()).isEqualTo("");
                break;
            default:
                throw new RuntimeException("Unable to find field: " + errorText );
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String enteredFirstName, String enteredLastName) {
        form.fillName(enteredFirstName, enteredLastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String name) {
        assertThat(form.getElementText(field)).isEqualTo(name);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String first, String middle, String last) {
        form.fillName(first, middle, last);
    }
}
